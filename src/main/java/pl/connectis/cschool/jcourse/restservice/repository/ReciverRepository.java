package pl.connectis.cschool.jcourse.restservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.connectis.cschool.jcourse.restservice.domain.Reciver;

import javax.sound.midi.Receiver;

/**
 * Created by Benia on 2017-06-17.
 */
public interface ReciverRepository extends CrudRepository<Reciver, Long> {

   Reciver findByReciverName(String reciverName);
}
