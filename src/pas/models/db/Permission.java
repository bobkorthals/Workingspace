/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.models.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Frank
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findById", query = "SELECT p FROM Permission p WHERE p.id = :id"),
    @NamedQuery(name = "Permission.findByDescription", query = "SELECT p FROM Permission p WHERE p.description = :description"),
    @NamedQuery(name = "Permission.findByAllow", query = "SELECT p FROM Permission p WHERE p.allow = :allow")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private String description;
    private Integer allow;
    @JoinTable(name = "rolepermission", joinColumns = {
        @JoinColumn(name = "permissionid", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "roleid", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Roles> rolesCollection;
    @JoinColumn(name = "resourceid", referencedColumnName = "id")
    @ManyToOne
    private Resource resourceid;
    @JoinColumn(name = "privilegeid", referencedColumnName = "id")
    @ManyToOne
    private Privilege privilegeid;
    @JoinColumn(name = "claimid", referencedColumnName = "id")
    @ManyToOne
    private Claim claimid;

    public Permission() {
    }

    public Permission(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAllow() {
        return allow;
    }

    public void setAllow(Integer allow) {
        this.allow = allow;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    public Resource getResourceid() {
        return resourceid;
    }

    public void setResourceid(Resource resourceid) {
        this.resourceid = resourceid;
    }

    public Privilege getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(Privilege privilegeid) {
        this.privilegeid = privilegeid;
    }

    public Claim getClaimid() {
        return claimid;
    }

    public void setClaimid(Claim claimid) {
        this.claimid = claimid;
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
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pas.models.db.Permission[ id=" + id + " ]";
    }
    
}
