package com.taskmanager.auth_service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_logins")
public class UserLogin {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false)

    private User user;
    @Column(name = "login_timestamp", nullable = false)
    private LocalDateTime loginTimestamp;
    @Column(name = "ip_address")
    private String ipAddress;
    @Column(name = "user_agent")
    private String userAgent;
    @Column(nullable = false)
    private boolean success;
    @Column(name = "failure_reason")
    private String failureReason;
    @Column(nullable = false)
    private String location;

}

// <!-- User logins table -->
// <createTable tableName="user_logins" schemaName="auth">
// <column name="id" type="uuid">
// <constraints primaryKey="true" nullable="false"/>
// </column>
// <column name="user_id" type="uuid">
// <constraints nullable="false" foreignKeyName="fk_login_user" references="auth.users(id)"/>
// </column>
// <column name="login_timestamp" type="timestamp" defaultValueComputed="CURRENT_TIMESTAMP">
// <constraints nullable="false"/>
// </column>
// <column name="ip_address" type="varchar(45)"/>
// <column name="user_agent" type="varchar(255)"/>
// <column name="success" type="boolean" defaultValueBoolean="true">
// <constraints nullable="false"/>
// </column>
// <column name="failure_reason" type="varchar(100)"/>
// <column name="location" type="varchar(100)"/>
// </createTable>
