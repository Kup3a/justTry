/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kazakov.sessionbeans;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import kazakov.entities.Books;

/**
 *
 * @author aka_Kup3a
 */
@Stateless
@LocalBean
@ManagedBean
public class sessionForBooks {
    @PersistenceContext(unitName = "febrary2015-ejbPU")
    EntityManager entityManager;
    
    public void newRowToBooksTable(int book_id, String refer) {
        Books book = new Books(book_id);
        book.setReference(refer);
        entityManager.persist(book);        
    }
    
    public List<Books> selectAll () {
        Query query = entityManager.createNamedQuery("Books.findAll");
        return query.getResultList();
    }
}
