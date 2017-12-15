package pl.connectis.cschool.jcourse.restservice.dto;

import pl.connectis.cschool.jcourse.restservice.domain.Address;
import pl.connectis.cschool.jcourse.restservice.domain.Reciver;
import pl.connectis.cschool.jcourse.restservice.domain.Sender;
import pl.connectis.cschool.jcourse.restservice.utils.PrintStatus;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Benia on 2017-06-17.
 */
public class ShipmentDTO {

    private Long id;
    private String shipmentNumber;
    private Date createDate;
    private Date getDate;
    private Time createTime;
    private String sender;
    private String reciver;
    private String address;
    private String printStatus;
    private Long senderId;
    private Long reciverId;
    private Long addressId;
    private String reciverAddress;


    public ShipmentDTO() {
    }

    public ShipmentDTO(Long id, String shipmentNumber, Date createDate, Date getDate, Time createTime, String sender, String reciver, String address, String printStatus, Long senderId, Long reciverId, Long addressId, String reciverAddress) {
        this.id = id;
        this.shipmentNumber = shipmentNumber;
        this.createDate = createDate;
        this.getDate = getDate;
        this.createTime = createTime;
        this.sender = sender;
        this.reciver = reciver;
        this.address = address;
        this.printStatus = printStatus;
        this.senderId = senderId;
        this.reciverId = reciverId;
        this.addressId = addressId;
        this.reciverAddress = reciverAddress;
    }

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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReciverId() {
        return reciverId;
    }

    public void setReciverId(Long reciverId) {
        this.reciverId = reciverId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getReciverAddress() {
        return reciverAddress;
    }

    public void setReciverAddress(String reciverAddress) {
        this.reciverAddress = reciverAddress;
    }

    @Override
    public String toString() {
        return "ShipmentDTO{" +
                "shipmentNumber='" + shipmentNumber + '\'' +
                ", createDate=" + createDate +
                ", getDate=" + getDate +
                ", reciver='" + reciver + '\'' +
                ", address='" + address + '\'' +
                ", printStatus='" + printStatus + '\'' +
                ", reciverAddress='" + reciverAddress + '\'' +
                '}';
    }
}
