package com.apirest.webflux.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.domain.Usuario;
import com.apirest.webflux.service.UsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/usuario")
	public Flux<Usuario> getUsuario(){
		return service.findAll();
	}
	
	@GetMapping(value = "/usuario/{Id}")
	public Mono<Usuario> findById(@PathVariable String Id){
		return service.findById(Id);
	}
	
	@PostMapping(value = "/usuario/insert")
	public Mono<Usuario> insert(@RequestBody Usuario usuario){
		return service.save(usuario);
	}
}
