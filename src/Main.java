import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. ");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            Random random = new Random();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresaste la opción 1");

                    ArrayList<Integer> numeros = new ArrayList<>();
                    int numero;
                    System.out.println("Ingrese números (ingrese un número menor a 0 para terminar):");
                    while (true) {
                        numero = scanner.nextInt();
                        if (numero < 0) {
                            break;
                        }
                        numeros.add(numero);
                    }
                    System.out.println("Números ingresados:");
                    for (int num : numeros) {
                        System.out.println(num);
                    }
                    break;

                case 2:
                    System.out.println("Ingresaste la opción 2");

                    ArrayList<Double> numerosDecimales = new ArrayList<>();
                    System.out.println("Ingrese 20 números decimales:");
                    for (int i = 0; i < 20; i++) {
                        numerosDecimales.add(scanner.nextDouble());
                    }
                    double max = Collections.max(numerosDecimales);
                    double min = Collections.min(numerosDecimales);
                    double rango = max - min;
                    System.out.println("El mayor número es: " + max);
                    System.out.println("El menor número es: " + min);
                    System.out.println("El rango es: " + rango);
                    break;

                case 3:
                    System.out.println("Ingresaste la opción 3");

                    ArrayList<Integer> numerosAleatorios = new ArrayList<>();

                    for (int i = 0; i < 20; i++) {
                        int numeroAleatorio;
                        do {
                            numeroAleatorio = random.nextInt(100) + 1;
                        } while (numeroAleatorio % 2 != 0);
                        numerosAleatorios.add(numeroAleatorio);
                    }

                    // Calcular el promedio aritmético
                    double suma = 0;
                    for (int num : numerosAleatorios) {
                        suma += num;
                    }
                    double promedio = suma / numerosAleatorios.size();

                    int iguales = 0, mayores = 0, menores = 0;
                    for (int num : numerosAleatorios) {
                        if (num == promedio) {
                            iguales++;
                        } else if (num > promedio) {
                            mayores++;
                        } else {
                            menores++;
                        }
                    }

                    System.out.println("Números aleatorios generados:");
                    for (int num : numerosAleatorios) {
                        System.out.println(num);
                    }
                    System.out.println("Promedio aritmético: " + promedio);
                    System.out.println("Números iguales al promedio: " + iguales);
                    System.out.println("Números mayores que el promedio: " + mayores);
                    System.out.println("Números menores que el promedio: " + menores);
                    break;

                case 4:
                    System.out.println("Ingresaste la opción 4");

                    ArrayList<Integer> listaNumeros = new ArrayList<>();

                    // Generar 50 números aleatorios y agregarlos a la lista
                    for (int i = 0; i < 50; i++) {
                        listaNumeros.add(random.nextInt(100) + 1);
                    }

                    System.out.println("Ingrese el valor que desea buscar:");
                    int valorBuscado = scanner.nextInt();

                    boolean encontrado = false;
                    for (int i = 0; i < listaNumeros.size(); i++) {
                        if (listaNumeros.get(i) == valorBuscado) {
                            System.out.println("Valor encontrado en la posición: " + i);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Valor no encontrado en la lista.");
                    }
                    break;

                case 5:
                    System.out.println("Ingresaste la opción 5");
                    
                    ArrayList<Integer> digitos = new ArrayList<>();
                    System.out.println("Ingrese 10 dígitos enteros:");
                    for (int i = 0; i < 10; i++) {
                        digitos.add(scanner.nextInt());
                    }

                    ArrayList<Integer> ascendente = new ArrayList<>(digitos);
                    ArrayList<Integer> descendente = new ArrayList<>(digitos);

                    Collections.sort(ascendente);
                    Collections.sort(descendente, Collections.reverseOrder());

                    System.out.println("Lista en orden ascendente:");
                    for (int num : ascendente) {
                        System.out.println(num);
                    }

                    System.out.println("Lista en orden descendente:");
                    for (int num : descendente) {
                        System.out.println(num);
                    }
                    break;
                case 6:
                    System.out.println("Ingresaste la opción 6");

                    Matriz matriz = new Matriz();
                    scanner.nextLine(); // Consume the newline

                    while (true) {
                        System.out.println("Ingrese el valor para la celda (o 'FIN' para terminar):");
                        String valor = scanner.nextLine();
                        if (valor.equalsIgnoreCase("FIN")) {
                            break;
                        }

                        System.out.println("Ingrese la fila:");
                        int fila = scanner.nextInt();
                        System.out.println("Ingrese la columna:");
                        int columna = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        Celda celda = new Celda(fila, columna, valor);
                        matriz.agregarCelda(celda);
                    }

                    System.out.println("Valores cargados en matrizCuadrada:");
                    matriz.mostrarMatriz();

                    System.out.println("Ingrese la fila para obtener el valor:");
                    int fila = scanner.nextInt();
                    System.out.println("Ingrese la columna para obtener el valor:");
                    int columna = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    String valorObtenido = matriz.obtenerValor(fila, columna);
                    System.out.println("Valor obtenido: " + valorObtenido);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}