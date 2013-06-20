package pas.models;

import javax.persistence.EntityManager;
import pas.exception.NoEntityManagerException;
import pas.models.role.Member;
import session.SessionManagerInterface;

/**
 * The session manager provides indirect singleton access to secondary, non
 * crucial services.
 *
 * @author Frank
 */
public class SessionManager implements SessionManagerInterface {

    private EntityManager entityManager;
    private ActiveMember activeMember;
    private ActiveFacility activefacility;

    /*
     * Provides access to the database entity manager
     * 
     * @return EntityManager database entity manager
     * @throws NoEntityManagerException
     */
    public EntityManager getEntityManager() throws NoEntityManagerException {
        if (null == this.entityManager) {
            throw new NoEntityManagerException(
                    "No entity manager specified in the session manager");
        }
        this.entityManager.getTransaction();
        return this.entityManager;
    }

    /*
     * Sets the database entity manager
     * 
     * @param EntityManager database entity manager
     * @return void
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
     * Get the active member
     * 
     * @return ActiveMember active member
     */
    public ActiveMember getActiveMember() throws NoEntityManagerException {
        if (null == this.entityManager) {
            throw new NoEntityManagerException(
                    "No active member specified in the session manager");
        }

        return activeMember;
    }

    /*
     * Set the active facility
     * 
     * @param ActiveMember active facility
     * @return void
     */
    public void setActiveMember(ActiveMember currentMember) {
        this.activeMember = currentMember;
    }

    public ActiveFacility getActiveFacility() throws NoEntityManagerException {
        if (null == this.entityManager) {
            throw new NoEntityManagerException(
                    "No active facility specified in the session manager");
        }

        return activefacility;
    }

    /*
     * Set the active facility
     * 
     * @param ActiveMember active facility
     * @return void
     */
    public void setActiveFacility(ActiveFacility currentFacility) {
        this.activefacility = currentFacility;
    }
}
