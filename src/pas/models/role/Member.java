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
               ((Integer) dbResult.getGeslachte()).toString(),
               dbResult.getGeboortedatum());

        this.memberID = dbResult.getId();
    }

    /*
     * Return member id
     * 
     * @return int memberid
     */
    public int getMemberID() {
        return memberID;
    }
}
