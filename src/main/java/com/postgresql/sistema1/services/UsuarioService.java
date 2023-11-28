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

    public List<Object[]> obtenerUsuario(String nombreDeUsuario, String contrasenaUsuario){
        return usuarioRepository.obtenerUsuario(nombreDeUsuario,contrasenaUsuario);
    }

    public List<Object[]> obtenerRolesUsuario(String nombreDeUsuario, String contrasenaUsuario){
        return usuarioRepository.obtenerRolesUsuario(nombreDeUsuario,contrasenaUsuario);
    }

    
}