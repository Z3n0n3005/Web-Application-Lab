/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab_6;

/**
 *
 * @author vy
 */
public class AccountBean {
    private String name;
    private int visaCardNum;
    private String address;

    public String getName(){
        return name;
    }

    public int getVisaCardNum(){
        return visaCardNum;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setVisaCardNum(int visaCardNum) {
        this.visaCardNum = visaCardNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
