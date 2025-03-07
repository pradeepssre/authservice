package com.taskmanager.auth_service.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles") // <1>
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "role") // <1>
    private List<Permission> permissions; // <1>

    @Column(nullable = true, unique = true) // <2>
    private String name; // <2>

    @Column(nullable = true) // <3>
    private String description; // <3>

    @Column(nullable = true) // <4>
    private LocalDateTime createdAt; // <4>

    @Column(nullable = true) // <5>
    private LocalDateTime updatedAt; // <5>

}

// <createTable tableName="roles" schemaName="auth">
// <column name="id" type="uuid">
// <constraints primaryKey="true" nullable="false"/>
// </column>
// <column name="name" type="varchar(50)">
// <constraints unique="true" nullable="false"/>
// </column>
// <column name="description" type="varchar(255)"/>
// <column name="created_at" type="timestamp" defaultValueComputed="CURRENT_TIMESTAMP">
// <constraints nullable="false"/>
// </column>
// <column name="updated_at" type="timestamp" defaultValueComputed="CURRENT_TIMESTAMP">
// <constraints nullable="false"/>
// </column>
// </createTable>
