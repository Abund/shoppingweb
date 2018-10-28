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
@Table(name = "Category_Details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryDetails.findAll", query = "SELECT c FROM CategoryDetails c")
    , @NamedQuery(name = "CategoryDetails.findByCategoryID", query = "SELECT c FROM CategoryDetails c WHERE c.categoryID = :categoryID")
    , @NamedQuery(name = "CategoryDetails.findByCategoryName", query = "SELECT c FROM CategoryDetails c WHERE c.categoryName = :categoryName")
    , @NamedQuery(name = "CategoryDetails.findByDescription", query = "SELECT c FROM CategoryDetails c WHERE c.description = :description")})
public class CategoryDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Category_ID")
    private Integer categoryID;
    @Size(max = 2147483647)
    @Column(name = "Category_Name")
    private String categoryName;
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "categoryID")
    private Collection<ProductDetails> productDetailsCollection;

    public CategoryDetails() {
    }

    public CategoryDetails(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<ProductDetails> getProductDetailsCollection() {
        return productDetailsCollection;
    }

    public void setProductDetailsCollection(Collection<ProductDetails> productDetailsCollection) {
        this.productDetailsCollection = productDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryDetails)) {
            return false;
        }
        CategoryDetails other = (CategoryDetails) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.CategoryDetails[ categoryID=" + categoryID + " ]";
    }
    
}
