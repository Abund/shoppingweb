/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.CustomerTable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abun
 */
@Named(value = "register")
@SessionScoped
public class register implements Serializable {
    
    @EJB
    private CustomerTableFacade customerTableFacade;
    private CustomerTable cust = new CustomerTable();
    private String firstName;
    private String lastName;
    private String newsLetter;
    private String email;
    private String password;

    /**
     * Creates a new instance of register
     */
    public register() {
    }

    public String registerButton(){
        cust.setCustomerFirstName(firstName);
        cust.setCustomerLastName(lastName);
        cust.setEmail(email);
        cust.setNewsletter(newsLetter);
        cust.setPassword(password);
        customerTableFacade.create(cust);
        HttpSession session = SessionUtil.getSession();
        session.setAttribute("username", cust.getEmail());
        return "index?faces-redirect=true";
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the newsLetter
     */
    public String getNewsLetter() {
        return newsLetter;
    }

    /**
     * @param newsLetter the newsLetter to set
     */
    public void setNewsLetter(String newsLetter) {
        this.newsLetter = newsLetter;
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
    }
    
}
