package pas.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import mvc.model.PropertyChangeSupportInterface;
import pas.models.db.Finance;

/**
 *
 * @author Ruben
 */
public class FinancialData implements PropertyChangeSupportInterface {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public FinancialData(Finance dbResult){
        
    }
        
    /**
     * Implementation of addPropertyChangeListener
     * @param listener 
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Implementation of removePropertyChangeListener
     * @param listener 
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
