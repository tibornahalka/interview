package com.interview.persistence.entity;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class EntityBase {

    @Id
    private String id;

    @NotNull
    private Instant createdAt;

    @PrePersist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
            createdAt = Instant.now();
        }
    }

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityBase that = (EntityBase) o;
        return id.equals(that.id) && createdAt.equals(that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt);
    }

    @Override
    public String toString() {
        return "EntityBase{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
