package com.example.ENTREGA.FINAL.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ENTREGA.FINAL.dto.UsuarioDto;
import com.example.ENTREGA.FINAL.modelo.Usuario;


@Component
public class Usuariomapper1 implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null){
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setCorreo(usuarioDto.getCorreo());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setId(usuarioDto.getId());
        
      return usuario;
    }


    @Override
    public Usuario toUsuarioDto(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateUsuario(Usuario usuario, UsuarioDto usuarioDto) {
        // TODO Auto-generated method stub
        
    }

}
