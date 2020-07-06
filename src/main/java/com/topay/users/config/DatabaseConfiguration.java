package com.topay.users.config;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 02/05/2020
 */

import com.topay.users.domain.company.Company;
import com.topay.users.domain.employee.Employee;
import com.topay.users.domain.employee.EmployeeRepository;
import com.topay.users.domain.employee.Manager;
import com.topay.users.infra.converter.UuidAttributeConverter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.context.annotation.AdviceMode.*;

/**
 * This class is responsible for configuring the database connection and customizing it to optimize this connection
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 01/04/2020
 */
@Configuration
@EnableTransactionManagement(mode = ASPECTJ)
@EntityScan(basePackageClasses = {Employee.class, Manager.class, Company.class, UuidAttributeConverter.class})
@EnableJpaRepositories(basePackageClasses = {EmployeeRepository.class})
public class DatabaseConfiguration extends JpaBaseConfiguration {

    /**
     * Constructor for {@link DatabaseConfiguration}
     *
     * @param dataSource object with connection to database
     * @param properties settings written in application properties
     * @param jtaTransactionManager implementation of {@link AbstractPlatformTransactionManager} to manages transactions with database
     */
    public DatabaseConfiguration(final DataSource dataSource, final JpaProperties properties,
        final ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        final Map<String, Object> vendorProperties = new HashMap<>();
        vendorProperties.put("eclipselink.cache.shared.default", "false");
        vendorProperties.put("eclipselink.cache-usage", "CheckCacheThenDatabase");
        vendorProperties.put("eclipselink.jdbc.cache-statements", "false");
        vendorProperties.put("eclipselink.orm.throw.exceptions", "true");
        vendorProperties.put("eclipselink.weaving", "static");
        vendorProperties.put("eclipselink.query-results-cache", "true");
        vendorProperties.put("eclipselink.persistence-context.close-on-commit", "true");
        vendorProperties.put("eclipselink.persistence-context.flush-mode", "commit");
        vendorProperties.put("eclipselink.persistence-context.persist-on-commit", "false");
        return Collections.unmodifiableMap(vendorProperties);
    }

}

