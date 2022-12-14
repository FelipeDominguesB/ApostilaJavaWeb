package ifsp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao()
	{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	  public void adiciona(Contato contato) {
	      String sql = "insert into contatos " +
	              "(nome,email,endereco,dataNascimento)" +
	              " values (?,?,?,?)";

	      try {
	          // prepared statement para inserção
	          PreparedStatement stmt = this.connection.prepareStatement(sql);

	          // seta os valores

	          stmt.setString(1,contato.getNome());
	          stmt.setString(2,contato.getEmail());
	          stmt.setString(3,contato.getEndereco());
	          stmt.setDate(4, new Date(
	                  contato.getDataNascimento().getTimeInMillis()));

	          // executa
	          stmt.execute();
	          stmt.close();
	      } catch (SQLException e) {
	          throw new RuntimeException(e);
	      }
	  }
	  
	  public List<Contato> getLista() throws Exception {
		  PreparedStatement stmt = this.connection
		          .prepareStatement("select * from contatos");
		  ResultSet rs = stmt.executeQuery();

		  List<Contato> contatos = new ArrayList<Contato>();

		  while (rs.next()) {

		      // criando o objeto Contato
		      Contato contato = new Contato();
		      contato.setNome(rs.getString("nome"));
		      contato.setEmail(rs.getString("email"));
		      contato.setEndereco(rs.getString("endereco"));

		      // montando a data através do Calendar
		      Calendar data = Calendar.getInstance();
		      data.setTime(rs.getDate("dataNascimento"));
		      contato.setDataNascimento(data);

		      // adicionando o objeto à lista
		      contatos.add(contato);
		  }

		  rs.close();
		  stmt.close();

		  return contatos;
		}
}
