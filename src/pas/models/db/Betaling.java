/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Betaling.findAll", query = "SELECT b FROM Betaling b"),
    @NamedQuery(name = "Betaling.findById", query = "SELECT b FROM Betaling b WHERE b.id = :id"),
    @NamedQuery(name = "Betaling.findByTijddatum", query = "SELECT b FROM Betaling b WHERE b.tijddatum = :tijddatum"),
    @NamedQuery(name = "Betaling.findByLidid", query = "SELECT b FROM Betaling b WHERE b.lidid = :lidid"),
    @NamedQuery(name = "Betaling.findByMethode", query = "SELECT b FROM Betaling b WHERE b.methode = :methode"),
    @NamedQuery(name = "Betaling.findByRestant", query = "SELECT b FROM Betaling b WHERE b.restant = :restant"),
    @NamedQuery(name = "Betaling.findBySepa", query = "SELECT b FROM Betaling b WHERE b.sepa = :sepa")})
public class Betaling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tijddatum;
    @Basic(optional = false)
    private int lidid;
    @Basic(optional = false)
    private String methode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal restant;
    private Integer sepa;
    @JoinColumn(name = "factuurid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factuur factuurid;

    public Betaling() {
    }

    public Betaling(Integer id) {
        this.id = id;
    }

    public Betaling(Integer id, Date tijddatum, int lidid, String methode) {
        this.id = id;
        this.tijddatum = tijddatum;
        this.lidid = lidid;
        this.methode = methode;
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

    public int getLidid() {
        return lidid;
    }

    public void setLidid(int lidid) {
        this.lidid = lidid;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public BigDecimal getRestant() {
        return restant;
    }

    public void setRestant(BigDecimal restant) {
        this.restant = restant;
    }

    public Integer getSepa() {
        return sepa;
    }

    public void setSepa(Integer sepa) {
        this.sepa = sepa;
    }

    public Factuur getFactuurid() {
        return factuurid;
    }

    public void setFactuurid(Factuur factuurid) {
        this.factuurid = factuurid;
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
        if (!(object instanceof Betaling)) {
            return false;
        }
        Betaling other = (Betaling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Betaling[ id=" + id + " ]";
    }
    
}
