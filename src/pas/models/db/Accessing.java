/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
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
    @NamedQuery(name = "Accessing.findAll", query = "SELECT a FROM Accessing a"),
    @NamedQuery(name = "Accessing.findById", query = "SELECT a FROM Accessing a WHERE a.id = :id"),
    @NamedQuery(name = "Accessing.findByDatum", query = "SELECT a FROM Accessing a WHERE a.datum = :datum"),
    @NamedQuery(name = "Accessing.findByTimein", query = "SELECT a FROM Accessing a WHERE a.timein = :timein"),
    @NamedQuery(name = "Accessing.findByTimeout", query = "SELECT a FROM Accessing a WHERE a.timeout = :timeout")})
public class Accessing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timein;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeout;
    @JoinColumn(name = "reservationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reservation reservationid;
    @JoinColumn(name = "registrationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Registration registrationid;
    @JoinColumn(name = "memberid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member1 memberid;

    public Accessing() {
    }

    public Accessing(Integer id) {
        this.id = id;
    }

    public Accessing(Integer id, Date datum, Date timein, Date timeout) {
        this.id = id;
        this.datum = datum;
        this.timein = timein;
        this.timeout = timeout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getTimein() {
        return timein;
    }

    public void setTimein(Date timein) {
        this.timein = timein;
    }

    public Date getTimeout() {
        return timeout;
    }

    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    public Reservation getReservationid() {
        return reservationid;
    }

    public void setReservationid(Reservation reservationid) {
        this.reservationid = reservationid;
    }

    public Registration getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(Registration registrationid) {
        this.registrationid = registrationid;
    }

    public Member1 getMemberid() {
        return memberid;
    }

    public void setMemberid(Member1 memberid) {
        this.memberid = memberid;
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
        if (!(object instanceof Accessing)) {
            return false;
        }
        Accessing other = (Accessing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Accessing[ id=" + id + " ]";
    }
    
}
