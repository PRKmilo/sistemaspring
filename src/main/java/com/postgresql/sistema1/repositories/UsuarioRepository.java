package com.postgresql.sistema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.postgresql.sistema1.model.Usuario;

import java.util.List;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u.USERNAME_USUARIO, r.ID_ROL, r.NOM_ROL from Usuario u,Usuario_rol ur, Rol r where u.USERNAME_USUARIO= :nombreDeUsuario and u.PASSWORD_USUARIO= :contrasenaUsuario and u.ID_USUARIO=ur.ID_USUARIO  and ur.ID_ROL=r.ID_ROL")
    List<Object[]> findFirstByObtenerUsuario(@Param("nombreDeUsuario") String nombreDeUsuario,@Param("contrasenaUsuario") String contrasenaUsuario);

}
