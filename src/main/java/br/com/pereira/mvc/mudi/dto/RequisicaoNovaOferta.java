package br.com.pereira.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.pereira.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long pedidoId;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Data está com formado inválido. Formato correto Dia/Mes/Ano")
	@NotNull(message = "O campo data da entrega não pode ser vazio!")
	private String dataDaEntrega;

	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$", message = "Valor está com o formato inválido!")
	@NotNull(message = "O campo valor não pode ser vazio!")
	private String valorNegociado;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getdataDaEntrega() {
		return dataDaEntrega;
	}

	public void setdataDaEntrega(String dataDaEntraga) {
		this.dataDaEntrega = dataDaEntraga;
	}

	public String getvalorNegociado() {
		return valorNegociado;
	}

	public void setvalorNegociado(String valor) {
		valorNegociado = valor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();

		oferta.setComentario(this.comentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, formatter));
		oferta.setvalorNegociado(new BigDecimal(this.valorNegociado));

		return oferta;
	}
}
