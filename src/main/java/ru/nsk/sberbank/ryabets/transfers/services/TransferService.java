package ru.nsk.sberbank.ryabets.transfers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsk.sberbank.ryabets.transfers.models.Transfer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferService implements ITransferService {

    private final TransferRepository repository;

    @Autowired
    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Transfer> findAll() {
        return (List<Transfer>) repository.findAll();
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Transfer> findBySender(String sender) {
        return repository.findBySender(sender);
    }

    @Override
    public List<Transfer> findByReceiver(String receiver) {
        return repository.findByReceiver(receiver);
    }

    @Override
    public List<Transfer> findBySenderAndReceiver(String sender, String receiver) {
        return repository.findBySenderAndReceiver(sender, receiver);
    }

    @Override
    public void add(String sender, String receiver, Date createdDate, BigDecimal amount, String comment) {
        Transfer transfer = new Transfer(sender, receiver, createdDate, amount, comment);
        repository.save(transfer);
    }
}
