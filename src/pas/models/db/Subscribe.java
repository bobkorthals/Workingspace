/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Subscribe.findAll", query = "SELECT s FROM Subscribe s"),
    @NamedQuery(name = "Subscribe.findById", query = "SELECT s FROM Subscribe s WHERE s.id = :id"),
    @NamedQuery(name = "Subscribe.findByStartdate", query = "SELECT s FROM Subscribe s WHERE s.startdate = :startdate"),
    @NamedQuery(name = "Subscribe.findByEnddate", query = "SELECT s FROM Subscribe s WHERE s.enddate = :enddate")})
public class Subscribe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @JoinColumn(name = "subscriptionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subscription subscriptionid;
    @JoinColumn(name = "memberid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member1 memberid;
    @OneToMany(mappedBy = "subscribeid")
    private Collection<Invoiceline> invoicelineCollection;

    public Subscribe() {
    }

    public Subscribe(Integer id) {
        this.id = id;
    }

    public Subscribe(Integer id, Date startdate, Date enddate) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Subscription getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(Subscription subscriptionid) {
        this.subscriptionid = subscriptionid;
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
        if (!(object instanceof Subscribe)) {
            return false;
        }
        Subscribe other = (Subscribe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Subscribe[ id=" + id + " ]";
    }
    
}
