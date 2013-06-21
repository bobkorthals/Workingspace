package pas.models.role;

import java.math.BigDecimal;
import pas.models.db.Faciliteit;


public class FacilityModel extends AbstractFacility {

    // Read-only memberId
    private int faciliteitID;
    
    // Db result
    private Faciliteit dbResult;

    /*
     * Create member from supplied data
     * 
     * @param firstname String
     * @param lastname String
     * @param suffix String
     * @param dateOfBirth Date
     * @param String gender
     */
    public FacilityModel(String naamOmschrijving, String soort, Integer capaciteit, BigDecimal kosten) {
        super(naamOmschrijving, soort, capaciteit, kosten);
    }
    
    /*
     * Create member from db result
     * 
     * @param Lid dbResult
     */
    public FacilityModel(Faciliteit dbResult) {
        super(
            dbResult.getOmschrijving(), 
            dbResult.getSoort(),
            dbResult.getCapaciteit(),
            dbResult.getKosten());
        
        this.dbResult = dbResult;
        this.faciliteitID = dbResult.getId();
    }
    
    /*
     * Returns the Lid db result
     * 
     * @return Lid dbResult
     */
    private Faciliteit getDbResult() {
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
        return faciliteitID;
    }
    
    /*
     * Save current member state to db class
     * 
     * @return void
     */
    public void save() {
        Faciliteit faciliteit = this.getDbResult();
        faciliteit.setOmschrijving(getNaamOmschrijving());
        faciliteit.save();
    }
}
