package com.latam.alura.tienda.pruebas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		Producto celular = new Producto("Samsung","Telefono usado", new BigDecimal("1000"), Categoria.CELULARES);
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDAO productoDAO = new ProductoDAO(em);
		
		em.getTransaction().begin();
		
		productoDAO.guardar(celular);
		
		//Enviamos los valores a la DB
		em.getTransaction().commit();
		em.close();
	}
}
