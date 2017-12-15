package pl.connectis.cschool.jcourse.restservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Benia on 2017-06-16.
 */
@Entity
public class Reciver {

    private Long id;
    private String reciverName;
    private String reciverAddress;


    public Reciver(Long id, String reciverName, String reciverAddress) {
        this.id = id;
        this.reciverName = reciverName;
        this.reciverAddress = reciverAddress;
    }

    public Reciver() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName;
    }

    public String getReciverAddress() {
        return reciverAddress;
    }

    public void setReciverAddress(String reciverAddress) {
        this.reciverAddress = reciverAddress;
    }
}
