package fpt.aptech.bean;

import java.util.List;

/**
 *
 * @author ThienKim
 */
public interface IThienKim {
    List<ThienKim> findAll();
    ThienKim findOne(String cid);
    void addCourse(ThienKim course);
    void deleteCourse(String cid);
    ThienKim updateCourse(ThienKim c);
}
