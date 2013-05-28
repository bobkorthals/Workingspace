package pas.models.role;

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

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
