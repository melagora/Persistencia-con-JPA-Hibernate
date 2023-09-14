package com.latam.alura.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

public class ProductoDAO {
	private EntityManager em;

	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar (Producto producto) {
		this.em.persist(producto);
	}
}
