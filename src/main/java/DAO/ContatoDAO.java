package DAO;

import entities.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ContatoDAO {
	private static EntityManager em;
	
	public ContatoDAO()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
		 em = emf.createEntityManager();
	}
	
	
	public void CriaContato(Contato contato)
	{
         
		 em.getTransaction().begin();
         em.persist(contato);
         em.getTransaction().commit();
	}
}
