package com.rankin.finaljwr.bean;

import com.rankin.finaljwr.model.Book;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

@Named
@RequestScoped
public class BookBean implements Serializable {
    
    private Book current;
    private Book newBook;
    private DataModel items = null;
    @Inject
    private BookFacade bookFacade;
    private int selectedItemIndex;
    private List<Book> books;

    public BookBean() {
    }
    
    @PostConstruct
    public void init(){
        books = bookFacade.findAll();
        newBook = new Book();
    }

    public Book getSelected() {
        if (current == null) {
            current = new Book();
            selectedItemIndex = -1;
        }
        return current;
    }

    private BookFacade getFacade() {
        return bookFacade;
    }

    public Book getBook(Integer id) {
        return bookFacade.find(id);
    }
    
    public List<Book> getAllBooks(){
        return books;
    }
    
    public void onEdit(RowEditEvent event) { 
        Book book = (Book) event.getObject();
        System.out.println(book.getName());
        bookFacade.edit(book);
        FacesMessage msg = new FacesMessage("Book Edited", book.getName());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
    
    public void onCancel(RowEditEvent event) {
        
    } 
    
    public void createNewBook(ActionEvent actionEvent){
        bookFacade.create(newBook);
        books = bookFacade.findAll();
    }

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }
    
    
}
