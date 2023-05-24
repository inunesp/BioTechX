package BioTechX;

public class Polimero {
	// Procesa las reacciones encadenadas en un polímero y devuelve el polímero
	// reducido
	public String procesarReaccionesEncadenadas(String polimero) {
		StringBuilder reducido = new StringBuilder(polimero);

		boolean reaccionOcurrida = true;
		while (reaccionOcurrida) {
			reaccionOcurrida = false;
			for (int i = 0; i < reducido.length() - 1; i++) {
				char unidad1 = reducido.charAt(i);
				char unidad2 = reducido.charAt(i + 1);

				// Verificar si las unidades adyacentes son iguales pero con polaridades
				// opuestas
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

	public static void main(String[] args) {
		Polimero polimero = new Polimero();

		String polimero1 = "OmMLuUETt nNMIOo";
		String polimero1Reducido = polimero.procesarReaccionesEncadenadas(polimero1);

		String polimero2 = "pPBXxExXTkKIlLS";
		String polimero2Reducido = polimero.procesarReaccionesEncadenadas(polimero2);

		System.out.println("Polímero original: " + polimero1);
		System.out.println("Polímero reducido: " + polimero1Reducido + "\n");

		System.out.println("Polímero original: " + polimero2);
		System.out.println("Polímero reducido: " + polimero2Reducido + "\n");
	}
}