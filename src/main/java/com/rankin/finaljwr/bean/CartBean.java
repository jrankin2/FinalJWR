/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rankin.finaljwr.bean;

import com.rankin.finaljwr.model.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Joe
 */
@RequestScoped
@Named
public class CartBean implements Serializable{
    
    @Inject
    private BookFacade bookFacade;
    
    private Map<Book, Integer> cart;
    private Book selectedBook;
    private int selectedBookId;
    
    public CartBean(){
        cart = new HashMap<Book, Integer>();
    }
    
    @PostConstruct
    public void init(){
        cart = new HashMap<Book, Integer>();
    }
    
    /**
     * Add a book to the shopping cart.
     * @param book a book
     */
    /*
    public void addBook(Book book) {
        System.out.println("asdlfkjasdf\nasdfasdf\nasdfasdf\n");
        if(cart.containsKey(book)){
            cart.put(book, cart.get(book)+1);
        }else{
            cart.put(book, 1);
        }
    }*/
    
    public void addBook(int bookId) {
        System.out.println("asdlfkjasdf\nasdfasdf\nasdfasdf\n");
        Book book = bookFacade.find(bookId);
        if(cart.containsKey(book)){
            cart.put(book, cart.get(book)+1);
        }else{
            cart.put(book, 1);
        }
    }
    
    public List<Book> getBookList(){
        return new ArrayList<Book>(cart.keySet());
    }

    /**
     * Get a map of books and their quantities.
     * @return a map of books and their quantities.
     */
    public Map<Book, Integer> getCart() {
        return cart;
    }
    
    /**
     * Get the number of items in the shopping cart.
     * @return number of items in the shopping cart.
     */
    public int getNumberOfItems() {
        int total = 0;
        for(int i : cart.values()){
            total += i;
        }
        return total;
    }
    
    /**
     * Get the amount of a book in the cart.
     * @param book a book.
     * @return amount of book in the cart.
     */
    public int getBookAmount(Book book){
        return cart.get(book);
    }
    
    /**
     * Get the total price of the shopping cart in a formatted string.
     * @return total price of the shopping cart in a formatted string.
     */
    public String getTotalPriceString() {
        return String.format("$%,.2f", getTotalPrice());
    }

    /**
     * Get the total price of the shopping cart.
     * @return the total price of the shopping cart.
     */
    public double getTotalPrice() {
        double total = 0;
        for(Book b : cart.keySet()){
            total += b.getPrice() * cart.get(b);
        }
        return total;
    }
    
    /**
     * Whether or not the cart is empty.
     * @return whether or not the cart is empty.
     */
    public boolean isEmpty() {
        return cart.isEmpty();
    }
    
    /**
     * Removes a book with the specified id.
     * @param id a book id.
     */
    public void removeBookById(String id) {
        for(Book b : cart.keySet()){
            if(id.equals(String.valueOf(b.getId()))){
                if(cart.get(b) > 1){
                    cart.put(b, cart.get(b)-1);
                } else{
                    cart.remove(b);
                }
            }
        }
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void putSelectedBook(int bookId) {
        Book book = bookFacade.find(bookId);
        System.out.println("\n\n\n\n\n\n\n\nSelected book: ");
        this.selectedBook = book;
    }

    public int getSelectedBookId() {
        return selectedBookId;
    }

    public void setSelectedBookId(int selectedBookId) {
        System.out.println("1\n2\n3\n4\n");
        this.selectedBookId = selectedBookId;
    }
    
    public String testIt(){
        System.out.println("asddjalsdkasfdvasdfg\n\n\n\n\n\n\n\nasdfgasdfasdfg");
        return "/login.xhtml";
    }
}
