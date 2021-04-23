package fpt.aptech.bean;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ThienKim
 */
public class UsersDAO implements IUsers {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab06PU");
    EntityManager em = emf.createEntityManager();

    @Override
    public List<Users1> findAll() {
        try {
            String query = "SELECT u FROM Users1 u";
            return em.createQuery(query).getResultList();
        } finally {
            em.close();
        }

    }

    @Override
    public List<Users1> findByName(String uname) {
        // String query = "SELECT u FROM Users1 u WHERE u.fullname = :fullname";
        String query = "SELECT u FROM Users1 u WHERE u.fullname LIKE :fullname";
        try {
            return em.createQuery(query)
                    // .setParameter("fullname", uname)
                    .setParameter("fullname", "%"+uname+"%") // dùng cho LIKE còn nếu = thì dùng hàm trên
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Users1 findOne(String uid) {
        try {
            Users1 user = em.find(Users1.class, uid);
            return user;
        } finally {
            em.close();
        }
    }

    @Override
    public Users1 Login(String uid, String upass) {
        String query = "SELECT u FROM Users1 u WHERE u.userid = :userid AND u.password = :password";
        try {
            List<Users1> list = em.createQuery(query)
                    .setParameter("userid", uid)
                    .setParameter("password", upass)
                    .getResultList();
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return null;
            }
        } finally {
            em.close();
        }
    }
}
