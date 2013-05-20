/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.facility;

import mvc.controller.AbstractController;

/**
 *
 * @author jkg
 */
public class FacilityController extends AbstractController {

   public void facilityAction(){
       Facility view = new Facility(this);
       open(view);
   }
   
   public void actionReservation(){
       ReservationFacility view = new ReservationFacility(this);
       open(view);
   }
   
   public void reservationChange(){
       ReservationChange view = new ReservationChange(this);
       open(view);
   }
   
   public void paymentAction(){
       ReservationPayment view = new ReservationPayment(this);
       open(view);
   }
}

