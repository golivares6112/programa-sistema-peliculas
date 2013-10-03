package cl.blockbuster.database;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cl.blockbuster.model.Vendedor;

public class JPAFactoryConnection {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void createFactoryConnection()
	{
		try{
			emf = Persistence.createEntityManagerFactory("BlockBuster");
			em = emf.createEntityManager();
		}catch(Exception e){
			System.out.println("ERROR : " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static boolean validarEntrada(int idvendedor, String nombre)
	{
		boolean acceso = false;
		Query verificaVendedor = em.createNamedQuery("Vendedor.findAll");
		List<Vendedor> vendedorAuth = verificaVendedor.getResultList();
		Iterator<Vendedor> listaVendedores = vendedorAuth.iterator();
		while(listaVendedores.hasNext())
		{
			Vendedor v = listaVendedores.next();
			if((idvendedor == v.getIdVendedor()) && (nombre.equalsIgnoreCase(v.getNombre()))){
				acceso = true;
			}else{
				acceso = false;
			}
		}
		return acceso;
	}
	
	public static void chequearBD()
	{
		@SuppressWarnings("unused")
		Query verificaVendedor = em.createNamedQuery("Vendedor.findAll");
	}
}
