/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.bar;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;

/**
 *
 * @author jkg
 */
public class BarController extends AbstractController {

    private MainFrame mainFrame;

    public BarController() {
        mainFrame = (MainFrame) getMainFrame();
    }

    public void barAction() {

        Bar view = new Bar(this);
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
        open(view);
    }

    public void newBarOrderAction() {
        newBarOrder view = new newBarOrder(this);
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(false);
        open(view);
    }

    public void editBarAction() {
        editBar view = new editBar(this);
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
        open(view);
    }

    public void productAction() {
        Product view = new Product(this);
        mainFrame.setSidebarEnabled(true);
        mainFrame.setProfilePanelEnabled(true);
        open(view);
    }

    public void paymentBarAction() {
        paymentBar view = new paymentBar(this);
        mainFrame.setSidebarEnabled(false);
        mainFrame.setProfilePanelEnabled(false);
        open(view);
    }
}
