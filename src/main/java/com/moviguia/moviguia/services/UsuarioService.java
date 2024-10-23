package com.moviguia.moviguia.services;

import com.moviguia.moviguia.models.Usuario;
import com.moviguia.moviguia.models.login.UsuarioLogin;
import com.moviguia.moviguia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void novoUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }

    public void deletarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        Usuario usuarioAtual = usuarioRepository.findByEmail(usuario.getEmail());
        var usuarioNovo = new Usuario();
        usuarioNovo.setNome(usuario.getNome());
        usuarioNovo.setEmail(usuario.getEmail());
        return usuarioRepository.save(usuarioNovo);
    }

    public Usuario login(UsuarioLogin data) {
        Usuario usuario = usuarioRepository.findByEmail(data.email());
        if (usuario.getSenha().equals(data.senha())) {
            return usuario;
        }
        return null;
    }
}
