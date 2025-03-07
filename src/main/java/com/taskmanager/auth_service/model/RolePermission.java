package com.taskmanager.auth_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_permissions")

public class RolePermission {

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

}

// <!-- Role Permissions junction table -->
// <createTable tableName="role_permissions" schemaName="auth">
// <column name="role_id" type="uuid">
// <constraints nullable="false" foreignKeyName="fk_role_permissions_role" references="auth.roles(id)"/>
// </column>
// <column name="permission_id" type="uuid">
// <constraints nullable="false" foreignKeyName="fk_role_permissions_permission" references="auth.permissions(id)"/>
// </column>
// </createTable>
// <addPrimaryKey tableName="role_permissions" columnNames="role_id, permission_id" schemaName="auth"/>
