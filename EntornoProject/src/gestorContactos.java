//poder modificar nombre correo y telefono

import java.time.LocalDate;
import java.util.*;
public class gestorContactos {
    private static List <contacto> ListaContactos = new ArrayList<>();
    private static List <direccion> ListaDireccion = new ArrayList<>();
    private static List <datosTrabajo> ListaDatosTra = new ArrayList<>();
    
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("1: Crear direccion");
        System.out.println("2: Crear datos de trabajo");
        System.out.println("3: Crear nuevo contacto");
        System.out.println("2: Modificar contacto");
        System.out.println("3: Salir");
        System.out.println("*****************************");
        System.out.println("Que opcion quieres elegir");
        opcion = input.nextInt();

        switch (opcion) {
            case 1:
                crearDireccion(input, ListaDireccion);
                break;
            case 2:
                crearDatosTrabajo(input, ListaDatosTra);
            break;
            case 3:
                crearContacto(input, ListaContactos, ListaDireccion, ListaDatosTra);
            default:
                throw new AssertionError();
        }
    } while (opcion != 3);
}
    private static void crearDireccion(Scanner scanner, List<direccion> ListaDireccion) {
        String avenida, pueblo_ciudad;
        int numeroPuerta;
        boolean datosValidos;
            do { 
                datosValidos = true;
                try {
                    scanner.nextLine();
                    System.out.println("Introduce el pueblo o ciudad");
                    pueblo_ciudad = scanner.nextLine();
                    System.out.println("Di la avenida");
                    avenida = scanner.nextLine();
                    System.out.println("Introduce el numero de puerta");
                    numeroPuerta = scanner.nextInt();
                    ListaDireccion.add(new direccion(numeroPuerta, avenida, pueblo_ciudad));
                    System.out.println("Direccion guardada con exito");
                    ListaDireccion.add(new direccion(numeroPuerta, avenida, pueblo_ciudad));
                    System.out.println("Direccion creada con exito");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e);
                    datosValidos = false;
                }
            } while (!datosValidos);
            
    }
    private static void crearDatosTrabajo(Scanner scanner, List<datosTrabajo> ListaDatosT) {
    direccion direccionEmpresa;
    String correoEmpresa, numeroEmpresa, numeroEmpleado, correoEmpleado;
    boolean datosValidos;
        do {
            datosValidos = true;
            try {
                System.out.println("Introduce el correo de la empresa");
                correoEmpresa = scanner.nextLine();
                System.out.println("Introduce el numero de la empresa");
                numeroEmpresa = scanner.nextLine();
                System.out.println("Introduce el numero de empleados");
                numeroEmpleado = scanner.nextLine();
                System.out.println("Introduce el correo del empleado");
                correoEmpleado = scanner.nextLine();
                System.out.println("Introduce la direccion");
                    
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
                datosValidos = false;
            }
        } while (!datosValidos);
    
    }
    private static void crearContacto(Scanner scanner, List<contacto> ListaContactos, List<direccion> listaDireccion, List<datosTrabajo> listaDatosTra) {
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
                System.out.println("Elige una direccion");
                        for (int j = 0; j < ListaDireccion.size(); j++) {
                            System.out.println((j + 1) + " : " + ListaDireccion.get(j).toString());
                        }
                        System.out.println("Numero de la direccion");
                        int numDir = scanner.nextInt();
                        scanner.nextLine();
                        if (numDir < 1 || numDir > ListaDireccion.size()) {
                            throw new IllegalArgumentException("Debe de estar dentro del rango");
                        }

                System.out.println("Elige unos datos");
                        for (int i = 0; i < ListaDatosTra.size(); i++) {
                            System.out.println((1 + i) + " : " + ListaDatosTra.get(i).toString());
                        }
                        System.out.println("Numero de los datos");
                        int numDat = scanner.nextInt();
                        if (numDat < 1 || numDat > ListaDatosTra.size()) {
                            throw new IllegalArgumentException("Debe de estar dentro del rango");
                        }

                    
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
                datosValidos = false;
            }
        } while (!datosValidos);
    }
}
