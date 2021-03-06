package au.mgemployeehire.employeehirehrpanel;

public class JobApplyRecords {

    private String email;

    public JobApplyRecords(){
        //default constructor
    }

    public JobApplyRecords(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
