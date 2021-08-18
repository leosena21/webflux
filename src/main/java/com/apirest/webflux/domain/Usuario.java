package com.apirest.webflux.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Usuario {
	
	@Id
	private String id;
	private String nome;
	private String endereco;
}
