//Joel Jaquez 23369
//Nery Molina 23218
///Parte 5 Laboratorio 3 

import java.util.Scanner;

public class DecimalaBinario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de Opciones:");
            System.out.println("1. Pasar un numero decimal a un numero binario(No acepta numeros negativos)");
            System.out.println("2. Pasar un numero binario a A2");
            System.out.println("3. Sumar dos numeros binarios");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número decimal positivo que desea convertir a binario: ");
                    int decimalNumber = scanner.nextInt();
                    if (decimalNumber >= 0) {
                        String binaryString = convertirABinario(decimalNumber);
                        System.out.println("El número decimal " + decimalNumber + " en binario es: " + binaryString);
                    } else {
                        System.out.println("El número debe ser positivo.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese un numero binario de 8 bits para pasarlo a2 : ");
                    String binarioString = scanner.nextLine();
                    StringBuilder invertedBinary = new StringBuilder();
                    for (char bit : binarioString.toCharArray()) {
                        if (bit == '0') {
                            invertedBinary.append('1');
                        } else {
                            invertedBinary.append('0');
                        }
                    }
                    int decimal = Integer.parseInt(invertedBinary.toString(), 2) + 1;
                    String resultadoBinario = Integer.toBinaryString(decimal);
                    resultadoBinario = ajustarBits(resultadoBinario);
                    System.out.println("El resultado es: " + resultadoBinario);
                    break;

                case 3:
                    System.out.print("Ingrese el primer número binario: ");
                    String primerBinario = ajustarBits(scanner.nextLine());
                    System.out.print("Ingrese el segundo número binario: ");
                    String segundoBinario = ajustarBits(scanner.nextLine());

                    resultadoBinario = sumarBinarios(primerBinario, segundoBinario);
                    System.out.println("La suma de " + primerBinario + " y " + segundoBinario + " es: " + resultadoBinario.substring(resultadoBinario.length() > 8 ? 1 : 0));
                    break;

                case 4:
                    System.out.println("¡Gracias por utilizar el programa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static String convertirABinario(int numero) {
        String binario = Integer.toBinaryString(numero);
        while (binario.length() < 8) {
            binario = "0" + binario;
        }
        return binario;
    }

    private static String ajustarBits(String binario) {
        while (binario.length() < 8) {
            binario = "0" + binario;
        }
        return binario;
    }

    private static String sumarBinarios(String a, String b) {
        int decimalA = Integer.parseInt(a, 2);
        int decimalB = Integer.parseInt(b, 2);
        int suma = decimalA + decimalB;
        return convertirABinario(suma);
    }
}