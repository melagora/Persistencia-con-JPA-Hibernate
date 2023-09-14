package com.latam.alura.tienda.pruebas;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		EntityManager em = JPAUtils.getEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(celulares);
		
		celulares.setNombre("LIBROS");
		
		//Enviamos los valores a la DB
		em.getTransaction().commit();
		em.close();
		
		celulares.setNombre("SOFTWARE");
	}
}
