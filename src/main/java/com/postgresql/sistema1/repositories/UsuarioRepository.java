package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.postgresql.sistema1.model.Usuario;

import java.util.List;

@RepositoryRestResource
public interface  UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query("SELECT u.ID_USUARIO,u.USERNAME_USUARIO  FROM Usuario u WHERE u.USERNAME_USUARIO = :nombreDeUsuario AND u.PASSWORD_USUARIO = :contrasenaUsuario") 
    List<Object[]> obtenerUsuario(@Param("nombreDeUsuario") String nombreDeUsuario, @Param("contrasenaUsuario") String contrasenaUsuario);

    @Query("SELECT r.ID_ROL FROM Usuario u, Usuario_rol ru, Rol r  WHERE u.USERNAME_USUARIO = :nombreDeUsuario and u.PASSWORD_USUARIO= :contrasenaUsuario and ru.ID_USUARIO=u.ID_USUARIO and ru.ID_ROL=r.ID_ROL") 
    List<Object[]> obtenerRolesUsuario(@Param("nombreDeUsuario") String nombreDeUsuario, @Param("contrasenaUsuario") String contrasenaUsuario);

}
