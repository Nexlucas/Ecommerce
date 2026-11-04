package com.biolab.ecommerce.service;

import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.entities.Usuario;
import com.biolab.ecommerce.entities.enums.Role;
import com.biolab.ecommerce.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public String criar(UsuarioDTO u) {
        Usuario usuario = new Usuario();
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(passwordEncoder.encode(u.getSenha()));
        usuario.setTelefone(u.getTelefone());
        usuario.setRoles(u.getRoles());
        repo.save(usuario);
        return "Usuario criado com sucesso";
    }

    public String deletarUsuario(long id){
        Usuario usuario = repo.findById(id).orElseThrow();
        repo.deleteById(id);
        return "Usuario deletado com sucesso!";
    }

    public List<UsuarioDTO> listaUsuario() {
        List<UsuarioDTO> usuarios = repo.findAll().stream().map(usuario -> new UsuarioDTO(usuario.getId(),usuario.getNome(),usuario.getEmail(),usuario.getTelefone(),usuario.getRoles())).toList();
        return usuarios;
    }
}
