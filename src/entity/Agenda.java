package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idAgenda;
	@Column
	private Double valor;
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	@Temporal(TemporalType.DATE)
	private Date pagamento;
	@Column(length=600)
	private String descricao;
	
	public Agenda() {
		
	}

	public Agenda(Integer idAgenda, Double valor, Date vencimento,
			Date pagamento, String descricao) {
		this.idAgenda = idAgenda;
		this.valor = valor;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Agenda [idAgenda=" + idAgenda + ", valor=" + valor
				+ ", vencimento=" + vencimento + ", pagamento=" + pagamento
				+ ", descricao=" + descricao + "]";
	}

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
