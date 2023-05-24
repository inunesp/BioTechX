package BioTechX;

public class Polimero {

	// método para validar caracteres y procesar el texto
	public String validarYProcesar(String polimero) {

		StringBuilder reducido = new StringBuilder();

		for (int i = 0; i < polimero.length(); i++) {
			char c = polimero.charAt(i);

			// Si el caracter es una letra, se conserva sino 
			// se desecha el caracter
			if (Character.isLetter(c)) {
				reducido.append(c);
			}
		}

		boolean reaccion = true;

		while (reaccion) {

			reaccion = false;

			for (int i = 0; i < reducido.length() - 1; i++) {

				char unidad1 = reducido.charAt(i);
				char unidad2 = reducido.charAt(i + 1);

				// pasa a minusculas el texto y comprueba si i == i+1, en ese caso
				// si son iguales, los elimina reordenando el codigo.

				if (Character.toLowerCase(unidad1) == Character.toLowerCase(unidad2)
						&& Character.isLowerCase(unidad1) != Character.isLowerCase(unidad2)) {
					reducido.delete(i, i + 2);
					reaccion = true;
					break;

				}

			}

		}
		return reducido.toString();
	}
}