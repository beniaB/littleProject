package pl.connectis.cschool.jcourse.restservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.connectis.cschool.jcourse.restservice.domain.Address;
import pl.connectis.cschool.jcourse.restservice.domain.Reciver;
import pl.connectis.cschool.jcourse.restservice.domain.Sender;
import pl.connectis.cschool.jcourse.restservice.domain.Shipment;
import pl.connectis.cschool.jcourse.restservice.dto.ShipmentDTO;
import pl.connectis.cschool.jcourse.restservice.repository.AddressRepository;
import pl.connectis.cschool.jcourse.restservice.repository.ShipmentRepository;

import pl.connectis.cschool.jcourse.restservice.service.ShipmentService;
import pl.connectis.cschool.jcourse.restservice.utils.PrintStatus;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benia on 2017-06-17.
 */
@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private static final Logger logger = LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ShipmentService shipmentService;

    @RequestMapping(method = RequestMethod.GET)
    List<Shipment> allShipment() {
        return (List<Shipment>) shipmentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{addressId}")
    List<Shipment> findShipmentByAddressId(Long addressId) {
        addressId = addressRepository.findOne(addressId).getId();
        return (List<Shipment>) shipmentRepository.findShipmentByAddressId(addressId);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/number/{shipmentNumber}")
    Shipment findByShipmentNumber(@PathVariable String shipmentNumber) {
        return shipmentRepository.findByShipmentNumber(shipmentNumber);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/numberDTO/{shipmentNumber}")
    ShipmentDTO findShipmentDTOByShipmentNumber(@PathVariable String shipmentNumber) {
        ShipmentDTO shipmentDTO = shipmentService.shipmentDto(shipmentNumber);
        return shipmentDTO;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/DTO/{addressId}")
    List<ShipmentDTO> findShipmentDTOByAddressId(@PathVariable Long addressId) {

        List<ShipmentDTO> shipmentDTOList = new ArrayList<ShipmentDTO>();

        List<Shipment> shipmentList = shipmentRepository.findShipmentByAddressId(addressId);
        for (Shipment shipment : shipmentList) {
            ShipmentDTO shipmentDTO = new ShipmentDTO();
            Address address = shipment.getAddress();
            Sender sender = shipment.getSender();
            Reciver reciver = shipment.getReciver();
            PrintStatus printStatus = shipment.getPrintStatus();
            shipmentDTO.setId(shipment.getId());
            shipmentDTO.setShipmentNumber(shipment.getShipmentNumber());
            shipmentDTO.setCreateDate(shipment.getCreateDate());
            shipmentDTO.setGetDate(shipment.getGetDate());
            shipmentDTO.setCreateTime(shipment.getCreateTime());
            shipmentDTO.setSenderId(sender.getId());
            shipmentDTO.setSender(sender.getSenderName());
            shipmentDTO.setReciverId(reciver.getId());
            shipmentDTO.setReciver(reciver.getReciverName());
            shipmentDTO.setReciverAddress(reciver.getReciverAddress());
            shipmentDTO.setAddressId(address.getId());
            shipmentDTO.setAddress(address.getId() + address.getStreet() + address.getCode() + address.getCity());
            shipmentDTO.setPrintStatus(printStatus.name());

            shipmentDTOList.add(shipmentDTO);
        }

        return shipmentDTOList;
    }
}

