package br.com.dizimo.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection="dizimista")
@JsonIgnoreProperties(value = {"dataCadastro"}, allowGetters = true)
@CompoundIndexes({
    @CompoundIndex(name = "nome_dataNascimento_idx", def = "{'nome' : 1, 'dataNascimento': 1}", unique = true),
    
})
public class Dizimista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull
	@Field(order=1, value="nome")
	private String nome;
	
	@NotNull
	@Size(max = 200)
	@Field(order=2, value="endereco")
	private String endereco;
	
	@DBRef(db="igreja")
	@Field(order=3)
	private Igreja igreja;
	
	@NotNull
	@Field(order=4, value="dataNascimento")
	private Date dataNascimento;
	
	@NotNull
	@Field(order=5, value="telefoneFixo")
	private String telefoneFixo;
	
	@Field(order=6, value="telefoneCelular")
	private String telefoneCelular;
	
	@Field(order=7, value="nsu")
	private BigDecimal nsu;
	
	@Field(order=8, value="ativo")
	private boolean ativo;
	
	@Field(order=9, value="dataCadastro")
	private Date dataCadastro;
	
	public Dizimista(){
	}
	
	@PersistenceConstructor
	public Dizimista(String id, String nome, String endereco, Igreja igreja, Date dataNascimento, String telefoneFixo,
			String telefoneCelular, BigDecimal nsu, boolean ativo, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.igreja = igreja;
		this.dataNascimento = dataNascimento;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.nsu = nsu;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * @return the igreja
	 */
	public Igreja getIgreja() {
		return igreja;
	}

	/**
	 * @param igreja the igreja to set
	 */
	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the telefoneFixo
	 */
	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	/**
	 * @param telefoneFixo the telefoneFixo to set
	 */
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	/**
	 * @return the telefoneCelular
	 */
	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	/**
	 * @param telefoneCelular the telefoneCelular to set
	 */
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	/**
	 * @return the nsu
	 */
	public BigDecimal getNsu() {
		return nsu;
	}

	/**
	 * @param nsu the nsu to set
	 */
	public void setNsu(BigDecimal nsu) {
		this.nsu = nsu;
	}

	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}
	
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Dizimista)) {
			return false;
		}
		Dizimista other = (Dizimista) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
