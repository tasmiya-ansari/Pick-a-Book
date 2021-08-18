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
public class CartDetailsDTO {
    private String email;
    private String bookid;
    private int quantity;
    private double price;
    private double total;

    public CartDetailsDTO() {
    }

    public CartDetailsDTO(String email, String bookid, int quantity, double price, double total) {
        this.email = email;
        this.bookid = bookid;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartDetailsDTO{" + "email=" + email + ", bookid=" + bookid + ", quantity=" + quantity + ", price=" + price + ", total=" + total + '}';
    }
   
}
