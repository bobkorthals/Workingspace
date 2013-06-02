package pas.models;

import javax.persistence.EntityManager;
import pas.exception.NoEntityManagerException;
import pas.models.role.Member;
import session.SessionManagerInterface;

/**
 * The session manager provides indirect singleton access to secondary, 
 * non crucial services.
 * 
 * @author Frank
 */
public class SessionManager implements SessionManagerInterface {
    
    private EntityManager entityManager;
    private Member currentMember;

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
        
        return entityManager;
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
     * Get the current member
     * 
     * @return Member current member
     */
    public Member getCurrentMember() {
        return currentMember;
    }

    /*
     * Set the current member
     * 
     * @param Member current member
     * @return void
     */
    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }
}
