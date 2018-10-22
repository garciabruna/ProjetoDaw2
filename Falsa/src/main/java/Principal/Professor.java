package Principal;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Professor implements Identificavel {
	
	@Id
	@GeneratedValue(generator="professor_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="professor_seq")
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	@ManyToMany
	@JoinTable(name="professor_turma", joinColumns=@JoinColumn(name="id_professor"), inverseJoinColumns=@JoinColumn(name="id_turma"))
	private Set<Turma> turmas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Professor(Long id, String nome, String email, String senha, Set<Turma> turmas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.turmas = turmas;
	}
	
	public Professor() {
		
	}
}
