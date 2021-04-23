package fpt.aptech.JavaBean;

import java.io.Serializable;

/**
 *
 * @author ThienKim
 */
public class Calculator implements Serializable {

    private double num1, num2;
    private char opt;

    public Calculator() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public char getOpt() {
        return opt;
    }

    public void setOpt(char opt) {
        this.opt = opt;
    }

    public double result() {
        switch (opt) {
            case '+':
                return num1 + num2;
//                break;
            case '-':
                return num1 - num2;
//                break;
            case '*':
                return num1 * num2;
//                break;
            case '/':
                return num1 / num2;
//                break;
        }
        return 0;
    }
}
