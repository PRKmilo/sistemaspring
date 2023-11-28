package com.postgresql.sistema1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postgresql.sistema1.repositories.UsuarioRepository;

@Service
public class UsuarioService {
   
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Object[]> obtenerCiudades(String correoUsuario, String contrasenaUsuario){
        return usuarioRepository.obtenerUsuario(correoUsuario,contrasenaUsuario);
    }

    public List<Object[]> obtenerRolesUsuario(String correoUsuario, String contrasenaUsuario){
        return usuarioRepository.obtenerRolesUsuario(correoUsuario,contrasenaUsuario);
    }

    
}