package ru.nsk.sberbank.ryabets.transfers.viewmodels;

import ru.nsk.sberbank.ryabets.transfers.models.Transfer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Response")
public class GetTransfersResponse implements Serializable {

    @XmlElementWrapper(name = "Transfers")
    @XmlElement(name = "Transfer")
    private List<Transfer> items = new ArrayList<>();

    public GetTransfersResponse() {

    }

    public GetTransfersResponse(List<Transfer> items) {
        this.items = items;
    }

    public List<Transfer> getItems() {
        return items;
    }

    public void setItems(List<Transfer> items) {
        this.items = items;
    }
}
