//poder modificar nombre correo y telefono

import java.time.LocalDate;
import java.util.*;
public class gestorContactos {
    static List <contacto> ListaContactos = new ArrayList<>();
    
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("1: Crear direccion");
        System.out.println("1: Crear nuevo contacto");
        System.out.println("2: Modificar contacto");
        System.out.println("3: Salir");
        System.out.println("*****************************");
        System.out.println("Que opcion quieres elegir");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                crearContacto(scanner, ListaContactos);
                break;
            default:
                throw new AssertionError();
        }
    } while (opcion != 3);
}
    private static

    private static void crearContacto(Scanner scanner, List<contacto> ListaContactos) {
        String nombreContacto, alias, numTelefono, correoElectronico;
        String fechasImportantes;
        direccion direccion;
        datosTrabajo datosTrabajo;
        boolean datosValidos;

        do { 
            datosValidos = true;
            try {
                scanner.nextLine();
                System.out.println("Introduce el nombre del contacto");
                nombreContacto = scanner.nextLine();
                System.out.println("Introduce el alias");
                alias = scanner.nextLine();
                System.out.println("Introduce el numero de telefono");
                numTelefono = scanner.nextLine();
                System.out.println("Introduce el correoElectronico");
                correoElectronico = scanner.nextLine();
                System.out.println("Introduce una fecha importante");
                fechasImportantes = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(fechasImportantes);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
                datosValidos = false;
            }
        } while (!datosValidos);
    }
}
