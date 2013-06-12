package pas.models.role;

import java.util.Date;
import pas.models.db.Lid;

/**
 *
 * @author Frank
 */
public class Member extends AbsractPerson {

    // Read-only memberId
    private int memberID;
    
    // Db result
    private Lid dbResult;

    /*
     * Create member from supplied data
     * 
     * @param firstname String
     * @param lastname String
     * @param suffix String
     * @param dateOfBirth Date
     * @param String gender
     */
    public Member(String firstName, String lastName, String suffix, Date dateOfBirth, String gender) {
        super(firstName, lastName, suffix, gender, dateOfBirth);
    }
    
    /*
     * Create member from db result
     * 
     * @param Lid dbResult
     */
    public Member(Lid dbResult) {
        super(
            dbResult.getVoornaam(), 
            dbResult.getAchternaam(),
            dbResult.getAchtervoegsel(),
            ((Integer) dbResult.getGeslacht()).toString(),
            dbResult.getGeboortedatum());
        
        this.dbResult = dbResult;
        this.memberID = dbResult.getId();
    }
    
    /*
     * Returns the Lid db result
     * 
     * @return Lid dbResult
     */
    private Lid getDbResult() {
        if (null == this.dbResult) {
            
        }
        
        return this.dbResult;
    }
    
    /*
     * Return member id
     * 
     * @return int memberid
     */
    public int getMemberID() {
        return memberID;
    }
    
    /*
     * Save current member state to db class
     * 
     * @return void
     */
    public void save() {
        Lid lid = this.getDbResult();
        lid.setVoornaam(getFirstName());
    }
}
