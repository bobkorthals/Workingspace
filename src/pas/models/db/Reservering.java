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
    @NamedQuery(name = "Reservering.findAll", query = "SELECT r FROM Reservering r"),
    @NamedQuery(name = "Reservering.findById", query = "SELECT r FROM Reservering r WHERE r.id = :id"),
    @NamedQuery(name = "Reservering.findByTijddatum", query = "SELECT r FROM Reservering r WHERE r.tijddatum = :tijddatum")})
public class Reservering implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tijddatum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserveringid")
    private List<Toegang> toegangList;
    @OneToMany(mappedBy = "reserveringid")
    private List<Factuuritem> factuuritemList;
    @JoinColumn(name = "lidid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lid lidid;
    @JoinColumn(name = "faciliteitid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Faciliteit faciliteitid;

    public Reservering() {
    }

    public Reservering(Integer id) {
        this.id = id;
    }

    public Reservering(Integer id, Date tijddatum) {
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
    public List<Toegang> getToegangList() {
        return toegangList;
    }

    public void setToegangList(List<Toegang> toegangList) {
        this.toegangList = toegangList;
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

    public Faciliteit getFaciliteitid() {
        return faciliteitid;
    }

    public void setFaciliteitid(Faciliteit faciliteitid) {
        this.faciliteitid = faciliteitid;
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
        if (!(object instanceof Reservering)) {
            return false;
        }
        Reservering other = (Reservering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Reservering[ id=" + id + " ]";
    }
    
}
