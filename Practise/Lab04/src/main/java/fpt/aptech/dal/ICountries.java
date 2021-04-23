/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.aptech.dal;

import fpt.aptech.entities.Country;
import java.util.List;

/**
 *
 * @author ThienKim
 */
public interface ICountries {
    List<Country> findAll();
    void addCountries(String cname, int pop);
    void deleteCountries(int cid);
}
