package entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contatos")
public class Contato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "id")
	private Long id;
	
	@Column(name="nome")
    private String nome;
	
	@Column(name="email")
    private String email;
	
	@Column(name="endereco")
    private String endereco;
	
	@Column(name="dataNascimento")
    private Calendar dataNascimento;

  // métodos get e set para id, nome, email, endereço e dataNascimento

  public String getNome() {
    return this.nome;
  }
  public void setNome(String novo) {
    this.nome = novo;
  }

  public String getEmail() {
    return this.email;
  }
  public void setEmail(String novo) {
    this.email = novo;
  }

  public String getEndereco() {
    return this.endereco;
  }
  public void setEndereco(String novo) {
    this.endereco = novo;
  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long novo) {
    this.id = novo;
  }

  public Calendar getDataNascimento() {
    return this.dataNascimento;
  }
  public void setDataNascimento(Calendar dataNascimento) {
    this.dataNascimento = dataNascimento;
  }
}