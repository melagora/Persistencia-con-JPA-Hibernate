package com.latam.alura.tienda.pruebas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.latam.alura.dao.CategoriaDAO;
import com.latam.alura.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung","Telefono usado", new BigDecimal("1000"), celulares);
		
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		//Enviamos los valores a la DB
		em.getTransaction().commit();
		em.close();
	}
}
