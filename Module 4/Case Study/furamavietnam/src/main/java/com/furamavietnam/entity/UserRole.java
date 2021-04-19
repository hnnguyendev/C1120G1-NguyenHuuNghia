package com.furamavietnam.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(name = "USERS_UK", columnNames = {"username", "roleid"})
})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "roleid", referencedColumnName = "id", nullable = false)
    private AppRole appRole;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
