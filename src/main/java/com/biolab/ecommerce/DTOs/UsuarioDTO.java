package com.biolab.ecommerce.DTOs;

import com.biolab.ecommerce.entities.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Size(max = 150)
    private String email;
    @Size(max = 20, message = "O maximo são 20 caracteres")
    private String telefone;
    @NotBlank @Size(min = 6, max = 20)
    private String senha;
    private Role roles;

    public UsuarioDTO(String nome, String email, String telefone, String senha, Role roles) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.roles = roles;
    }

    public UsuarioDTO(long id, String nome, String email, String telefone, Role roles) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.roles = roles;
    }
}
