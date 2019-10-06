/**
 * @author Baranov DA
 * @version 1.99
 */
package com.socialdima.Socialdima.resource;

import com.socialdima.Socialdima.model.Message;
import com.socialdima.Socialdima.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for DB-table message
 */
@RestController
@RequestMapping(value = "/message")
public class MessageResource {
    /**
     * Объект для обращения к контроллёру сообщений
     */
    @Autowired
    MessageRepository messageRepository;

    /**
     * if path = "/message"
     * @return all messages
     */
    @GetMapping
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    /**
     * if path = "/message/send"
     * @param message - body with message data in POST-query
     * @return all messages
     */
    @PostMapping("/send")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Message> send(@RequestBody final Message message) {
        messageRepository.save(message);
        return messageRepository.findAll();
    }

    /**
     * if path = "/message/dialogue/{sender_id}_{receiver_id}"
     * @param sender - id user-sender
     * @param receiver - id user-receiver
     * @return messages between sender-user and receiver-user (dialogue)
     */
    @GetMapping("/dialogue/{sender}_{receiver}")
    public List<Message> getDialogue(@PathVariable Integer sender, @PathVariable Integer receiver) {
        return messageRepository.findBySenderAndReceiverOrReceiverAndSenderOrderByTimeAsc(sender, receiver, sender, receiver);
    }
}
