/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CustomerTable;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abun
 */
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

  @EJB
    private CustomerTableFacade customerTableFacade;
    private CustomerTable cust = new CustomerTable();
    
    private String email;
    private String password;

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
        
    }
    
    public void grantPermission(){
        FacesContext facesContext= FacesContext.getCurrentInstance();
        HttpSession session =(HttpSession)facesContext.getExternalContext()
                .getSession(true);
        Object userLoggedIn = session.getAttribute("username");
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        if(userLoggedIn == null){
            try{
                context.redirect("login.xhtml?faces-redirect=true");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public String validateLogin(){
        cust.setEmail(email);
        cust.setPassword(password);
        List<CustomerTable> cst= customerTableFacade.findAll();

        for(int i=0; i< cst.size();i++){
            if(cst.get(i).getEmail().equals(cust.getEmail())&&cst.get(i).getPassword().toString().equals(cust.getPassword())){
                HttpSession session = SessionUtil.getSession();
                session.setAttribute("username", cust.getEmail());
                return "index?faces-redirect=true";
            }
               
        }
        return "mail";

    }
    public String logout(){
        HttpSession session = SessionUtil.getSession();
        session.invalidate();
        return"index.xhtml?faces-redirect=true";
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
        //cust.setCustomerName(email);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
        //cust.setPassword(password);
    }
    
}
