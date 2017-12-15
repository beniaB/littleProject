package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.connectis.cschool.jcourse.restservice.domain.Sender;

import java.util.List;

/**
 * Created by Benia on 2017-06-16.
 */
public interface SenderRepository extends CrudRepository<Sender, Long> {

    List<Sender> findSenderBySenderName(String senderName);


}
