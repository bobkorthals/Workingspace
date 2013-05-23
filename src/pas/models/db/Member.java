/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

/**
 *
 * @author jkg
 */
public class Member extends Person {

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
