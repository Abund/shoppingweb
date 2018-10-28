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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Product_Details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetails.findAll", query = "SELECT p FROM ProductDetails p")
    , @NamedQuery(name = "ProductDetails.findByProductID", query = "SELECT p FROM ProductDetails p WHERE p.productID = :productID")
    , @NamedQuery(name = "ProductDetails.findByProductName", query = "SELECT p FROM ProductDetails p WHERE p.productName = :productName")
    , @NamedQuery(name = "ProductDetails.findByStock", query = "SELECT p FROM ProductDetails p WHERE p.stock = :stock")
    , @NamedQuery(name = "ProductDetails.findByDescription", query = "SELECT p FROM ProductDetails p WHERE p.description = :description")
    , @NamedQuery(name = "ProductDetails.findByMinDescription", query = "SELECT p FROM ProductDetails p WHERE p.minDescription = :minDescription")
    , @NamedQuery(name = "ProductDetails.findByOldPrice", query = "SELECT p FROM ProductDetails p WHERE p.oldPrice = :oldPrice")
    , @NamedQuery(name = "ProductDetails.findByNewPrice", query = "SELECT p FROM ProductDetails p WHERE p.newPrice = :newPrice")
    , @NamedQuery(name = "ProductDetails.findBySubCategory", query = "SELECT p FROM ProductDetails p WHERE p.subCategory = :subCategory")
    , @NamedQuery(name = "ProductDetails.findByImage1", query = "SELECT p FROM ProductDetails p WHERE p.image1 = :image1")
    , @NamedQuery(name = "ProductDetails.findByImage2", query = "SELECT p FROM ProductDetails p WHERE p.image2 = :image2")
    , @NamedQuery(name = "ProductDetails.findByImage3", query = "SELECT p FROM ProductDetails p WHERE p.image3 = :image3")})
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_ID")
    private Integer productID;
    @Size(max = 2147483647)
    @Column(name = "Product_Name")
    private String productName;
    @Column(name = "Stock")
    private Integer stock;
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Size(max = 2147483647)
    @Column(name = "MinDescription")
    private String minDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OldPrice")
    private Double oldPrice;
    @Column(name = "NewPrice")
    private Double newPrice;
    @Size(max = 2147483647)
    @Column(name = "SubCategory")
    private String subCategory;
    @Size(max = 2147483647)
    @Column(name = "Image1")
    private String image1;
    @Size(max = 2147483647)
    @Column(name = "Image2")
    private String image2;
    @Size(max = 2147483647)
    @Column(name = "Image3")
    private String image3;
    @OneToMany(mappedBy = "productID")
    private Collection<OrderTable> orderTableCollection;
    @OneToMany(mappedBy = "productID")
    private Collection<ReviewTable> reviewTableCollection;
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    @ManyToOne
    private CategoryDetails categoryID;

    public ProductDetails() {
    }

    public ProductDetails(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinDescription() {
        return minDescription;
    }

    public void setMinDescription(String minDescription) {
        this.minDescription = minDescription;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
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

    public CategoryDetails getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryDetails categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetails)) {
            return false;
        }
        ProductDetails other = (ProductDetails) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.ProductDetails[ productID=" + productID + " ]";
    }
    
}
