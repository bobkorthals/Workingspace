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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissie.findAll", query = "SELECT p FROM Permissie p"),
    @NamedQuery(name = "Permissie.findById", query = "SELECT p FROM Permissie p WHERE p.id = :id"),
    @NamedQuery(name = "Permissie.findByOmschrijving", query = "SELECT p FROM Permissie p WHERE p.omschrijving = :omschrijving"),
    @NamedQuery(name = "Permissie.findByToestaan", query = "SELECT p FROM Permissie p WHERE p.toestaan = :toestaan")})
public class Permissie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String omschrijving;
    @Basic(optional = false)
    private int toestaan;
    @ManyToMany(mappedBy = "permissieList")
    private List<Functie> functieList;
    @JoinColumn(name = "privilegeid", referencedColumnName = "id")
    @ManyToOne
    private Privilege privilegeid;
    @JoinColumn(name = "hulpbronid", referencedColumnName = "id")
    @ManyToOne
    private Hulpbron hulpbronid;
    @JoinColumn(name = "beweringid", referencedColumnName = "id")
    @ManyToOne
    private Bewering beweringid;

    public Permissie() {
    }

    public Permissie(Integer id) {
        this.id = id;
    }

    public Permissie(Integer id, int toestaan) {
        this.id = id;
        this.toestaan = toestaan;
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

    public int getToestaan() {
        return toestaan;
    }

    public void setToestaan(int toestaan) {
        this.toestaan = toestaan;
    }

    @XmlTransient
    public List<Functie> getFunctieList() {
        return functieList;
    }

    public void setFunctieList(List<Functie> functieList) {
        this.functieList = functieList;
    }

    public Privilege getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(Privilege privilegeid) {
        this.privilegeid = privilegeid;
    }

    public Hulpbron getHulpbronid() {
        return hulpbronid;
    }

    public void setHulpbronid(Hulpbron hulpbronid) {
        this.hulpbronid = hulpbronid;
    }

    public Bewering getBeweringid() {
        return beweringid;
    }

    public void setBeweringid(Bewering beweringid) {
        this.beweringid = beweringid;
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
        if (!(object instanceof Permissie)) {
            return false;
        }
        Permissie other = (Permissie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Permissie[ id=" + id + " ]";
    }
    
}
