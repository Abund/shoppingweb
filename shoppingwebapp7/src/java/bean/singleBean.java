/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.AdminTable;
import data.CustomerTable;
import data.OrderTable;
import data.ProductDetails;
import data.ReviewTable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.PrePersist;
import javax.servlet.http.HttpSession;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Abun
 */
@Named(value = "singleBean")
@SessionScoped
public class singleBean implements Serializable {
    private Dialog dialog= new Dialog();
    //cart parameters
    private int productID;
    private int qty=1;
    private String status="cart";
    private int occas;
    private int color;
    private String message;
    private String Subject;
    private List<ReviewTable> review;
    private int numberOfProductReviews;
    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    
    //ejb parameters used to add to cart
    @EJB
    private OrderTableFacade orderTableFacade;
    private OrderTable add= new OrderTable();
    private checkoutBean ckb = new checkoutBean();
    private CustomerTable CustomerId = new CustomerTable();
    @EJB
    private CustomerTableFacade customerTableFacade;
    private AdminTable adt = new AdminTable();
    @EJB
    private AdminTableFacade atf;
    
    //normal parameters used in the single page
    private ProductDetails prods = new ProductDetails();
    @EJB
    private ProductDetailsFacade pdf;
    
    @EJB
    private ReviewTableFacade rtf;
    private ReviewTable rt = new ReviewTable();
    
    
    /**
     * Creates a new instance of singleBean
     */
    public singleBean() {
    }
    
    public void load(){
        prods= pdf.find(getProductID());
        adt =atf.find(1);
        review = rtf.getProductReview(prods);
        numberOfProductReviews=numOfReviewsForProduct();
    }
    
    public void addToCartSinglePage(){
        List<CustomerTable> cst= customerTableFacade.findAll();
        FacesContext facesContext= FacesContext.getCurrentInstance();
        HttpSession session =(HttpSession)facesContext.getExternalContext()
                .getSession(true);
        String userLoggedIn = (String)session.getAttribute("username");
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        for(int i=0; i< cst.size();i++){
            if(cst.get(i).getEmail().equals(userLoggedIn)){
                
                CustomerId.setCustomerID(cst.get(i).getCustomerID());
                
            }
               
        }
        if(orderTableFacade.checkPro(prods, CustomerId)==false){
            adt.setAdminID(1);
            add.setAmount(prods.getNewPrice());
            add.setAdminID(adt);
            add.setQuantity(qty);
            add.setStatus(status);
            add.setCustomerID(CustomerId);
            add.setImage(prods.getImage1());
            add.setOrderDate(date);
            add.setProductID(prods);
            orderTableFacade.create(add);
        }else{
            int qtt1= orderTableFacade.getQuantityPro(prods, CustomerId);
            int qtt = (qty-1) + qtt1;
            orderTableFacade.addToQty(qtt,prods,CustomerId);
            ckb.setOrders(new ArrayList<OrderTable>());
            ckb.setOrders(orderTableFacade.findOrders(CustomerId));
            ckb.setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
            ckb.TotalCost=ckb.totalCost();
            //RequestContext context3 = RequestContext.getCurrentInstance();
            //context3.execute("PF('myDialogVar1').show();");
        }
    }
    
    
    public void addToCart(ProductDetails pdt){
        List<CustomerTable> cst= customerTableFacade.findAll();
        FacesContext facesContext= FacesContext.getCurrentInstance();
        HttpSession session =(HttpSession)facesContext.getExternalContext()
                .getSession(true);
        String userLoggedIn = (String)session.getAttribute("username");
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        for(int i=0; i< cst.size();i++){
            if(cst.get(i).getEmail().equals(userLoggedIn)){
                
                CustomerId.setCustomerID(cst.get(i).getCustomerID());
                
            }
               
        }
        if(CustomerId.getCustomerID()!=null){
            if(orderTableFacade.checkPro(pdt, CustomerId)==false){
            adt.setAdminID(1);
            add.setAdminID(adt);
            //add.setOrderID(4);
            add.setQuantity(qty);
            add.setStatus(status);
            add.setCustomerID(CustomerId);
            add.setImage(pdt.getImage1());
            add.setAmount(pdt.getNewPrice());
            add.setOrderDate(date);
            add.setProductID(pdt);
            orderTableFacade.create(add);
            ckb.setOrders(new ArrayList<>());
            ckb.setOrders(orderTableFacade.findOrders(CustomerId));
            ckb.setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
            ckb.TotalCost=ckb.totalCost();
            //RequestContext context2 = RequestContext.getCurrentInstance();
            //context2.execute("PF('myDialogVar1').show();");
            }else{
                int qtt= orderTableFacade.getQuantityPro(pdt, CustomerId);
                orderTableFacade.addToQty(qtt,pdt,CustomerId);
                ckb.setOrders(new ArrayList<>());
                ckb.setOrders(orderTableFacade.findOrders(CustomerId));
                ckb.setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
                ckb.TotalCost=ckb.totalCost();
                //RequestContext context3 = RequestContext.getCurrentInstance();
                //context3.execute("PF('myDialogVar1').show();");
            }
        }else{
            //RequestContext context1 = RequestContext.getCurrentInstance();
            dialog.setHeader("lalalallalala");
            dialog.setVisible(true);
            //RequestContext.getCurrentInstance().execute("#PF('myDialogVar1').show();");
        }
    }
    
    public void sendReview(){
        List<CustomerTable> cst= customerTableFacade.findAll();
        FacesContext facesContext= FacesContext.getCurrentInstance();
        HttpSession session1 =(HttpSession)facesContext.getExternalContext()
                .getSession(true);
        String userLoggedIn = (String)session1.getAttribute("username");
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        
        for(int i=0; i< cst.size();i++){
            if(cst.get(i).getEmail().equals(userLoggedIn)){
                CustomerId.setCustomerID(cst.get(i).getCustomerID());
                CustomerId.setEmail(cst.get(i).getEmail());
                CustomerId.setCustomerFirstName(cst.get(i).getCustomerFirstName());
            }
               
        }
        
        rt.setEmail(CustomerId.getEmail());
        rt.setCustomerID(CustomerId);
        rt.setName(CustomerId.getCustomerFirstName());
        rt.setProductID(prods);
        rt.setReview(getMessage());
        rt.setSubject(getSubject());
        rtf.create(rt);
    }
    
    public int numOfReviewsForProduct(){
        int num=0;
        num = rtf.NoOfProductReviews(prods);
        return num;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the prods
     */
    public ProductDetails getProds() {
        return prods;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the occas
     */
    public int getOccas() {
        return occas;
    }

    /**
     * @param occas the occas to set
     */
    public void setOccas(int occas) {
        this.occas = occas;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the Subject
     */
    public String getSubject() {
        return Subject;
    }

    /**
     * @param Subject the Subject to set
     */
    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    /**
     * @return the review
     */
    public List<ReviewTable> getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(List<ReviewTable> review) {
        this.review = review;
    }

    /**
     * @return the numberOfProductReviews
     */
    public int getNumberOfProductReviews() {
        return numberOfProductReviews;
    }

    /**
     * @param numberOfProductReviews the numberOfProductReviews to set
     */
    public void setNumberOfProductReviews(int numberOfProductReviews) {
        this.numberOfProductReviews = numberOfProductReviews;
    }
    
}
