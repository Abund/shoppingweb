/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abun
 */
@Entity
@Table(name = "Admin_Table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminTable.findAll", query = "SELECT a FROM AdminTable a")
    , @NamedQuery(name = "AdminTable.findByAdminID", query = "SELECT a FROM AdminTable a WHERE a.adminID = :adminID")
    , @NamedQuery(name = "AdminTable.findByAdminFirstName", query = "SELECT a FROM AdminTable a WHERE a.adminFirstName = :adminFirstName")
    , @NamedQuery(name = "AdminTable.findByAdminLastName", query = "SELECT a FROM AdminTable a WHERE a.adminLastName = :adminLastName")
    , @NamedQuery(name = "AdminTable.findByGender", query = "SELECT a FROM AdminTable a WHERE a.gender = :gender")
    , @NamedQuery(name = "AdminTable.findByAddress", query = "SELECT a FROM AdminTable a WHERE a.address = :address")
    , @NamedQuery(name = "AdminTable.findByEmail", query = "SELECT a FROM AdminTable a WHERE a.email = :email")
    , @NamedQuery(name = "AdminTable.findByPassword", query = "SELECT a FROM AdminTable a WHERE a.password = :password")
    , @NamedQuery(name = "AdminTable.findByPhone", query = "SELECT a FROM AdminTable a WHERE a.phone = :phone")})
public class AdminTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Admin_ID")
    private Integer adminID;
    @Size(max = 2147483647)
    @Column(name = "Admin_FirstName")
    private String adminFirstName;
    @Size(max = 2147483647)
    @Column(name = "Admin_LastName")
    private String adminLastName;
    @Size(max = 2147483647)
    @Column(name = "Gender")
    private String gender;
    @Size(max = 2147483647)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "Email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "Password")
    private String password;
    @Column(name = "Phone")
    private Integer phone;
    @OneToMany(mappedBy = "adminID")
    private Collection<OrderTable> orderTableCollection;

    public AdminTable() {
    }

    public AdminTable(Integer adminID) {
        this.adminID = adminID;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<OrderTable> getOrderTableCollection() {
        return orderTableCollection;
    }

    public void setOrderTableCollection(Collection<OrderTable> orderTableCollection) {
        this.orderTableCollection = orderTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminID != null ? adminID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminTable)) {
            return false;
        }
        AdminTable other = (AdminTable) object;
        if ((this.adminID == null && other.adminID != null) || (this.adminID != null && !this.adminID.equals(other.adminID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.AdminTable[ adminID=" + adminID + " ]";
    }
    
}
