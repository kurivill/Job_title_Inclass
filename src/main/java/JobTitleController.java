import java.util.ArrayList;

public class JobTitleController {

    private JobTitleDao jobTitleDao;

    public JobTitleController() {
        this.jobTitleDao = new JobTitleDao();
    }

    public ArrayList<String> getJobTitles(String language) throws Exception {
        ArrayList<String> titles = jobTitleDao.getJobTitles(language);
        return titles;
    }

    public void addOrUpdateTranslation(String language, String jobTitle, String translation) throws Exception {
        jobTitleDao.addOrUpdateTranslation(language, jobTitle, translation);
    }
}
