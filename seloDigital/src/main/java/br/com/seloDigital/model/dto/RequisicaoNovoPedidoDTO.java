package br.com.seloDigital.model.dto;

import java.util.Objects;

import br.com.seloDigital.model.Pedido;
import br.com.seloDigital.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RequisicaoNovoPedidoDTO {

	@NotBlank
	@Size(min = 5, max = 20)
	private String nomeProduto;

	@NotBlank
	private String urlProduto;

	@NotBlank
	private String urlImagem;
	private String descricaoProduto;

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

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricaoProduto);
		pedido.setStatusPedido(StatusPedido.AGUARDANDO);
		return pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequisicaoNovoPedidoDTO other = (RequisicaoNovoPedidoDTO) obj;
		return Objects.equals(nomeProduto, other.nomeProduto);
	}

	@Override
	public String toString() {
		return "RequisaoNovoPedido [nomeProduto=" + nomeProduto + "]";
	}

}
