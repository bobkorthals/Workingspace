/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
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
    @NamedQuery(name = "Invoiceline.findAll", query = "SELECT i FROM Invoiceline i"),
    @NamedQuery(name = "Invoiceline.findById", query = "SELECT i FROM Invoiceline i WHERE i.id = :id")})
public class Invoiceline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoicelineid")
    private Collection<Invoice> invoiceCollection;
    @JoinColumn(name = "subscribeid", referencedColumnName = "id")
    @ManyToOne
    private Subscribe subscribeid;
    @JoinColumn(name = "reservationid", referencedColumnName = "id")
    @ManyToOne
    private Reservation reservationid;
    @JoinColumn(name = "registrationid", referencedColumnName = "id")
    @ManyToOne
    private Registration registrationid;
    @JoinColumn(name = "productid", referencedColumnName = "id")
    @ManyToOne
    private Product productid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoicelineid")
    private Collection<Orders> ordersCollection;

    public Invoiceline() {
    }

    public Invoiceline(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    public Subscribe getSubscribeid() {
        return subscribeid;
    }

    public void setSubscribeid(Subscribe subscribeid) {
        this.subscribeid = subscribeid;
    }

    public Reservation getReservationid() {
        return reservationid;
    }

    public void setReservationid(Reservation reservationid) {
        this.reservationid = reservationid;
    }

    public Registration getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(Registration registrationid) {
        this.registrationid = registrationid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof Invoiceline)) {
            return false;
        }
        Invoiceline other = (Invoiceline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Invoiceline[ id=" + id + " ]";
    }
    
}
