/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CustomerTable;
import data.ProductDetails;
import data.ReviewTable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Abun
 */
@Stateless
public class ReviewTableFacade extends AbstractFacade<ReviewTable> {
    
    private List<ReviewTable> rt;

    @PersistenceContext(unitName = "shoppingwebapp7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReviewTableFacade() {
        super(ReviewTable.class);
    }
    
    public List<ReviewTable> getProductReview(ProductDetails pid){
        rt = new ArrayList<>();
        Query q = em.createQuery("select a from ReviewTable a where a.productID =:pid ");
        q.setParameter("pid", pid);
        rt=q.getResultList();
        return rt;
        
    }
    
    public int NoOfProductReviews(ProductDetails pid){
        Object num=null;
        try{
        Query q = em.createQuery("select count(a.productID) from ReviewTable a where a.productID =:pid group by a.productID");
        q.setParameter("pid", pid);
        num=q.getSingleResult();
        }catch(NoResultException e){
               num ="0";
        }
        return Integer.parseInt(num.toString());
    }
    
}
