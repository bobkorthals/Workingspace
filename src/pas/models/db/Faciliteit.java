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
    @NamedQuery(name = "Faciliteit.findAll", query = "SELECT f FROM Faciliteit f"),
    @NamedQuery(name = "Faciliteit.findById", query = "SELECT f FROM Faciliteit f WHERE f.id = :id"),
    @NamedQuery(name = "Faciliteit.findByCapaciteit", query = "SELECT f FROM Faciliteit f WHERE f.capaciteit = :capaciteit"),
    @NamedQuery(name = "Faciliteit.findByOmschrijving", query = "SELECT f FROM Faciliteit f WHERE f.omschrijving = :omschrijving"),
    @NamedQuery(name = "Faciliteit.findByKosten", query = "SELECT f FROM Faciliteit f WHERE f.kosten = :kosten"),
    @NamedQuery(name = "Faciliteit.findByTypen", query = "SELECT f FROM Faciliteit f WHERE f.typen = :typen")})
public class Faciliteit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int capaciteit;
    private String omschrijving;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal kosten;
    @Basic(optional = false)
    private String typen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faciliteitid")
    private List<Reservering> reserveringList;
    @JoinColumn(name = "vestigingid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vestiging vestigingid;

    public Faciliteit() {
    }

    public Faciliteit(Integer id) {
        this.id = id;
    }

    public Faciliteit(Integer id, int capaciteit, BigDecimal kosten, String typen) {
        this.id = id;
        this.capaciteit = capaciteit;
        this.kosten = kosten;
        this.typen = typen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public BigDecimal getKosten() {
        return kosten;
    }

    public void setKosten(BigDecimal kosten) {
        this.kosten = kosten;
    }

    public String getTypen() {
        return typen;
    }

    public void setTypen(String typen) {
        this.typen = typen;
    }

    @XmlTransient
    public List<Reservering> getReserveringList() {
        return reserveringList;
    }

    public void setReserveringList(List<Reservering> reserveringList) {
        this.reserveringList = reserveringList;
    }

    public Vestiging getVestigingid() {
        return vestigingid;
    }

    public void setVestigingid(Vestiging vestigingid) {
        this.vestigingid = vestigingid;
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
        if (!(object instanceof Faciliteit)) {
            return false;
        }
        Faciliteit other = (Faciliteit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Faciliteit[ id=" + id + " ]";
    }
    
}
