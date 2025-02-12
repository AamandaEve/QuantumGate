package com.listener.impl.listener;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class HistoryListener {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public HistoryListener(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostPersist
    public void afterInsert(Object entity) {
        publishEvent("INSERT", entity);
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        publishEvent("UPDATE", entity);
    }

    @PostRemove
    public void afterDelete(Object entity) {
        publishEvent("DELETE", entity);
    }

    private void publishEvent(String operation, Object entity) {
        String entityName = entity.getClass().getSimpleName();
        UUID entityId = getEntityId(entity);
        LocalDateTime date = getLocalDateTime(entity);
        eventPublisher.publishEvent(new AuditEvent(operation, entityName, entityId, date));
    }

    private UUID getEntityId(Object entity) {
        try {
            Field field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            return (UUID) field.get(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter o ID da entidade", e);
        }
    }

    private LocalDateTime getLocalDateTime(Object entity){
        try {
            Field field = entity.getClass().getDeclaredField("createdDate");
            field.setAccessible(true);
            return (LocalDateTime) field.get(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter a data da entidade", e);
        }
    }
}

