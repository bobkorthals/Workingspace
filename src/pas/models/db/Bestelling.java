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
    @NamedQuery(name = "Bestelling.findAll", query = "SELECT b FROM Bestelling b"),
    @NamedQuery(name = "Bestelling.findById", query = "SELECT b FROM Bestelling b WHERE b.id = :id"),
    @NamedQuery(name = "Bestelling.findByTijddatum", query = "SELECT b FROM Bestelling b WHERE b.tijddatum = :tijddatum")})
public class Bestelling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tijddatum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestellingid")
    private List<Factuuritem> factuuritemList;
    @JoinColumn(name = "werknemerid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Werknemer werknemerid;
    @JoinColumn(name = "lidid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lid lidid;

    public Bestelling() {
    }

    public Bestelling(Integer id) {
        this.id = id;
    }

    public Bestelling(Integer id, Date tijddatum) {
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
    public List<Factuuritem> getFactuuritemList() {
        return factuuritemList;
    }

    public void setFactuuritemList(List<Factuuritem> factuuritemList) {
        this.factuuritemList = factuuritemList;
    }

    public Werknemer getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Werknemer werknemerid) {
        this.werknemerid = werknemerid;
    }

    public Lid getLidid() {
        return lidid;
    }

    public void setLidid(Lid lidid) {
        this.lidid = lidid;
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
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Bestelling[ id=" + id + " ]";
    }
    
}
