package pl.connectis.cschool.jcourse.restservice.domain;

import javax.persistence.*;

/**
 * Created by Benia on 2017-06-16.
 */
@Entity
public class Address {

    private Long id;
    private String street;
    private String code;
    private String city;


    public Address(Long id, String street, String code, String city) {
        this.id = id;
        this.street = street;
        this.code = code;
        this.city = city;
    }

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
