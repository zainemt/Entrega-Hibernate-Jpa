package dao;

import javax.persistence.EntityManager;

import entities.Aluno;

public class AlunoDAO {
	
	private EntityManager em;
	
	public AlunoDAO(EntityManager em) {
		this.em = em;
	}
	
	//salvar
	public void saveAluno(Aluno aluno) {
		em.getTransaction().begin();
			em.persist(aluno);
		em.getTransaction().commit();
	}
	
	//buscar
	public Aluno findAlunoById(int id) {
		Aluno aluno = em.find(Aluno.class, id);
		return aluno;
	}
	
	//deletar
	public void deleteAluno(int id) {
		Aluno aluno = findAlunoById(id);
		
		em.getTransaction().begin();
			em.remove(aluno);
		em.getTransaction().commit();	
	}
	
	//atualizar
	public void updateAluno(int id, String nome, String email, int matricula) {
		em.getTransaction().begin();
			
			Aluno a1 = findAlunoById(id);
				a1.setNome(nome);
				a1.setEmail(email);
				a1.setMatricula(matricula);
			em.merge(a1);
		
		em.getTransaction().commit();
	}

}
