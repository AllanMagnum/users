package com.topay.users.domain.employee;

import com.topay.users.domain.company.Company;
import lombok.Getter;
import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static com.topay.users.domain.employee.EmployeeType.*;
import static javax.persistence.EnumType.*;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 02/05/2020
 */
@Entity
@Table(name = "EMPLOYEE", schema = "USR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("EMPLOYEE")
@UuidGenerator(name = "uuid-wire-transfer-generator")
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid-wire-transfer-generator")
    @Column(name = "UUID")
    @Getter
    private UUID uuid;

    @NotNull
    @Column(name = "CREATION_DATE")
    @Getter
    private final LocalDateTime creationDate;

    @NotNull
    @Enumerated(STRING)
    @Column(name = "TYPE")
    private final EmployeeType type;

    @NotNull
    @Column(name = "NAME")
    @Getter
    private final String name;

    @NotNull
    @Column(name = "EMAIL")
    @Getter
    private final String email;

    @ManyToOne
    @JoinColumn(name = "UUID_MANAGER")
    private final Manager manager;

    @ManyToOne
    @JoinColumn(name = "ID_COMPANY")
    private final Company company;

    /**
     * @param type
     * @param name
     * @param email
     * @param manager
     * @param company
     */
    protected Employee(final EmployeeType type, final String name, final String email, final Manager manager, final Company company) {
        this.creationDate = LocalDateTime.now(ZoneId.of("UTC"));
        this.type = type;
        this.name = name;
        this.email = email;
        this.manager = manager;
        this.company = company;
    }

    /**
     * @param email
     * @param name
     * @param manager
     * @param company
     */
    public Employee(final String email, final String name, final Manager manager, final Company company) {
        this(EMPLOYEE, email, name, manager, company);
    }

    private Employee() {
        this(null, null, null, null, null);
    }

}
