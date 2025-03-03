//poder modificar nombre correo y telefono

import java.time.LocalDate;
import java.util.*;
public class gestorContactos {
    static List <contacto> ListaContactos = new ArrayList<>();
    static List <direccion> ListaDireccion = new ArrayList<>();
    static List <datosTrabajo> ListaDatosTra = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int opcion;
    
public static void main(String[] args) {

    do {
        menu();
        switch (opcion) {
            case 1:
                crearDireccion();
                break;
            case 2:
                crearDatosTrabajo();
            break;
            case 3:
                crearContacto();
            break;
            case 4:
                crearContacto();
            break;
            case 5:
                System.out.println("Gracias por usar nuestro programa");;
            break;
            default:
                throw new AssertionError();
        }
    } while (opcion != 5);
}
    private static void menu(){
        System.out.println("1: Crear direccion");
        System.out.println("2: Crear datos de trabajo");
        System.out.println("3: Crear nuevo contacto");
        System.out.println("4: Modificar contacto");
        System.out.println("5: Salir");
        System.out.println("*****************************");
        System.out.println("Que opcion quieres elegir");
        opcion = input.nextInt();
    }
    private static void crearDireccion() {
        String avenida, pueblo_ciudad;
        int numeroPuerta;
        boolean datosValidos;
            do { 
                datosValidos = true;
                try {
                    input.nextLine();
                    System.out.println("Introduce el pueblo o ciudad");
                    pueblo_ciudad = input.nextLine();
                    System.out.println("Di la avenida");
                    avenida = input.nextLine();
                    System.out.println("Introduce el numero de puerta");
                    numeroPuerta = input.nextInt();
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
    private static void crearDatosTrabajo() {
    direccion direccionEmpresa;
    String correoEmpresa, numeroEmpresa, numeroEmpleado, correoEmpleado;
    boolean datosValidos;
        do {
            datosValidos = true;
            try {
                System.out.println("Introduce el correo de la empresa");
                correoEmpresa = input.nextLine();
                System.out.println("Introduce el numero de la empresa");
                numeroEmpresa = input.nextLine();
                System.out.println("Introduce el numero de empleados");
                numeroEmpleado = input.nextLine();
                System.out.println("Introduce el correo del empleado");
                correoEmpleado = input.nextLine();
                System.out.println("Introduce la direccion");
                    
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
                datosValidos = false;
            }
        } while (!datosValidos);
    
    }
    private static void crearContacto() {
        String nombreContacto, alias, numTelefono, correoElectronico;
        String fechasImportantes;
        direccion direccion;
        datosTrabajo datosTrabajo;
        boolean datosValidos;

        do { 
            datosValidos = true;
            try {
                input.nextLine();
                System.out.println("Introduce el nombre del contacto");
                nombreContacto = input.nextLine();
                System.out.println("Introduce el alias");
                alias = input.nextLine();
                System.out.println("Introduce el numero de telefono");
                numTelefono = input.nextLine();
                System.out.println("Introduce el correoElectronico");
                correoElectronico = input.nextLine();
                System.out.println("Introduce una fecha importante");
                fechasImportantes = input.nextLine();
                LocalDate localDate = LocalDate.parse(fechasImportantes);
                System.out.println("Elige una direccion");
                        for (int j = 0; j < ListaDireccion.size(); j++) {
                            System.out.println((j + 1) + " : " + ListaDireccion.get(j).toString());
                        }
                        System.out.println("Numero de la direccion");
                        int numDir = input.nextInt();
                        input.nextLine();
                        if (numDir < 1 || numDir > ListaDireccion.size()) {
                            throw new IllegalArgumentException("Debe de estar dentro del rango");
                        }

                System.out.println("Elige unos datos");
                        for (int i = 0; i < ListaDatosTra.size(); i++) {
                            System.out.println((1 + i) + " : " + ListaDatosTra.get(i).toString());
                        }
                        System.out.println("Numero de los datos");
                        int numDat = input.nextInt();
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
