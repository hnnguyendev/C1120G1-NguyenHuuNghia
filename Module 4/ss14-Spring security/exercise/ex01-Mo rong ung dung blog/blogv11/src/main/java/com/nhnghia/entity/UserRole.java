package com.nhnghia.entity;

import javax.persistence.*;

@Entity
@Table(name = "userrole", uniqueConstraints = {
        @UniqueConstraint(name = "USERS_UK", columnNames = {"userid", "roleid"})
})
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    private AppUser appUser;

    @ManyToOne(cascade = CascadeType.ALL)
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
