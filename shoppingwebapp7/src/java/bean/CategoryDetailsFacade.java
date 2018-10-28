/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CategoryDetails;
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
public class CategoryDetailsFacade extends AbstractFacade<CategoryDetails> {

    @PersistenceContext(unitName = "shoppingwebapp7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryDetailsFacade() {
        super(CategoryDetails.class);
    }
    
    public String  getProductsBySubCatName(String subcat,int caty){
        Object catName; 
        Query q = em.createQuery("select p.categoryID FROM ProductDetails p where p.subCategory= :npid ");
        q.setParameter("npid",subcat);
        Object num = q.getFirstResult();
        String num1 = num.toString();
        int num3 = q.getFirstResult();
        
        Query q1 = em.createQuery("select p.categoryName FROM CategoryDetails p where p.categoryID= :npid2 ");
        q1.setParameter("npid2",caty);
        catName = q1.getSingleResult();
        return catName.toString();
    }
    
}
