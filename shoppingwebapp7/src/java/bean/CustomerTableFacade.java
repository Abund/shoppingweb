/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CustomerTable;
import data.ProductDetails;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Abun
 */
@Stateless
public class CustomerTableFacade extends AbstractFacade<CustomerTable> {
    
    private List<CustomerTable> cst;

    @PersistenceContext(unitName = "shoppingwebapp7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerTableFacade() {
        super(CustomerTable.class);
    }
    
    public List<CustomerTable> getCustomers(){
        cst = new ArrayList<>();
        Query q = em.createQuery("select p.email,p.password FROM CustomerTable p  ");
        cst = q.getResultList();
       return cst; 
    }
    
}
