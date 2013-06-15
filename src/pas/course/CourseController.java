/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.course;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mvc.Application;
import mvc.controller.AbstractController;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.member.MemberController;
import pas.models.ActiveMember;
import pas.models.SessionManager;
import pas.models.db.Cursus;
import pas.models.db.Vestiging;
import session.NoSessionManagerException;

/**
 *
 * @author U
 */
public class CourseController extends AbstractController {

    private MainFrame mainframe;

    public CourseController() {
        mainframe = (MainFrame) getMainFrame();
        // Maakt Side Pane en het profiel scherm zichtbaar wat je links en rechtsbovenin de applicatie ziet
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
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

    /*
     * Returns the active member
     * 
     * @return ActiveMember
     */
    private ActiveMember getActiveMember() {
        try {
            return getSessionManager().getActiveMember();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
     * Get course from the database
     * 
     * @return List<Cursus>
     */
    public List<Cursus> getCourseByLocatieId(Vestiging vestigingId) {
        Query query = getEntityManager().createNamedQuery("Cursus.findbyIdLocatie");
        query.setParameter("vestigingid", vestigingId);
        return query.getResultList();
    }

    /*
     * Get courses from the database
     * 
     * @return List<Cursus>
     */
    private List<Vestiging> getVestigingen() {
        Query query = getEntityManager().createNamedQuery("Vestiging.findAll");
        return query.getResultList();
    }

    public void CourseMainAction() {
        CourseMain view = new CourseMain(this);
        open(view);
    }

    public void AddCourseAction() {
        open(new AddCourse(this));
    }

    public void ScheduleCourseAction() {
        open(new ScheduleCourse(this));
    }

    public void AddScheduleAction() {
        open(new AddSchedule(this));
    }

    public void PaymentScheduleAction() {
        open(new PaymentSchedule(this,
                getActiveMember().getMember()));
    }

    public void NewScheduleOrderAction() {
        open(new NewScheduleOrder(this,
                getActiveMember().getMember(),
                getVestigingen()));
    }
}
