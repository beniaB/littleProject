package pl.connectis.cschool.jcourse.restservice.domain;

import pl.connectis.cschool.jcourse.restservice.utils.PrintStatus;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Benia on 2017-06-16.
 */
@Entity
public class Shipment {

    private Long id;
    private String shipmentNumber;
    private Date createDate;
    private Date getDate;
    private Time createTime;
    private Sender sender;
    private Reciver reciver;
    private Address address;
    private PrintStatus printStatus;


    public Shipment(Long id, String shipmentNumber, Date createDate, Date getDate, Time createTime, Sender sender, Reciver reciver, Address address, PrintStatus printStatus) {
        this.id = id;
        this.shipmentNumber = shipmentNumber;
        this.createDate = createDate;
        this.getDate = getDate;
        this.createTime = createTime;
        this.sender = sender;
        this.reciver = reciver;
        this.address = address;
        this.printStatus = printStatus;
    }


    public Shipment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Reciver getReciver() {
        return reciver;
    }

    public void setReciver(Reciver reciver) {
        this.reciver = reciver;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PrintStatus getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(PrintStatus printStatus) {
        this.printStatus = printStatus;
    }
}
