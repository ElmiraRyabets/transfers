package ru.nsk.sberbank.ryabets.transfers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsk.sberbank.ryabets.transfers.models.Transfer;
import ru.nsk.sberbank.ryabets.transfers.services.ITransferService;
import ru.nsk.sberbank.ryabets.transfers.viewmodels.CreateTransferRequest;
import ru.nsk.sberbank.ryabets.transfers.viewmodels.GetTransfersRequest;
import ru.nsk.sberbank.ryabets.transfers.viewmodels.GetTransfersResponse;

import java.util.Date;

@RestController
@RequestMapping(path = "/transfers", produces = MediaType.APPLICATION_XML_VALUE)
public class TransfersController {

    private final ITransferService transferService;

    @Autowired
    public TransfersController(ITransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping(value = "")
    public GetTransfersResponse get() {
        return new GetTransfersResponse(transferService.findAll());
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_XML_VALUE)
    public GetTransfersResponse getFiltered(@RequestBody GetTransfersRequest request) {
        return new GetTransfersResponse(transferService.findBySenderAndReceiver(request.getSender(), request.getReceiver()));
    }

    @GetMapping(value = "/out/{from}")
    public GetTransfersResponse getOutgoing(@PathVariable String from) {
        return new GetTransfersResponse(transferService.findBySender(from));
    }

    @GetMapping(value = "/in/{to}")
    public GetTransfersResponse getIncoming(@PathVariable String to) {
        return new GetTransfersResponse(transferService.findByReceiver(to));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transfer> getById(@PathVariable Long id) {
        return transferService.findById(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateTransferRequest request) {
        transferService.add(request.getSender(), request.getReceiver(), new Date(), request.getAmount(), request.getComment());
    }
}
