package Behavioral.ChainOfResponsibility.JobApplication;

public class JobApplication {
    private String applicationName;
    private String jobTitle;
    private String jobCode;
    private StringBuilder comments;


    public JobApplication(String applicationName, String jobTitle, String jobCode, StringBuilder comments) {
        this.applicationName = applicationName;
        this.jobTitle = jobTitle;
        this.jobCode = jobCode;
        this.comments = comments;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public StringBuilder getComments() {
        return comments;
    }

    public void setComments(StringBuilder comments) {
        this.comments = comments;
    }

    public String showComments(){
        return comments.toString();
    }
}
