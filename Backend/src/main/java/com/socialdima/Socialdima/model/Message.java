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
 *  This class represents DB-table message
 */
@Entity
public class Message {
    /**
     * @attribute id - identifying attribute / auto_increment
     * This columns for table images
     */
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Integer id;

    /**
     * @attribute sender - id sender-user
     */
    @Column(name = "sender")
    private Integer sender;

    /**
     * @attribute receiver - id receiver-user
     */
    @Column(name = "receiver")
    private Integer receiver;

    /**
     * @attribute time - date and time when message sent
     */
    @Column(name = "time")
    private Calendar time;

    /**
     * @attribute text - text in message
     */
    @Column(name = "text")
    private String text;

    public Message() {
    }

    /**
     * Getter for id message
     * @return id of the message
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for id message
     * @param id of the message
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for sender
     * @return id of user-sender
     */
    public Integer getSender() {
        return sender;
    }

    /**
     * Setter for sender
     * @param sender - id of user-sender
     */
    public void setSender(Integer sender) {
        this.sender = sender;
    }

    /**
     * Getter for receiver
     * @return id of user-receiver
     */
    public Integer getReceiver() {
        return receiver;
    }

    /**
     * Setter for receiver
     * @param receiver - id of user-receiver
     */
    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    /**
     * Getter for time
     * @return date and time, when message sent
     */
    public Calendar getTime() {
        return time;
    }

    /**
     * Setter of time
     * @param time - date and time, when message sent
     */
    public void setTime(Calendar time) {
        this.time = time;
    }

    /**
     * Getter for text
     * @return text in message
     */
    public String getText() {
        return text;
    }

    /**
     * Setter for text
     * @param text - text in message
     */
    public void setText(String text) {
        this.text = text;
    }
}
