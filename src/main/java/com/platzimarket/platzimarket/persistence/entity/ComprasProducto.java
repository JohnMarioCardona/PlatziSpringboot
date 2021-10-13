package com.platzimarket.platzimarket.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPRAS_PRODUCTO")
public class ComprasProducto {
	//private Integer idCompra;
	//private Integer idProducto;
	@EmbeddedId
	private ComprasProductoPK id;
	private Integer cantidad;
	private Integer total;
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_producto",insertable=false,updatable=false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="id_compra",insertable=false,updatable=false)
	private Compra compra;
	
	
	public ComprasProductoPK getId() {
		return id;
	}
	public void setId(ComprasProductoPK id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
