import java.util.Date;

public class MasterPatient {
    private String firstName;
    private String lastName;
    private String address;
    private Date lastUpdateDate;

    public MasterPatient(){

    }

    public MasterPatient(String firstName, String lastName, String address, Date lastUpdateDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
