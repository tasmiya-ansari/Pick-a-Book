package pickabook.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tasmi
 */
public class BookDetailsDTO {
    private String bookid;
    private String title;
    private String author;
    private String description;
    private double price;
    private String category;
    private String imagename;

    public BookDetailsDTO() {
    }

    public BookDetailsDTO(String bookid, String title, String author, String description, double price, String category, String imagename) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imagename = imagename;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    @Override
    public String toString() {
        return "BookDetailsDTO{" + "bookid=" + bookid + ", title=" + title + ", author=" + author + ", description=" + description + ", price=" + price + ", category=" + category + ", imagename=" + imagename + '}';
    }
    
    
}
