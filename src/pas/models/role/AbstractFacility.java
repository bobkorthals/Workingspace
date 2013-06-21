package pas.models.role;

import java.math.BigDecimal;
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
public abstract class AbstractFacility{

    private String naamOmschrijving;
    private String soort;
    private Integer capaciteit;
    private BigDecimal kosten;

    public AbstractFacility(String naamOmschrijving, String soort, Integer capaciteit, BigDecimal kosten) {
        this.naamOmschrijving = naamOmschrijving;
        this.soort = soort;
        this.capaciteit = capaciteit;
        this.kosten = kosten;
    }

    public String getNaamOmschrijving() {
        return naamOmschrijving;
    }

    public void setNaamOmschrijving(String naamOmschrijving) {
        this.naamOmschrijving = naamOmschrijving;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String Soort) {
        this.soort = Soort;
    }

    public Integer getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(Integer capaciteit) {
        this.capaciteit = capaciteit;
    }

    public BigDecimal getKosten() {
        return kosten;
    }

    public void setKosten(BigDecimal kosten) {
        this.kosten = kosten;
    }
    
    /*
     * Returns the Sessionmanager
     * 
     * @return SessionManager
     */
    private SessionManager getSessionManager() {
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
    private EntityManager getEntityManager() {
        try {
            return this.getSessionManager().getEntityManager();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
