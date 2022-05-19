package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
	public static Connection connection = null; //conexao com banco de dados
	public static Statement statement = null; //gerencia consultas
	public static ResultSet result = null;  //armazena e retorna as consultas feitas
	
	
	public static Connection conectar() {
		String hostname = "motty.db.elephantsql.com";
		int port = 5432;
		String database = "wcihovxy";
		String username = "wcihovxy";
		String password = "TZx4T0NNCHgylklO2ASwYqw-GYL_xQj5";
		String servidor = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
		
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			connection = DriverManager.getConnection(servidor, username, password);
			statement = connection.createStatement();

			// escreve sysout e aperta ctrl + espaço //
		}
		
		catch (SQLException ex) {
			System.err.println("Erro na conexão" + ex.getMessage());
		}
		
		catch (Exception ex) {
			System.err.println("Erro geral" + ex.getMessage());
		}
		return connection;
	}


	public void closeconexao() {
		try {
			connection.close();
		}

		catch (Exception ex) {
			System.err.println("Erro ao desconectar" + ex.getMessage());
		}
	}


}// FIM DA CLASSE