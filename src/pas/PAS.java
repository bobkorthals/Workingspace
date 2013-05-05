package pas;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mvc.Application;
import mvc.controller.InstanceController;
import pas.layout.MainFrame;
import pas.member.MemberController;

/**
 * 
 * @author Frank
 */
public class PAS {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        Application application = Application.getInstance();
        application.setInstanceController(
                new InstanceController(new MainFrame()));
        
        new MemberController().manageMemberAction();
    }
}
