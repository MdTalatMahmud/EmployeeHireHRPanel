package au.mgemployeehire.employeehirehrpanel;

public class JobApplyRecords {

    private String applicantName;
    private String email;//this is signed in email
    private String applicantContactEmail;
    private String applicantContactNumber;
    private String applicantExperience;
    private String applicantLicense;

    public JobApplyRecords(){
        //default constructor
    }

    public JobApplyRecords(String applicantName, String email, String applicantContactEmail, String applicantContactNumber, String applicantExperience, String applicantLicense) {
        this.applicantName = applicantName;
        this.email = email;
        this.applicantContactEmail = applicantContactEmail;
        this.applicantContactNumber = applicantContactNumber;
        this.applicantExperience = applicantExperience;
        this.applicantLicense = applicantLicense;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApplicantContactEmail() {
        return applicantContactEmail;
    }

    public void setApplicantContactEmail(String applicantContactEmail) {
        this.applicantContactEmail = applicantContactEmail;
    }

    public String getApplicantContactNumber() {
        return applicantContactNumber;
    }

    public void setApplicantContactNumber(String applicantContactNumber) {
        this.applicantContactNumber = applicantContactNumber;
    }

    public String getApplicantExperience() {
        return applicantExperience;
    }

    public void setApplicantExperience(String applicantExperience) {
        this.applicantExperience = applicantExperience;
    }

    public String getApplicantLicense() {
        return applicantLicense;
    }

    public void setApplicantLicense(String applicantLicense) {
        this.applicantLicense = applicantLicense;
    }
}
