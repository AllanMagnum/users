package com.topay.users.domain.event;

import lombok.Getter;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 05/07/2020
 */
@Entity
@Table(name = "DOMAIN_EVENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@UuidGenerator(name = "uuid-domain-event-generator")
public abstract class DomainEvent<T> {
    @Id
    @GeneratedValue(generator = "uuid-domain-event-generator")
    @Column(name = "UUID")
    @Getter
    private UUID uuid;

    @NotNull
    @Column(name = "CREATION_DATE")
    private final LocalDateTime creationDate;

    @Getter
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private final DomainEventType type;

    @Getter
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    /**
     * Constructs a prototypical Event.
     *
     * @param type
     * @throws IllegalArgumentException if source is null
     */
    protected DomainEvent(final DomainEventType type) {
        this.creationDate = LocalDateTime.now();
        this.type = type;
        this.status = Status.CREATED;
    }

    /**
     * The concrete method will be able to return a source of a concrete DomainEvent
     * @return an instance of a concrete {@link DomainEvent} source's
     */
    public abstract T getSource();

    protected void processing() {
        this.status = Status.PROCESSING;
    }
}
