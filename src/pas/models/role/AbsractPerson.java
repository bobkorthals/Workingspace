package pas.models.role;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import mvc.Application;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.models.SessionManager;
import session.NoSessionManagerException;

/**
 *
 * @author jkg
 */
public abstract class AbsractPerson {

    private String firstName;
    private String lastName;
    private String suffix;
    private String gender;
    private String dateOfBrith;
    private int age;

    public AbsractPerson(String firstName, String lastName, String suffix, String gender, String dateOfBrith) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }
    
    /*
     * Returns the Sessionmanager
     * 
     * @return SessionManager
     */
    protected SessionManager getSessionManager() {
        try {
            return (SessionManager) Application.getInstance().getSessionManager();
        } catch (NoSessionManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
     * Returns the database entity manager
     * 
     * @return EntityManager
     */
    protected EntityManager getEntityManager() {
        try {
            return this.getSessionManager().getEntityManager();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
