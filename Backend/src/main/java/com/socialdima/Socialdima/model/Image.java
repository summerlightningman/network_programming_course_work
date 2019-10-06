/**
 * @author Baranov DA
 * @version 1.99
 */
package com.socialdima.Socialdima.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

/**
 *  This class represents DB-table image
 */
@Entity
public class Image {
    /**
     * @attribute id - identifying attribute / auto_increment
     * This columns for table images
     */
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Integer id;

    /**
     * @attribute path - path for picture in the storage
     */
    @Column(name = "path")
    private String path;

    /**
     * @attribute published - date and time of public this image
     */
    @Column(name = "published")
    private Calendar published;

    public Image() {
    }

    /**
     * Getter for Id
     * @return identifying attribute for row
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for Id
     * @param id - identifying attribute for row
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for Id
     * @return path for picture in the storage
     */
    public String getPath() {
        return path;
    }

    /**
     * Setter for path
     * @param path - path for picture in the storage
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Getter for published
     * @return date and time of public this image
     */
    public Calendar getPublished() {
        return published;
    }

    /**
     * Setter for published
     * @param published - date and time of public this image
     */
    public void setPublished(Calendar published) {
        this.published = published;
    }

}
