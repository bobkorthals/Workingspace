/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Bewering.findAll", query = "SELECT b FROM Bewering b"),
    @NamedQuery(name = "Bewering.findById", query = "SELECT b FROM Bewering b WHERE b.id = :id"),
    @NamedQuery(name = "Bewering.findByOmschrijving", query = "SELECT b FROM Bewering b WHERE b.omschrijving = :omschrijving")})
public class Bewering implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String omschrijving;
    @OneToMany(mappedBy = "beweringid")
    private List<Permissie> permissieList;

    public Bewering() {
    }

    public Bewering(Integer id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bewering)) {
            return false;
        }
        Bewering other = (Bewering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Bewering[ id=" + id + " ]";
    }
    
}
