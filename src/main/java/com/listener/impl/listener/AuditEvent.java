package com.listener.impl.listener;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditEvent {
    private final String operation;
    private final String entityName;
    private final UUID entityId;
    private final LocalDateTime date;
    private final String keywords;

    public AuditEvent(String operation, String entityName, UUID entityId, LocalDateTime date, String keywords) {
        this.operation = operation;
        this.entityName = entityName;
        this.entityId = entityId;
        this.date = date;
        this.keywords = keywords;
    }

    public String getOperation() {
        return operation;
    }

    public String getEntityName() {
        return entityName;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public LocalDateTime getDate(){return date;}

    public String getKeywords(){return keywords;}
}

