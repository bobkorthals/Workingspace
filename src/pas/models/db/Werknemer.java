/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Werknemer.findAll", query = "SELECT w FROM Werknemer w"),
    @NamedQuery(name = "Werknemer.findById", query = "SELECT w FROM Werknemer w WHERE w.id = :id"),
    @NamedQuery(name = "Werknemer.findByVoornaam", query = "SELECT w FROM Werknemer w WHERE w.voornaam = :voornaam"),
    @NamedQuery(name = "Werknemer.findByTussenvoegsel", query = "SELECT w FROM Werknemer w WHERE w.tussenvoegsel = :tussenvoegsel"),
    @NamedQuery(name = "Werknemer.findByAchternaam", query = "SELECT w FROM Werknemer w WHERE w.achternaam = :achternaam"),
    @NamedQuery(name = "Werknemer.findByGeboortedatum", query = "SELECT w FROM Werknemer w WHERE w.geboortedatum = :geboortedatum"),
    @NamedQuery(name = "Werknemer.findByGeslachte", query = "SELECT w FROM Werknemer w WHERE w.geslachte = :geslachte"),
    @NamedQuery(name = "Werknemer.findByMobiel", query = "SELECT w FROM Werknemer w WHERE w.mobiel = :mobiel"),
    @NamedQuery(name = "Werknemer.findByTelefoonnummer", query = "SELECT w FROM Werknemer w WHERE w.telefoonnummer = :telefoonnummer"),
    @NamedQuery(name = "Werknemer.findByEmail", query = "SELECT w FROM Werknemer w WHERE w.email = :email"),
    @NamedQuery(name = "Werknemer.findByIndienst", query = "SELECT w FROM Werknemer w WHERE w.indienst = :indienst"),
    @NamedQuery(name = "Werknemer.findByUitdienst", query = "SELECT w FROM Werknemer w WHERE w.uitdienst = :uitdienst"),
    @NamedQuery(name = "Werknemer.findByStraatnaam", query = "SELECT w FROM Werknemer w WHERE w.straatnaam = :straatnaam"),
    @NamedQuery(name = "Werknemer.findByHuisnummer", query = "SELECT w FROM Werknemer w WHERE w.huisnummer = :huisnummer"),
    @NamedQuery(name = "Werknemer.findByAchtervoegsel", query = "SELECT w FROM Werknemer w WHERE w.achtervoegsel = :achtervoegsel"),
    @NamedQuery(name = "Werknemer.findByPostcode", query = "SELECT w FROM Werknemer w WHERE w.postcode = :postcode"),
    @NamedQuery(name = "Werknemer.findByPlaats", query = "SELECT w FROM Werknemer w WHERE w.plaats = :plaats"),
    @NamedQuery(name = "Werknemer.findByStatus", query = "SELECT w FROM Werknemer w WHERE w.status = :status"),
    @NamedQuery(name = "Werknemer.findByWachtwoord", query = "SELECT w FROM Werknemer w WHERE w.wachtwoord = :wachtwoord"),
    @NamedQuery(name = "Werknemer.findByLaatstelogin", query = "SELECT w FROM Werknemer w WHERE w.laatstelogin = :laatstelogin"),
    @NamedQuery(name = "Werknemer.findByLaatstewijziging", query = "SELECT w FROM Werknemer w WHERE w.laatstewijziging = :laatstewijziging"),
    @NamedQuery(name = "Werknemer.findByOpmerking", query = "SELECT w FROM Werknemer w WHERE w.opmerking = :opmerking"),
    @NamedQuery(name = "Werknemer.findByIdentitynr", query = "SELECT w FROM Werknemer w WHERE w.identitynr = :identitynr")})
public class Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String voornaam;
    private String tussenvoegsel;
    @Basic(optional = false)
    private String achternaam;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date geboortedatum;
    @Basic(optional = false)
    private int geslachte;
    private String mobiel;
    private String telefoonnummer;
    private String email;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date indienst;
    @Temporal(TemporalType.DATE)
    private Date uitdienst;
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
    @Basic(optional = false)
    private String wachtwoord;
    @Temporal(TemporalType.TIMESTAMP)
    private Date laatstelogin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date laatstewijziging;
    private String opmerking;
    @Basic(optional = false)
    private int identitynr;
    @JoinColumn(name = "vestigingid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vestiging vestigingid;
    @JoinColumn(name = "functieid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Functie functieid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "werknemerid")
    private List<Bestelling> bestellingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "werknemerid")
    private List<Lid> lidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "werknemerid")
    private List<Planning> planningList;

    public Werknemer() {
    }

    public Werknemer(Integer id) {
        this.id = id;
    }

    public Werknemer(Integer id, String voornaam, String achternaam, Date geboortedatum, int geslachte, Date indienst, String straatnaam, int huisnummer, String postcode, String plaats, String status, String wachtwoord, int identitynr) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.geslachte = geslachte;
        this.indienst = indienst;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
        this.status = status;
        this.wachtwoord = wachtwoord;
        this.identitynr = identitynr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getGeslachte() {
        return geslachte;
    }

    public void setGeslachte(int geslachte) {
        this.geslachte = geslachte;
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

    public Date getIndienst() {
        return indienst;
    }

    public void setIndienst(Date indienst) {
        this.indienst = indienst;
    }

    public Date getUitdienst() {
        return uitdienst;
    }

    public void setUitdienst(Date uitdienst) {
        this.uitdienst = uitdienst;
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

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Date getLaatstelogin() {
        return laatstelogin;
    }

    public void setLaatstelogin(Date laatstelogin) {
        this.laatstelogin = laatstelogin;
    }

    public Date getLaatstewijziging() {
        return laatstewijziging;
    }

    public void setLaatstewijziging(Date laatstewijziging) {
        this.laatstewijziging = laatstewijziging;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public int getIdentitynr() {
        return identitynr;
    }

    public void setIdentitynr(int identitynr) {
        this.identitynr = identitynr;
    }

    public Vestiging getVestigingid() {
        return vestigingid;
    }

    public void setVestigingid(Vestiging vestigingid) {
        this.vestigingid = vestigingid;
    }

    public Functie getFunctieid() {
        return functieid;
    }

    public void setFunctieid(Functie functieid) {
        this.functieid = functieid;
    }

    @XmlTransient
    public List<Bestelling> getBestellingList() {
        return bestellingList;
    }

    public void setBestellingList(List<Bestelling> bestellingList) {
        this.bestellingList = bestellingList;
    }

    @XmlTransient
    public List<Lid> getLidList() {
        return lidList;
    }

    public void setLidList(List<Lid> lidList) {
        this.lidList = lidList;
    }

    @XmlTransient
    public List<Planning> getPlanningList() {
        return planningList;
    }

    public void setPlanningList(List<Planning> planningList) {
        this.planningList = planningList;
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
        if (!(object instanceof Werknemer)) {
            return false;
        }
        Werknemer other = (Werknemer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Werknemer[ id=" + id + " ]";
    }
    
}
