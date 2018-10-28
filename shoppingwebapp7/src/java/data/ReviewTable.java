/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abun
 */
@Entity
@Table(name = "Review_Table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewTable.findAll", query = "SELECT r FROM ReviewTable r")
    , @NamedQuery(name = "ReviewTable.findByReviewID", query = "SELECT r FROM ReviewTable r WHERE r.reviewID = :reviewID")
    , @NamedQuery(name = "ReviewTable.findByReview", query = "SELECT r FROM ReviewTable r WHERE r.review = :review")
    , @NamedQuery(name = "ReviewTable.findByName", query = "SELECT r FROM ReviewTable r WHERE r.name = :name")
    , @NamedQuery(name = "ReviewTable.findByEmail", query = "SELECT r FROM ReviewTable r WHERE r.email = :email")
    , @NamedQuery(name = "ReviewTable.findBySubject", query = "SELECT r FROM ReviewTable r WHERE r.subject = :subject")})
public class ReviewTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Review_ID")
    private Integer reviewID;
    @Size(max = 2147483647)
    @Column(name = "Review")
    private String review;
    @Size(max = 2147483647)
    @Column(name = "Name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "Email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "Subject")
    private String subject;
    @JoinColumn(name = "Customer_ID", referencedColumnName = "Customer_ID")
    @ManyToOne
    private CustomerTable customerID;
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    @ManyToOne
    private ProductDetails productID;

    public ReviewTable() {
    }

    public ReviewTable(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CustomerTable getCustomerID() {
        return customerID;
    }

    public void setCustomerID(CustomerTable customerID) {
        this.customerID = customerID;
    }

    public ProductDetails getProductID() {
        return productID;
    }

    public void setProductID(ProductDetails productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewID != null ? reviewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewTable)) {
            return false;
        }
        ReviewTable other = (ReviewTable) object;
        if ((this.reviewID == null && other.reviewID != null) || (this.reviewID != null && !this.reviewID.equals(other.reviewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.ReviewTable[ reviewID=" + reviewID + " ]";
    }
    
}
