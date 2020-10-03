package dad.maven.gson;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
	//Funcion para comprobar si es numerico
	public static boolean isNumeric(String termino) {

		boolean resultado;

		try {
			Integer.parseInt(termino);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}
	//Funcion para devolver error
	public static String error() {
		return "Campo obligatorio tiene que rellenar todos los campos.";
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Persona p = new Persona();

		System.out.println("Introduzca su Nombre: ");
		p.nombre = in.nextLine();
		// Comprobamos que no esta vacio y que no sea un numero
		if (!p.nombre.isEmpty() & !p.nombre.isBlank()) {
			if (isNumeric(p.nombre) == false) {
				
				System.out.println("Introduzca su Apellidos: ");
				p.apellidos = in.nextLine();
				// Comprobamos que no esta vacio y que no sea un numero
				if (!p.apellidos.isEmpty() & !p.apellidos.isBlank()) {
					if (isNumeric(p.apellidos) == false) {
						try {
							
							System.out.println("Introduzca su Edad: ");
							p.edad = in.nextInt();

							Gson gson = new GsonBuilder().setPrettyPrinting().create();
							String json = gson.toJson(p);
							System.out.println(json);
							in.close();
							
						} catch (InputMismatchException e) {
							System.err.println("Introduzca un caracter numerico");
						}
					} else {
						System.err.println("Error no se pueden introducir números, por favor utilice caracteres");
					}
				} else {
					System.err.println(error());
				}

			} else {
				System.err.println("Error no se pueden introducir números, por favor utilice caracteres");
			}
		} else {
			System.err.println(error());
		}
	}
}
