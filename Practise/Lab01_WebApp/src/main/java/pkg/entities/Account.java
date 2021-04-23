/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg.entities;

/**
 *
 * @author ThienKim
 */
public class Account {
    private String AccountCode;
    private String AccountName;
    private String PinCode;
    private Long Balance;

    public Account() {
    }

    public String getAccountCode() {
        return AccountCode;
    }

    public void setAccountCode(String AccountCode) {
        this.AccountCode = AccountCode;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String PinCode) {
        this.PinCode = PinCode;
    }

    public Long getBalance() {
        return Balance;
    }

    public void setBalance(Long Balance) {
        this.Balance = Balance;
    }
}
