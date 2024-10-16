package com.moviguia.moviguia.controllers;

import com.moviguia.moviguia.models.Usuario;
import com.moviguia.moviguia.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {}

    @PostMapping
    public ResponseEntity novoUsuario(@RequestBody @Valid Usuario usuario) {
        usuarioService.novoUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizarUsuario(@RequestBody @Valid Usuario usuario) {
        var usuarioNovo = usuarioService.atualizarUsuario(usuario);
        return ResponseEntity.ok().body(usuarioNovo);
    }

    @GetMapping
    public ResponseEntity buscarUsuarios(@RequestBody String email) {
        var usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping
    public ResponseEntity<Void> removerUsuario(@RequestBody @Valid Usuario usuario) {
        usuarioService.deletarUsuario(usuario);
        return ResponseEntity.noContent().build();
    }
}
