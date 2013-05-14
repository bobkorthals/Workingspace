package pas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mvc.Application;
import mvc.controller.InstanceController;
import pas.layout.MainFrame;
import pas.main.MainController;

/**
 *
 * @author Frank
 */
public class PAS {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        PAS.setLookAndFeel();
        Application application = Application.getInstance();
        application.setInstanceController(
                new InstanceController(new MainFrame()));

        new MainController().mainAction();
    }

   
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PAS.class.getName()).log(Level.SEVERE, null, ex);
        }

        //UIManager.put("Panel.background", new Color(0, 0, 0, 0));
    }
    
    
}
