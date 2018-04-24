package br.com.dizimo.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

//@Entity
//@Table(name="CONTRIBUICAODIZIMO")
public class ContribuicaoDizimo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
// 	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="IDCONTRIBUICAO")
	private Long id;
	
//	@ManyToOne(targetEntity= Dizimista.class, optional = false)
//	@JoinColumn(name="IDDIZIMISTA")
	private Dizimista dizimista;
	
//	@NotNull
//	@Column(name="DATAPAGAMENTO")
	private Date dataPagamento;
	
	@NotNull
//	@Column(name="DATACONTRIBUICAO")
	private Date dataContribuicao;
	
	@NotNull
//	@Column(name="VALOR")
	private BigDecimal valor;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dizimista
	 */
	public Dizimista getDizimista() {
		return dizimista;
	}

	/**
	 * @param dizimista the dizimista to set
	 */
	public void setDizimista(Dizimista dizimista) {
		this.dizimista = dizimista;
	}

	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return the dataContribuicao
	 */
	public Date getDataContribuicao() {
		return dataContribuicao;
	}

	/**
	 * @param dataContribuicao the dataContribuicao to set
	 */
	public void setDataContribuicao(Date dataContribuicao) {
		this.dataContribuicao = dataContribuicao;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		if (!(obj instanceof ContribuicaoDizimo)) {
			return false;
		}
		ContribuicaoDizimo other = (ContribuicaoDizimo) obj;
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
