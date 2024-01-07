package com.sysfactelect.admin.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.GUIDGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "id_rol", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id_user", referencedColumnName = "id") }
    )
    @JsonIgnore
    private List<User> userList = new ArrayList<>();
}
