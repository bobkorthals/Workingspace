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
    @NamedQuery(name = "Cursus.findAll", query = "SELECT c FROM Cursus c"),
    @NamedQuery(name = "Cursus.findById", query = "SELECT c FROM Cursus c WHERE c.id = :id"),
    @NamedQuery(name = "Cursus.findByNaam", query = "SELECT c FROM Cursus c WHERE c.naam = :naam"),
    @NamedQuery(name = "Cursus.findByCapaciteit", query = "SELECT c FROM Cursus c WHERE c.capaciteit = :capaciteit"),
    @NamedQuery(name = "Cursus.findByMinimum", query = "SELECT c FROM Cursus c WHERE c.minimum = :minimum"),
    @NamedQuery(name = "Cursus.findByDuur", query = "SELECT c FROM Cursus c WHERE c.duur = :duur"),
    @NamedQuery(name = "Cursus.findByOmschrijving", query = "SELECT c FROM Cursus c WHERE c.omschrijving = :omschrijving"),
    @NamedQuery(name = "Cursus.findByKosten", query = "SELECT c FROM Cursus c WHERE c.kosten = :kosten")})
public class Cursus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String naam;
    @Basic(optional = false)
    private int capaciteit;
    @Basic(optional = false)
    private int minimum;
    @Basic(optional = false)
    private int duur;
    private String omschrijving;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal kosten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursusid")
    private List<Planning> planningList;
    @JoinColumn(name = "vestigingid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vestiging vestigingid;

    public Cursus() {
    }

    public Cursus(Integer id) {
        this.id = id;
    }

    public Cursus(Integer id, String naam, int capaciteit, int minimum, int duur, BigDecimal kosten) {
        this.id = id;
        this.naam = naam;
        this.capaciteit = capaciteit;
        this.minimum = minimum;
        this.duur = duur;
        this.kosten = kosten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getDuur() {
        return duur;
    }

    public void setDuur(int duur) {
        this.duur = duur;
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

    @XmlTransient
    public List<Planning> getPlanningList() {
        return planningList;
    }

    public void setPlanningList(List<Planning> planningList) {
        this.planningList = planningList;
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
        if (!(object instanceof Cursus)) {
            return false;
        }
        Cursus other = (Cursus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Cursus[ id=" + id + " ]";
    }
    
}
