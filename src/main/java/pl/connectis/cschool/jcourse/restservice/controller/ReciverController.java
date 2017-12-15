package pl.connectis.cschool.jcourse.restservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.connectis.cschool.jcourse.restservice.domain.Reciver;
import pl.connectis.cschool.jcourse.restservice.repository.ReciverRepository;

import java.util.List;

/**
 * Created by Benia on 2017-06-17.
 */

@RestController
@RequestMapping("/recivers")
public class ReciverController {


    private static final Logger logger = LoggerFactory.getLogger(ReciverController.class);

    @Autowired
    ReciverRepository receiverRepository;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Reciver> addReciver(@RequestBody Reciver reciver) {
        Reciver savedReciver = receiverRepository.save(reciver);
        return new ResponseEntity<Reciver>(savedReciver, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{reciverName}")
    Reciver findByReciverName(@PathVariable String reciverName) {
        logger.info("Szukam osoby o imieniu  " + reciverName);
        return receiverRepository.findByReciverName(reciverName);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Reciver> allReciver() {
        return (List<Reciver>) receiverRepository.findAll();
    }
}
