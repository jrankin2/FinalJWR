/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rankin.finaljwr.bean;

import com.rankin.finaljwr.model.Book;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Joe
 */
@SessionScoped
@Named
public class CartBean implements Serializable{
    
    private Map<Book, Integer> cart;
    
    public CartBean(){
    }
    
    @PostConstruct
    public void init(){
        cart = new HashMap<Book, Integer>();
    }
    
    /**
     * Add a book to the shopping cart.
     * @param book a book
     */
    public void addBook(Book book) {
        if(cart.containsKey(book)){
            cart.put(book, cart.get(book)+1);
        }else{
            cart.put(book, 1);
        }
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
}
