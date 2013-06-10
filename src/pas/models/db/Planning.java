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
    @NamedQuery(name = "Planning.findAll", query = "SELECT p FROM Planning p"),
    @NamedQuery(name = "Planning.findById", query = "SELECT p FROM Planning p WHERE p.id = :id"),
    @NamedQuery(name = "Planning.findByTijddatum", query = "SELECT p FROM Planning p WHERE p.tijddatum = :tijddatum")})
public class Planning implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tijddatum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planningid")
    private List<Inschrijving> inschrijvingList;
    @JoinColumn(name = "werknemerid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Werknemer werknemerid;
    @JoinColumn(name = "cursusid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cursus cursusid;

    public Planning() {
    }

    public Planning(Integer id) {
        this.id = id;
    }

    public Planning(Integer id, Date tijddatum) {
        this.id = id;
        this.tijddatum = tijddatum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTijddatum() {
        return tijddatum;
    }

    public void setTijddatum(Date tijddatum) {
        this.tijddatum = tijddatum;
    }

    @XmlTransient
    public List<Inschrijving> getInschrijvingList() {
        return inschrijvingList;
    }

    public void setInschrijvingList(List<Inschrijving> inschrijvingList) {
        this.inschrijvingList = inschrijvingList;
    }

    public Werknemer getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Werknemer werknemerid) {
        this.werknemerid = werknemerid;
    }

    public Cursus getCursusid() {
        return cursusid;
    }

    public void setCursusid(Cursus cursusid) {
        this.cursusid = cursusid;
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
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Planning[ id=" + id + " ]";
    }
    
}
