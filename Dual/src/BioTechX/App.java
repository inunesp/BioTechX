package BioTechX;

public class App {
	public static void main(String[] args) {

		// metodo main con el texto por pantalla

		Polimero polimero = new Polimero();

		String polimero1 = "OmMLu3UETt nNMIOo";
		String polimero1Reducido = polimero.validarYProcesar(polimero1);

		String polimero2 = "pPBXxEx2XTkKIlLS";
		String polimero2Reducido = polimero.validarYProcesar(polimero2);

		System.out.println("Polimero original: " + polimero1);
		System.out.println("Polimero reducido: " + polimero1Reducido + "\n");

		System.out.println("Polimero original: " + polimero2);
		System.out.println("Polimero reducido: " + polimero2Reducido + "\n");

	}
}
