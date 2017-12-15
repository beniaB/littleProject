package pl.connectis.cschool.jcourse.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.connectis.cschool.jcourse.restservice.domain.Address;
import pl.connectis.cschool.jcourse.restservice.domain.Reciver;
import pl.connectis.cschool.jcourse.restservice.domain.Shipment;
import pl.connectis.cschool.jcourse.restservice.dto.ShipmentDTO;
import pl.connectis.cschool.jcourse.restservice.repository.AddressRepository;
import pl.connectis.cschool.jcourse.restservice.repository.ShipmentRepository;
import pl.connectis.cschool.jcourse.restservice.utils.PrintStatus;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benia on 2017-06-17.
 */
@Service
@Transactional
public class ShipmentService {


    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    public List<Long> shipment(String street, String city) {

        List<Address> addresses = addressRepository.findByStreetOrCity(street, city);
        List<Long> addressIds = new ArrayList<Long>();

        for (Address a : addresses) {
            addressIds.add(a.getId());
        }
        return addressIds;
    }

    public ShipmentDTO shipmentDto(String shipmentNumber) {

        Shipment shipment = shipmentRepository.findByShipmentNumber(shipmentNumber);

        ShipmentDTO shipmentDTO = new ShipmentDTO();
        Address address = shipment.getAddress();
        Reciver reciver = shipment.getReciver();
        PrintStatus printStatus = shipment.getPrintStatus();
        shipmentDTO.setShipmentNumber(shipment.getShipmentNumber());
        shipmentDTO.setCreateDate(shipment.getCreateDate());
        shipmentDTO.setGetDate(shipment.getGetDate());
        shipmentDTO.setAddress(address.getId() + address.getStreet() + address.getCode() + address.getCity());
        shipmentDTO.setReciver(reciver.getReciverName());
        shipmentDTO.setReciverAddress(reciver.getReciverAddress());
        shipmentDTO.setPrintStatus(printStatus.name());

        return shipmentDTO;
    }

}
