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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Customer_Table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerTable.findAll", query = "SELECT c FROM CustomerTable c")
    , @NamedQuery(name = "CustomerTable.findByCustomerID", query = "SELECT c FROM CustomerTable c WHERE c.customerID = :customerID")
    , @NamedQuery(name = "CustomerTable.findByCustomerFirstName", query = "SELECT c FROM CustomerTable c WHERE c.customerFirstName = :customerFirstName")
    , @NamedQuery(name = "CustomerTable.findByCustomerLastName", query = "SELECT c FROM CustomerTable c WHERE c.customerLastName = :customerLastName")
    , @NamedQuery(name = "CustomerTable.findByEmail", query = "SELECT c FROM CustomerTable c WHERE c.email = :email")
    , @NamedQuery(name = "CustomerTable.findByGender", query = "SELECT c FROM CustomerTable c WHERE c.gender = :gender")
    , @NamedQuery(name = "CustomerTable.findByAddress", query = "SELECT c FROM CustomerTable c WHERE c.address = :address")
    , @NamedQuery(name = "CustomerTable.findByPhone", query = "SELECT c FROM CustomerTable c WHERE c.phone = :phone")
    , @NamedQuery(name = "CustomerTable.findByPassword", query = "SELECT c FROM CustomerTable c WHERE c.password = :password")
    , @NamedQuery(name = "CustomerTable.findByCreditCardNo", query = "SELECT c FROM CustomerTable c WHERE c.creditCardNo = :creditCardNo")
    , @NamedQuery(name = "CustomerTable.findByCreditCardType", query = "SELECT c FROM CustomerTable c WHERE c.creditCardType = :creditCardType")
    , @NamedQuery(name = "CustomerTable.findByImage", query = "SELECT c FROM CustomerTable c WHERE c.image = :image")
    , @NamedQuery(name = "CustomerTable.findByNewsletter", query = "SELECT c FROM CustomerTable c WHERE c.newsletter = :newsletter")})
public class CustomerTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Integer customerID;
    @Size(max = 2147483647)
    @Column(name = "Customer_FirstName")
    private String customerFirstName;
    @Size(max = 2147483647)
    @Column(name = "Customer_LastName")
    private String customerLastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "Gender")
    private String gender;
    @Size(max = 2147483647)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "Phone")
    private String phone;
    @Size(max = 2147483647)
    @Column(name = "Password")
    private String password;
    @Column(name = "CreditCardNo")
    private Integer creditCardNo;
    @Size(max = 2147483647)
    @Column(name = "CreditCardType")
    private String creditCardType;
    @Size(max = 2147483647)
    @Column(name = "Image")
    private String image;
    @Size(max = 2147483647)
    @Column(name = "Newsletter")
    private String newsletter;
    @OneToMany(mappedBy = "customerID")
    private Collection<OrderTable> orderTableCollection;
    @OneToMany(mappedBy = "customerID")
    private Collection<ReviewTable> reviewTableCollection;

    public CustomerTable() {
    }

    public CustomerTable(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(Integer creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    @XmlTransient
    public Collection<OrderTable> getOrderTableCollection() {
        return orderTableCollection;
    }

    public void setOrderTableCollection(Collection<OrderTable> orderTableCollection) {
        this.orderTableCollection = orderTableCollection;
    }

    @XmlTransient
    public Collection<ReviewTable> getReviewTableCollection() {
        return reviewTableCollection;
    }

    public void setReviewTableCollection(Collection<ReviewTable> reviewTableCollection) {
        this.reviewTableCollection = reviewTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerTable)) {
            return false;
        }
        CustomerTable other = (CustomerTable) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.CustomerTable[ customerID=" + customerID + " ]";
    }
    
}
