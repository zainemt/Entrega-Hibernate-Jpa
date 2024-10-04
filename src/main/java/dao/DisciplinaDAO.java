package dao;

import javax.persistence.EntityManager;

import entities.Disciplina;

public class DisciplinaDAO {
	
	private EntityManager em;

	public DisciplinaDAO(EntityManager em) {
		this.em = em;
	}
	
	public Disciplina findDisciplinaById(int id) {
		Disciplina disciplina = em.find(Disciplina.class, id);
		return disciplina;
	}
	
	
}
