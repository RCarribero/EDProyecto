/**
 * Clase gestorContactos
 * 
 * Esta clase gestiona una lista de contactos, direcciones y datos de trabajo.
 * Permite crear, modificar y visualizar contactos.
 * @author David Rodriguez, Ruben Venegas, Alejandro Vallin, Felix Venegas, Jose Luis Quevedo
 * @version 1.0
 */

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Clase principal para gestionar contactos.
 */
public class gestorContactos {
    static List<contacto> ListaContactos = new ArrayList<>(); // Lista de contactos
    static List<direccion> ListaDireccion = new ArrayList<>(); // Lista de direcciones
    static List<datosTrabajo> ListaDatosTra = new ArrayList<>(); // Lista de datos de trabajo
    static Scanner input = new Scanner(System.in);
    static int opcion, Numero_puerta; // Variables del programa
    static String Avenida, Pueblo_Ciudad, correoEmpresa, numeroEmpresa, numeroEmpleado, correoEmpleado; // Variables del programa
    static String nombreContacto, alias, numTelefono, correoElectronico; // Variables del programa
    static LocalDate fechasImportantes; // Variables del programa

    /**
     * Método principal que inicia el programa.
    */
    public static void main(String[] args) {
        inicializarDatosPredeterminados();
        do {
            menu();
            System.out.print("❇️  Opción: ");
            opcion = input.nextInt();
            input.nextLine();
            // Switch de opciones para las opciones que queramos
            switch (opcion) {
                case 1:
                    crearDireccion(); // Llamamos al método crearDireccion()
                    break;
                case 2:
                    crearDatosTrabajo();
                    break;
                case 3:
                    crearContacto();
                    break;
                case 4:
                    modificarContacto();
                    break;
                case 5:
                    verContactoEspecifico();
                    break;
                case 6:
                   mostrarTodosDatos();
                    break;
                case 7:
                    System.out.println("Gracias por usar nuestro programa");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 7);
    }

    /**
     * Inicializa datos predeterminados para direcciones, datos de trabajo y contactos.
     */
    public static void inicializarDatosPredeterminados() {
        // Agregar direcciones predeterminadas
        ListaDireccion.add(new direccion(50, "Avenida Principal", "Ciudad Ejemplo"));
        ListaDireccion.add(new direccion(51, "Calle Secundaria", "Pueblo Demo"));

        // Agregar datos de trabajo predeterminados
        ListaDatosTra.add(new datosTrabajo("empresa@ejemplo.com", "123456789", "123456789", "empleado@ejemplo.com"));
        ListaDatosTra.add(new datosTrabajo("negocio@demo.com", "987654321", "987654321", "trabajador@demo.com"));

        // Agregar contactos predeterminados
        ListaContactos.add(new contacto("Juan Pérez", "JPE", "741258963", "juan@example.com", LocalDate.of(1990, 5, 15),
                ListaDireccion.get(0), ListaDatosTra.get(0)));
        ListaContactos.add(new contacto("María López", "MLA", "369852147", "maria@example.com",
                LocalDate.of(1985, 10, 20), ListaDireccion.get(1), ListaDatosTra.get(1)));
    }

    /**
     * Muestra la información completa de un contacto específico basado en su número de teléfono.
     */
    public static void verContactoEspecifico() {
        System.out.println("5️⃣  Ver contacto especifico");
        System.out.println();
        try {
            System.out.println("Dime el numero de telefono que quieres ver su informacion completa: ");
            for (contacto contacto : ListaContactos) {
                System.out.println(contacto.getNumTelefono().toString());
            }
            String numMostrar = input.next();
            for (contacto contacto : ListaContactos) {
                if (contacto.getNumTelefono().equalsIgnoreCase(numMostrar)) {
                    System.out.println(contacto.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Algo fallo en ver contacto");
        }
    }

    /**
     * Limpia la consola.
     */
    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra todos los contactos en la lista.
     */
    public static void mostrarContacto() {
        for (contacto contacto : ListaContactos) {
            System.out.println(contacto);
        }
    }

    /**
     * Modifica la información de un contacto existente.
     */
    private static void modificarContacto() {
        clear();
        String nombreContacto, alias, numTelefono, correoElectronico;
        String fechasImportantes;
        boolean datosValidos = true;
        String numTelf = "";
        System.out.println("4️⃣  Modificar contacto");
        System.out.println();
        System.out.println("Lista contactos");
        mostrarContacto();
        System.out.println();
        System.out.println("Dime el numero del contacto que quieres modificar");
        numTelf = input.nextLine();
        for (contacto contacto : ListaContactos) {
            if (contacto.getNumTelefono().equalsIgnoreCase(numTelf)) {
                do {
                    datosValidos = true;
                    try {
                        input.nextLine();
                        do {
                            try {
                                datosValidos = true;
                                System.out.println("Introduce el nombre del contacto");
                                nombreContacto = input.nextLine();
                                contacto.setNombreContacto(nombreContacto);
                            } catch (Exception e) {
                                System.out.println(e);
                                datosValidos = false;
                            }
                        } while (!datosValidos);

                        do {
                            try {
                                datosValidos = true;
                                System.out.println("Introduce el alias");
                                alias = input.nextLine();
                                contacto.setAlias(alias);
                            } catch (Exception e) {
                                System.out.println(e);
                                datosValidos = false;
                            }
                        } while (!datosValidos);

                        do {
                            try {
                                datosValidos = true;
                                System.out.println("Introduce el numero de telefono");
                                numTelefono = input.nextLine();
                                contacto.setNumTelefono(numTelefono);
                            } catch (Exception e) {
                                System.out.println(e);
                                datosValidos = false;
                            }
                        } while (!datosValidos);

                        do {
                            try {
                                datosValidos = true;
                                System.out.println("Introduce el correoElectronico");
                                correoElectronico = input.nextLine();
                                contacto.setCorreoElectronico(correoElectronico);
                            } catch (Exception e) {
                                System.out.println(e);
                                datosValidos = false;
                            }
                        } while (!datosValidos);

                        do {
                            try {
                                datosValidos = true;
                                System.out.println("Introduce una fecha importante");
                                fechasImportantes = input.nextLine();
                                LocalDate localDate = LocalDate.parse(fechasImportantes);
                                contacto.setFechasImportantes(localDate);
                            } catch (Exception e) {
                                System.out.println(e);
                                datosValidos = false;
                            }
                        } while (!datosValidos);

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
    }

    /**
     * Muestra el menú de opciones.
     */
    private static void menu() {
        System.out.println("1️⃣  Crear direccion");
        System.out.println("2️⃣  Crear datos de trabajo");
        System.out.println("3️⃣  Crear nuevo contacto");
        System.out.println("4️⃣  Modificar contacto");
        System.out.println("5️⃣  Ver contacto especifico");
        System.out.println("6️⃣  Salir");
    }

    /**
     * Crea una nueva dirección y la agrega a la lista de direcciones.
     */
    private static void crearDireccion() {
        ListaDireccion.add(new direccion());
        String avenida, pueblo_ciudad;
        int numeroPuerta;
        boolean datosValidos;

        System.out.println("1️⃣  Crear direccion");
        System.out.println();
        do {
            datosValidos = true;
            try {
                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el pueblo o ciudad");
                        pueblo_ciudad = input.nextLine();
                        ListaDireccion.getLast().setPueblo_Ciudad(pueblo_ciudad);
                    } catch (Exception e) {
                        datosValidos = false;
                        System.out.println(e);
                    }
                } while (!datosValidos);
                do {
                    try {
                        datosValidos = true;
                        System.out.println("Di la avenida");
                        avenida = input.nextLine();
                        ListaDireccion.getLast().setAvenida(avenida);
                    } catch (Exception e) {
                        datosValidos = false;
                        System.out.println(e);
                    }
                } while (!datosValidos);
                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el numero de puerta");
                        numeroPuerta = input.nextInt();
                        ListaDireccion.getLast().setNumero_puerta(numeroPuerta);
                    } catch (Exception e) {
                        datosValidos = false;
                        System.out.println(e);
                    }
                } while (!datosValidos);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
                datosValidos = false;
            }
        } while (!datosValidos);

    }

    /**
     * Crea
 nuos
datos de trabajo y los agrega a la lista de datos de trabajo.
     */
    private static void crearDatosTrabajo() {
        String correoEmpresa, numeroEmpresa, numeroEmpleado, correoEmpleado;
        boolean datosValidos;
        ListaDatosTra.add(new datosTrabajo());

        System.out.println("2️⃣  Crear datos de trabajo");
        System.out.println();
        do {
            datosValidos = true;
            try {
                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el correo de la empresa");
                        correoEmpresa = input.nextLine();
                        ListaDatosTra.getLast().setCorreoEmpresa(correoEmpresa);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el numero de la empresa");
                        numeroEmpresa = input.nextLine();
                        ListaDatosTra.getLast().setNumeroEmpresa(numeroEmpresa);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el numero de empleados");
                        numeroEmpleado = input.nextLine();
                        ListaDatosTra.getLast().setNumeroEmpleado(numeroEmpleado);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el correo del empleado");
                        correoEmpleado = input.nextLine();
                        ListaDatosTra.getLast().setCorreoEmpleado(correoEmpleado);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                    do {
                        try {
                            datosValidos = true;

                        } catch (Exception e) {
                            System.out.println(e);
                            datosValidos = false;
                        }
                    } while (!datosValidos);
                } while (!datosValidos);

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e);
                datosValidos = false;
            }
        } while (!datosValidos);
    }

    /**
     * Crea un nuevo contacto y lo agrega a la lista de contactos.
     */
    private static void crearContacto() {
        String nombreContacto, alias, numTelefono, correoElectronico;
        String fechasImportantes;
        boolean datosValidos = true;
        ListaContactos.add(new contacto());

        System.out.println("");
        do {
            try {
                System.out.println("3️⃣  Crear nuevo contacto");
                System.out.println();
                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el nombre del contacto");
                        nombreContacto = input.nextLine();
                        ListaContactos.getLast().setNombreContacto(nombreContacto);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el alias");
                        alias = input.nextLine();
                        ListaContactos.getLast().setAlias(alias);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el numero de telefono");
                        numTelefono = input.nextLine();
                        ListaContactos.getLast().setNumTelefono(numTelefono);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el correoElectronico");
                        correoElectronico = input.nextLine();
                        ListaContactos.getLast().setCorreoElectronico(correoElectronico);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce una fecha importante");
                        fechasImportantes = input.nextLine();
                        LocalDate localDate = LocalDate.parse(fechasImportantes);
                        ListaContactos.getLast().setFechasImportantes(localDate);
                    } catch (Exception e) {
                        System.out.println(e);
                        datosValidos = false;
                    }
                } while (!datosValidos);

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

    static void mostrarTodosDatos(){
        System.out.println("6️⃣  Mostrar todos los datos");
        System.out.println();
        System.out.println("Datos contactos🪪📞");
        for (contacto contacto : ListaContactos) {
            System.out.println(contacto.toString());
        }

        System.out.println();
        
        System.out.println("Direcciones📱");
        for (direccion direccion : ListaDireccion) {
            System.out.println(direccion.toString());
        }
       
        System.out.println();

        System.out.println("Trabajos🛠️");
        for (datosTrabajo trabajo : ListaDatosTra) {
            System.out.println(trabajo.toString());
        }

        Enter(input);
    }
}