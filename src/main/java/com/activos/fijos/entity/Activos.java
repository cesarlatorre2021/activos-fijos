package com.activos.fijos.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "activos")
public class Activos {
	
	@Id
	@Column(name = "id_activo")
	private long idActivo;
	
	private String nombre;
	private String descripcion;
	private String tipo;
    private String serial;
    
    @Column(name = "num_inventario")
    private long numeroInventario;
    
    private long peso;
    private long alto;
    private long ancho;
    private long largo;
    
    @Column(name = "valor_compra")
    private long valorCompra;
    
    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;
    
    @ManyToOne
    @JoinColumn(name = "idPersona", insertable = true, updatable = false)
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "idArea", insertable = true, updatable = false)
    private Area area;
	
	public long getIdActivo() {
		return idActivo;
	}

	public void setIdActivo(long idBodega) {
		this.idActivo = idBodega;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public long getNumeroInventario() {
		return numeroInventario;
	}

	public void setNumeroInventario(long numeroInventario) {
		this.numeroInventario = numeroInventario;
	}

	public long getPeso() {
		return peso;
	}

	public void setPeso(long peso) {
		this.peso = peso;
	}

	public long getAlto() {
		return alto;
	}

	public void setAlto(long alto) {
		this.alto = alto;
	}

	public long getAncho() {
		return ancho;
	}

	public void setAncho(long ancho) {
		this.ancho = ancho;
	}

	public long getLargo() {
		return largo;
	}

	public void setLargo(long largo) {
		this.largo = largo;
	}

	public long getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(long valorCompra) {
		this.valorCompra = valorCompra;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
