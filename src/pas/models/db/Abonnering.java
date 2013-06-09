/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @NamedQuery(name = "Abonnering.findAll", query = "SELECT a FROM Abonnering a"),
    @NamedQuery(name = "Abonnering.findById", query = "SELECT a FROM Abonnering a WHERE a.id = :id"),
    @NamedQuery(name = "Abonnering.findByStartdate", query = "SELECT a FROM Abonnering a WHERE a.startdate = :startdate"),
    @NamedQuery(name = "Abonnering.findByEnddate", query = "SELECT a FROM Abonnering a WHERE a.enddate = :enddate")})
public class Abonnering implements Serializable {
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
    @OneToMany(mappedBy = "abonneringid")
    private List<Factuuritem> factuuritemList;
    @JoinColumn(name = "lidid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lid lidid;
    @JoinColumn(name = "abonnementid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Abonnement abonnementid;

    public Abonnering() {
    }

    public Abonnering(Integer id) {
        this.id = id;
    }

    public Abonnering(Integer id, Date startdate, Date enddate) {
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

    @XmlTransient
    public List<Factuuritem> getFactuuritemList() {
        return factuuritemList;
    }

    public void setFactuuritemList(List<Factuuritem> factuuritemList) {
        this.factuuritemList = factuuritemList;
    }

    public Lid getLidid() {
        return lidid;
    }

    public void setLidid(Lid lidid) {
        this.lidid = lidid;
    }

    public Abonnement getAbonnementid() {
        return abonnementid;
    }

    public void setAbonnementid(Abonnement abonnementid) {
        this.abonnementid = abonnementid;
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
        if (!(object instanceof Abonnering)) {
            return false;
        }
        Abonnering other = (Abonnering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Abonnering[ id=" + id + " ]";
    }
    
}
