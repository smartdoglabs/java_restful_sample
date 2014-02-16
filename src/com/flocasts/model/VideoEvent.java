package com.flocasts.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Date;

/**
 * My Kick Ass Video Metrics and Recommendation System
 * User: Jose Rubio
 * Date: 2/9/14
 * Time: 7:59 PM
 *
 * The VideoEvent class holds the data about a particular video event that occurred in the system.
 * We could have made this more generic and called it Event, but for the purpose of this exercise I
 * will just focus it on videos.
 *
 * And event will be created when a user plays a video, shares a video, rates a video, etc. We will
 * hold as much information about the event as possible so we can use this data later on.
 */
@Entity
@Table(name="event")
@XmlRootElement(name="event")
public class  VideoEvent {

    /**
     * The event ID.
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * The event type. See @link EventType for the possible values.
     */
    @Column(name="type")
    private String type;

    /**
     * The agent stores the browser/device used to access the video. So we will store that.
     */
    @Column(name="agent")
    private String agent;

    /**
     * What channel the event occured. Flotrack, Flowrestling, etc.
     */
    @Column(name="channel")
    private String channel;

    @Column(name="attributes")
    private String attributes;

    /**
     * We are going to use this flag to mark an event that came from a recommendation. So for example, if we get a list
     * of recommended videos, and a user clicks on it, then the LOAD event and any subsequent event will have this flag
     * set as true. The attributes column will have more information about who recommended this.
     */
    @Column(name="from_recommendation")
    private Boolean fromRecommendation;

    /**
     * The session ID will help us know what the user did during a visit. So we will be able to tell how many videos,
     * shares, comments, etc. the user did in one sitting. Just using the timestamp would be hard to know for sure.
     */
    @Column(name="session_id")
    private String sessionId;

    /**
     * The User that initiated the event. We could use Hibernate's @ManyToOne relationship here, but since we are
     * going to be passing this object around in the services, etc. And this table is going to grow and we might be
     * loading a bunch of them, I'm going to keep this referring to the ID.
     *
     * The database has a foreign key for this, so it will double check that we are not inserting an event for a user
     * that doesn't exist
     */
    @Column(name="user_id")
    private Integer userId;

    /**
     * The Video this event corresponds to. We could use Hibernate's @ManyToOne relationship here, but since we are
     * going to be passing this object around in the services, etc. And this table is going to grow and we might be
     * loading a bunch of them, I'm going to keep this referring to the ID.
     *
     * The database has a foreign key for this, so it will double check that we are not inserting an event for a video
     * that doesn't exist
     *
     */
    @Column(name="video_id")
    private Integer videoId;


    /**
     * The timestamp for the event.
     */
    @Column(name="timestamp")
    private Date timestamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public Boolean getFromRecommendation() {
        return fromRecommendation;
    }

    public void setFromRecommendation(Boolean fromRecommendation) {
        this.fromRecommendation = fromRecommendation;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
