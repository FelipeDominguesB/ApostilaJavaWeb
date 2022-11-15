package ifsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;

import entities.*;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	 private static final long serialVersionUID = 1L;	
	 
	 protected void service(HttpServletRequest request,
             HttpServletResponse response)
             throws IOException, ServletException {

         PrintWriter out = response.getWriter();

         String nome = request.getParameter("nome");
         String endereco = request.getParameter("endereco");
         String email = request.getParameter("email");
         String dataEmTexto = request.getParameter("dataNascimento");
         Calendar dataNascimento = null;

         try {
             Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
             dataNascimento = Calendar.getInstance();
             dataNascimento.setTime(date);
         } catch (ParseException e) {
             out.println("Erro de conversão da data");
             return;
         }

         entities.Contato contato = new entities.Contato();
         contato.setNome(nome);
         contato.setEndereco(endereco);
         contato.setEmail(email);
         contato.setDataNascimento(dataNascimento);
         
         DAO.ContatoDAO contatoDB = new ContatoDAO();
         contatoDB.CriaContato(contato);
         
         
         out.println("<html>");
         out.println("<body>");
         out.println("Contato adicionado com sucesso");       
         out.println("</body>");
         out.println("</html>");

     }
}
