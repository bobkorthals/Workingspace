/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.course;

import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.Application;
import mvc.controller.AbstractController;
import mvc.exception.NoInstanceControllerException;
import mvc.view.AbstractView;
import pas.layout.MainFrame;

/**
 *
 * @author U
 */
public class CourseController extends AbstractController {

    private MainFrame mainframe;

    public CourseController() {
        mainframe = (MainFrame) getMainFrame();
    }

    public void openReferer() {
        try {
            open(Application.getInstance().getInstanceController().getReferer());
        } catch (NoInstanceControllerException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CourseMainAction() {

        CourseMain view = new CourseMain(this);

        // Maakt Side Pane en het profiel scherm zichtbaar wat je links en rechtsbovenin de applicatie ziet
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
        open(view);
    }
    
    public void returnAction(AbstractView view){
        
        open(view);
    
    }

    public void AddCourseAction() {
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
        open(new AddCourse(this));
    }

    public void ScheduleCourseAction() {
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
        open(new ScheduleCourse(this));
    }

    public void AddScheduleAction() {
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
        open(new AddSchedule(this));
    }

    public void NewScheduleOrderAction() {
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
        open(new NewScheduleOrder(this));
    }

    public void PaymentScheduleAction() {
        mainframe.setSidebarEnabled(true);
        mainframe.setProfilePanelEnabled(true);
        open(new PaymentSchedule(this));
    }
    
    public void SearchMemberAction() {
        open(new SearchMember(this));
    }

}
