package fpt.aptech.dal;

import fpt.aptech.entities.Country;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
public class CountriesDAO implements ICountries {

    // định nghĩa EntityManagerFactory để gọi Persistence Unit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab04PU");

    public void Persit(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            // bắt đầu
            em.getTransaction().begin();
            // thêm đối tượng
            em.persist(object);
            // cập nhật là merge, xóa là remove, thêm là persit
            // thực thi một Transaction
            em.getTransaction().commit();
        } catch (Exception e) {
            // kết thúc
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Country> findAll() {
        EntityManager em = emf.createEntityManager();
        String query = "SELECT c FROM Country c";
        Query q = em.createQuery(query);
        return q.getResultList(); // trả về nhiều một tập tất cả collection
        // trả về một đối tượng : getSingleResult
        // mọi phương thức đều phải return trừ void
    }

    @Override
    public void addCountries(String cname, int pop) {
        EntityManager em = emf.createEntityManager();
        try {
            Country country = new Country();
            country.setCountryname(cname);
            country.setPopulation(pop);
            // bắt đầu
            em.getTransaction().begin();
            em.persist(country);
            // thực thi
            em.getTransaction().commit();
        } catch (Exception e) {
            // kết thúc
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteCountries(int cid) {
        EntityManager em = emf.createEntityManager();
        try {
            Country c = new Country();
            c = em.find(Country.class, cid);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
