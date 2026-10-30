package com.biolab.ecommerce.entities;

import com.biolab.ecommerce.entities.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @Column(length = 150)
    private String email;
    @Column(length = 20)
    private String telefone;
    @NotBlank @Size(min = 6, max = 20)
    private String senha;
    @Enumerated(EnumType.STRING)
    private Role roles;
}
