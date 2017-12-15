package pl.connectis.cschool.jcourse.restservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.connectis.cschool.jcourse.restservice.domain.Sender;
import pl.connectis.cschool.jcourse.restservice.repository.SenderRepository;

import java.util.List;

/**
 * Created by Benia on 2017-06-16.
 */
@RestController
@RequestMapping("/senders")
public class SenderController {

    private static final Logger logger = LoggerFactory.getLogger(SenderController.class);

    @Autowired
    SenderRepository senderRepository;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Sender> addSender(@RequestBody Sender sender) {
        Sender savedSender = senderRepository.save(sender);
        return new ResponseEntity<Sender>(savedSender, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchName/{senderName}")
    List<Sender> findSenderBySenderName(@PathVariable String senderName) {
        logger.info("Szukam osoby o imieniu  " + senderName);
        return (List<Sender>) senderRepository.findSenderBySenderName(senderName);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Sender> allSender() {
        return (List<Sender>) senderRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{senderId}")
    ResponseEntity<Sender> deleteNadawca(@PathVariable Long senderId) {
        senderRepository.delete(senderId);
        return new ResponseEntity<Sender>(HttpStatus.OK);
    }


}
