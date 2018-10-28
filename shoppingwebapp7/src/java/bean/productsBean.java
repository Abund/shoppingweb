/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.ProductDetails;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Abun
 */
@Named(value = "productsBean")
@SessionScoped
public class productsBean implements Serializable {
    
    private String headerName;
    private String categoryName;
    private int numberInCategrory;  
    private String newProduct="mensclothing";
    private List<ProductDetails> byCategory;
    private List<ProductDetails> newProductList;
    private int catid;
    private List<ProductDetails> subList;
    private int number8 =30;
    private int number9 =80;

    @EJB
    private ProductDetailsFacade productDetailsFacade;
    
    @EJB
    private CategoryDetailsFacade categoryDetailsFacade;

    /**
     * Creates a new instance of productsBean
     */
    public productsBean() {
    }
    
    public void loadProducts(){
        setByCategory(productDetailsFacade.getProductsByCategory(categoryName));
        setNewProductList(productDetailsFacade.getNewProducts(newProduct));
        setSubList(productDetailsFacade.getProductsBySubCat(categoryName,catid));
        headerName=categoryDetailsFacade.getProductsBySubCatName(categoryName,catid);
        
    }
    
    public void displaySubCat(){
        setByCategory(productDetailsFacade.getProductsByCategory(categoryName));
        setNewProductList(productDetailsFacade.getNewProducts(newProduct));
        setSubList(productDetailsFacade.getProductsBySubCat(categoryName,catid));
        headerName=categoryDetailsFacade.getProductsBySubCatName(categoryName,catid);
        
    }
    
    public void productByPrice(int price1,int price2){
        setByCategory(productDetailsFacade.getProductByPrice(price2, price2));
    }

    public int getProductMainCategory(String product){
        int num =0;
        num = productDetailsFacade.getProductMainCategoryNum(product);
        return num;
    }
    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the newProduct
     */
    public String getNewProduct() {
        return newProduct;
    }

    /**
     * @param newProduct the newProduct to set
     */
    public void setNewProduct(String newProduct) {
        this.newProduct = newProduct;
    }

    /**
     * @return the byCategory
     */
    public List<ProductDetails> getByCategory() {
        return byCategory;
    }

    /**
     * @param byCategory the byCategory to set
     */
    public void setByCategory(List<ProductDetails> byCategory) {
        this.byCategory = byCategory;
    }

    /**
     * @return the newProductList
     */
    public List<ProductDetails> getNewProductList() {
        return newProductList;
    }

    /**
     * @param newProductList the newProductList to set
     */
    public void setNewProductList(List<ProductDetails> newProductList) {
        this.newProductList = newProductList;
    }
    
    
    
    public int subCatProNum(String SubCat){
        setNumberInCategrory(productDetailsFacade.getSubCatNum(SubCat));
        return numberInCategrory;
    }

    /**
     * @return the subList
     */
    public List<ProductDetails> getSubList() {
        return subList;
    }

    /**
     * @param subList the subList to set
     */
    public void setSubList(List<ProductDetails> subList) {
        this.subList = subList;
    }

    /**
     * @return the headerName
     */
    public String getHeaderName() {
        return headerName;
    }

    /**
     * @param headerName the headerName to set
     */
    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    /**
     * @return the numberInCategrory
     */
    public int getNumberInCategrory() {
        return numberInCategrory;
    }

    /**
     * @param numberInCategrory the numberInCategrory to set
     */
    public void setNumberInCategrory(int numberInCategrory) {
        this.numberInCategrory = numberInCategrory;
    }

    /**
     * @return the catid
     */
    public int getCatid() {
        return catid;
    }

    /**
     * @param catid the catid to set
     */
    public void setCatid(int catid) {
        this.catid = catid;
    }

    /**
     * @return the number8
     */
    public int getNumber8() {
        return number8;
    }

    /**
     * @param number8 the number8 to set
     */
    public void setNumber8(int number8) {
        this.number8 = number8;
    }

    /**
     * @return the number9
     */
    public int getNumber9() {
        return number9;
    }

    /**
     * @param number9 the number9 to set
     */
    public void setNumber9(int number9) {
        this.number9 = number9;
    }
    
}
