package DAO;

import entities.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class ContatoDAO {
	private static EntityManager em;
	
	public ContatoDAO()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
		 em = emf.createEntityManager();
	}
	
	public List<Contato> getLista()
	{
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Contato c", Contato.class);
		
		List<Contato> contatos = query.getResultList();
		
		
		return contatos;
		
	}
	
	public void CriaContato(Contato contato)
	{
         
		 em.getTransaction().begin();
         em.persist(contato);
         em.getTransaction().commit();
	}
}
