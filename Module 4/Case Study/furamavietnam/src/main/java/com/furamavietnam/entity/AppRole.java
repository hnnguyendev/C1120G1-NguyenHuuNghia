package com.furamavietnam.entity;

import javax.persistence.*;

@Entity
@Table(name = "app_roles", uniqueConstraints = {
        @UniqueConstraint(name = "ROLES_UK", columnNames = "rolename")
        })
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rolename", nullable = false)
    private String roleName;

    public AppRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
