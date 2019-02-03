package ru.nsk.sberbank.ryabets.transfers.viewmodels;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement(name = "Request")
public class CreateTransferRequest {

    @NotEmpty
    @XmlElement
    private String sender;

    @NotEmpty
    @XmlElement
    private String receiver;

    @NotNull
    @XmlElement
    private BigDecimal amount;

    @XmlElement
    private String comment;

    public CreateTransferRequest() {
        amount = BigDecimal.ZERO;
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
