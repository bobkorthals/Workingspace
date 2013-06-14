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
    @NamedQuery(name = "Finance.getProductRevenuesByLocation", 
        query = "SELECT 	product.name, categorie.omschrijving, SUM(product.prijs) AS omzet, vestiging.id, vestiging.naam"+
                "FROM 		factuuritem"+
                "LEFT JOIN 	product 		ON product.id 			= factuuritem.productid"+
                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid"+
                "LEFT JOIN 	bestelling 		ON bestelling.id 		= factuuritem.bestellingid"+
                "LEFT JOIN	categorie		ON categorie.id			= product.categorieid"+
                "WHERE 		vestiging.id 						= :vestiging"+
                "AND		factuuritem.tijddatum	BETWEEN :timeofset		AND :timeendset"+
                "GROUP BY	product.name, categorie.omschrijving, vestiging.id, vestiging.naam"),
    
    @NamedQuery(name = "Finance.getProductRevenues", 
        query = "SELECT 	product.name, categorie.omschrijving, SUM(product.prijs) AS omzet, vestiging.id, vestiging.naam"+
                "FROM 		factuuritem"+
                "LEFT JOIN 	product 		ON product.id 			= factuuritem.productid"+
                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid"+
                "LEFT JOIN 	bestelling 		ON bestelling.id 		= factuuritem.bestellingid"+
                "LEFT JOIN	categorie		ON categorie.id			= product.categorieid"+
                "AND		factuuritem.tijddatum	BETWEEN :timeofset		AND :timeendset"+
                "GROUP BY	product.name, categorie.omschrijving, vestiging.id, vestiging.naam"),
    @NamedQuery(name = "Finance.getFacilityRevenuesByLocation", 
        query = "SELECT		faciliteit.name, SUM(faciliteit.kosten) AS omzet, COUNT(reservering.faciliteitid) AS gebruikers, vestiging.id, vestiging.naam"+
                "FROM 		factuuritem"+
                "LEFT JOIN	reservering		ON reservering.id		= factuuritem.reserveringid"+
                "LEFT JOIN	faciliteit		ON faciliteit.id		= reservering.faciliteitid"+
                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid"+
                "WHERE		faciliteit.vestigingid					= :vestiging"+
                "AND		reservering.tijddatum	BETWEEN :timeoffset		AND :timeendset"+
                "GROUP BY	faciliteit.name, vestiging.id, vestiging.naam"),
    
    @NamedQuery(name = "Finance.getFacilityRevenues", 
        query = "SELECT		faciliteit.name, SUM(faciliteit.kosten) AS omzet, COUNT(reservering.faciliteitid) AS gebruikers, vestiging.id, vestiging.naam"+
                "FROM 		factuuritem"+
                "LEFT JOIN	reservering		ON reservering.id		= factuuritem.reserveringid"+
                "LEFT JOIN	faciliteit		ON faciliteit.id		= reservering.faciliteitid"+
                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid"+
                "AND		reservering.tijddatum	BETWEEN :timeoffset		AND :timeendset"+
                "GROUP BY	faciliteit.name, vestiging.id, vestiging.naam"),
    @NamedQuery(name = "Finance.getCourseRevenuesByLocation", 
        query = "SELECT		cursus.naam, SUM(cursus.kosten) AS omzet, COUNT(planning.id) AS deelnames, vestiging.id, vestiging.naam"+
                "FROM		factuuritem"+
                "LEFT JOIN	inschrijving		ON inschrijving.id		= factuuritem.inschrijvingid"+
                "LEFT JOIN	planning		ON planning.id			= inschrijving.planningid"+
                "LEFT JOIN	cursus			ON cursus.id			= planning.cursusid"+
                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid"+
                "WHERE		cursus.vestigingid					= :vestiging"+
                "AND		planning.tijddatum	BETWEEN :timeoffset		AND :timeendset"+
                "GROUP BY	planning.id, vestiging.id, cursus.naam, vestiging.naam"),    
    @NamedQuery(name = "Finance.getCourseRevenues", 
        query = "SELECT		cursus.naam, SUM(cursus.kosten) AS omzet, COUNT(planning.id) AS deelnames, vestiging.id, vestiging.naam"+
                "FROM		factuuritem"+
                "LEFT JOIN	inschrijving		ON inschrijving.id		= factuuritem.inschrijvingid"+
                "LEFT JOIN	planning		ON planning.id			= inschrijving.planningid"+
                "LEFT JOIN	cursus			ON cursus.id			= planning.cursusid"+
                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid"+
                "AND		planning.tijddatum	BETWEEN :timeoffset		AND :timeendset"+
                "GROUP BY	planning.id, vestiging.id, cursus.naam, vestiging.naam"),    
    @NamedQuery(name = "Finance.getSubscriptionRevenuesByLocation", 
        query = "SELECT		abonnement.name, SUM(abonnement.kosten) AS omzet, vestiging.id, vestiging.naam"+
                "FROM		factuuritem"+
                "LEFT JOIN	abonnering		ON abonnering.id		= factuuritem.abonneringid"+
                "LEFT JOIN	abonnement		ON abonnement.id		= abonnering.abonnementid"+
                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid"+
                "WHERE		factuuritem.vestigingid					= :vestiging"+
                "AND		abonnering.startdate 	BETWEEN :timeoffset 		AND :timeendset"+
                "OR		abonnering.enddate 	BETWEEN :timeoffset 	 	AND :timeendset"+
                "GROUP BY	abonnement.name, vestiging.id, vestiging.naam"),    
    @NamedQuery(name = "Finance.getSubscriptionRevenues", 
        query = "SELECT		abonnement.name, SUM(abonnement.kosten) AS omzet, vestiging.id, vestiging.naam"+
                "FROM		factuuritem"+
                "LEFT JOIN	abonnering		ON abonnering.id		= factuuritem.abonneringid"+
                "LEFT JOIN	abonnement		ON abonnement.id		= abonnering.abonnementid"+
                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid"+
                "AND		abonnering.startdate 	BETWEEN :timeoffset 		AND :timeendset"+
                "OR		abonnering.enddate 	BETWEEN :timeoffset 	 	AND :timeendset"+
                "GROUP BY	abonnement.name, vestiging.id, vestiging.naam")})
public class Finance implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "financeid")
    private List<Abonnering> abonneringList;

    public Finance() {
    }

    public Finance(Integer id) {
        this.id = id;
    }

    public Finance(Integer id, BigDecimal kosten, String periodes, String typen) {
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
        if (!(object instanceof Finance)) {
            return false;
        }
        Finance other = (Finance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Finance[ id=" + id + " ]";
    }
    
}
