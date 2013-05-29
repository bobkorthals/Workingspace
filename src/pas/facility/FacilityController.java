/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.facility;

import mvc.controller.AbstractController;
import pas.layout.MainFrame;


/**
 *
 * @author jkg
 */
public class FacilityController extends AbstractController {
    private MainFrame mainFrame;
    
   public FacilityController(){
   mainFrame = (MainFrame) getMainFrame();
   }
    
    public void facilityAction(){
       Facility view = new Facility(this);
       mainFrame.setProfilePanelEnabled(true);
       mainFrame.setSidebarEnabled(true);
       open(view);
   }
   
   public void actionReservation(){
       ReservationFacility view = new ReservationFacility(this);
       mainFrame.setProfilePanelEnabled(true);
       mainFrame.setSidebarEnabled(true);
       open(view);
   }
   
   public void reservationChange(){
       ReservationChange view = new ReservationChange(this);
       mainFrame.setProfilePanelEnabled(true);
       mainFrame.setSidebarEnabled(true);
       open(view);
   }
   
   public void paymentAction(){
       ReservationPayment view = new ReservationPayment(this);
       mainFrame.setProfilePanelEnabled(true);
       mainFrame.setSidebarEnabled(true);
       open(view);
   }
   
   public void addFacilityAction(){
       AddFacility view = new AddFacility(this);
       mainFrame.setProfilePanelEnabled(true);
       mainFrame.setSidebarEnabled(true);
       open(view);
   }
}

