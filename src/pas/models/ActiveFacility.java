package pas.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import mvc.model.PropertyChangeSupportInterface;
import pas.models.db.Faciliteit;

/**
 *
 * @author Bob
 */
public class ActiveFacility implements PropertyChangeSupportInterface {

    // Propery name
    public static final String FACILITEIT = "faciliteit";
    // Active faciliteit
    private Faciliteit faciliteit;
    // Listeners
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /*
     * Is there an active faciliteit?
     * 
     * @return boolean
     */
    public boolean hasMember() {
        return null != this.faciliteit;
    }

    /*
     * Return the active faciliteit
     * 
     * @return Member active faciliteit
     */
    public Faciliteit getFaciliteit(){
        return faciliteit;
    }
      

    /*
     * Update active faciliteit
     */
    public void setFaciliteit(Faciliteit faciliteit) {
        if (this.propertyChangeSupport.hasListeners(null)) {
            this.propertyChangeSupport.firePropertyChange(
                    ActiveFacility.FACILITEIT, this.faciliteit, faciliteit);
        }

        this.faciliteit = faciliteit;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
