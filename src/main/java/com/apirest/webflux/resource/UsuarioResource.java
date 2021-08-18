package com.apirest.webflux.resource;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.domain.Usuario;
import com.apirest.webflux.service.UsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

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
	
	@GetMapping(value = "/usuarios/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Usuario>> getUsuarioByEvent(){
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<Usuario> events = service.findAll();
		System.out.println("evento");
		return Flux.zip(interval, events);
	}
}
