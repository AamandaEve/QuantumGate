package com.listener.impl.listener;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String operation; // INSERT, UPDATE, DELETE
    private LocalDateTime date;
    private String name; // Produto, Item, Compra, etc.
    private UUID entityId; // ID do item afetado


    public History(String operation, UUID entityId, String name, LocalDateTime date){
        this.name = name;
        this.entityId = entityId;
        this.operation = operation;
        this.date = LocalDateTime.now();
    }
}
