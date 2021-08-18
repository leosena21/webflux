package com.apirest.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.webflux.domain.Usuario;
import com.apirest.webflux.repository.UsuarioRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Flux<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Mono<Usuario> findById(String Id){
		return usuarioRepository.findById(Id);
	}
	
	public Mono<Usuario> save(Usuario usuario){
		return usuarioRepository.save(usuario);
	}

}
