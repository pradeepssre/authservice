package com.taskmanager.auth_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_roles")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}

// <!-- User Roles junction table -->
// <createTable tableName="user_roles" schemaName="auth">
// <column name="user_id" type="uuid">
// <constraints nullable="false" foreignKeyName="fk_user_roles_user" references="auth.users(id)"/>
// </column>
// <column name="role_id" type="uuid">
// <constraints nullable="false" foreignKeyName="fk_user_roles_role" references="auth.roles(id)"/>
// </column>
// </createTable>
// <addPrimaryKey tableName="user_roles" columnNames="user_id, role_id" schemaName="auth"/>
