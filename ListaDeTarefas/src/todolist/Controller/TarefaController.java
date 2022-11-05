package todolist.Controller;

import java.sql.SQLException;
import java.util.Scanner;

import todolist.Model.TarefaModel;

public class TarefaController {
	
	
	public static void Menu () throws SQLException {
		if (TarefaModel.RetornarId() > 0) { 
			System.out.println("1 - [Nova tarefa] / 2 - [Consultar tarefa] / 3 - [Deletar tarefa] / 4 - [Mudar Status Tarefa] / 5 - [Sair]");
		}else { 
			System.out.println("1 - [Nova tarefa] / 2 - [Sair]");
		}
	}
	
	public static int ValidaOp() throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		int op = teclado.nextInt();
		
		if (TarefaModel.RetornarId() > 0) { 
			if ((op < 1) || (op > 5)) { 
				System.out.println("Opção inválida, tente novamente: ");
				op = teclado.nextInt();
				return op;
			}
		} else if (TarefaModel.RetornarId() <= 0) { 
			if (op ==2) { 
				op = 5;
				return op;
			} else
			if ((op < 1) || (op > 2)) { 
				System.out.println("Opção inválida, tente novamente: ");
				op = teclado.nextInt();
				return op;
				}
		}
		return op;
		
	}
	
	
	
	public static void InserirTarefa (int id, String nome, boolean check) throws SQLException {
		try {
			
			TarefaModel.InserirTarefa(id, nome, check);
			System.out.println("Atividade cadastrada com sucesso!!!");
			
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("A posição se encontra ocupada na lista por outra atividade.");
			
			
			System.out.println("Tente inserir a atividade "+ nome + " na posição: " + (TarefaModel.RetornarId()+1));
			System.out.println("Ou Escolha a opção 'Consultar' para verificar as posições.");
			}
		}
	
	
	public static void ConsultarTarefa () {
		try {
			System.out.println("[Posição]-[Atividade]-[Concluida]");
			TarefaModel.ConsultarTarefa();
			
			
		} catch(Exception e) {
			System.out.println("Não foi possível realizar a consulta: " + e);
		}
	}
	
	
	public static void DeletarTarefa() throws SQLException {
		Scanner teclado = new Scanner(System.in);
		
		int opcao = 0;
		boolean valida_j = false;
		
		while( valida_j != true) {
			try {
				System.out.println("Digite a posição da tarefa a ser deletada: ");
				opcao = teclado.nextInt();
				if ((opcao <= TarefaModel.RetornarId()) && (opcao > 0)) { 
					valida_j = true;
				} else {System.out.println("Posição inválida, tente novamente: ");}
			} catch(Exception e) {
				String str = teclado.nextLine();
				System.out.println("Dígito inválido, tente novamente: ");
			}
			
		}
		
		System.out.println();
		TarefaModel.DeletarTarefa(opcao);
	}
	
	
	public static void AtualizarStatus() throws SQLException {
		Scanner teclado = new Scanner(System.in);
		
		int id = 0;
		boolean valida_j = false;
		
		while( valida_j != true) {
			try {
				System.out.println("Digite a posição da tarefa a atualizada: ");
				id = teclado.nextInt();
				if ((id <= TarefaModel.RetornarId()) && (id > 0)) { 
					valida_j = true;
				} else {System.out.println("Posição inválida, tente novamente: ");}
			} catch(Exception e) {
				String texto = teclado.nextLine();
				System.out.println("Dígito inválido, tente novamente: ");
			}
			
		}
		
		System.out.println("Atividade conlcuida? [Sim /Não]");
		String check = teclado.next().toUpperCase();
		boolean status = false;
		int validador_y = 0;
		while (validador_y != 1) {
			if ((check.equals("1")) || (check.equals("SIM"))) {
				status = true;
				validador_y = 1;
			} else if ((check.equals("2")) || (check.equals("NÃO"))) {
				status = false;
				validador_y = 1;
			} else {
				System.out.println("Descrição inválida, tente novamente: ");
				check = teclado.next().toUpperCase();
				}
			}
	
		
		TarefaModel.AtualizarStatus(status, id);
		System.out.println("Status da atividade " + id + " atualizado com sucesso!");
	}
	
	
	public static void ValidaInsercao() throws SQLException {
		Scanner teclado = new Scanner(System.in);
		
		
		System.out.println("Digite o nome da atividade: [Apenas 1 palavra]");
		String nome = teclado.next();
		
		
		
		System.out.println("Digite a posição da atividade: [1º, 2º, 3º...]");
		boolean validador_x = false;
		int posicao = 0;
		while (validador_x != true) { 
			try {
				posicao = teclado.nextInt(); 
				validador_x = true; 
			} catch(Exception e) {
				String texto = teclado.nextLine();
				System.out.println("Ops, dígito inválido, tente novamente: ");
				
			}
		}
		
		
		System.out.println("Atividade concluida? [1 - SIM] / [2 - NÃO] ");
		String check = teclado.next().toUpperCase();
		boolean status = false; 
		int validador_y = 0; 
		while (validador_y != 1) {
			if ((check.equals("1")) || (check.equals("SIM"))) {
				status = true;
				validador_y = 1;
			} else if ((check.equals("2")) || (check.equals("NÃO"))) {
				status = false;
				validador_y = 1;
			} else {
				System.out.println("Descrição inválida, tente novamente: ");
				check = teclado.next().toUpperCase();
				}
			}
		
		TarefaController.InserirTarefa(posicao, nome, status);
		
		}
		
		
		
	
	
	
	}
