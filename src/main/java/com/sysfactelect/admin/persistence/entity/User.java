package com.sysfactelect.admin.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    @ManyToOne()
    @JoinColumn(name = "id_company", nullable = false, updatable = true)
    @JsonIgnore
    private Company company;
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "id_user", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id_rol", referencedColumnName = "id") }
    )
    @JsonIgnore
    private List<Role> roles = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Commercial commercial;

    public void addRole(Role role){
        roles.add(role);
        role.getUserList().add(this);
    }

}
