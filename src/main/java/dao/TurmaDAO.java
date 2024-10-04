package dao;

import javax.persistence.EntityManager;

import entities.Turma;

public class TurmaDAO {
	
	private EntityManager em;

	public TurmaDAO(EntityManager em) {
		this.em = em;
	}
	
	public Turma findTurmaById(int id) {
		Turma turma = em.find(Turma.class, id);
		return turma;
	}

}
