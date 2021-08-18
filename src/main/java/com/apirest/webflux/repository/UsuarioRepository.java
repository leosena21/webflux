package com.apirest.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.webflux.domain.Usuario;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String>{

}
