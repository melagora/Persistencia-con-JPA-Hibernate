package com.latam.alura.tienda.pruebas;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.dao.CategoriaDAO;
import com.latam.alura.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.utils.JPAUtils;

public class RegistroDeProducto {
	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorId(1L);
		System.out.println(producto.getNombre());
		
		List<Producto> productos =  productoDAO.consultaPorNombreDeCategoria("CELULARES");
		productos.forEach(prod -> System.out.println(prod.getDescripcion()));
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Producto celular = new Producto("Xiaomi Redmi","Muy bueno",new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
}
