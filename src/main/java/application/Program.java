package application;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DaoFactory;
import entities.Aluno;
import entities.Disciplina;
import entities.Turma;

public class Program {

	public static void main(String[] args) {
		
		//povoamento do banco de dados
		/*
		Disciplina d1 = new Disciplina("Ciência da computação", "ccp");
		Disciplina d2 = new Disciplina("Análise e Desenvolvimento de Sistemas", "ads");
		Disciplina d3 = new Disciplina("Sistemas de informação", "si");
		Disciplina d4 = new Disciplina("Engenharia de software", "engs");
		
		Turma t1 = new Turma("ccp-t1", d1);
		Turma t2 = new Turma("ads-t1", d2);
		Turma t3 = new Turma("si-t1", d3);
		Turma t4 = new Turma("engs-t1", d4);
		
		Aluno al1 = new Aluno("aaaaaa", 0001 ,"aaaaaa@gmail.com", d1, t1);
		Aluno al2 = new Aluno("bbbbbb", 0002 ,"bbbbbb@gmail.com", d2, t2);
		Aluno al3 = new Aluno("cccccc", 0003 ,"cccccc@gmail.com", d3, t3);
		Aluno al4 = new Aluno("dddddd", 0004 ,"dddddd@gmail.com", d4, t4);
		Aluno al5 = new Aluno("eeeeee", 0005 ,"eeeeee@gmail.com", d1, t1);
		
		em.getTransaction().begin();
			em.persist(d1);
			em.persist(d2);
			em.persist(d3);
			em.persist(d4);
		em.getTransaction().commit();
			
		em.getTransaction().begin();
			em.persist(t1);
			em.persist(t2);
			em.persist(t3);
			em.persist(t4);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
			em.persist(al1);
			em.persist(al2);
			em.persist(al3);
			em.persist(al4);
			em.persist(al5);
		em.getTransaction().commit();
		*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("entrega-orm");
		EntityManager em = emf.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		
		while (option != 5) {
			
			switch (option) {
			
				case 1: {
					System.out.printf("Nome do aluno: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.printf("Matrícula do aluno: ");
					int matricula = sc.nextInt();
					System.out.printf("Email do aluno: ");
					String email = sc.next();
					System.out.printf("Id da disciplina: ");
					int id = sc.nextInt();
					Disciplina disciplina = DaoFactory.createDisciplinaService(em).findDisciplinaById(id);
					System.out.print("Id da turma: ");
					id = sc.nextInt();
					Turma turma = DaoFactory.createTurmaService(em).findTurmaById(id);
					
					DaoFactory.createAlunoService(em).saveAluno(new Aluno(nome, matricula, email, disciplina, turma));
					System.out.println("Aluno inserido!");
				} break;
				
				case 2: {
					System.out.printf("Id do aluno que deseja atualizar: ");
					int id = sc.nextInt();
					
					System.out.printf("Nome do aluno: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.printf("Matrícula do aluno: ");
					int matricula = sc.nextInt();
					System.out.printf("Email do aluno: ");
					sc.nextLine();
					String email = sc.nextLine();
		
					DaoFactory.createAlunoService(em).updateAluno(id, nome, email, matricula);
					System.err.println("Informações atualizadas!");
				} break;
				
				case 3: {
					System.out.printf("Id do aluno que deseja remover: ");
					int id = sc.nextInt();
					
					DaoFactory.createAlunoService(em).deleteAluno(id);
					System.out.println("Aluno removido!");
				} break;
				
				case 4: {
					System.out.printf("Id do aluno que deseja consultar: ");
					int id = sc.nextInt();
					
					Aluno aluno = DaoFactory.createAlunoService(em).findAlunoById(id);
					System.out.println(aluno.toString());
				} break;
			
			}
			
			System.out.printf("[1] - ADICIONAR ALUNO %n"
							+ "[2] - UPDATE ALUNO %n"
							+ "[3] - REMOVER ALUNO %n"
							+ "[4] - CONSULTAR ALUNO %n"
							+ "[5] - SAIR %n");
			option = sc.nextInt();
		}
		sc.close();
	}

}
