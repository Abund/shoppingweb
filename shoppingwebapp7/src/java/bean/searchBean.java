/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.ProductDetails;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Abun
 */
@Named(value = "searchBean")
@SessionScoped
public class searchBean implements Serializable {
    
    private String searchItem;
    private String newProduct="mensclothing";
    private List<ProductDetails> newProductList;
    private ProductDetails productDetails = new ProductDetails();
    @EJB
    private ProductDetailsFacade productDetailsFacade;
    private List<ProductDetails> pdt;

    /**
     * Creates a new instance of searchBean
     */
    public searchBean() {
    }
    
    
    @PostConstruct
    public void init() {
        pdt = new ArrayList<ProductDetails>();
        setPdt(productDetailsFacade.getProductBySearchName3(searchItem));
        setNewProductList(productDetailsFacade.getNewProducts(newProduct));
    }
    
    public String searchButton(String butt){
        pdt = new ArrayList<ProductDetails>();
        setPdt(productDetailsFacade.getProductBySearchName3(searchItem));
        setNewProductList(productDetailsFacade.getNewProducts(newProduct));
        return "search.xhtml?faces-redirect=true";
    }

    /**
     * @return the searchItem
     */
    public String getSearchItem() {
        return searchItem;
    }

    /**
     * @param searchItem the searchItem to set
     */
    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    /**
     * @return the pdt
     */
    public List<ProductDetails> getPdt() {
        return pdt;
    }

    /**
     * @param pdt the pdt to set
     */
    public void setPdt(List<ProductDetails> pdt) {
        this.pdt = pdt;
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
    
}
