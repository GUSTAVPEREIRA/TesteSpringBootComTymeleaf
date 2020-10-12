package br.com.pereira.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.pereira.mvc.mudi.enums.StatusPedido;
import br.com.pereira.mvc.mudi.model.Pedido;

public class RequisicaoNovoPedido {

	@NotBlank(message = "O nome do produto não pode estar em branco!")
	private String nomeProduto;
	
	@NotBlank(message = "A URL do produto não pode estar em branco!")
	private String urlProduto;
	
	@NotBlank(message = "A URL da imagem não pode estar em branco!")
	private String urlImagem;
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	} 

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setDescricao(descricao);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setStatusPedido(StatusPedido.AGUARDANDO);

		return pedido;
	}
}