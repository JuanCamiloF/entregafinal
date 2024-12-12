package com.example.ENTREGA.FINAL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {
    
    private Long id;
    private String nombre;
    private String correo;
}
