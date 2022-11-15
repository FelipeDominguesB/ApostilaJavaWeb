package ifsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContatoMap {

	public static Map<Integer, Contato> contatos = new HashMap<>();
	public static List<Contato> pessoas = new ArrayList<Contato>();
	
	private static int contador = 0;
	public ContatoMap()
	{	
		
		if(contatos.size() == 0)
		{
			Contato contato = new Contato();
	        contato.setNome("Felipe");
	        contato.setEndereco("Teste");
	        contato.setEmail("Felipe Domingues");
	        
	        Calendar dataNascimento = null;


	        Date date;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse("23/06/2001");
				 dataNascimento = Calendar.getInstance();
		        dataNascimento.setTime(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        contato.setDataNascimento(dataNascimento);
	        
	        adicionarContato(contato);
		}
		
        
	}
	
	public void adicionarContato(Contato contato)
	{
		contatos.put(contador, contato);
		contador++;
		pessoas = new ArrayList<Contato>(contatos.values());
	}
	
	public Contato getContato(int chave)
	{
		return contatos.get(chave);
	}
	
	public List<Contato> getPessoas()
	{
		return pessoas;
	}
	public  Collection<Contato> getAllContatos()
	{
		return contatos.values();
	}
}
