package fpt.aptech.bean;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
public class ThienKimDAO implements IThienKim {

    // định nghĩa EntityManagerFactory để gọi Persistence Unit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab05PU");
    EntityManager em = emf.createEntityManager();

    public void Persit(Object object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<ThienKim> findAll() {
        List<ThienKim> list = new ArrayList<>();
        String query = "SELECT c FROM ThienKim c";
        Query q = em.createQuery(query);
        list = q.getResultList();
        return list; // trả về nhiều một tập tất cả collection
        // trả về một đối tượng : getSingleResult
        // mọi phương thức đều phải return trừ void
        // return em.createQuery("SELECT c FROM ThienKim c").getResultList();
    }

    @Override
    public ThienKim findOne(String cid) {
         return em.find(ThienKim.class, cid);
//        ThienKim course = null;
//        try {
//            em.getTransaction();
//            course = em.find(ThienKim.class, cid);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        } finally {
//            em.close();
//        }
//        return course;
    }
    
    @Override
    public void addCourse(ThienKim course) {
        Persit(course);
    }

    @Override
    public void deleteCourse(String cid) {
                try {
            em.getTransaction().begin();
            ThienKim course = em.find(ThienKim.class, cid);
            if (course != null) {
                em.remove(course);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public ThienKim updateCourse(ThienKim c) {
        //        Query q = em.createQuery("UPDATE ThienKim SET course_name = :name, duration = :duration, fee = :fee WHERE course_id = :id").setParameter("name", c.getThienKimName())
//                .setParameter("duration", c.getDuration()).setParameter("fee", c.getFee()).setParameter("id", c.getThienKimId());
        try {
                em.getTransaction().begin();
//                Query q = em.createQuery("UPDATE ThienKim SET course_name = :name, duration = :duration, fee = :fee WHERE course_id = :id").setParameter("name", c.getThienKimName())
//                .setParameter("duration", c.getDuration()).setParameter("fee", c.getFee()).setParameter("id", c.getThienKimId());
                em.merge(c);
                em.getTransaction().commit();
        }catch (Exception e) {
                em.getTransaction().rollback();
        }finally{
                em.close();
        }
        return c;
    }
}
