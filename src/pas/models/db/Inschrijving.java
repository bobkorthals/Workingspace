/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inschrijving.findAll", query = "SELECT i FROM Inschrijving i"),
    @NamedQuery(name = "Inschrijving.findById", query = "SELECT i FROM Inschrijving i WHERE i.id = :id")})
public class Inschrijving implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inschrijvingid")
    private List<Toegang> toegangList;
    @OneToMany(mappedBy = "inschrijvingid")
    private List<Factuuritem> factuuritemList;
    @JoinColumn(name = "planningid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Planning planningid;
    @JoinColumn(name = "lidid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lid lidid;

    public Inschrijving() {
    }

    public Inschrijving(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Planning getPlanningid() {
        return planningid;
    }

    public void setPlanningid(Planning planningid) {
        this.planningid = planningid;
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
        if (!(object instanceof Inschrijving)) {
            return false;
        }
        Inschrijving other = (Inschrijving) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Inschrijving[ id=" + id + " ]";
    }
    
}
