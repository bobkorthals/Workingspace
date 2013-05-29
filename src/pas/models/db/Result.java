/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findById", query = "SELECT r FROM Result r WHERE r.id = :id"),
    @NamedQuery(name = "Result.findByMemberid", query = "SELECT r FROM Result r WHERE r.memberid = :memberid"),
    @NamedQuery(name = "Result.findByLenght", query = "SELECT r FROM Result r WHERE r.lenght = :lenght"),
    @NamedQuery(name = "Result.findByWeight", query = "SELECT r FROM Result r WHERE r.weight = :weight"),
    @NamedQuery(name = "Result.findByTimes", query = "SELECT r FROM Result r WHERE r.times = :times"),
    @NamedQuery(name = "Result.findByMaxsettings", query = "SELECT r FROM Result r WHERE r.maxsettings = :maxsettings")})
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private int memberid;
    @Basic(optional = false)
    private int lenght;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal weight;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date times;
    private String maxsettings;
    @JoinColumn(name = "deviceid", referencedColumnName = "id")
    @ManyToOne
    private Device deviceid;

    public Result() {
    }

    public Result(Integer id) {
        this.id = id;
    }

    public Result(Integer id, int memberid, int lenght, BigDecimal weight, Date times) {
        this.id = id;
        this.memberid = memberid;
        this.lenght = lenght;
        this.weight = weight;
        this.times = times;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getMaxsettings() {
        return maxsettings;
    }

    public void setMaxsettings(String maxsettings) {
        this.maxsettings = maxsettings;
    }

    public Device getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Device deviceid) {
        this.deviceid = deviceid;
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
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Result[ id=" + id + " ]";
    }
    
}
