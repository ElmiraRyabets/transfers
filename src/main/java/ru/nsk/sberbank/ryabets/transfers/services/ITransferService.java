package ru.nsk.sberbank.ryabets.transfers.services;

import ru.nsk.sberbank.ryabets.transfers.models.Transfer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITransferService {

    List<Transfer> findAll();
    Optional<Transfer> findById(Long id);
    List<Transfer> findBySender(String sender);
    List<Transfer> findByReceiver(String receiver);
    List<Transfer> findBySenderAndReceiver(String sender, String receiver);
    void add(String sender, String receiver, Date createdDate, BigDecimal amount, String comment);
}
