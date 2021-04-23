package fpt.aptech.bean;

import java.util.List;

/**
 *
 * @author ThienKim
 */
public interface IUsers {
    List<Users1> findAll();
    List<Users1> findByName(String uname);
    Users1 findOne(String uid);
    Users1 Login(String uid, String upass);
}
