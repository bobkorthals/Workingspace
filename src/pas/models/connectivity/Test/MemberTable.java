/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.connectivity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pas.models.db.Member;

/**
 *
 * @author jkg
 */
public class MemberTable {

    private final DbManagerTest dbmanager;
    private Member member;

    public MemberTable(DbManagerTest dbmanager) {
        this.dbmanager = dbmanager;
    }

    public List<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lid ORDER BY lidnummer ASC";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                Member member = new Member(
                        result.getString("voornaam"),
                        result.getString("achternaam"),
                        result.getString("tussenvoegsel"),
                        result.getString("geslacht"),
                        result.getString("geboortedatum"),
                        result.getInt("lidnummer"));
                members.add(member);
            }
        } catch (SQLException e) {
            System.err.println(DbManagerTest.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
        return members;
    }

    public Member getMemberById(String memberId) {
        Member member = null;
        try {
            String sql = "SELECT * FROM lid WHERE lidnummer='" + memberId + "'";
            ResultSet result = dbmanager.doQuery(sql);
            if (result.next()) {
                member = new Member(
                        result.getString("voornaam"),
                        result.getString("achternaam"),
                        result.getString("tussenvoegsel"),
                        result.getString("geslacht"),
                        result.getString("geboortedatum"),                        
                        result.getInt("lidnummer"));
            }
        } catch (SQLException e) {
            System.err.println(DbManagerTest.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
        return member;
    }
}