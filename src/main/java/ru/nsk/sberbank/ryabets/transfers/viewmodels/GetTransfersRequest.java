package ru.nsk.sberbank.ryabets.transfers.viewmodels;

import org.springframework.lang.Nullable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class GetTransfersRequest {

    @XmlElement
    @Nullable
    private String sender;

    @XmlElement
    @Nullable
    private String receiver;

    public GetTransfersRequest() {
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
}
