package com.sysfactelect.invoice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.admin.persistence.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commercial")
public class Commercial {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String last_name;
    private String email;
    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, updatable = true)
    @JsonIgnore
    private User user;
}
