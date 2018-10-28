/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CustomerTable;
import data.OrderTable;
import data.ProductDetails;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import java.lang.String;

/**
 *
 * @author Abun
 */
@Named(value = "checkoutBean")
@ViewScoped
public class checkoutBean implements Serializable {
    
    private List<OrderTable> ody;
    private String numer;int qtty;
    String TotalCost;
    private String pqty;
    
    @EJB
    private OrderTableFacade orderTableFacade;
    
    @EJB
    private CustomerTableFacade customerTableFacade;
    
    @EJB
    private ProductDetailsFacade pdt; 
    
    private OrderTable odt =new OrderTable();
    
    private List<OrderTable> orders;
    private CustomerTable CustomerId = new CustomerTable();
    
    /**
     * Creates a new instance of checkoutBean
     */
    public checkoutBean() {
        
    }
    
    @PostConstruct
    public void init() {
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
        
        setOrders(new ArrayList<OrderTable>());
        setOrders(orderTableFacade.findOrders(CustomerId));
        if(CustomerId.getCustomerID()!=null){
            setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
            TotalCost=totalCost();
            //increaseQty(orders.get(qtty).getQuantity(),orders.get(qtty).getProductID());
        }
    }
    
    public void updateQuantity(ValueChangeEvent event){
        qtty = (Integer) event.getNewValue();
    }
    
    
    
    public void emptyCart(){
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
        orderTableFacade.deleteAllItems(CustomerId);
        setOrders(new ArrayList<OrderTable>());
        setOrders(orderTableFacade.findOrders(CustomerId));
        setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
        TotalCost=totalCost();
        //return "checkout.xhtml?faces-redirect=true";
    }

    /**
     * @return the orders
     */
    public List<OrderTable> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(List<OrderTable> orders) {
        this.orders = orders;
    }
    public int mutiplying(int a, int b){
        return a*b;
    }
    public String getProductName(int id){
        List<ProductDetails> pt = new ArrayList<>();
        pt= pdt.findAll();
        for(int i=0; i<= pt.size();i++){
            if(pt.get(i).getProductID().equals(id)){
                return pt.get(i).getProductName();
            }
               
        } 
        return "";
    }
    
    public void increaseQty(int qt,int ptq){
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
        pqty=orderTableFacade.updateQuantityAdd(qt, ptq);
        setOrders(new ArrayList<OrderTable>());
        setOrders(orderTableFacade.findOrders(CustomerId));
        setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
        TotalCost=totalCost();
    }
    
    public void decreaseQty(int qt,int ptq){
        
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
        pqty=orderTableFacade.updateQuantitySub(qt, ptq);
        setOrders(new ArrayList<OrderTable>());
        setOrders(orderTableFacade.findOrders(CustomerId));
        setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
        TotalCost=totalCost();
    }
    
    public String tranfor(int num){
        pqty= num+"";
        return pqty;
    }
    
    public String numberOfOrders(){
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
        //String numer=orderTableFacade.numberOfCustomerOrders1(CustomerId);
        
        return numer;
    }
    public int serviceCharge(String gr1){
        int gr=0;
        if (gr1==""){
           gr=0;
        }else{
        gr = Integer.parseInt(gr1);
        }
        return gr*15;
    }
    
    public String deleteItem(int odt){
        orderTableFacade.deleteSelectedItem(odt);
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
        
        setOrders(new ArrayList<OrderTable>());
        setOrders(orderTableFacade.findOrders(CustomerId));
        //if(CustomerId.getCustomerID()!=null){
            setNumer(orderTableFacade.numberOfCustomerOrders1(CustomerId));
            TotalCost=totalCost();
            
        //}
        
        return "checkout.xhtml?faces-redirect=true";
    }
    
    public void ajja(){
        
        
        
    }
    public String totalCost(){
        double total=0;
        int i;
        for(i=0;i<orders.size();i++){
            total += orders.get(i).getQuantity()*orders.get(i).getAmount();
        }
        int crt =15;
        int tots = Integer.parseInt(numer)*crt;
        total +=tots;
        String realTotal=total+"";
        setTotalCost(realTotal);
        return getTotalCost();
    }

    /**
     * @return the ody
     */
    public List<OrderTable> getOdy() {
        return ody;
    }

    /**
     * @param ody the ody to set
     */
    public void setOdy(List<OrderTable> ody) {
        this.ody = ody;
    }

    /**
     * @return the numer
     */
    public String getNumer() {
        return numer;
    }

    /**
     * @param numer the numer to set
     */
    public void setNumer(String numer) {
        this.numer = numer;
    }

    /**
     * @return the TotalCost
     */
    public String getTotalCost() {
        return TotalCost;
    }

    /**
     * @param TotalCost the TotalCost to set
     */
    public void setTotalCost(String TotalCost) {
        this.TotalCost = TotalCost;
    }

    /**
     * @return the pqty
     */
    public String getPqty() {
        return pqty;
    }

    /**
     * @param pqty the pqty to set
     */
    public void setPqty(String pqty) {
        
       pqty= odt.getQuantity()+"";
       this.pqty = pqty;
    }
    
    
    
}
