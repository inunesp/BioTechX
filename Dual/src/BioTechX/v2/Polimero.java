package BioTechX.v2;

import java.util.HashMap;
import java.util.Map;

public class Polimero {
	private Map<String, String> polimeros; // Mapa para almacenar polimeros y sus reducciones

	public Polimero() {
		polimeros = new HashMap<>(); // Inicializar el mapa en el constructor
	}

	// Procesa las reacciones encadenadas en un polimero y devuelve el polimero
	// reducido
	public String procesarReaccionesEncadenadas(String polimero) {
		StringBuilder reducido = new StringBuilder(polimero);

		boolean reaccionOcurrida = true;
		while (reaccionOcurrida) {
			reaccionOcurrida = false;
			for (int i = 0; i < reducido.length() - 1; i++) {
				char unidad1 = reducido.charAt(i);
				char unidad2 = reducido.charAt(i + 1);

				// Verificar si las unidades adyacentes tienen polaridades opuestas
				if (Character.toLowerCase(unidad1) == Character.toLowerCase(unidad2)
						&& Character.isLowerCase(unidad1) != Character.isLowerCase(unidad2)) {
					reducido.delete(i, i + 2); // Eliminar las unidades
					reaccionOcurrida = true;
					break;
				}
			}
		}

		return reducido.toString();
	}

	// Registra un polimero y su reduccion en el mapa
	public void registrarPolimero(String polimero) {
		String reducido = procesarReaccionesEncadenadas(polimero);
		polimeros.put(polimero, reducido);
	}

	// Verifica si un polimero contiene caracteres especiales
	public boolean contieneCaracterEspecial(String polimero) {
		return polimero.matches(".*[^a-zA-Z].*");
	}

	// Verifica si un polimero contiene numeros
	public boolean contieneNumeros(String polimero) {
		return polimero.matches(".*\\d.*");
	}

	// Comprueba si un polimero reducido tiene un exceso de carga positiva o
	// negativa
	public void comprobarExcesoCarga(String polimero) {
		int cargaPositiva = 0;
		int cargaNegativa = 0;
		char prevChar = '\0';

		for (char c : polimero.toCharArray()) {
			if (Character.isUpperCase(c)) {
				if (c == prevChar) {
					cargaPositiva++; // Incrementar la carga positiva si es la misma unidad consecutiva
				} else {
					cargaPositiva = 1; // Reiniciar la carga positiva si es una nueva unidad
				}
			} else if (Character.isLowerCase(c)) {
				if (c == prevChar) {
					cargaNegativa++; // Incrementar la carga negativa si es la misma unidad consecutiva
				} else {
					cargaNegativa = 1; // Reiniciar la carga negativa si es una nueva unidad
				}
			}

			prevChar = c;
		}

		// Mostrar advertencia si se encuentra un exceso de carga positiva o negativa
		if (cargaPositiva > 2) {
			System.out.println("Advertencia: Exceso de carga positiva encontrada");
		} else if (cargaNegativa > 2) {
			System.out.println("Advertencia: Exceso de carga negativa encontrada");
		}
	}

	public static void main(String[] args) {
		Polimero polimero = new Polimero();

		String polimero1 = "OmMLuUETt nNMIOo";
		polimero.registrarPolimero(polimero1);

		String polimero2 = "pPBXxExXTkKIlLS";
		polimero.registrarPolimero(polimero2);

		System.out.println("Polimero original: " + polimero1);
		System.out.println("Polimero reducido: " + polimero.polimeros.get(polimero1) + "\n");

		System.out.println("Polimero original: " + polimero2);
		System.out.println("Polimero reducido: " + polimero.polimeros.get(polimero2) + "\n");
	}

}
