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
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findById", query = "SELECT r FROM Registration r WHERE r.id = :id")})
public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registrationid")
    private Collection<Accessing> accessingCollection;
    @JoinColumn(name = "scheduleid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Schedule scheduleid;
    @JoinColumn(name = "memberid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member1 memberid;
    @OneToMany(mappedBy = "registrationid")
    private Collection<Invoiceline> invoicelineCollection;

    public Registration() {
    }

    public Registration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Accessing> getAccessingCollection() {
        return accessingCollection;
    }

    public void setAccessingCollection(Collection<Accessing> accessingCollection) {
        this.accessingCollection = accessingCollection;
    }

    public Schedule getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Schedule scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Member1 getMemberid() {
        return memberid;
    }

    public void setMemberid(Member1 memberid) {
        this.memberid = memberid;
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
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Registration[ id=" + id + " ]";
    }
    
}
