/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mvc.Application;
import pas.exception.NoEntityManagerException;
import pas.layout.MainFrame;
import pas.models.SessionManager;
import session.NoSessionManagerException;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lid.findAll", query = "SELECT l FROM Lid l"),
    @NamedQuery(name = "Lid.findById", query = "SELECT l FROM Lid l WHERE l.id = :id"),
    @NamedQuery(name = "Lid.findBySleutelid", query = "SELECT l FROM Lid l WHERE l.sleutelid = :sleutelid"),
    @NamedQuery(name = "Lid.findByIdentiteitsid", query = "SELECT l FROM Lid l WHERE l.identiteitsid = :identiteitsid"),
    @NamedQuery(name = "Lid.findByBestandslocatie", query = "SELECT l FROM Lid l WHERE l.bestandslocatie = :bestandslocatie"),
    @NamedQuery(name = "Lid.findByCredit", query = "SELECT l FROM Lid l WHERE l.credit = :credit"),
    @NamedQuery(name = "Lid.findByVoornaam", query = "SELECT l FROM Lid l WHERE l.voornaam = :voornaam"),
    @NamedQuery(name = "Lid.findByTussenvoegsel", query = "SELECT l FROM Lid l WHERE l.tussenvoegsel = :tussenvoegsel"),
    @NamedQuery(name = "Lid.findByAchternaam", query = "SELECT l FROM Lid l WHERE l.achternaam = :achternaam"),
    @NamedQuery(name = "Lid.findByGeboortedatum", query = "SELECT l FROM Lid l WHERE l.geboortedatum = :geboortedatum"),
    @NamedQuery(name = "Lid.findByGeslacht", query = "SELECT l FROM Lid l WHERE l.geslacht = :geslacht"),
    @NamedQuery(name = "Lid.findByMobiel", query = "SELECT l FROM Lid l WHERE l.mobiel = :mobiel"),
    @NamedQuery(name = "Lid.findByTelefoonnummer", query = "SELECT l FROM Lid l WHERE l.telefoonnummer = :telefoonnummer"),
    @NamedQuery(name = "Lid.findByEmail", query = "SELECT l FROM Lid l WHERE l.email = :email"),
    @NamedQuery(name = "Lid.findByStraatnaam", query = "SELECT l FROM Lid l WHERE l.straatnaam = :straatnaam"),
    @NamedQuery(name = "Lid.findByHuisnummer", query = "SELECT l FROM Lid l WHERE l.huisnummer = :huisnummer"),
    @NamedQuery(name = "Lid.findByAchtervoegsel", query = "SELECT l FROM Lid l WHERE l.achtervoegsel = :achtervoegsel"),
    @NamedQuery(name = "Lid.findByPostcode", query = "SELECT l FROM Lid l WHERE l.postcode = :postcode"),
    @NamedQuery(name = "Lid.findByPlaats", query = "SELECT l FROM Lid l WHERE l.plaats = :plaats"),
    @NamedQuery(name = "Lid.findByStatus", query = "SELECT l FROM Lid l WHERE l.status = :status"),
    @NamedQuery(name = "Lid.findByOpmerking", query = "SELECT l FROM Lid l WHERE l.opmerking = :opmerking"),
    @NamedQuery(name = "Lid.findByIdentiteitid", query = "SELECT l FROM Lid l WHERE l.identiteitid = :identiteitid"),
    @NamedQuery(name = "Lid.findByCheckin", query = "SELECT l FROM Lid l WHERE l.checkin = :checkin"),
    @NamedQuery(name = "Lid.search", query = "SELECT l FROM Lid l WHERE l.searchable LIKE :searchable"),
    @NamedQuery(name = "Lid.update", query = "UPDATE Lid SET voornaam = :voornaam")})
public class Lid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int sleutelid;
    @Basic(optional = false)
    private int identiteitsid;
    private String bestandslocatie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal credit;
    @Basic(optional = false)
    private String voornaam;
    private String tussenvoegsel;
    @Basic(optional = false)
    private String achternaam;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date geboortedatum;
    @Basic(optional = false)
    private int geslacht;
    private String mobiel;
    private String telefoonnummer;
    private String email;
    @Basic(optional = false)
    private String straatnaam;
    @Basic(optional = false)
    private int huisnummer;
    private String achtervoegsel;
    @Basic(optional = false)
    private String postcode;
    @Basic(optional = false)
    private String plaats;
    @Basic(optional = false)
    private String status;
    private String opmerking;
    @Basic(optional = false)
    private int identiteitid;
    private Integer checkin;
    private String searchable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lidid")
    private List<Toegang> toegangList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lidid")
    private List<Bestelling> bestellingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lidid")
    private List<Inschrijving> inschrijvingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lidid")
    private List<Abonnering> abonneringList;
    @JoinColumn(name = "werknemerid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Werknemer werknemerid;
    @JoinColumn(name = "vestigingid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vestiging vestigingid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lidid")
    private List<Factuur> factuurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lidid")
    private List<Reservering> reserveringList;

    public Lid() {
    }

    public Lid(Integer id) {
        this.id = id;
    }

    public Lid(Integer id, int sleutelid, int identiteitsid, BigDecimal credit, String voornaam, String achternaam, Date geboortedatum, int geslacht, String straatnaam, int huisnummer, String postcode, String plaats, String status, int identiteitid) {
        this.id = id;
        this.sleutelid = sleutelid;
        this.identiteitsid = identiteitsid;
        this.credit = credit;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.geslacht = geslacht;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
        this.status = status;
        this.identiteitid = identiteitid;
    }
    
    /*
     * Returns the Sessionmanager
     * 
     * @return SessionManager
     */
    private SessionManager getSessionManager() {
        try {
            return (SessionManager) Application.getInstance().getSessionManager();
        } catch (NoSessionManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
     * Returns the database entity manager
     * 
     * @return EntityManager
     */
    private EntityManager getEntityManager() {
        try {
            return this.getSessionManager().getEntityManager();
        } catch (NoEntityManagerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSleutelid() {
        return sleutelid;
    }

    public void setSleutelid(int sleutelid) {
        this.sleutelid = sleutelid;
    }

    public int getIdentiteitsid() {
        return identiteitsid;
    }

    public void setIdentiteitsid(int identiteitsid) {
        this.identiteitsid = identiteitsid;
    }

    public String getBestandslocatie() {
        return bestandslocatie;
    }

    public void setBestandslocatie(String bestandslocatie) {
        this.bestandslocatie = bestandslocatie;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public int getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(int geslacht) {
        this.geslacht = geslacht;
    }

    public String getMobiel() {
        return mobiel;
    }

    public void setMobiel(String mobiel) {
        this.mobiel = mobiel;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getAchtervoegsel() {
        return achtervoegsel;
    }

    public void setAchtervoegsel(String achtervoegsel) {
        this.achtervoegsel = achtervoegsel;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public int getIdentiteitid() {
        return identiteitid;
    }

    public void setIdentiteitid(int identiteitid) {
        this.identiteitid = identiteitid;
    }

    public Integer getCheckin() {
        return checkin;
    }

    public void setCheckin(Integer checkin) {
        this.checkin = checkin;
    }

    public String getSearchable() {
        return searchable;
    }

    public void setSearchable(String searchable) {
        this.searchable = searchable;
    }

    @XmlTransient
    public List<Toegang> getToegangList() {
        return toegangList;
    }

    public void setToegangList(List<Toegang> toegangList) {
        this.toegangList = toegangList;
    }

    @XmlTransient
    public List<Bestelling> getBestellingList() {
        return bestellingList;
    }

    public void setBestellingList(List<Bestelling> bestellingList) {
        this.bestellingList = bestellingList;
    }

    @XmlTransient
    public List<Inschrijving> getInschrijvingList() {
        return inschrijvingList;
    }

    public void setInschrijvingList(List<Inschrijving> inschrijvingList) {
        this.inschrijvingList = inschrijvingList;
    }

    @XmlTransient
    public List<Abonnering> getAbonneringList() {
        return abonneringList;
    }

    public void setAbonneringList(List<Abonnering> abonneringList) {
        this.abonneringList = abonneringList;
    }

    public Werknemer getWerknemerid() {
        return werknemerid;
    }

    public void setWerknemerid(Werknemer werknemerid) {
        this.werknemerid = werknemerid;
    }

    public Vestiging getVestigingid() {
        return vestigingid;
    }

    public void setVestigingid(Vestiging vestigingid) {
        this.vestigingid = vestigingid;
    }

    @XmlTransient
    public List<Factuur> getFactuurList() {
        return factuurList;
    }

    public void setFactuurList(List<Factuur> factuurList) {
        this.factuurList = factuurList;
    }

    @XmlTransient
    public List<Reservering> getReserveringList() {
        return reserveringList;
    }

    public void setReserveringList(List<Reservering> reserveringList) {
        this.reserveringList = reserveringList;
    }
    
    public void save() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("Lid.update");
        query.setParameter("voornaam", this.getVoornaam());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.clear();
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
        if (!(object instanceof Lid)) {
            return false;
        }
        Lid other = (Lid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Lid[ id=" + id + " ]";
    }
    
}
