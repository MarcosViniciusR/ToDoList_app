package todolist.View;

import java.sql.SQLException;
import java.util.Scanner;

import todolist.Controller.TarefaController;
import todolist.Model.TarefaModel;

public class TarefaView {

	public static void main(String[] args) throws SQLException {
		int x = 1;
		int op = 0;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println(" ");
			System.out.println("|____ BEM VINDO AO TO DO LIST ____|");
			System.out.println("|____ Qual ação deseja realizar? ____|");
			System.out.println(" ");
			
			
			TarefaController.Menu();
			
			
			op = TarefaController.ValidaOp();
			
			
			if (op == 5 ) {
				x = 0;
				System.out.println("Encerrando o programa, até mais!");
			}
			
			
			if (op == 1) {
				
				TarefaController.ValidaInsercao();
				
			}
			
			
			if (op == 2) {
				TarefaController.ConsultarTarefa();
				System.out.println(" ");
				
			}
			
			
			if (op == 3) {
				TarefaController.ConsultarTarefa();
				System.out.println(" ");
				TarefaController.DeletarTarefa();
				System.out.println("Tarefa deletada com sucesso!");
			}
			
			
			if (op == 4) {
				TarefaController.ConsultarTarefa();
				TarefaController.AtualizarStatus();
			}
			
			
		} while (x != 0);
		
		
	

	}

}
