package au.mgemployeehire.employeehirehrpanel;

public class JobApplyRecords {

    private String applicantName;
    private String email;//this is signed in email
    private String applicantContactEmail;
    private String applicantContactNumber;
    private String applicantEducationalQualification;
    private String applicantExperience;
    private String applicantLicense;
    private String applicantAvailability;
    private String encryptedEmailID;

    public JobApplyRecords(){
        //default constructor
    }

    public JobApplyRecords(String applicantName, String email, String applicantContactEmail, String applicantContactNumber, String applicantEducationalQualification, String applicantExperience, String applicantLicense, String applicantAvailability, String encryptedEmailID) {
        this.applicantName = applicantName;
        this.email = email;
        this.applicantContactEmail = applicantContactEmail;
        this.applicantContactNumber = applicantContactNumber;
        this.applicantEducationalQualification = applicantEducationalQualification;
        this.applicantExperience = applicantExperience;
        this.applicantLicense = applicantLicense;
        this.applicantAvailability = applicantAvailability;
        this.encryptedEmailID = encryptedEmailID;
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

    public String getApplicantEducationalQualification() {
        return applicantEducationalQualification;
    }

    public void setApplicantEducationalQualification(String applicantEducationalQualification) {
        this.applicantEducationalQualification = applicantEducationalQualification;
    }

    public String getApplicantAvailability() {
        return applicantAvailability;
    }

    public void setApplicantAvailability(String applicantAvailability) {
        this.applicantAvailability = applicantAvailability;
    }

    public String getEncryptedEmailID() {
        return encryptedEmailID;
    }

    public void setEncryptedEmailID(String encryptedEmail) {
        this.encryptedEmailID = encryptedEmail;
    }
}
