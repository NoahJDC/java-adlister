import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao (Config config) throws SQLException {
    DriverManager.registerDriver(new Driver());
        String user = config.getUser();
        String password = config.getPassword();
        String url = config.getUrl();
        connection = DriverManager.getConnection(
                url,
                user,
                password
        );

    }

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long user_id = resultSet.getLong("user_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Ad ad = new Ad(id, user_id, title, description);
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads from the database", e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads(user_id, title, description) VALUES " +
                "(" + ad.getUserId() + ", " +
                "'" + ad.getTitle() +"', " +
                "'" + ad.getDescription() + "')";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = stmt.getGeneratedKeys();
            if(resultSet.next()){
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting a new ad", e);
        }
        return null;
    }



}
