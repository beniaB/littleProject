package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.connectis.cschool.jcourse.restservice.domain.Address;

import java.util.List;

/**
 * Created by Benia on 2017-06-16.
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByStreetOrCity(String street, String city);

}
