/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ThienKim
 */
@Entity
@Table(name = "Users1")
@NamedQueries({
    @NamedQuery(name = "Users1.findAll", query = "SELECT u FROM Users1 u"),
    @NamedQuery(name = "Users1.findByUserid", query = "SELECT u FROM Users1 u WHERE u.userid = :userid"),
    @NamedQuery(name = "Users1.findByFullname", query = "SELECT u FROM Users1 u WHERE u.fullname = :fullname"),
    @NamedQuery(name = "Users1.findByPassword", query = "SELECT u FROM Users1 u WHERE u.password = :password"),
    @NamedQuery(name = "Users1.findByAddress", query = "SELECT u FROM Users1 u WHERE u.address = :address")})
public class Users1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userid")
    private String userid;
    @Size(max = 50)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "address")
    private String address;

    public Users1() {
    }

    public Users1(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users1)) {
            return false;
        }
        Users1 other = (Users1) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.bean.Users1[ userid=" + userid + " ]";
    }
    
}
