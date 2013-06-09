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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Functie.findAll", query = "SELECT f FROM Functie f"),
    @NamedQuery(name = "Functie.findById", query = "SELECT f FROM Functie f WHERE f.id = :id"),
    @NamedQuery(name = "Functie.findByOmschrijving", query = "SELECT f FROM Functie f WHERE f.omschrijving = :omschrijving")})
public class Functie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String omschrijving;
    @JoinTable(name = "functiepermissie", joinColumns = {
        @JoinColumn(name = "functieid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "permissieid", referencedColumnName = "id")})
    @ManyToMany
    private List<Permissie> permissieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "functieid")
    private List<Werknemer> werknemerList;

    public Functie() {
    }

    public Functie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @XmlTransient
    public List<Permissie> getPermissieList() {
        return permissieList;
    }

    public void setPermissieList(List<Permissie> permissieList) {
        this.permissieList = permissieList;
    }

    @XmlTransient
    public List<Werknemer> getWerknemerList() {
        return werknemerList;
    }

    public void setWerknemerList(List<Werknemer> werknemerList) {
        this.werknemerList = werknemerList;
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
        if (!(object instanceof Functie)) {
            return false;
        }
        Functie other = (Functie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Functie[ id=" + id + " ]";
    }
    
}
