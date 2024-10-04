package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int matricula;
	private String email;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@ManyToOne
	private Turma turma;
	
	public Aluno() {}
	
	public Aluno(String nome, int matricula, String email, Disciplina disciplina, Turma turma) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		
		this.disciplina = disciplina;
		this.turma = turma;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Aluno id = " + id + "\n" +
				"Nome = " + nome + "\n" +
				"Matricula = " + matricula + "\n" +
				"Email = " + email + "\n" +
				"Disciplina: \n" + disciplina + "\n" +
				"Turma: \n" + turma + " \n";
	}
	
	
}



