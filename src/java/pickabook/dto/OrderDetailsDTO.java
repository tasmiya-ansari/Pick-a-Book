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
public class OrderDetailsDTO {
    private String orderid;
    private String email;
    private String username;
    private String bookid;
    private int quantity;
    private String mobileno;
    private String address;
    private String city;
    private String state;
    private double total;
    private String payment;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String orderid, String email, String username, String bookid, int quantity, String mobileno, String address, String city, String state, double total, String payment) {
        this.orderid = orderid;
        this.email = email;
        this.username = username;
        this.bookid = bookid;
        this.quantity = quantity;
        this.mobileno = mobileno;
        this.address = address;
        this.city = city;
        this.state = state;
        this.total = total;
        this.payment = payment;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" + "orderid=" + orderid + ", email=" + email + ", username=" + username + ", bookid=" + bookid + ", quantity=" + quantity + ", mobileno=" + mobileno + ", address=" + address + ", city=" + city + ", state=" + state + ", total=" + total + ", payment=" + payment + '}';
    }

}
