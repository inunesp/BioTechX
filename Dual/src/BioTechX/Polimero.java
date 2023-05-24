package BioTechX;

public class Polimero {

	// metodo para procesar el texto
	public String procesado(String polimero) {
		StringBuilder reducido = new StringBuilder(polimero);

		boolean reaccion = true;
		while (reaccion) {
			reaccion = false;
			for (int i = 0; i < reducido.length() - 1; i++) {
				char unidad1 = reducido.charAt(i);
				char unidad2 = reducido.charAt(i + 1);

				// pasa a minusculas el texto y comprara si i == i+1 , en el caso
				// de ser iguales los eliminas reordenando el codigo.
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

	public static void main(String[] args) {
		// metodo main con el texto por pantalla
		Polimero polimero = new Polimero();

		String polimero1 = "OmMLuUETt nNMIOo";
		String polimero1Reducido = polimero.procesado(polimero1);

		String polimero2 = "pPBXxExXTkKIlLS";
		String polimero2Reducido = polimero.procesado(polimero2);

		System.out.println("Polimero original: " + polimero1);
		System.out.println("Polimero reducido: " + polimero1Reducido + "\n");

		System.out.println("Polimero original: " + polimero2);
		System.out.println("Polimero reducido: " + polimero2Reducido + "\n");
	}
}
