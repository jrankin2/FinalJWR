package com.rankin.finaljwr.bean;

import com.rankin.finaljwr.model.User;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    private UserFacade userFacade;
    private User loggedInUser;
    private User newUser;

    public UserBean() {
        
    }
    
    @PostConstruct
    public void init(){
        newUser = new User();
    }
    
    
    public String registerUser(){
        userFacade.create(newUser);
        loggedInUser = newUser;
        return "/shop/index";
    }

    public String logOut(){
        loggedInUser = null;
        return "/account/login";
    }
    
    
    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

}
