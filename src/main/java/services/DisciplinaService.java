package services;

import dao.DisciplinaDAO;
import entities.Disciplina;

public class DisciplinaService {

	private DisciplinaDAO disciplinaDao;

	public DisciplinaService(DisciplinaDAO disciplinaDao) {
		this.disciplinaDao = disciplinaDao;
	}
	
	public Disciplina findDisciplinaById(int id) {
		Disciplina disciplina = disciplinaDao.findDisciplinaById(id);
		return disciplina;
	}
	
	
	
}
