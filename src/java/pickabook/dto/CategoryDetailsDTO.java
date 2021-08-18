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
public class CategoryDetailsDTO {
    private String categoryid;
    private String categoryname;

    public CategoryDetailsDTO() {
    }

    public CategoryDetailsDTO(String categoryid, String categoryname) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "CategoryDeatilsDTO{" + "categoryid=" + categoryid + ", categoryname=" + categoryname + '}';
    }
}
