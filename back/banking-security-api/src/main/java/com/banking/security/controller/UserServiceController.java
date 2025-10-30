package com.banking.security.controller;

import com.banking.security.TabUsuarioService.TabUsuarioService;
import com.banking.security.model.TabUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user-service")
public class TabUsuarioController {

    private final TabUsuarioService usuarioService;

    public TabUsuarioController(TabUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /** Crear o actualizar un usuario */
    /**URL> http://localhost:8080/api/v1/user-service/create*/
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TabUsuario> createUsuario(@RequestBody TabUsuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    /** Obtener todos los usuarios */
    /**URL> http://localhost:8080/api/v1/user-service/list*/
    @PostMapping("/list")
    public Flux<TabUsuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Mono<TabUsuario> getUsuarioById(@PathVariable String id) {
        return usuarioService.getUsuarioById(id);
    }

    // Obtener usuario por nombre
    @GetMapping("/by-usuario/{usuario}")
    public Mono<TabUsuario> getUsuarioByUsuario(@PathVariable String usuario) {
        return usuarioService.getUsuarioByUsuario(usuario);
    }

    // Obtener usuarios por correo
    @GetMapping("/by-correo/{correo}")
    public Flux<TabUsuario> getUsuariosByCorreo(@PathVariable String correo) {
        return usuarioService.getUsuariosByCorreo(correo);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUsuario(@PathVariable String id) {
        return usuarioService.deleteUsuario(id);
    }
}
