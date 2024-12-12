package com.example.ENTREGA.FINAL.mapper;
import java.util.List;

import com.example.ENTREGA.FINAL.dto.UsuarioDto;
import com.example.ENTREGA.FINAL.modelo.Usuario;

public interface UsuarioMapper {
    Usuario toUsuario(UsuarioDto usuarioDto);
    Usuario toUsuarioDto(Usuario usuario);
    List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios);
    void updateUsuario(Usuario usuario, UsuarioDto usuarioDto);
}
