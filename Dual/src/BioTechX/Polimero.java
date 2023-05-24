package BioTechX;

import java.util.Scanner;

public class Polimero {
    // Procesa las reacciones encadenadas en un polímero y devuelve el polímero reducido
    public String procesamiento(String polimero) {
        StringBuilder reducido = new StringBuilder(polimero);

        boolean reaccion = true;
        while (reaccion) {
            reaccion = false;
            for (int i = 0; i < reducido.length() - 1; i++) {
                char unidad1 = reducido.charAt(i);
                char unidad2 = reducido.charAt(i + 1);

                // Verificar si las unidades adyacentes son iguales pero con polaridades opuestas
                if (Character.isLetter(unidad1) && Character.isLetter(unidad2)
                        && Character.toLowerCase(unidad1) == Character.toLowerCase(unidad2)
                        && Character.isLowerCase(unidad1) != Character.isLowerCase(unidad2)) {
                    reducido.delete(i, i + 2); // Eliminar las unidades
                    reaccion = true;
                    break;
                }
            }
        }

        return reducido.toString();
    }

    // Comprueba si el polímero reducido presenta un exceso de carga positiva o negativa
    public void comprobarExcesoCarga(String polimero) {
        int cargaPositiva = 0;
        int cargaNegativa = 0;

        for (char unidad : polimero.toCharArray()) {
            if (Character.isUpperCase(unidad)) {
                cargaPositiva++;
            } else if (Character.isLowerCase(unidad)) {
                cargaNegativa++;
            }
        }

        if (cargaPositiva > cargaNegativa) {
            System.out.println("El polímero reducido presenta un exceso de carga positiva.");
        } else if (cargaPositiva < cargaNegativa) {
            System.out.println("El polímero reducido presenta un exceso de carga negativa.");
        } else {
            System.out.println("El polímero reducido no presenta un exceso de carga.");
        }
    }

    // Muestra un mensaje de advertencia indicando el tipo de exceso de carga identificado
    public void mostrarAdvertenciaExcesoCarga(String polimero) {
        int cargaPositiva = 0;
        int cargaNegativa = 0;

        for (char unidad : polimero.toCharArray()) {
            if (Character.isUpperCase(unidad)) {
                cargaPositiva++;
            } else if (Character.isLowerCase(unidad)) {
                cargaNegativa++;
            }
        }

        if (cargaPositiva > cargaNegativa) {
            System.out.println("Advertencia: El polímero reducido presenta un exceso de carga positiva.");
        } else if (cargaPositiva < cargaNegativa) {
            System.out.println("Advertencia: El polímero reducido presenta un exceso de carga negativa.");
        } else {
            System.out.println("El polímero reducido no presenta un exceso de carga.");
        }
    }

    public static void main(String[] args) {
        Polimero polimero = new Polimero();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el polímero 1: ");
        String polimero1 = scanner.nextLine();
     // ejemplo OmMLuUETt nNMIOo
        System.out.print("Ingrese el polímero 2: ");
        String polimero2 = scanner.nextLine();
        scanner.close();
     // ejemplo pPBXxExXTkKIlLS
        String polimero1Procesado = polimero.procesamiento(polimero1);
        String polimero2Procesado = polimero.procesamiento(polimero2);

        System.out.println("Polímero reducido 1: " + polimero1Procesado);
        polimero.mostrarAdvertenciaExcesoCarga(polimero1Procesado);
        System.out.println();

        System.out.println("Polímero reducido 2: " + polimero2Procesado);
        polimero.mostrarAdvertenciaExcesoCarga(polimero2Procesado);
        System.out.println();
    }
}
