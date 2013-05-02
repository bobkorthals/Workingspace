package pas;

import mvc.Application;
import mvc.controller.InstanceController;
import pas.layout.MainFrame;

/**
 * 
 * @author Frank
 */
public class PAS {

    public static void main(String[] args) {
        Application application = Application.getInstance();
        application.setInstanceController(
                new InstanceController(new MainFrame()));
        
        new MemberController().
    }
}
