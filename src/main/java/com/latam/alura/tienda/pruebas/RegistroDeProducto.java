package com.latam.alura.tienda.pruebas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.modelo.Producto;

public class RegistroDeProducto {
	public static void main(String[] args) {
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono usado");
		celular.setPrecio(new BigDecimal ("1000"));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda"); 
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		//Enviamos los valores a la DB
		em.getTransaction().commit();
		em.close();
	}
}
