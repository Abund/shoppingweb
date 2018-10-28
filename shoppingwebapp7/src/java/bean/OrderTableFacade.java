/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CustomerTable;
import data.OrderTable;
import data.OrderTable_;
import data.ProductDetails;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Abun
 */
@Stateless
public class OrderTableFacade extends AbstractFacade<OrderTable> {
    
    private List<OrderTable> orders;
    int cont;
    private List<OrderTable> numberOfOrdersByCustomer;

    @PersistenceContext(unitName = "shoppingwebapp7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderTableFacade() {
        super(OrderTable.class);
    }
    
    public List<OrderTable> findOrders(CustomerTable id) {
        orders = new ArrayList<>();
        Query q = em.createNamedQuery("OrderTable.findByCustomerId");
        q.setParameter("customerID", id);
        orders= q.getResultList();
        return orders;
        
    }
    
    public String numberOfCustomerOrders1(CustomerTable id) {
        Object ans=null;
        if(id!=null){
            try{
        TypedQuery<String> tq= em.createQuery("select count(a.customerID) from OrderTable a where a.customerID=:id group by a.customerID", String.class);
        tq.setParameter("id", id);   
        ans =tq.getSingleResult();
            }catch(NoResultException e){
               ans ="0";
        }
        return ans.toString();
        }else{
            return "0";
        } 
        
    }
    
    public void deleteAllItems(CustomerTable id){
        Query q = em.createQuery("delete from OrderTable a where a.customerID=:id");
        q.setParameter("id", id);
        q.executeUpdate();
    }
    
    public String updateQuantityAdd(int qt,int pid){
        Query q = em.createQuery("update OrderTable a set a.quantity =:qty where a.orderID=:pid");
        q.setParameter("qty", qt+1);
        q.setParameter("pid", pid);
        q.executeUpdate();
        
        Query q1 = em.createQuery("select a.quantity from OrderTable a where a.orderID =:pid2");
        
        q1.setParameter("pid2", pid);
        String num =q.getFirstResult()+"";
        return num;
        
    }
    
    public String updateQuantitySub(int qt,int pid){
        String num="";
        Query q0 = em.createQuery("select a.quantity from OrderTable a where a.orderID =:pid2");
        q0.setParameter("pid2", pid);
        if(Integer.parseInt(q0.getSingleResult().toString())==0){
            num="0";
        }else{
           Query q = em.createQuery("update OrderTable a set a.quantity =:qty where a.orderID=:pid");
        q.setParameter("qty", --qt);
        q.setParameter("pid", pid);
        q.executeUpdate();
        
        Query q1 = em.createQuery("select a.quantity from OrderTable a where a.orderID =:pid2");
        q1.setParameter("pid2", pid);
        num =q.getFirstResult()+"";
         
        }
        return num;
    }
    
    public void deleteSelectedItem(int qty){
        Query q = em.createQuery("delete from OrderTable a where a.orderID=:id ");
        
        q.setParameter("id", qty);
        q.executeUpdate();
    }
    
    public boolean checkPro(ProductDetails pid,CustomerTable cid){
        Object cont1=null;
        Query q = em.createQuery("select a.quantity from OrderTable a where a.customerID =:cid and a.productID=:pid");
        q.setParameter("cid", cid);
        q.setParameter("pid", pid);
        try{
        cont1=q.getSingleResult();
        }catch(NoResultException e){
            cont1="0";
        }
        String cont2 = cont1.toString();
        int cont3 = Integer.parseInt(cont2);
        if(cont3==0){
            return false;
        }else{
            return true;
        }
        
    }
    
    public int getQuantityPro(ProductDetails pid,CustomerTable cid){
        Query q = em.createQuery("select a.quantity from OrderTable a where a.customerID =:cid and a.productID=:pid");
        q.setParameter("cid", cid);
        q.setParameter("pid", pid);
        Object cont1=q.getSingleResult();
        String cont2= cont1.toString();
        int cont3= Integer.parseInt(cont2);
        return cont3;
        
    }
    
    public void addToQty(int qty,ProductDetails pid,CustomerTable cid){
        Query q = em.createQuery("update OrderTable a set a.quantity =:qty where a.customerID=:cid and a.productID=:pid");
        q.setParameter("cid", cid);
        q.setParameter("pid", pid);
        q.setParameter("qty", qty+1);
        q.executeUpdate();
    }
}
