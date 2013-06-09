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
    @NamedQuery(name = "Toegang.findAll", query = "SELECT t FROM Toegang t"),
    @NamedQuery(name = "Toegang.findById", query = "SELECT t FROM Toegang t WHERE t.id = :id"),
    @NamedQuery(name = "Toegang.findByDatum", query = "SELECT t FROM Toegang t WHERE t.datum = :datum"),
    @NamedQuery(name = "Toegang.findByCheckintijd", query = "SELECT t FROM Toegang t WHERE t.checkintijd = :checkintijd"),
    @NamedQuery(name = "Toegang.findByCheckouttijd", query = "SELECT t FROM Toegang t WHERE t.checkouttijd = :checkouttijd")})
public class Toegang implements Serializable {
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
    private Date checkintijd;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkouttijd;
    @JoinColumn(name = "reserveringid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reservering reserveringid;
    @JoinColumn(name = "lidid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lid lidid;
    @JoinColumn(name = "inschrijvingid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Inschrijving inschrijvingid;

    public Toegang() {
    }

    public Toegang(Integer id) {
        this.id = id;
    }

    public Toegang(Integer id, Date datum, Date checkintijd, Date checkouttijd) {
        this.id = id;
        this.datum = datum;
        this.checkintijd = checkintijd;
        this.checkouttijd = checkouttijd;
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

    public Date getCheckintijd() {
        return checkintijd;
    }

    public void setCheckintijd(Date checkintijd) {
        this.checkintijd = checkintijd;
    }

    public Date getCheckouttijd() {
        return checkouttijd;
    }

    public void setCheckouttijd(Date checkouttijd) {
        this.checkouttijd = checkouttijd;
    }

    public Reservering getReserveringid() {
        return reserveringid;
    }

    public void setReserveringid(Reservering reserveringid) {
        this.reserveringid = reserveringid;
    }

    public Lid getLidid() {
        return lidid;
    }

    public void setLidid(Lid lidid) {
        this.lidid = lidid;
    }

    public Inschrijving getInschrijvingid() {
        return inschrijvingid;
    }

    public void setInschrijvingid(Inschrijving inschrijvingid) {
        this.inschrijvingid = inschrijvingid;
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
        if (!(object instanceof Toegang)) {
            return false;
        }
        Toegang other = (Toegang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Toegang[ id=" + id + " ]";
    }
    
}
