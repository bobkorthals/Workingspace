package pas.models.role;

import javax.persistence.Query;
import pas.models.db.Member1;

/**
 *
 * @author jkg
 */
public class Member extends AbsractPerson {

    private int memberID;

    public Member(String firstName, String lastName, String suffix, String dateOfBirth, String gender, int memberID) {
        super(firstName, lastName, suffix, dateOfBirth, gender);
        this.memberID = memberID;
    }
    
    public Member(int memberId) {
        super(null, null, null, null, null);
        Query query = getEntityManager().createNamedQuery("Member1.findById");
        query.setParameter("id", memberId);
        Member1 member = (Member1) query.getSingleResult();
        
        member.getFirstname();
        
        setFirstName(member.getFirstname());
        setLastName(member.getLastname());
        setSuffix(member.getSuffix()); 
        setDateOfBrith(member.getBirthday().toString());
        setGender(((Integer) member.getGender()).toString());
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
