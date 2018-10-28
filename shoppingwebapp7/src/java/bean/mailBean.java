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
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abun
 */
@Named(value = "mailBean")
@SessionScoped
public class mailBean implements Serializable {
    String to ="abunonyeodi@gmail.com";
    private String name;
    private String from;
    String host ="localhost";
    private String subject;
    private String text;
    
    @EJB
    private CustomerTableFacade customerTableFacade;
    CustomerTable CustomerId = new CustomerTable();
    
    /**
     * Creates a new instance of mailBean
     */
    public mailBean() {
    }
    
    public void sendEmail(){
        List<CustomerTable> cst= customerTableFacade.findAll();
        FacesContext facesContext= FacesContext.getCurrentInstance();
        HttpSession session1 =(HttpSession)facesContext.getExternalContext()
                .getSession(true);
        String userLoggedIn = (String)session1.getAttribute("username");
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();
        
        for(int i=0; i< cst.size();i++){
            if(cst.get(i).getEmail().equals(userLoggedIn)){
                CustomerId.setCustomerID(cst.get(i).getCustomerID());
                CustomerId.setEmail(cst.get(i).getEmail());
                CustomerId.setCustomerFirstName(cst.get(i).getCustomerFirstName());
            }
               
        }
        
        if(CustomerId.getCustomerID()==null){
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", to);
            Session session = Session.getDefaultInstance(properties);
            try{
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(getFrom(), getName()));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(getSubject());
                message.setText(getText());
                Transport.send(message);
            }catch(MessagingException mex){
                mex.printStackTrace();
            }catch(UnsupportedEncodingException mex){
                mex.printStackTrace();
            }
        }else{
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", to);
            Session session = Session.getDefaultInstance(properties);
            try{
                MimeMessage message = new MimeMessage(session);
                //message.setFrom(new InternetAddress(getFrom(), getName()));
                message.setFrom(new InternetAddress(CustomerId.getEmail(),CustomerId.getCustomerFirstName()));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(getSubject());
                message.setText(getText());
                Transport.send(message);
            }catch(MessagingException mex){
                mex.printStackTrace();
            }catch(UnsupportedEncodingException mex){
                mex.printStackTrace();
            }
        }
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Name
     */
    
    
}
