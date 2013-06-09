package pas.financial;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author Ruben
 */
public class FinancialController extends AbstractController {

    private MainFrame mainFrame;

    public FinancialController() {
        mainFrame = (MainFrame) getMainFrame();
    }

    public void defaultAction() {
        mainFrame.setSidebarEnabled(false);
        mainFrame.setProfilePanelEnabled(true);
        this.openCollection();        
    }

    public void openRevenue(){
        Revenue view = new Revenue(this);
        this.open(view);
    }
    
    public void openPayment(){
        Payment view = new Payment(this);
        this.open(view);
    }
    
    public void openCost(){
        Cost view = new Cost(this);
        this.open(view);
    }
    
    public void openCollection(){
        Collection view = new Collection(this);
        this.open(view);
    }
}
