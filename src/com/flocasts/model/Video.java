package com.flocasts.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/14/14
 * Time: 7:58 PM
 *
 * Simple model object to represent a video.
 */
@Entity
@Table(name="video")
@XmlRootElement(name="video")
public class Video {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="url")
    private String url;

    @Column(name="length")
    private Integer length; //In seconds

    @Column(name="categories",columnDefinition = "mediumtext")
    private String categories;

    @Column(name="channels",columnDefinition = "mediumtext")
    private String channels;

    @Column(name="tags",columnDefinition = "mediumtext")
    private String tags;

    @Column(name="is_active",columnDefinition = "bit")
    private Boolean isActive = true;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="lcts")
    private Date lcts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLcts() {
        return lcts;
    }

    public void setLcts(Date lcts) {
        this.lcts = lcts;
    }
}
