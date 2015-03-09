/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kazakov.webbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import kazakov.entities.Books;
import kazakov.sessionbeans.sessionForBooks;

@ManagedBean
@ViewScoped
public class forPDF {
    private List<String> ref = new ArrayList<>();
    private String strRef = "https://www.dropbox.com/s/3e6wkru1rrpbjdc/Getting%20Started.pdf?dl=0";
    private String reference;

    public List<String> getRef() {
        return ref;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStrRef() {
        return strRef;
    }

    public void setStrRef(String strRef) {
        this.strRef = strRef;
    }

    public void setRef(List<String> ref) {
        this.ref = ref;
    }
    
    public void add() {
        reference = strRef;
        ref.add("docs/Getting.pdf");
    }
    
    //работа с session-бинами
    @Inject
    sessionForBooks sessBooks;
    public void newBook () {
        sessBooks.newRowToBooksTable(10, "ref10");
        reference = "hello from newBook";
    }
    
//    private List<Books> books;
//
//    public List<Books> getBooks() {
//        return sessBooks.selectAll();
//    }
//
//    public void setBooks(List<Books> books) {
//        this.books = books;
//    }
//    public List<Books> getBookss () {
//        return sessBooks.selectAll();
//    }
}
