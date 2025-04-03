import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JobTitleDao {

    // Varmaan järkevintä tehdä olio noista, ja sitten vaan niitä tehdä ja pistää listaan.
    public ArrayList<String> getJobTitles(String language) throws Exception {
        Connection conn = MariaDbConnection.getConnection();
        ArrayList<String> jobTitles = new ArrayList<>();

        String sql = "select job_title, translation from translations where language = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, language);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    jobTitles.add(rs.getString("translation"));

                }
            }

        }
    }
}
