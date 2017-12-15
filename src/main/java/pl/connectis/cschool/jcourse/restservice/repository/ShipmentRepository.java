package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.connectis.cschool.jcourse.restservice.domain.Shipment;
import pl.connectis.cschool.jcourse.restservice.dto.ShipmentDTO;

import java.util.List;


/**
 * Created by Benia on 2017-06-16.
 */
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    List<Shipment> findShipmentByAddressId(Long addressId);
    Shipment findByShipmentNumber(String shipmentNumber);


}


