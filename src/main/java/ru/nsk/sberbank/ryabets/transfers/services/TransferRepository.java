package ru.nsk.sberbank.ryabets.transfers.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.nsk.sberbank.ryabets.transfers.models.Transfer;

import java.util.List;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {
    List<Transfer> findBySender(String sender);
    List<Transfer> findByReceiver(String receiver);
    @Query("from Transfer where (:sender is null or SENDER = :sender) and (:receiver is null or RECEIVER = :receiver)")
    List<Transfer> findBySenderAndReceiver(@Param("sender") String sender, @Param("receiver") String receiver);
}
