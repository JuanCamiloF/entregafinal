package com.example.ENTREGA.FINAL.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ENTREGA.FINAL.Repository.UsuarioRepository;
import com.example.ENTREGA.FINAL.modelo.Usuario;


@RestController
@RequestMapping("/api/usuarios")
public class Controlador {

    @Autowired
    private UsuarioRepository usuarioRepository;  // Inyectamos el repositorio de usuarios

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();  // Devuelve todos los usuarios desde la base de datos
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);  // Busca el usuario por ID
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear o actualizar un usuario
    @PostMapping
    public ResponseEntity<Usuario> createOrUpdateUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.save(usuario);  // Guarda o actualiza el usuario
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);  // Retorna el usuario guardado con el status 201
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {  // Verifica si el usuario existe
            usuarioRepository.deleteById(id);  // Elimina el usuario por ID
            return ResponseEntity.noContent().build();  // Responde con un código 204 (sin contenido)
        } else {
            return ResponseEntity.notFound().build();  // Si el usuario no se encuentra, responde con un 404
        }
    }
}
