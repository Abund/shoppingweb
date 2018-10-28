/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CategoryDetails;
import data.CustomerTable;
import data.ProductDetails;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Abun
 */
@Stateless
public class ProductDetailsFacade extends AbstractFacade<ProductDetails> {
    
    private List<ProductDetails> mensClothing; 
    private List<ProductDetails> searchByName;
    private List<ProductDetails> womenJewlery; 
    private List<ProductDetails> menShoe;
    private List<ProductDetails> Lighting; 
    private List<ProductDetails> diningTables;
    private List<ProductDetails> products;
    private List<ProductDetails> byCategory;
    private List<ProductDetails> productByList;
    private List<ProductDetails> subListing;
    CategoryDetails cgd = new CategoryDetails();
    int numCat;

    private String mensclothing="mensclothing";
    private String womensclothing="womensclothing";
    private String menshoe="mensshoes";
    private String boysclothing="boysclothing";
    private String menswatches="menswatches";
    @PersistenceContext(unitName = "shoppingwebapp7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductDetailsFacade() {
        super(ProductDetails.class);
    }
    
    public List<ProductDetails> getMensClothing() {
        
        mensClothing = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory");
        q.setParameter("subCategory", mensclothing);
        mensClothing= q.getResultList();
        return mensClothing;
        
    }
    
    public List<ProductDetails> getWomensClothing() {
        
        womenJewlery = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory").setParameter("subCategory", womensclothing);
        womenJewlery= q.getResultList();
        return womenJewlery;
        
    }
    
    public List<ProductDetails> getMensShoes() {
        
        menShoe = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory").setParameter("subCategory", menshoe);
        menShoe= q.getResultList();
        return menShoe;
        
    }
    
    public List<ProductDetails> getMensWatches(){
        
        diningTables = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory").setParameter("subCategory", menswatches);
        
        q.getResultList().set(2, q.getResultList().remove(5));
        diningTables= q.getResultList();
        return diningTables;
        
    }
    
    public List<ProductDetails> getBoysClothing() {
        
        Lighting = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory").setParameter("subCategory", boysclothing);
        Lighting= q.getResultList();
        return Lighting;
        
    }
    
    public List<ProductDetails> getProductsByCategory(String Category) {
        
        byCategory = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory");
        q.setParameter("subCategory", Category);
        byCategory= q.getResultList();
        return byCategory;
        
    }
    
    public List<ProductDetails> getNewProducts(String Category) {
        
        byCategory = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findBySubCategory");
        q.setParameter("subCategory", Category);
        q.setMaxResults(3);
        byCategory= q.getResultList();
        return byCategory;
        
    }
    
     public List<ProductDetails> getProductByPrice(int price, int nprice){
        productByList = new ArrayList<>();
        Query q = em.createQuery("select p.categoryID,p.description,p.image1,p.image2,p.image3,p.minDescription,p.newPrice,p.oldPrice,p.productID,p.productName,p.subCategory FROM ProductDetails p where p.newPrice between :pid and :npid ");
        q.setParameter("pid", price);
        q.setParameter("npid", nprice);
        productByList = q.getResultList();
       return productByList; 
    }
     
    public List<ProductDetails>  getProductsBySubCat(String subcat,int catty){
        subListing = new ArrayList<>(); 
        Query q = em.createQuery("select p.categoryID FROM ProductDetails p where p.subCategory= :npid ");
        //Query q = em.createQuery("select p.categoryID FROM ProductDetails p where p.subCategory= :npid ");
        q.setParameter("npid",subcat);
        Object num = q.getFirstResult();
        String num1 = num.toString();
        int num3 = Integer.parseInt(num1);
        
        cgd.setCategoryID(catty);
        
        Query q1 = em.createQuery("select distinct p.subCategory FROM ProductDetails p where p.categoryID =:npid2 ");
        q1.setParameter("npid2",cgd);
        //Object hd = q1.getSingleResult();
        subListing = q1.getResultList();
        return subListing;
    }
    
    public int  getSubCatNum(String subcat){
        subListing = new ArrayList<>(); 
        Object num;
        Query q = em.createQuery("select count(p.subCategory) FROM ProductDetails p where p.subCategory= :npid group by p.subCategory");
        q.setParameter("npid",subcat);
        
        num = q.getSingleResult();
        String num1 = num.toString();
        try{
        numCat = Integer.parseInt(num1);
        }catch(NumberFormatException e){
            numCat=0;
        }
        return numCat;
    }
    
    public List<ProductDetails>  getProductBySearchName(String name){
        searchByName = new ArrayList<>(); 
        Query q = em.createQuery("select p.categoryID,p.description,p.image1,p.image2,p.image3,p.minDescription,p.newPrice,p.oldPrice,p.productID,p.productName,p.stock,p.subCategory FROM ProductDetails p where p.productName like :npname");
        q.setParameter("npname",name);
        searchByName = q.getResultList();
        return searchByName;
    }
    
    public List<ProductDetails>  getProductBySearchName1(String name){
        searchByName = new ArrayList<>();
        Query q = em.createNamedQuery("ProductDetails.findByProductName");
        q.setParameter("productName", name);
        searchByName= q.getResultList();
        return searchByName;
    }
    
    public List<ProductDetails>  getProductBySearchName3(String name){
        searchByName = new ArrayList<>(); 
        Query q = em.createQuery("select p FROM ProductDetails p where p.productName like concat(:npname,'%')");
        q.setParameter("npname",name);
        searchByName = q.getResultList();
        return searchByName;
    }
    
    public int getProductMainCategoryNum(String name){
        Query q = em.createQuery("select distinct p.categoryID FROM ProductDetails p where p.subCategory =:sub");
        q.setParameter("sub",name);
        CategoryDetails dtd= new CategoryDetails();
        dtd= (CategoryDetails) q.getSingleResult();
        //String num1= num.toString();
        int num2=dtd.getCategoryID();
        //int num2 = Integer.parseInt(num1);
        return num2;
    }
    
}
