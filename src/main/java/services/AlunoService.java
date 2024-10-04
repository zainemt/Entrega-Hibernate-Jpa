package services;

import dao.AlunoDAO;
import entities.Aluno;

public class AlunoService {

	private AlunoDAO alunoDao;
	
	public AlunoService(AlunoDAO alunoDao) {
		this.alunoDao = alunoDao;
	}
	
	public void saveAluno(Aluno aluno) {
		alunoDao.saveAluno(aluno);
	}

	public Aluno findAlunoById(int id) {
		Aluno aluno = alunoDao.findAlunoById(id);
		return aluno;
	}
	
	public void deleteAluno(int id) {
		alunoDao.deleteAluno(id);
	}
	
	public void updateAluno(int id, String nome, String email, int matricula) {
		alunoDao.updateAluno(id, nome, email, matricula);
	}
	
}
