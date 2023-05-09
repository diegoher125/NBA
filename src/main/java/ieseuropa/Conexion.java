package main.java.ieseuropa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
	
	private static String db_ = "nba";
	private static String login_ = "root";
	private static String pwd_ = "root";
	private static String url_ = "jdbc:mysql://localhost/" + db_ + "?serverTimezone=UTC";
	private static Connection conection_;
	private static Statement st_;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conection_ = DriverManager.getConnection(url_, login_, pwd_);
			if(conection_ != null) {
				st_ = conection_.createStatement();
				System.out.println("Conexion exitosa a la base de datos " + db_);
			}else {
				System.out.println("Conexion fallida. Muerte y destruccion");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ejecutarQuery(String query) {
		try {
			Statement st = conection_.createStatement();
			
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int cargarInt(String query){
		int calculo = 0;
		try {
			Statement st = conection_.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				calculo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return calculo;
	}
	
	public String cargarString(String query){
		String cadena = "";
		try {
			Statement st = conection_.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				cadena = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadena;
	}

}