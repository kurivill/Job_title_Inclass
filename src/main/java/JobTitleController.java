import java.util.ArrayList;

public class JobTitleController {

    private JobTitleDao jobTitleDao;

    public JobTitleController() {
        this.jobTitleDao = new JobTitleDao();
    }

    public ArrayList<String> getJobTitles(String language) throws Exception {
        System.out.println(language);
        ArrayList<String> titles = jobTitleDao.getJobTitles(language);
        for (String title : titles) {
            System.out.println(title);
        }
        return titles;
    }

    public ArrayList<String> addOrUpdateTranslation(String language, String jobTitle, String translation) throws Exception {
        jobTitleDao.addOrUpdateTranslation(language, jobTitle, translation);
        return getJobTitles(language);
    }
}
