package br.com.pereira.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private BigDecimal valorNegociado;	
	private LocalDate dataDaEntrega;
	private String comentario;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	public String getComentario() {
		return comentario;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getvalorNegociado() {
		return valorNegociado;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setvalorNegociado(BigDecimal valor) {
		this.valorNegociado = valor;
	}

}
