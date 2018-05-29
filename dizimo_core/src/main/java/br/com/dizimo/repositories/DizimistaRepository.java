package br.com.dizimo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dizimo.entidade.Dizimista;

public interface DizimistaRepository extends MongoRepository<Dizimista, String> {

}
