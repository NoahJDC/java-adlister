import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        Config config = new Config();
        if (adsDao == null) {
            try {
                adsDao = new MySQLAdsDao(config);
            } catch (SQLException e){
                System.out.println("Error will robinson");
            }
        }
        return adsDao;
    }
}
