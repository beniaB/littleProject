package pl.connectis.cschool.jcourse.restservice;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.connectis.cschool.jcourse.restservice.domain.*;
import pl.connectis.cschool.jcourse.restservice.repository.AddressRepository;
import pl.connectis.cschool.jcourse.restservice.repository.ReciverRepository;
import pl.connectis.cschool.jcourse.restservice.repository.SenderRepository;
import pl.connectis.cschool.jcourse.restservice.repository.ShipmentRepository;
import pl.connectis.cschool.jcourse.restservice.utils.PrintStatus;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(final ShipmentRepository sr, final SenderRepository sendR, final AddressRepository ar, final ReciverRepository rr) {
        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {


                Sender sender = new Sender(1l, "Henio");
                Reciver r = new Reciver(1l, "Franio", "Gdynia");
                Address a = new Address(1l, "dluga", "80-831", "Gdansk");
                Address a2 = new Address(4l, "makowa", "90-901", "oslo");
                Address a3 = new Address(4l, "dluga", "90-901", "oslo");
                Address a4 = new Address(4l, "szeroka", "90-901", "miastko");
                Date d1 = new Date(1234567);
                Date d2 = new Date(8765432);
                Time t = new Time(123);

                Shipment s = new Shipment(1l, "111", d1, d2, t, sender, r, a, PrintStatus.NotYet);
                Shipment s1 = new Shipment(2l, "222", d1, d2, t, sender, r, a2, PrintStatus.NotYet);
                Shipment s2 = new Shipment(3l, "9000", d1, d2, t, sender, r, a3, PrintStatus.NotYet);
                Shipment s3 = new Shipment(4l, "1234", d1, d2, t, sender, r, a4, PrintStatus.NotYet);
                Shipment s4 = new Shipment(4l, "4321", d1, d2, t, sender, r, a, PrintStatus.NotYet);

                sendR.save(sender);

                rr.save(r);

                ar.save(a);
                ar.save(a2);

                sr.save(s);
                sr.save(s1);
                sr.save(s2);
                sr.save(s3);
                sr.save(s4);


            }
        };
    }

}
