package com.latam.alura.tienda.pruebas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Producto;

public class RegistroDeProducto {
	public static void main(String[] args) {
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono usado");
		celular.setPrecio(new BigDecimal ("1000"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda"); 
		EntityManager em = factory.createEntityManager();
		
		ProductoDAO productoDAO = new ProductoDAO(em);
		
		em.getTransaction().begin();
		
		productoDAO.guardar(celular);
		
		//Enviamos los valores a la DB
		em.getTransaction().commit();
		em.close();
	}
}
