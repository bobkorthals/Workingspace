/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id"),
    @NamedQuery(name = "Reservation.findByTimes", query = "SELECT r FROM Reservation r WHERE r.times = :times")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date times;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationid")
    private Collection<Accessing> accessingCollection;
    @JoinColumn(name = "memberid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member memberid;
    @JoinColumn(name = "facilityid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Facility facilityid;
    @OneToMany(mappedBy = "reservationid")
    private Collection<Invoiceline> invoicelineCollection;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, Date times) {
        this.id = id;
        this.times = times;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @XmlTransient
    public Collection<Accessing> getAccessingCollection() {
        return accessingCollection;
    }

    public void setAccessingCollection(Collection<Accessing> accessingCollection) {
        this.accessingCollection = accessingCollection;
    }

    public Member getMemberid() {
        return memberid;
    }

    public void setMemberid(Member memberid) {
        this.memberid = memberid;
    }

    public Facility getFacilityid() {
        return facilityid;
    }

    public void setFacilityid(Facility facilityid) {
        this.facilityid = facilityid;
    }

    @XmlTransient
    public Collection<Invoiceline> getInvoicelineCollection() {
        return invoicelineCollection;
    }

    public void setInvoicelineCollection(Collection<Invoiceline> invoicelineCollection) {
        this.invoicelineCollection = invoicelineCollection;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Reservation[ id=" + id + " ]";
    }
    
}
