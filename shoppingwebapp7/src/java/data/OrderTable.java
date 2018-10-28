/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abun
 */
@Entity
@Table(name = "Order_Table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTable.findAll", query = "SELECT o FROM OrderTable o")
    , @NamedQuery(name = "OrderTable.findByOrderID", query = "SELECT o FROM OrderTable o WHERE o.orderID = :orderID")
    , @NamedQuery(name = "OrderTable.findByQuantity", query = "SELECT o FROM OrderTable o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderTable.findByOrderDate", query = "SELECT o FROM OrderTable o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "OrderTable.findByAmount", query = "SELECT o FROM OrderTable o WHERE o.amount = :amount")
    , @NamedQuery(name = "OrderTable.findByStatus", query = "SELECT o FROM OrderTable o WHERE o.status = :status")
    , @NamedQuery(name = "OrderTable.findByImage", query = "SELECT o FROM OrderTable o WHERE o.image = :image")
    ,@NamedQuery(name = "OrderTable.findByCustomerId", query = "SELECT o FROM OrderTable o WHERE o.customerID = :customerID")})
public class OrderTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID" )
    private Integer orderID;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "Order_Date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Amount")
    private Double amount;
    @Size(max = 2147483647)
    @Column(name = "Status")
    private String status;
    @Size(max = 2147483647)
    @Column(name = "Image")
    private String image;
    @JoinColumn(name = "Admin_ID", referencedColumnName = "Admin_ID")
    @ManyToOne
    private AdminTable adminID;
    @JoinColumn(name = "Customer_ID", referencedColumnName = "Customer_ID")
    @ManyToOne
    private CustomerTable customerID;
    @JoinColumn(name = "Product_ID", referencedColumnName = "Product_ID")
    @ManyToOne
    private ProductDetails productID;

    public OrderTable() {
    }

    public OrderTable(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AdminTable getAdminID() {
        return adminID;
    }

    public void setAdminID(AdminTable adminID) {
        this.adminID = adminID;
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
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTable)) {
            return false;
        }
        OrderTable other = (OrderTable) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.OrderTable[ orderID=" + orderID + " ]";
    }
    
}
