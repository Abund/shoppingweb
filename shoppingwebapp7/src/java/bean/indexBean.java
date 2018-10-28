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
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Abun
 */
@Named(value = "indexBean")
@SessionScoped
public class indexBean implements Serializable {
    
    private List<ProductDetails> mensClothing; 
    private List<ProductDetails> autoCompLi;
    private List<String> autoCompLi2;
    private List<String> autoCompLi3;
    private String searchWord;
    private List<ProductDetails> womenClothing; 
    private List<ProductDetails> menShoe;
    private List<ProductDetails> watches; 
    private List<ProductDetails> kidswears;
    private String searchItem="";
    private List<ProductDetails> data=null;
    private List<String> result=null;
    //private List<ProductDetails> products;
    @EJB
    private ProductDetailsFacade productDetailsFacade;
    
    private ProductDetails pd;
    /**
     * Creates a new instance of indexBean
     */
    public indexBean() {
        
    }
    @PostConstruct
    public void init() {
        autoCompLi = new ArrayList();
        setAutoCompLi2((List<String>) new ArrayList());
        autoCompLi3 = new ArrayList<String>();
        setResult((List<String>) new ArrayList());
        data = new ArrayList<ProductDetails>();
        data=productDetailsFacade.findAll();
        
        //products= productDetailsFacade.findAll();
        setMensClothing(productDetailsFacade.getMensClothing());
        womenClothing =productDetailsFacade.getWomensClothing();
        menShoe =productDetailsFacade.getMensShoes();
        kidswears =productDetailsFacade.getBoysClothing();
        watches =productDetailsFacade.getMensWatches();
        autoCompLi=productDetailsFacade.findAll();
        autoCompLi3=typeAheadVales();
        
    }
    public List<String> typeAheadVales(){
//        for(ProductDetails pdt:autoCompLi){
//            if(pdt.getProductName().startsWith(getSearchWord())){
//               autoCompLi2.add(pdt.getProductName());
//            }
//        }
//        
//        return autoCompLi2;
        
        for(int i=0;i<autoCompLi.size();i++){
            getAutoCompLi2().add(autoCompLi.get(i).getProductName());
        }
        return getAutoCompLi2();
    }

    
    public void search(){
        result.clear();
        for(ProductDetails pr:getData()){
            if(pr.getProductName().startsWith(searchItem));
            getResult().add(pr.getProductName());
        }
    }
    
    public void search1(){
        result.clear();
        for(ProductDetails pr:getData()){
            if(pr.getProductName().startsWith(searchItem));
            getResult().add(pr.getProductName());
        }
    }

    /**
     * @return the mensClothing
     */
    public List<ProductDetails> getMensClothing() {
        return mensClothing;
    }

    /**
     * @return the womenJewlery
     */
    

    /**
     * @return the menShoe
     */
    public List<ProductDetails> getMenShoe() {
        return menShoe;
    }

    /**
     * @return the lighting
     */
  

    /**
     * @param mensClothing the mensClothing to set
     */
    public void setMensClothing(List<ProductDetails> mensClothing) {
        this.mensClothing = mensClothing;
    }

    /**
     * @return the pd
     */
    public ProductDetails getPd() {
        return pd;
    }

    /**
     * @param pd the pd to set
     */
    public void setPd(ProductDetails pd) {
        this.pd = pd;
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
     * @return the data
     */
    public List<ProductDetails> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<ProductDetails> data) {
        this.data = data;
    }

    /**
     * @return the result
     */
    public List<String> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<String> result) {
        this.result = result;
    }

    /**
     * @return the womenClothing
     */
    public List<ProductDetails> getWomenClothing() {
        return womenClothing;
    }

    /**
     * @return the watches
     */
    public List<ProductDetails> getWatches() {
        return watches;
    }

    /**
     * @return the kidswears
     */
    public List<ProductDetails> getKidswears() {
        return kidswears;
    }
    
    
    /**
     * @return the autoCompLi
     */
    public List<ProductDetails> getAutoCompLi() {
        return autoCompLi;
    }

    /**
     * @param autoCompLi the autoCompLi to set
     */
    public void setAutoCompLi(List<ProductDetails> autoCompLi) {
        this.autoCompLi = autoCompLi;
    }

    /**
     * @return the autoCompLi2
     */
    public List<String> getAutoCompLi2() {
        return autoCompLi2;
    }

    /**
     * @param autoCompLi2 the autoCompLi2 to set
     */
    public void setAutoCompLi2(List<String> autoCompLi2) {
        this.autoCompLi2 = autoCompLi2;
    }

    /**
     * @return the searchWord
     */
    public String getSearchWord() {
        return searchWord;
    }

    /**
     * @param searchWord the searchWord to set
     */
    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    /**
     * @return the autoCompLi3
     */
    public List<String> getAutoCompLi3() {
        return autoCompLi3;
    }

    /**
     * @param autoCompLi3 the autoCompLi3 to set
     */
    public void setAutoCompLi3(List<String> autoCompLi3) {
        this.autoCompLi3 = autoCompLi3;
    }
    
    
}
