package Principal;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Turma implements Identificavel{
	
	@Id
	@GeneratedValue(generator="turma_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="turma_seq")
	private Long id; 
	
	@ManyToOne
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name="id_disc")
	private Disciplina disciplina;
	
	@ManyToMany
	@JoinTable(name="turma_aluno", joinColumns=@JoinColumn(name="id_turma"), inverseJoinColumns=@JoinColumn(name="id_aluno"))
	private Set<Aluno> alunos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Set<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
