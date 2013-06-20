/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
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
    @NamedQuery(name = "Vestiging.findAll", query = "SELECT v FROM Vestiging v"),
    @NamedQuery(name = "Vestiging.findById", query = "SELECT v FROM Vestiging v WHERE v.id = :id"),
    @NamedQuery(name = "Vestiging.findByNaam", query = "SELECT v FROM Vestiging v WHERE v.naam = :naam"),
    @NamedQuery(name = "Vestiging.findByTelefoonnummer", query = "SELECT v FROM Vestiging v WHERE v.telefoonnummer = :telefoonnummer"),
    @NamedQuery(name = "Vestiging.findByEmail", query = "SELECT v FROM Vestiging v WHERE v.email = :email"),
    @NamedQuery(name = "Vestiging.findByStraatnaam", query = "SELECT v FROM Vestiging v WHERE v.straatnaam = :straatnaam"),
    @NamedQuery(name = "Vestiging.findByHuisnummer", query = "SELECT v FROM Vestiging v WHERE v.huisnummer = :huisnummer"),
    @NamedQuery(name = "Vestiging.findByAchtervoegsel", query = "SELECT v FROM Vestiging v WHERE v.achtervoegsel = :achtervoegsel"),
    @NamedQuery(name = "Vestiging.findByPostcode", query = "SELECT v FROM Vestiging v WHERE v.postcode = :postcode"),
    @NamedQuery(name = "Vestiging.findByPlaats", query = "SELECT v FROM Vestiging v WHERE v.plaats = :plaats")})
public class Vestiging implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String naam;
    @Basic(optional = false)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vestigingid")
    private List<Werknemer> werknemerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vestigingid")
    private List<Lid> lidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vestigingid")
    private List<Faciliteit> faciliteitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vestigingid")
    private List<Cursus> cursusList;

    public Vestiging() {
    }

    public Vestiging(Integer id) {
        this.id = id;
    }

    public Vestiging(Integer id, String naam, String telefoonnummer, String straatnaam, int huisnummer, String postcode, String plaats) {
        this.id = id;
        this.naam = naam;
        this.telefoonnummer = telefoonnummer;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
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

    @XmlTransient
    public List<Werknemer> getWerknemerList() {
        return werknemerList;
    }

    public void setWerknemerList(List<Werknemer> werknemerList) {
        this.werknemerList = werknemerList;
    }

    @XmlTransient
    public List<Lid> getLidList() {
        return lidList;
    }

    public void setLidList(List<Lid> lidList) {
        this.lidList = lidList;
    }

    @XmlTransient
    public List<Faciliteit> getFaciliteitList() {
        return faciliteitList;
    }

    public void setFaciliteitList(List<Faciliteit> faciliteitList) {
        this.faciliteitList = faciliteitList;
    }

    @XmlTransient
    public List<Cursus> getCursusList() {
        return cursusList;
    }

    public void setCursusList(List<Cursus> cursusList) {
        this.cursusList = cursusList;
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
        if (!(object instanceof Vestiging)) {
            return false;
        }
        Vestiging other = (Vestiging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Vestiging[ id=" + id + " ]";
    }
    
}
