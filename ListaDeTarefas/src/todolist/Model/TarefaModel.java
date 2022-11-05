package todolist.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TarefaModel {
	
	
	private int id;
	private String nome;
	private boolean check;
	
	private static String database_url = "jdbc:mysql://localhost:3306/todo";
	private static String usuario = "root";
	private static String password = "**********";
	
	
	
	
	
	public TarefaModel(int id, String nome, boolean check) {
		super();
		this.id = id;
		this.nome = nome;
		this.check = check;
	}


	public TarefaModel() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean isCheck() {
		return check;
	}


	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
	
	public static void InserirTarefa(int id, String nome, boolean check) throws SQLException {
		
		Connection con = DriverManager.getConnection(database_url, usuario, password);
		
		String sql = "insert into tarefas (id, nome, verificado) values (?, ? ,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		TarefaModel tarefa = new TarefaModel(id, nome, check);
		
		ps.setInt(1, tarefa.getId());
		ps.setString(2, tarefa.getNome());
		ps.setBoolean(3, tarefa.isCheck());
		ps.execute();
	}
	
	
	public static void ConsultarTarefa() throws SQLException {
		
		
		Connection con = DriverManager.getConnection(database_url, usuario, password);
		
		String sql = "select * from tarefas";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			TarefaModel tarefa = new TarefaModel();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setCheck(rs.getBoolean("verificado"));
			System.out.println(" ");
			System.out.print(tarefa.getId() + " - ");
			System.out.print(tarefa.getNome() + " - ");
			if (tarefa.isCheck()) {
				System.out.println("Sim");
			} else {
				System.out.println("Não");
			}
			
			
		}
		
		
	}

	
	public static void DeletarTarefa(int id) throws SQLException {
		
		Connection con = DriverManager.getConnection(database_url, usuario, password);
		
		String sql = "delete from tarefas where id = " + id;
		PreparedStatement st = con.prepareStatement(sql);
		
		st.execute();
	}
	
	
	public static void AtualizarStatus(boolean vf, int id) throws SQLException {
		Connection con = DriverManager.getConnection(database_url, usuario, password);
		
		String sql = "update tarefas set verificado = "+ vf +" where id = " + id;
		PreparedStatement ps = con.prepareStatement(sql);
		

		ps.execute();
	}
	
	
	public static int RetornarId() throws SQLException {
		
		Connection con = DriverManager.getConnection(database_url, usuario, password);
		
		String sql = "select * from tarefas";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		int contador_de_id = 0;
		while (rs.next()) {
			TarefaModel tarefa = new TarefaModel();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setCheck(rs.getBoolean("verificado"));
			contador_de_id = rs.getInt("id");
			
		}
		return contador_de_id;
		
		
	}
	
	
	

}
