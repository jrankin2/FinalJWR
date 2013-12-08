package com.rankin.finaljwr.bean;

import com.rankin.finaljwr.model.LoginModel;
import com.rankin.finaljwr.model.User;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    private UserFacade userFacade;
    private User loggedInUser;
    private LoginModel login;
    private User newUser;

    public UserBean() {
        
    }
    
    @PostConstruct
    public void init(){
        login = new LoginModel();
        newUser = new User();
    }
    
    private UserFacade getFacade() {
        return userFacade;
    }
    
    private void logIn(){
        
        
    }
    
    private void register(){
    }

    public void setLogin(LoginModel login) {
        this.login = login;
    }

    public LoginModel getLogin() {
        return login;
    }

}
