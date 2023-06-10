package main.java.menu;

import main.java.arreglos.UsuarioArray;
import main.java.clases.Bungalow;
import main.java.clases.Productos;
import main.java.clases.Usuario;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    private static final String USER = "admin"; // Reemplaza "usuario" con el valor correcto
    private static final String PASS = "admin"; // Reemplaza "contrasena" con el valor correcto

    public static void main(String[] args) {

        login();
        UsuarioArray userArray;

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Productos> productos = new ArrayList<>();
        ArrayList<Bungalow> bungalows = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("==== MENÚ ====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar producto");
            System.out.println("3. Registrar hospedaje");
            System.out.println("4. Buscar usuario");
            System.out.println("5. Buscar producto");
            System.out.println("6. Buscar hospedaje");
            System.out.println("7. Eliminar usuario");
            System.out.println("8. Eliminar producto");
            System.out.println("9. Eliminar hospedaje");
            System.out.println("10. Listar usuarios");
            System.out.println("11. Listar productos");
            System.out.println("12. Listar hospedajes");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    registrarUsuario(scanner, usuarios);
                    break;
                case 2:
                    registrarProducto(scanner, productos);
                    break;
                case 3:
                    registrarHospedaje(scanner, bungalows);
                    break;
                case 4:
                    buscarUsuario(scanner, usuarios);
                    break;
                case 5:
                    buscarProducto(scanner, productos);
                    break;
                case 6:
                    buscarHospedaje(scanner, bungalows);
                    break;
                case 7:
                    eliminarUsuario(scanner, usuarios);
                    break;
                case 8:
                    eliminarProducto(scanner, productos);
                    break;
                case 9:
                    eliminarHospedaje(scanner, bungalows);
                    break;
                case 10:
                    listarUsuarios(usuarios);
                    break;
                case 11:
                    listarProductos(productos);
                    break;
                case 12:
                    listarHospedajes(bungalows);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);
    }
        private static void registrarUsuario(Scanner scanner, ArrayList <Usuario> usuarios) {
            System.out.println("=== Registrar Usuario ===");
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            Usuario usuario = new Usuario(codigo, nombre, apellido, dni, telefono);
            usuarios.add(usuario);
            System.out.println("¡Usuario registrado exitosamente!");
        }

    private static void registrarProducto(Scanner scanner, ArrayList<Productos> productos) {
        System.out.println("=== Registrar Producto ===");
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Detalles: ");
        String detalles = scanner.nextLine();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        Productos producto = new Productos(id, detalles, stock, precioUnitario);
        productos.add(producto);
        System.out.println("¡Producto registrado exitosamente!");
    }
    private static void eliminarUsuario(Scanner scanner, ArrayList<Usuario> usuarios) {
        System.out.println("=== Eliminar Usuario===");
        System.out.print("Ingrese el código del usuario a eliminar: ");
        int codigo = scanner.nextInt();

        boolean usuarioEliminado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getUserId() == codigo) {
                usuarios.remove(usuario);
                usuarioEliminado = true;
                break;
            }
        }

        if (usuarioEliminado) {
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void listarUsuarios(ArrayList<Usuario> usuarios) {
        UsuarioArray usuarioArray;
        System.out.println("=== Listado de Usuarios ===");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void listarProductos(ArrayList<Productos> productos) {
        System.out.println("=== Listado de Productos ===");
        for (Productos producto : productos) {
            System.out.println(producto);
        }
    }

    private static void listarHospedajes(ArrayList<Bungalow> hospedajes) {
        System.out.println("=== Listado de Hospedajes ===");
        for (Bungalow hospedaje : hospedajes) {
            System.out.println(hospedaje);
        }
    }

    private static void registrarHospedaje(Scanner scanner, ArrayList<Bungalow> hospedajes) {
        System.out.println("=== Registrar Hospedaje ===");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Categoría: ");
        int categoria = scanner.nextInt();
        System.out.print("Precio por día: ");
        double precioDia = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Estado: ");
        int estado = scanner.nextInt();

        Bungalow bungalow = new Bungalow(codigo, categoria, precioDia, estado);
        hospedajes.add(bungalow);
        System.out.println("¡Hospedaje registrado exitosamente!");
    }

    private static void buscarUsuario(Scanner scanner, ArrayList<Usuario> usuarios) {
        System.out.println("=== Buscar Usuario ===");
        System.out.print("Ingrese el código del usuario: ");
        int codigo = scanner.nextInt();

        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getUserId() == codigo) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            System.out.println("Usuario encontrado:");
            System.out.println(usuarioEncontrado);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void buscarProducto(Scanner scanner, ArrayList<Productos> productos) {
        System.out.println("=== Buscar Producto ===");
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();

        Productos productoEncontrado = null;
        for (Productos producto : productos) {
            if (producto.getProductId() == id) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println(productoEncontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void buscarHospedaje(Scanner scanner, ArrayList<Bungalow> bungalows) {
        System.out.println("=== Buscar Hospedaje ===");
        System.out.print("Ingrese el código del hospedaje: ");
        int codigo = scanner.nextInt();

        Bungalow hospedajeEncontrado = null;
        for (Bungalow bungalow : bungalows) {
            if (bungalow.getBungalowId() == codigo) {
                hospedajeEncontrado = bungalow;
                break;
            }
        }

        if (hospedajeEncontrado != null) {
            System.out.println("Hospedaje encontrado:");
            System.out.println(hospedajeEncontrado);
        } else {
            System.out.println("Hospedaje no encontrado.");
        }
    }

    private static void eliminarProducto(Scanner scanner, ArrayList<Productos> productos) {
        System.out.println("=== Eliminar Producto ===");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();

        boolean productoEliminado = false;
        for (Productos producto : productos) {
            if (producto.getProductId() == id) {
                productos.remove(producto);
                productoEliminado = true;
                break;
            }
        }

        if (productoEliminado) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void eliminarHospedaje(Scanner scanner, ArrayList<Bungalow> bungalows) {
        System.out.println("=== Eliminar Hospedaje ===");
        System.out.print("Ingrese el código del hospedaje a eliminar: ");
        int codigo = scanner.nextInt();

        boolean hospedajeEliminado = false;
        for (Bungalow bungalow : bungalows) {
            if (bungalow.getBungalowId() == codigo) {
                bungalows.remove(bungalow);
                hospedajeEliminado = true;
                break;
            }
        }

        if (hospedajeEliminado) {
            System.out.println("Hospedaje eliminado exitosamente.");
        } else {
            System.out.println("Hospedaje no encontrado.");
        }
    }

    public static void login() {
        setTitle("LOGIN");
        boolean entry = false;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            clearScreen();
            System.out.println("\n"
                    + "                                          _    _____ _     _                       \n"
                    + "     /\\                                  | |  / ____(_)   | |                      \n"
                    + "    /  \\   ___ ___ ___  ___  ___     __ _| | | (___  _ ___| |_ ___ _ __ ___   __ _ \n"
                    + "   / /\\ \\ / __/ __/ _ \\/ __|/ _ \\   / _` | |  \\___ \\| / __| __/ _ \\ '_ ` _ \\ / _` |\n"
                    + "  / ____ \\ (_| (_|  __/\\__ \\ (_) | | (_| | |  ____) | \\__ \\ ||  __/ | | | | | (_| |\n"
                    + " /_/    \\_\\___\\___\\___||___/\\___/   \\__,_|_| |_____/|_|___/\\__\\___|_| |_| |_|\\__,_|\n"
                    + "                                                                                   \n"
                    + "                                                                                   ");
            System.out.println("\t\t\t\n"
                    + "\t\t   _   _   _   _   _   _   _   _   _   _  \n"
                    + "\t\t  / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n"
                    + "\t\t ( E ( D ( 2 ( 0 ( 2 ( 0 ( - ( S ( V ( M )\n"
                    + "\t\t  \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \n");
            System.out.println();
            System.out.print("\t\t * Usuario : ");
            String username = scanner.nextLine();
            System.out.print("\t  * Seguro");
            String password = "admin";

            if (username.equals(USER) && password.equals(PASS)) {
                System.out.println("\t\t\nVALIDACIÓN Y CLAVE CONFORME");
                entry = true;
                scanner.nextLine();
                pause();
                clearScreen();
                System.out.println("\n");
            } else {
                System.out.println("Usuario o Contraseña incorrecta");
                attempts++;
                scanner.nextLine();
            }
        } while (!entry && attempts < 3);

        if (entry) {
            setColor(11);
            banners();
            menuMain();
        } else {
            System.out.println("\tHa sobrepasado el número permitido de intentos");
            System.exit(1);
        }
    }

    public static void setTitle(String title) {
        System.out.print("\033]0;" + title + "\007");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String hidePasswordInput() {
        String password = "";
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();

        if (console == null) {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                try {
                    ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "cmdkey", "/c");
                    builder.redirectErrorStream(true);
                    Process process = builder.start();
                    process.waitFor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                try {
                    Runtime.getRuntime().exec("clear");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            ConsoleEraser consoleEraser = new ConsoleEraser();
            Thread eraserThread = new Thread(consoleEraser);
            eraserThread.start();
            password = scanner.nextLine();
            consoleEraser.stop();
        }

        return password;
    }

    public static void pause() {
        try {
            System.out.print("Presione Enter para continuar...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setColor(int colorCode) {
        System.out.print("\033[0;" + colorCode + "m");
    }

    public static void banners() {
        // Aquí puedes agregar el código para mostrar los banners
    }

    public static void menuMain() {
        // Aquí puedes agregar el código para mostrar el menú principal
    }

    // Clase auxiliar para borrar la entrada de la contraseña
    static class ConsoleEraser implements Runnable {
        private volatile boolean running = true;

        public void stop() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                System.out.print("\010*");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}