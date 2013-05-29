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
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s"),
    @NamedQuery(name = "Subscription.findById", query = "SELECT s FROM Subscription s WHERE s.id = :id"),
    @NamedQuery(name = "Subscription.findByCosts", query = "SELECT s FROM Subscription s WHERE s.costs = :costs"),
    @NamedQuery(name = "Subscription.findByDescription", query = "SELECT s FROM Subscription s WHERE s.description = :description"),
    @NamedQuery(name = "Subscription.findByPeriodes", query = "SELECT s FROM Subscription s WHERE s.periodes = :periodes"),
    @NamedQuery(name = "Subscription.findByTypen", query = "SELECT s FROM Subscription s WHERE s.typen = :typen")})
public class Subscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal costs;
    private String description;
    @Basic(optional = false)
    private String periodes;
    @Basic(optional = false)
    private String typen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriptionid")
    private Collection<Subscribe> subscribeCollection;

    public Subscription() {
    }

    public Subscription(Integer id) {
        this.id = id;
    }

    public Subscription(Integer id, BigDecimal costs, String periodes, String typen) {
        this.id = id;
        this.costs = costs;
        this.periodes = periodes;
        this.typen = typen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriodes() {
        return periodes;
    }

    public void setPeriodes(String periodes) {
        this.periodes = periodes;
    }

    public String getTypen() {
        return typen;
    }

    public void setTypen(String typen) {
        this.typen = typen;
    }

    @XmlTransient
    public Collection<Subscribe> getSubscribeCollection() {
        return subscribeCollection;
    }

    public void setSubscribeCollection(Collection<Subscribe> subscribeCollection) {
        this.subscribeCollection = subscribeCollection;
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
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Subscription[ id=" + id + " ]";
    }
    
}
