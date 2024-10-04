package services;

import dao.TurmaDAO;
import entities.Turma;

public class TurmaService {
	
	private TurmaDAO turmaDao;
	
	public TurmaService(TurmaDAO turmaDao) {
		this.turmaDao = turmaDao;
	}
	
	public Turma findTurmaById(int id) {
		return turmaDao.findTurmaById(id);
	}

}
