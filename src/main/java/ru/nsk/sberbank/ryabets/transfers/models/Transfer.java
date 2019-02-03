package ru.nsk.sberbank.ryabets.transfers.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSFERS")
@XmlRootElement(name = "Transfer")
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    private Long id;

    @NotEmpty
    @XmlElement
    private String sender;

    @NotEmpty
    @XmlElement
    private String receiver;

    @NotNull
    @XmlElement
    private Date createdDate;

    @NotNull
    @XmlElement
    private BigDecimal amount;

    @XmlElement
    private String comment;

    public Transfer() {
    }

    public Transfer(@NotEmpty String sender, @NotEmpty String receiver, @NotNull Date createdDate, @NotNull BigDecimal amount, String comment) {
        this.sender = sender;
        this.receiver = receiver;
        this.createdDate = createdDate;
        this.amount = amount;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
