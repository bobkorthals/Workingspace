/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ruben
 */
@Entity
@XmlRootElement
@NamedQueries({
//    @NamedQuery(name = "Finance.getRevenuesByLocation",
//                query = "SELECT f FROM factuuritem 80")
//    @NamedQuery(name = "Finance.getRevenues",
//                query = "SELECT f, p, v, b, c FROM Factuuritem f, Product p, Vestiging v, Bestelling b, Categorie c")
//        query = "SELECT 	product.name, categorie.omschrijving, SUM(product.prijs) AS omzet, vestiging.id, vestiging.naam "+
//                "FROM 		factuuritem "+
//                "LEFT JOIN 	product 		ON product.id 			= factuuritem.productid "+
//                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid "+
//                "LEFT JOIN 	bestelling 		ON bestelling.id 		= factuuritem.bestellingid "+
//                "LEFT JOIN	categorie		ON categorie.id			= product.categorieid "+
//                "WHERE 		vestiging.id 						= :vestiging "+
//                "AND		factuuritem.tijddatum	BETWEEN :timeofset		AND :timeendset "+
//                "GROUP BY	product.name, categorie.omschrijving, vestiging.id, vestiging.naam"),
//    @NamedQuery(name = "Finance.getProductRevenues", 
//        query = "SELECT 	product.name, categorie.omschrijving, SUM(product.prijs) AS omzet, vestiging.id, vestiging.naam "+
//                "FROM 		factuuritem "+
//                "LEFT JOIN 	product 		ON product.id 			= factuuritem.productid "+
//                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid "+
//                "LEFT JOIN 	bestelling 		ON bestelling.id 		= factuuritem.bestellingid "+
//                "LEFT JOIN	categorie		ON categorie.id			= product.categorieid "+
//                "AND		factuuritem.tijddatum	BETWEEN :timeofset		AND :timeendset "+
//                "GROUP BY	product.name, categorie.omschrijving, vestiging.id, vestiging.naam"),
//    @NamedQuery(name = "Finance.getFacilityRevenuesByLocation", 
//        query = "SELECT		faciliteit.name, SUM(faciliteit.kosten) AS omzet, COUNT(reservering.faciliteitid) AS gebruikers, vestiging.id, vestiging.naam "+
//                "FROM 		factuuritem "+
//                "LEFT JOIN	reservering		ON reservering.id		= factuuritem.reserveringid "+
//                "LEFT JOIN	faciliteit		ON faciliteit.id		= reservering.faciliteitid "+
//                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid "+
//                "WHERE		faciliteit.vestigingid					= :vestiging "+
//                "AND		reservering.tijddatum	BETWEEN :timeoffset		AND :timeendset "+
//                "GROUP BY	faciliteit.name, vestiging.id, vestiging.naam"),
//    
//    @NamedQuery(name = "Finance.getFacilityRevenues", 
//        query = "SELECT		faciliteit.name, SUM(faciliteit.kosten) AS omzet, COUNT(reservering.faciliteitid) AS gebruikers, vestiging.id, vestiging.naam "+
//                "FROM 		factuuritem "+
//                "LEFT JOIN	reservering		ON reservering.id		= factuuritem.reserveringid "+
//                "LEFT JOIN	faciliteit		ON faciliteit.id		= reservering.faciliteitid "+
//                "LEFT JOIN 	vestiging 		ON vestiging.id 		= factuuritem.vestigingid "+
//                "AND		reservering.tijddatum	BETWEEN :timeoffset		AND :timeendset "+
//                "GROUP BY	faciliteit.name, vestiging.id, vestiging.naam"),
//    @NamedQuery(name = "Finance.getCourseRevenuesByLocation", 
//        query = "SELECT		cursus.naam, SUM(cursus.kosten) AS omzet, COUNT(planning.id) AS deelnames, vestiging.id, vestiging.naam "+
//                "FROM		factuuritem "+
//                "LEFT JOIN	inschrijving		ON inschrijving.id		= factuuritem.inschrijvingid "+
//                "LEFT JOIN	planning		ON planning.id			= inschrijving.planningid "+
//                "LEFT JOIN	cursus			ON cursus.id			= planning.cursusid "+
//                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid "+
//                "WHERE		cursus.vestigingid					= :vestiging "+
//                "AND		planning.tijddatum	BETWEEN :timeoffset		AND :timeendset "+
//                "GROUP BY	planning.id, vestiging.id, cursus.naam, vestiging.naam"),    
//    @NamedQuery(name = "Finance.getCourseRevenues", 
//        query = "SELECT		cursus.naam, SUM(cursus.kosten) AS omzet, COUNT(planning.id) AS deelnames, vestiging.id, vestiging.naam "+
//                "FROM		factuuritem "+
//                "LEFT JOIN	inschrijving		ON inschrijving.id		= factuuritem.inschrijvingid "+
//                "LEFT JOIN	planning		ON planning.id			= inschrijving.planningid "+
//                "LEFT JOIN	cursus			ON cursus.id			= planning.cursusid "+
//                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid "+
//                "AND		planning.tijddatum	BETWEEN :timeoffset		AND :timeendset "+
//                "GROUP BY	planning.id, vestiging.id, cursus.naam, vestiging.naam"),    
//    @NamedQuery(name = "Finance.getSubscriptionRevenuesByLocation", 
//        query = "SELECT		abonnement.name, SUM(abonnement.kosten) AS omzet, vestiging.id, vestiging.naam "+
//                "FROM		factuuritem "+
//                "LEFT JOIN	abonnering		ON abonnering.id		= factuuritem.abonneringid "+
//                "LEFT JOIN	abonnement		ON abonnement.id		= abonnering.abonnementid "+
//                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid "+
//                "WHERE		factuuritem.vestigingid					= :vestiging "+
//                "AND		abonnering.startdate 	BETWEEN :timeoffset 		AND :timeendset "+
//                "OR		abonnering.enddate 	BETWEEN :timeoffset 	 	AND :timeendset "+
//                "GROUP BY	abonnement.name, vestiging.id, vestiging.naam"),    
//    @NamedQuery(name = "Finance.getSubscriptionRevenues", 
//        query = "SELECT		abonnement.name, SUM(abonnement.kosten) AS omzet, vestiging.id, vestiging.naam "+
//                "FROM		factuuritem "+
//                "LEFT JOIN	abonnering		ON abonnering.id		= factuuritem.abonneringid "+
//                "LEFT JOIN	abonnement		ON abonnement.id		= abonnering.abonnementid "+
//                "LEFT JOIN	vestiging		ON vestiging.id			= factuuritem.vestigingid "+
//                "AND		abonnering.startdate 	BETWEEN :timeoffset 		AND :timeendset "+
//                "OR		abonnering.enddate 	BETWEEN :timeoffset 	 	AND :timeendset "+
//                "GROUP BY	abonnement.name, vestiging.id, vestiging.naam")
})



public class Finance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private String productName;
    private Integer revenues;
    private Integer locationId;
    private String locationName;
    private Integer tijddatum;

    public Finance() {
    }

    public Finance(Integer id) {
        
    }

    public Finance(Integer id, BigDecimal kosten, String periodes, String typen) {
        
    }

    public Integer getLocationId() {
        return 0;
    }

    public Integer getRevenues() {
        return 0;
    }

    public String getLocation() {
        return "";
    }

    public String getProductName() {
        return "";
    }
}
