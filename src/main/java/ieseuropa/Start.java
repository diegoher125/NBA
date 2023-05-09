package main.java.ieseuropa;

import java.util.Scanner;

public class Start {

	private static String pedirString(String texto) {
		Scanner teclado = new Scanner(System.in);
		System.out.println(texto);
		return teclado.nextLine();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion conexion = new Conexion();

		System.out.println("El maximo de puntos del equipo visitante es "
				+ conexion.cargarInt("select max(puntos_visitante) from nba.partidos;"));

		System.out.println("El maximo promedio de asistencias de un jugador es "
				+ conexion.cargarInt("select max(Asistencias_por_partido) from nba.estadisticas;"));

		System.out.println("Su equipo es " + 
							conexion.cargarString("SELECT Nombre_equipo FROM nba.jugadores where Nombre = '"
										+ pedirString("Indique el nombre del jugador") + "';"));
	}

}
