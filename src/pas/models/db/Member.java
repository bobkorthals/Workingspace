/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@Table(name = "member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m"),
    @NamedQuery(name = "Member.findById", query = "SELECT m FROM Member m WHERE m.id = :id"),
    @NamedQuery(name = "Member.findByKeyid", query = "SELECT m FROM Member m WHERE m.keyid = :keyid"),
    @NamedQuery(name = "Member.findByCredit", query = "SELECT m FROM Member m WHERE m.credit = :credit"),
    @NamedQuery(name = "Member.findByFirstname", query = "SELECT m FROM Member m WHERE m.firstname = :firstname"),
    @NamedQuery(name = "Member.findBySuffix", query = "SELECT m FROM Member m WHERE m.suffix = :suffix"),
    @NamedQuery(name = "Member.findByLastname", query = "SELECT m FROM Member m WHERE m.lastname = :lastname"),
    @NamedQuery(name = "Member.findByBirthday", query = "SELECT m FROM Member m WHERE m.birthday = :birthday"),
    @NamedQuery(name = "Member.findByGender", query = "SELECT m FROM Member m WHERE m.gender = :gender"),
    @NamedQuery(name = "Member.findByMobile", query = "SELECT m FROM Member m WHERE m.mobile = :mobile"),
    @NamedQuery(name = "Member.findByTelnumber", query = "SELECT m FROM Member m WHERE m.telnumber = :telnumber"),
    @NamedQuery(name = "Member.findByEmail", query = "SELECT m FROM Member m WHERE m.email = :email"),
    @NamedQuery(name = "Member.findByStreetname", query = "SELECT m FROM Member m WHERE m.streetname = :streetname"),
    @NamedQuery(name = "Member.findByHousenumber", query = "SELECT m FROM Member m WHERE m.housenumber = :housenumber"),
    @NamedQuery(name = "Member.findByHousesuffix", query = "SELECT m FROM Member m WHERE m.housesuffix = :housesuffix"),
    @NamedQuery(name = "Member.findByZipcode", query = "SELECT m FROM Member m WHERE m.zipcode = :zipcode"),
    @NamedQuery(name = "Member.findByCity", query = "SELECT m FROM Member m WHERE m.city = :city"),
    @NamedQuery(name = "Member.findByStatus", query = "SELECT m FROM Member m WHERE m.status = :status"),
    @NamedQuery(name = "Member.findByComment", query = "SELECT m FROM Member m WHERE m.comment = :comment"),
    @NamedQuery(name = "Member.findByIdentityid", query = "SELECT m FROM Member m WHERE m.identityid = :identityid")})
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int keyid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal credit;
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
    private String comment;
    @Basic(optional = false)
    private int identityid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberid")
    private Collection<Accessing> accessingCollection;
    @JoinColumn(name = "locationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Locations locationid;
    @JoinColumn(name = "employeeid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberid")
    private Collection<Invoice> invoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberid")
    private Collection<Registration> registrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberid")
    private Collection<Subscribe> subscribeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberid")
    private Collection<Reservation> reservationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberid")
    private Collection<Orders> ordersCollection;

    public Member() {
    }

    public Member(Integer id) {
        this.id = id;
    }

    public Member(Integer id, int keyid, BigDecimal credit, String firstname, String lastname, Date birthday, int gender, String streetname, int housenumber, String zipcode, String city, String status, int identityid) {
        this.id = id;
        this.keyid = keyid;
        this.credit = credit;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.gender = gender;
        this.streetname = streetname;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.city = city;
        this.status = status;
        this.identityid = identityid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKeyid() {
        return keyid;
    }

    public void setKeyid(int keyid) {
        this.keyid = keyid;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdentityid() {
        return identityid;
    }

    public void setIdentityid(int identityid) {
        this.identityid = identityid;
    }

    @XmlTransient
    public Collection<Accessing> getAccessingCollection() {
        return accessingCollection;
    }

    public void setAccessingCollection(Collection<Accessing> accessingCollection) {
        this.accessingCollection = accessingCollection;
    }

    public Locations getLocationid() {
        return locationid;
    }

    public void setLocationid(Locations locationid) {
        this.locationid = locationid;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @XmlTransient
    public Collection<Registration> getRegistrationCollection() {
        return registrationCollection;
    }

    public void setRegistrationCollection(Collection<Registration> registrationCollection) {
        this.registrationCollection = registrationCollection;
    }

    @XmlTransient
    public Collection<Subscribe> getSubscribeCollection() {
        return subscribeCollection;
    }

    public void setSubscribeCollection(Collection<Subscribe> subscribeCollection) {
        this.subscribeCollection = subscribeCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Member[ id=" + id + " ]";
    }
}
