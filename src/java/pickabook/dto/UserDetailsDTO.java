/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.dto;

/**
 *
 * @author tasmi
 */
public class UserDetailsDTO {
    
    private String email;
    private String password;
    private String username;
    private long mobile_no;
    private String address;
    private String city;
    private String state;
    
    //the user_details table in the database has 8 columns but we'll be making 7 datamembers coz the last column i.e usertype would always bhi "customer' for evry registration.

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(String email, String password, String username, long mobile_no, String address, String city, String state) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.mobile_no = mobile_no;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserDetailsDTO{" + "email=" + email + ", password=" + password + ", username=" + username + ", mobile_no=" + mobile_no + ", address=" + address + ", city=" + city + ", state=" + state + '}';
    }
    
    
}
