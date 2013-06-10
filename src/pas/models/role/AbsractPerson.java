package pas.models.role;

import java.util.Date;

/**
 *
 * @author jkg
 */
public abstract class AbsractPerson {

    private String firstName;
    private String lastName;
    private String suffix;
    private String gender;
    private Date dateOfBrith;

    public AbsractPerson(String firstName, String lastName, String suffix, String gender, Date dateOfBrith) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfBrith = dateOfBrith;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String Suffix) {
        this.suffix = Suffix;
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

    public Date getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(Date dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }
}
