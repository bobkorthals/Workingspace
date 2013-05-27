/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facility.findAll", query = "SELECT f FROM Facility f"),
    @NamedQuery(name = "Facility.findById", query = "SELECT f FROM Facility f WHERE f.id = :id"),
    @NamedQuery(name = "Facility.findByActivity", query = "SELECT f FROM Facility f WHERE f.activity = :activity"),
    @NamedQuery(name = "Facility.findByCapacity", query = "SELECT f FROM Facility f WHERE f.capacity = :capacity"),
    @NamedQuery(name = "Facility.findByDescription", query = "SELECT f FROM Facility f WHERE f.description = :description"),
    @NamedQuery(name = "Facility.findByCosts", query = "SELECT f FROM Facility f WHERE f.costs = :costs"),
    @NamedQuery(name = "Facility.findByTypen", query = "SELECT f FROM Facility f WHERE f.typen = :typen")})
public class Facility implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String activity;
    @Basic(optional = false)
    private int capacity;
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal costs;
    @Basic(optional = false)
    private String typen;
    @JoinColumn(name = "locationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Locations locationid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityid")
    private Collection<Reservation> reservationCollection;

    public Facility() {
    }

    public Facility(Integer id) {
        this.id = id;
    }

    public Facility(Integer id, String activity, int capacity, BigDecimal costs, String typen) {
        this.id = id;
        this.activity = activity;
        this.capacity = capacity;
        this.costs = costs;
        this.typen = typen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getTypen() {
        return typen;
    }

    public void setTypen(String typen) {
        this.typen = typen;
    }

    public Locations getLocationid() {
        return locationid;
    }

    public void setLocationid(Locations locationid) {
        this.locationid = locationid;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facility)) {
            return false;
        }
        Facility other = (Facility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Facility[ id=" + id + " ]";
    }
    
}
