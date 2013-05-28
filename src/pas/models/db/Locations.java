/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Collection;
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
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l"),
    @NamedQuery(name = "Locations.findById", query = "SELECT l FROM Locations l WHERE l.id = :id"),
    @NamedQuery(name = "Locations.findByLocationname", query = "SELECT l FROM Locations l WHERE l.locationname = :locationname"),
    @NamedQuery(name = "Locations.findByTelnumber", query = "SELECT l FROM Locations l WHERE l.telnumber = :telnumber"),
    @NamedQuery(name = "Locations.findByEmail", query = "SELECT l FROM Locations l WHERE l.email = :email"),
    @NamedQuery(name = "Locations.findByStreetname", query = "SELECT l FROM Locations l WHERE l.streetname = :streetname"),
    @NamedQuery(name = "Locations.findByHousenumber", query = "SELECT l FROM Locations l WHERE l.housenumber = :housenumber"),
    @NamedQuery(name = "Locations.findByHousesuffix", query = "SELECT l FROM Locations l WHERE l.housesuffix = :housesuffix"),
    @NamedQuery(name = "Locations.findByZipcode", query = "SELECT l FROM Locations l WHERE l.zipcode = :zipcode"),
    @NamedQuery(name = "Locations.findByCity", query = "SELECT l FROM Locations l WHERE l.city = :city")})
public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String locationname;
    @Basic(optional = false)
    private String telnumber;
    private String email;
    @Basic(optional = false)
    private String streetname;
    @Basic(optional = false)
    private int housenumber;
    private String housesuffix;
    @Basic(optional = false)
    private String zipcode;
    @Basic(optional = false)
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid")
    private Collection<Member> member1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid")
    private Collection<Facility> facilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid")
    private Collection<Employee> employeeCollection;

    public Locations() {
    }

    public Locations(Integer id) {
        this.id = id;
    }

    public Locations(Integer id, String locationname, String telnumber, String streetname, int housenumber, String zipcode, String city) {
        this.id = id;
        this.locationname = locationname;
        this.telnumber = telnumber;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public String getHousesuffix() {
        return housesuffix;
    }

    public void setHousesuffix(String housesuffix) {
        this.housesuffix = housesuffix;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Member> getMember1Collection() {
        return member1Collection;
    }

    public void setMember1Collection(Collection<Member> member1Collection) {
        this.member1Collection = member1Collection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<Facility> getFacilityCollection() {
        return facilityCollection;
    }

    public void setFacilityCollection(Collection<Facility> facilityCollection) {
        this.facilityCollection = facilityCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
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
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Locations[ id=" + id + " ]";
    }
    
}
