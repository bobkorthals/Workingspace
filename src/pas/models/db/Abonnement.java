/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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
    @NamedQuery(name = "Abonnement.findAll", query = "SELECT a FROM Abonnement a"),
    @NamedQuery(name = "Abonnement.findById", query = "SELECT a FROM Abonnement a WHERE a.id = :id"),
    @NamedQuery(name = "Abonnement.findByKosten", query = "SELECT a FROM Abonnement a WHERE a.kosten = :kosten"),
    @NamedQuery(name = "Abonnement.findByOmschrijving", query = "SELECT a FROM Abonnement a WHERE a.omschrijving = :omschrijving"),
    @NamedQuery(name = "Abonnement.findByPeriodes", query = "SELECT a FROM Abonnement a WHERE a.periodes = :periodes"),
    @NamedQuery(name = "Abonnement.findByTypen", query = "SELECT a FROM Abonnement a WHERE a.typen = :typen")})
public class Abonnement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal kosten;
    private String omschrijving;
    @Basic(optional = false)
    private String periodes;
    @Basic(optional = false)
    private String typen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abonnementid")
    private List<Abonnering> abonneringList;

    public Abonnement() {
    }

    public Abonnement(Integer id) {
        this.id = id;
    }

    public Abonnement(Integer id, BigDecimal kosten, String periodes, String typen) {
        this.id = id;
        this.kosten = kosten;
        this.periodes = periodes;
        this.typen = typen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getKosten() {
        return kosten;
    }

    public void setKosten(BigDecimal kosten) {
        this.kosten = kosten;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
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
    public List<Abonnering> getAbonneringList() {
        return abonneringList;
    }

    public void setAbonneringList(List<Abonnering> abonneringList) {
        this.abonneringList = abonneringList;
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
        if (!(object instanceof Abonnement)) {
            return false;
        }
        Abonnement other = (Abonnement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Abonnement[ id=" + id + " ]";
    }
    
}
