package com.listener.impl.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
class AuditEventListener {

    private final HistoryRepository historyRepository;

    @Autowired
    public AuditEventListener(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @TransactionalEventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW) // Garante que será salvo em uma nova transação
    public void handleAuditEvent(AuditEvent event) {
        History history = new History(event.getOperation(), event.getEntityId(), event.getEntityName(), event.getDate(), event.getKeywords());
        historyRepository.save(history);
    }
}

