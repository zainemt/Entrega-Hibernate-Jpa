package dao;

import javax.persistence.EntityManager;

import services.AlunoService;
import services.DisciplinaService;
import services.TurmaService;

public class DaoFactory {

	public static AlunoService createAlunoService(EntityManager em) {
		AlunoDAO alunoDao = new AlunoDAO(em);
		return new AlunoService(alunoDao);
	}

	public static DisciplinaService createDisciplinaService(EntityManager em) {
		DisciplinaDAO disciplinaDao = new DisciplinaDAO(em);
		return new DisciplinaService(disciplinaDao);
	}
	
	public static TurmaService createTurmaService(EntityManager em) {
		TurmaDAO turmaDAO = new TurmaDAO(em);
		return new TurmaService(turmaDAO);
	}
}
