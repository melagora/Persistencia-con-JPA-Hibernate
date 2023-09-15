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
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNombre("SOFTWARE");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		em.remove(celulares);
		em.flush();
	}
}
