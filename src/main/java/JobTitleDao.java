import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JobTitleDao {

    // Varmaan järkevintä tehdä olio noista, ja sitten vaan niitä tehdä ja pistää listaan.
    public ArrayList<String> getJobTitles(String language) throws Exception {
        Connection conn = MariaDbConnection.getConnection();
        ArrayList<String> jobTitles = new ArrayList<>();

        String sql = "select key_name, translation from translations where language = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, language);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Key name: " + rs.getString("key_name"));
                    jobTitles.add(rs.getString("translation"));
                } return jobTitles;
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("Error executing query: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error preparing statement: " + e.getMessage());
        }
    }

    public void addOrUpdateTranslation(String language, String jobTitle, String translation) throws Exception {
        Connection conn = MariaDbConnection.getConnection();

        String sql = "insert into translations (language, key_name, translation) values (?, ?, ?) " +
                "on duplicate key update translation = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, language);
            ps.setString(2, jobTitle);
            ps.setString(3, translation);
            ps.setString(4, translation);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error preparing statement: " + e.getMessage());
        }
    }
}
