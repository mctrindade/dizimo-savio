package br.com.dizimo.bean;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dizimo.entidade.Dizimista;
import br.com.dizimo.repositories.DizimistaRepository;


@RestController
@RequestMapping("/dizimo")
@CrossOrigin("*")
public class DizimistaBean {
	
	@Autowired
	private DizimistaRepository dizimistaRepository;
	
	@Autowired 
	private MongoOperations mongoOps;
	
	public String iniciarCadastro() {
		return "";
	}
	
	@GetMapping("/dizimista")
	public List<Dizimista> iniciarPesquisa() {
		Sort sortByNomeDesc = new Sort(Sort.Direction.DESC, "nome");
		return dizimistaRepository.findAll(sortByNomeDesc);
	}
	
	@GetMapping("/dizimistas")
	public List<Dizimista> pesquisar(@RequestBody Dizimista dizimista) {
		Query query = new Query();
		if(dizimista != null) {
			if(StringUtils.isNotBlank(dizimista.getNome())){
				query.addCriteria(new Criteria().orOperator(Criteria.where("nome").regex(dizimista.getNome())));
			}
			if(dizimista.getIgreja() != null) {
				query.addCriteria(new Criteria().orOperator(Criteria.where("igreja.id").is(dizimista.getIgreja())));
			}
			if(dizimista.getDataNascimento() != null) {
				query.addCriteria(new Criteria().orOperator(Criteria.where("dataNascimento").is(dizimista.getDataNascimento())));
			}
			if(dizimista.getNsu() != null) {
				query.addCriteria(new Criteria().orOperator(Criteria.where("nsu").is(dizimista.getNsu())));
			}
			query.with(new Sort(Sort.Direction.DESC, "nome"));
		}
		return mongoOps.find(query, Dizimista.class);
	}
	
	public String editar() {
		return "";
	}
	
	@PostMapping("/dizimista")
	public Dizimista salvar(@Valid @RequestBody Dizimista dizimista) {
		dizimista.setDataCadastro(new Date());
		return dizimistaRepository.save(dizimista);
	}
	
	
	@PutMapping(value="/dizimista/{id}")
	public ResponseEntity<Dizimista> alterar(@PathVariable("id") Long id,
            @Valid @RequestBody Dizimista dizimista) {
		return dizimistaRepository.findById(id)
                .map(dizimistaData -> {
                	/*dizimistaData.setTitle(dizimista.getTitle());
                	dizimistaData.setCompleted(dizimista.getCompleted());*/
                	Dizimista updatedTodo = dizimistaRepository.save(dizimistaData);
                    return ResponseEntity.ok().body(updatedTodo);
                }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(value="/dizimista/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		 return dizimistaRepository.findById(id)
	                .map(dizimista -> {
	                	dizimistaRepository.deleteById(id);
	                    return ResponseEntity.ok().build();
	                }).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value="/dizimista/{id}")
	public ResponseEntity<Dizimista> visualizarCarteirinha(@PathVariable("id") Long id) {
		return dizimistaRepository.findById(id)
                .map(dizimista -> ResponseEntity.ok().body(dizimista))
                .orElse(ResponseEntity.notFound().build());
	}	
}
