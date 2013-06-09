/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @NamedQuery(name = "Factuur.findAll", query = "SELECT f FROM Factuur f"),
    @NamedQuery(name = "Factuur.findById", query = "SELECT f FROM Factuur f WHERE f.id = :id"),
    @NamedQuery(name = "Factuur.findByTimes", query = "SELECT f FROM Factuur f WHERE f.times = :times")})
public class Factuur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date times;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factuurid")
    private List<Factuuritem> factuuritemList;
    @JoinColumn(name = "lidid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lid lidid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factuurid")
    private List<Betaling> betalingList;

    public Factuur() {
    }

    public Factuur(Integer id) {
        this.id = id;
    }

    public Factuur(Integer id, Date times) {
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

    @XmlTransient
    public List<Betaling> getBetalingList() {
        return betalingList;
    }

    public void setBetalingList(List<Betaling> betalingList) {
        this.betalingList = betalingList;
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
        if (!(object instanceof Factuur)) {
            return false;
        }
        Factuur other = (Factuur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Factuur[ id=" + id + " ]";
    }
    
}
