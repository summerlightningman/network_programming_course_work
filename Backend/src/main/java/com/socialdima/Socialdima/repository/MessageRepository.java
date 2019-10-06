package com.socialdima.Socialdima.repository;

import com.socialdima.Socialdima.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * interface for message
 * generates automatically
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
    /**
     * Open dialogue
     * @param sender - id sender (who is opened the dialogue)
     * @param receiver - id receiver
     * @param sender2 - id sender (who is opened the dialogue) = sender
     * @param receiver2 - id receiver = receiver
     * @return  message of sender and receiver (dialogue)
     */
    List<Message> findBySenderAndReceiverOrReceiverAndSenderOrderByTimeAsc(Integer sender, Integer receiver, Integer sender2, Integer receiver2);
}
