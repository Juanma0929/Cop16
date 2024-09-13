//Entradas: Opcion, nombres[], area[], opcionDepto
//Salidas: nombres[], area[], departamentos[], nombresDeptos[], conteoDeptos[]

//Análisis: El programa le pregunta al usuario cuál opción de las siguientes opciones desea realizar: 
//Registrar el lugar biodiverso, consultar los lugares ordenados de menor a mayor con respecto al área, 
//consultar el departamento con más lugares registrados y salir del programa. Si el usuario elige la 
//opción de registrar el lugar, se le pide que digite el nombre del lugar, el área del lugar en km 
//cuadrados y el departamento en el que está ubicado. Si elige consultar los lugares ordenados de menor a 
//mayor respector al área, se le muestra una lista de los lugares en ese orden, con su nombre, área y departamento. 
//Si se eligle la tercera opción, se le muestra al usuario el nombre del departamento con más lugares registrados.
//Los procedimientos para llegar a estas opciones se hacen de manera interna en el código, con arreglos y
//ciclos "for" que los recorren.
import java.util.Scanner;

public class TareaIntegradora2 {

    private static String[] nombres = new String[100];      
    private static int[] areas = new int[100];              
    private static String[] departamentos = new String[100]; 
    private static int contador = 0; 
    private static Scanner LectorScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nBienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
        int Opcion;
        do {
            mostrarMenu();
            Opcion = LectorScanner.nextInt();
            LectorScanner.nextLine();

            switch (Opcion) {
                case 1:
                    registrarLugar();
                    break;
                case 2:
                    mostrarLugaresOrdenados();
                    break;
                case 3:
                    mostrarDepartamentoConMasLugares();
                    break;
                case 4:
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción entre 1 y 4.");
            }
        } while (Opcion != 4);

        LectorScanner.close();
    }

    /**
     * Muestra el menú con las opciones de aqullo que puede realizar el usuario, que es: Registrar el lugar biodiverso, 
     * consultar los lugares ordenados de menor a mayor con respecto al área, consultar el departamento con más lugares registrados
     * y salir del programa
     */
    private static void mostrarMenu() {
        System.out.println("Te presentamos las siguientes opciones:");
        System.out.println("1. Para registrar un lugar con diversidad biológica");
        System.out.println("2. Para consultar los lugares ordenados de menor a mayor con respecto al área");
        System.out.println("3. Para consultar el departamento que tiene más lugares registrados");
        System.out.println("4. Para salir del programa.");
        System.out.print("Elija una opción: ");
    }

    /**
     * Método para registrar el lugar biodiverso. Primero se le pide al usuario que digite el nombre del lugar biodiverso,
     * después que ingrese su área y el departamento correspondiente. Al final, si aquello que digite el usuario cumple las
     * condiciones (Registra en uno de los 4 departamentos disponibles menos de 100 lugares), se le muestra un mensaje de confirmación;
     * de lo contrario, uno de error
     */
    private static void registrarLugar() {
        if (contador >= 100) {
            System.out.println("No se pueden registrar más lugares, capacidad máxima alcanzada.");
            return;
        }

        System.out.println("Ingresa el nombre del lugar biodiverso:");
        nombres[contador] = LectorScanner.nextLine();

        System.out.println("Ingresa el área en kilómetros cuadrados:");
        areas[contador] = LectorScanner.nextInt();
        LectorScanner.nextLine();

        System.out.println("Ingresa el departamento correspondiente:");
        System.out.println("1. Chocó");
        System.out.println("2. Valle");
        System.out.println("3. Cauca");
        System.out.println("4. Nariño");
        int opcionDepto = LectorScanner.nextInt();
        LectorScanner.nextLine();

        departamentos[contador] = obtenerNombreDepartamento(opcionDepto);
        if (departamentos[contador] == null) {
            System.out.println("Opción inválida, departamento no registrado.");
        } else {
            System.out.println("Lugar biodiverso agregado correctamente.");
            contador++;
        }
    }

    /**
     * Método que le muestra al usuario los nombres de los departamentos disponibles para registrar un 
     * lugar biodiverso
     * @param opcionDepto Variable de la clase interger usada para elegir la opción del departamento en el cual
     * el usuario registrará el lugar biodiverso. Solo acepta números del 1 al 4 (cantidad de departamentos)
     * @return Retorna la opción que el usuario digitó
     */
    private static String obtenerNombreDepartamento(int opcionDepto) {
        switch (opcionDepto) {
            case 1: return "Chocó";
            case 2: return "Valle";
            case 3: return "Cauca";
            case 4: return "Nariño";
            default: return null;
        }
    }

    /**
     * Método para mostrar los lugares ordenados de mayor a menor área
     */
    private static void mostrarLugaresOrdenados() {
        if (contador == 0) {
            System.out.println("No hay lugares registrados.");
            return;
        }

        System.out.println("Lugares ordenados de menor a mayor según el área:");
        
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (areas[j] > areas[j + 1]) {
                    intercambiar(j, j + 1);
                }
            }
        }

        for (int i = 0; i < contador; i++) {
            System.out.println(nombres[i] + " (Área: " + areas[i] + " km², Departamento: " + departamentos[i] + ")");
        }
    }

    /**
     * Método que cambia la posiciones en el arreglo, para ordenar los lugares registrados de mayor a menor área.
     * Se se hace el proceso de intercambio con área, nombre y departamento
     * @param a
     * @param b
     */
    private static void intercambiar(int a, int b) {
        // Intercambiar área
        int tempArea = areas[a];
        areas[a] = areas[b];
        areas[b] = tempArea;

        // Intercambiar nombre
        String tempNombre = nombres[a];
        nombres[a] = nombres[b];
        nombres[b] = tempNombre;

        // Intercambiar departamento
        String tempDepto = departamentos[a];
        departamentos[a] = departamentos[b];
        departamentos[b] = tempDepto;
    }

    /**
     * Método utilizado para contar cuántos lugares se han registrado por departamento, y posteriormente, mostrar
     * al usuario aquel departamento con más lugares registrados
     */
    private static void mostrarDepartamentoConMasLugares() {
        if (contador == 0) {
            System.out.println("No hay lugares registrados.");
            return;
        }

        int[] conteoDeptos = new int[4]; // Contador para cada departamento

        for (int i = 0; i < contador; i++) {
            switch (departamentos[i]) {
                case "Chocó": conteoDeptos[0]++; break;
                case "Valle": conteoDeptos[1]++; break;
                case "Cauca": conteoDeptos[2]++; break;
                case "Nariño": conteoDeptos[3]++; break;
            }
        }

        // Encontrar el departamento con más lugares
        String[] nombresDeptos = { "Chocó", "Valle", "Cauca", "Nariño" };
        int maxIndex = 0;
        for (int i = 1; i < 4; i++) {
            if (conteoDeptos[i] > conteoDeptos[maxIndex]) {
                maxIndex = i;
            }
        }

        System.out.println("El departamento con más lugares registrados es " + nombresDeptos[maxIndex] + " con " + conteoDeptos[maxIndex] + " lugares.");
    }
}
