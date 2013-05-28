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
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    @NamedQuery(name = "Schedule.findByTimes", query = "SELECT s FROM Schedule s WHERE s.times = :times")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date times;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleid")
    private Collection<Registration> registrationCollection;
    @JoinColumn(name = "employeeid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeid;
    @JoinColumn(name = "courseid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseid;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, Date times) {
        this.id = id;
        this.times = times;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @XmlTransient
    public Collection<Registration> getRegistrationCollection() {
        return registrationCollection;
    }

    public void setRegistrationCollection(Collection<Registration> registrationCollection) {
        this.registrationCollection = registrationCollection;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Schedule[ id=" + id + " ]";
    }
    
}
