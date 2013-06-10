package pas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mvc.Application;
import mvc.controller.InstanceController;
import pas.layout.MainFrame;
import pas.main.MainController;
import pas.models.ActiveMember;
import pas.models.SessionManager;

/**
 *
 * @author Frank
 */
public class PAS {
    
    public static final String PERSISTENCE_UNIT_NAME = "PASPU"; 

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        PAS.setLookAndFeel();
        
        Application application = Application.getInstance();
        SessionManager sessionManager = new SessionManager();
        sessionManager.setEntityManager(
                    Persistence.createEntityManagerFactory(PAS.PERSISTENCE_UNIT_NAME)
                               .createEntityManager());
        sessionManager.setActiveMember(new ActiveMember());
        application.setSessionManager(sessionManager);
        
        InstanceController instanceController = new InstanceController(new MainFrame());
        application.setInstanceController(instanceController);

        new MainController().mainAction();
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PAS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
