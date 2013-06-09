/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factuuritem.findAll", query = "SELECT f FROM Factuuritem f"),
    @NamedQuery(name = "Factuuritem.findById", query = "SELECT f FROM Factuuritem f WHERE f.id = :id")})
public class Factuuritem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "reserveringid", referencedColumnName = "id")
    @ManyToOne
    private Reservering reserveringid;
    @JoinColumn(name = "productid", referencedColumnName = "id")
    @ManyToOne
    private Product productid;
    @JoinColumn(name = "inschrijvingid", referencedColumnName = "id")
    @ManyToOne
    private Inschrijving inschrijvingid;
    @JoinColumn(name = "factuurid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factuur factuurid;
    @JoinColumn(name = "bestellingid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bestelling bestellingid;
    @JoinColumn(name = "abonneringid", referencedColumnName = "id")
    @ManyToOne
    private Abonnering abonneringid;

    public Factuuritem() {
    }

    public Factuuritem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservering getReserveringid() {
        return reserveringid;
    }

    public void setReserveringid(Reservering reserveringid) {
        this.reserveringid = reserveringid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    public Inschrijving getInschrijvingid() {
        return inschrijvingid;
    }

    public void setInschrijvingid(Inschrijving inschrijvingid) {
        this.inschrijvingid = inschrijvingid;
    }

    public Factuur getFactuurid() {
        return factuurid;
    }

    public void setFactuurid(Factuur factuurid) {
        this.factuurid = factuurid;
    }

    public Bestelling getBestellingid() {
        return bestellingid;
    }

    public void setBestellingid(Bestelling bestellingid) {
        this.bestellingid = bestellingid;
    }

    public Abonnering getAbonneringid() {
        return abonneringid;
    }

    public void setAbonneringid(Abonnering abonneringid) {
        this.abonneringid = abonneringid;
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
        if (!(object instanceof Factuuritem)) {
            return false;
        }
        Factuuritem other = (Factuuritem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Factuuritem[ id=" + id + " ]";
    }
    
}
