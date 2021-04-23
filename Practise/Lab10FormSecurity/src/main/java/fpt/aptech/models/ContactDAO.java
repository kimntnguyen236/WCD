package fpt.aptech.models;
import javax.persistence.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author ThienKim
 */
public class ContactDAO {

    public ContactDAO() {
        
    }
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab10PU");
    EntityManager em;
    
    public List<Contact> findAll(){
        em = emf.createEntityManager();
        return em.createQuery("SELECT c FROM Contact c").getResultList();
    }
}
