package com.alfredosalazar.jugos.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfredosalazar.jugos.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
    Usuario findByCorreo(String correo);

    Usuario save(Usuario nuevoUsuario);
}
