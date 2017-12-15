package pl.connectis.cschool.jcourse.restservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.connectis.cschool.jcourse.restservice.domain.Address;
import pl.connectis.cschool.jcourse.restservice.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benia on 2017-06-16.
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address savedAddress = addressRepository.save(address);
        return new ResponseEntity<Address>(savedAddress, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{streetOrCity}")
    List<Address> findByStreetOrCity(@PathVariable String streetOrCity) {
        logger.info("Szukam adresu : " + streetOrCity);
        return (List<Address>) addressRepository.findByStreetOrCity(streetOrCity, streetOrCity);
    }

}
