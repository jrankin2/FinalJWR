/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rankin.finaljwr.bean;

import com.rankin.finaljwr.model.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jrankin2
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {
    @PersistenceContext(unitName = "com.rankin_FinalJWR_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
    public List<Book> searchByName(String name){
        Query query = em.createNamedQuery("Book.findByName");
        query.setParameter("name", "%" +name + "%");
        List<Book> results = query.getResultList();
        for (Book book : results) {
            System.out.println("bookfacade result: " + book);
        }
        
        
        return results;
    }
    
}
