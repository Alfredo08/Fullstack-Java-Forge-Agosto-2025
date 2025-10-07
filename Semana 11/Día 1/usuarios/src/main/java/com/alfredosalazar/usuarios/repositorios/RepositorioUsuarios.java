package com.alfredosalazar.usuarios.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfredosalazar.usuarios.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
    Usuario save(Usuario nuevoUsuario);
    Usuario findByCorreoAndContrasenia(String correo, String contrasenia);
}
