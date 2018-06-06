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
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        String query = "INSERT INTO ads(user_id, title, description) VALUES (ad.getUserid(), ad.getTitle(), ad.getDescription())";
        try {
            System.out.println(query);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = stmt.getGeneratedKeys();
            if(resultSet.next()){
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
