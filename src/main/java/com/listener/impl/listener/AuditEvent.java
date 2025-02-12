package com.listener.impl.listener;

import java.util.UUID;

public class AuditEvent {
    private final String operation;
    private final String entityName;
    private final UUID entityId;

    public AuditEvent(String operation, String entityName, UUID entityId) {
        this.operation = operation;
        this.entityName = entityName;
        this.entityId = entityId;
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
}

