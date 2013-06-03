/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employee.findBySuffix", query = "SELECT e FROM Employee e WHERE e.suffix = :suffix"),
    @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Employee.findByBirthday", query = "SELECT e FROM Employee e WHERE e.birthday = :birthday"),
    @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employee.findByMobile", query = "SELECT e FROM Employee e WHERE e.mobile = :mobile"),
    @NamedQuery(name = "Employee.findByTelnumber", query = "SELECT e FROM Employee e WHERE e.telnumber = :telnumber"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByInservice", query = "SELECT e FROM Employee e WHERE e.inservice = :inservice"),
    @NamedQuery(name = "Employee.findByOutofservice", query = "SELECT e FROM Employee e WHERE e.outofservice = :outofservice"),
    @NamedQuery(name = "Employee.findByStreetname", query = "SELECT e FROM Employee e WHERE e.streetname = :streetname"),
    @NamedQuery(name = "Employee.findByHousenumber", query = "SELECT e FROM Employee e WHERE e.housenumber = :housenumber"),
    @NamedQuery(name = "Employee.findByHousesuffix", query = "SELECT e FROM Employee e WHERE e.housesuffix = :housesuffix"),
    @NamedQuery(name = "Employee.findByZipcode", query = "SELECT e FROM Employee e WHERE e.zipcode = :zipcode"),
    @NamedQuery(name = "Employee.findByCity", query = "SELECT e FROM Employee e WHERE e.city = :city"),
    @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status"),
    @NamedQuery(name = "Employee.findByPasswords", query = "SELECT e FROM Employee e WHERE e.passwords = :passwords"),
    @NamedQuery(name = "Employee.findByLastlogin", query = "SELECT e FROM Employee e WHERE e.lastlogin = :lastlogin"),
    @NamedQuery(name = "Employee.findByLastchange", query = "SELECT e FROM Employee e WHERE e.lastchange = :lastchange"),
    @NamedQuery(name = "Employee.findByComment", query = "SELECT e FROM Employee e WHERE e.comment = :comment"),
    @NamedQuery(name = "Employee.findByIdentitynr", query = "SELECT e FROM Employee e WHERE e.identitynr = :identitynr")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String firstname;
    private String suffix;
    @Basic(optional = false)
    private String lastname;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    private int gender;
    private String mobile;
    private String telnumber;
    private String email;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date inservice;
    @Temporal(TemporalType.DATE)
    private Date outofservice;
    @Basic(optional = false)
    private String streetname;
    @Basic(optional = false)
    private int housenumber;
    private String housesuffix;
    @Basic(optional = false)
    private String zipcode;
    @Basic(optional = false)
    private String city;
    @Basic(optional = false)
    private String status;
    @Basic(optional = false)
    private String passwords;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastchange;
    private String comment;
    private Integer identitynr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<Member1> member1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<Schedule> scheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "roleid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles roleid;
    @JoinColumn(name = "locationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Locations locationid;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String firstname, String lastname, Date birthday, int gender, Date inservice, String streetname, int housenumber, String zipcode, String city, String status, String passwords, Date lastlogin, Date lastchange) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.inservice = inservice;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.city = city;
        this.status = status;
        this.passwords = passwords;
        this.lastlogin = lastlogin;
        this.lastchange = lastchange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Date getInservice() {
        return inservice;
    }

    public void setInservice(Date inservice) {
        this.inservice = inservice;
    }

    public Date getOutofservice() {
        return outofservice;
    }

    public void setOutofservice(Date outofservice) {
        this.outofservice = outofservice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Date getLastchange() {
        return lastchange;
    }

    public void setLastchange(Date lastchange) {
        this.lastchange = lastchange;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIdentitynr() {
        return identitynr;
    }

    public void setIdentitynr(Integer identitynr) {
        this.identitynr = identitynr;
    }

    @XmlTransient
    public Collection<Member1> getMember1Collection() {
        return member1Collection;
    }

    public void setMember1Collection(Collection<Member1> member1Collection) {
        this.member1Collection = member1Collection;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }

    public Locations getLocationid() {
        return locationid;
    }

    public void setLocationid(Locations locationid) {
        this.locationid = locationid;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Employee[ id=" + id + " ]";
    }
    
}
