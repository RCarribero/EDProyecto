//poder modificar nombre correo y telefono

import java.time.LocalDate;
import java.util.*;
import java.io.IOException;

public class gestorContactos {
    static List<contacto> ListaContactos = new ArrayList<>();
    static List<direccion> ListaDireccion = new ArrayList<>();
    static List<datosTrabajo> ListaDatosTra = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static int opcion,Numero_puerta;
    static String Avenida,Pueblo_Ciudad,correoEmpresa,numeroEmpresa,numeroEmpleado,correoEmpleado;
    static String nombreContacto,alias,numTelefono,correoElectronico;
    static LocalDate fechasImportantes;

    public static void main(String[] args) {
        inicializarDatosPredeterminados();
        do {
            clear();
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
                    modificarContacto();
                    break;
                case 5:
                    System.out.println("Gracias por usar nuestro programa");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 5);
    }

    public static void inicializarDatosPredeterminados() {
        // Agregar direcciones predeterminadas
        ListaDireccion.add(new direccion(101,"Avenida Principal", "Ciudad Ejemplo"));
        ListaDireccion.add(new direccion(202,"Calle Secundaria", "Pueblo Demo"));
    
        // Agregar datos de trabajo predeterminados
        ListaDatosTra.add(new datosTrabajo("empresa@ejemplo.com", "123456789", "50", "empleado@ejemplo.com"));
        ListaDatosTra.add(new datosTrabajo("negocio@demo.com", "987654321", "100", "trabajador@demo.com"));
    
        // Agregar contactos predeterminados
        ListaContactos.add(new contacto("Juan Pérez", "JP", "111222333", "juan@example.com", LocalDate.of(1990, 5, 15)));
        ListaContactos.add(new contacto("María López", "ML", "444555666", "maria@example.com", LocalDate.of(1985, 10, 20)));
    }
    

    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void modificarContacto() {
        String nombreContacto, alias, numTelefono, correoElectronico;
        String fechasImportantes;
        boolean datosValidos = true;
        contacto contacto2 = new contacto();
        for (contacto contacto : ListaContactos) {
            System.out.println(contacto);
        }
        System.out.println("Dime el numero del contacto que quieres modificar");
        String numTelf = input.nextLine();
        for (contacto contacto : ListaContactos) {
            if (numTelf.equalsIgnoreCase(contacto.getNumTelefono())) {
                contacto2 = contacto;
            }
        }

        do {
            datosValidos = true;
            try {
                input.nextLine();
                do {
                    try {
                        datosValidos = true;
                        System.out.println("Introduce el nombre del contacto");
                        nombreContacto = input.nextLine();
                        contacto2.setNombreContacto(nombreContacto);
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
                        contacto2.setAlias(alias);
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
                        contacto2.setNumTelefono(numTelefono);
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
                        contacto2.setCorreoElectronico(correoElectronico);
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
                        contacto2.setFechasImportantes(localDate);
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

    private static void menu() {
        System.out.println("1: Crear direccion");
        System.out.println("2: Crear datos de trabajo");
        System.out.println("3: Crear nuevo contacto");
        System.out.println("4: Modificar contacto");
        System.out.println("5: Salir");
        System.out.println("*****************************");
        System.out.println("Que opcion quieres elegir");
        opcion = input.nextInt();
        input.nextLine();
    }

    private static void crearDireccion() {
        ListaDireccion.add(new direccion());
        String avenida, pueblo_ciudad;
        int numeroPuerta;
        boolean datosValidos;
        do {
            datosValidos = true;
            try {
                input.nextLine();
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

    private static void crearDatosTrabajo() {
        String correoEmpresa, numeroEmpresa, numeroEmpleado, correoEmpleado;
        boolean datosValidos;
        ListaDatosTra.add(new datosTrabajo());
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

    private static void crearContacto() {
        String nombreContacto, alias, numTelefono, correoElectronico;
        String fechasImportantes;
        boolean datosValidos = true;
        ListaContactos.add(new contacto());

        do {
            try {
                input.nextLine();
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
}
