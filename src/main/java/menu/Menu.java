package main.java.menu;

import main.java.arreglos.UsuarioArray;
import main.java.dto.BungalowDto;
import main.java.dto.ProductosDto;
import main.java.dto.UsuarioDto;
import main.java.facade.BungalowFacade;
import main.java.facade.ProductoFacade;
import main.java.facade.UsuarioFacade;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

    private static final String USER = "admin"; // Reemplaza "usuario" con el valor correcto
    private static final String PASS = "admin"; // Reemplaza "contrasena" con el valor correcto
    private static BungalowFacade bungalowFacade = new BungalowFacade();
    private static ProductoFacade productoFacade = new ProductoFacade();
    private static UsuarioFacade usuarioFacade = new UsuarioFacade();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        login();
        UsuarioArray userArray;

        ArrayList<UsuarioDto> usuarios = new ArrayList<>();
        ArrayList<ProductosDto> productos = new ArrayList<>();
        ArrayList<BungalowDto> bungalows = new ArrayList<>();

        int opcion;
        do {
            System.out.println("==== MENÚ ====");
            System.out.println("1. Usuario");
            System.out.println("2. Bungalow");
            System.out.println("3. Producto");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    clearScreen();
                    menuUsuario(scanner, usuarios);
                    break;
                case 2:
                    clearScreen();
                    menuBungalow();
                    break;
                case 3:
                    clearScreen();
                    menuProducto();
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

       /* int opcion;
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
                    //registrarHospedaje(scanner, bungalows);
                    registrarHospedaje();
                    break;
                case 4:
                    buscarUsuario(scanner, usuarios);
                    break;
                case 5:
                    buscarProducto(scanner, productos);
                    break;
                case 6:
                    //buscarHospedaje(scanner, bungalows);
                    buscarHospedaje();
                    break;
                case 7:
                    eliminarUsuario(scanner, usuarios);
                    break;
                case 8:
                    eliminarProducto(scanner, productos);
                    break;
                case 9:
                    //eliminarHospedaje(scanner, bungalows);
                    eliminarHospedaje();
                    break;
                case 10:
                    //listarUsuarios(usuarios);
                    listarUsuarios();
                    break;
                case 11:
                    listarProductos(productos);
                    break;
                case 12:
                    listarHospedajes();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);*/
    }

    public static void menuUsuario(Scanner scanner, ArrayList<UsuarioDto> usuarios) {
        int opcion;
        do {
            System.out.println("==== MANTENIMIENTO DE USUARIOS ====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("0. Volver");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    clearScreen();
                    registrarUsuario(scanner, usuarios);
                    break;
                case 2:
                    clearScreen();
                    buscarUsuario(scanner, usuarios);
                    break;
                case 3:
                    clearScreen();
                    eliminarUsuario(scanner, usuarios);
                    break;
                case 4:
                    clearScreen();
                    listarUsuarios();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);
    }

    public static void menuProducto() {
        int opcion;
        do {
            System.out.println("==== MANTENIMIENTO DE PRODUCTO ====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Listar producto");
            System.out.println("0. Volver");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    registrarProductos();
                    break;
                case 2:
                    buscarProductos();
                    break;
                case 3:
                    eliminarProductos();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);
    }

    public static void menuBungalow() {
        int opcion;
        do {
            System.out.println("==== MANTENIMIENTO DE BUNGALOW ====");
            System.out.println("1. Registrar bungalow");
            System.out.println("2. Buscar bungalow");
            System.out.println("3. Eliminar bungalow");
            System.out.println("4. Listar bungalow");
            System.out.println("0. Volver");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    clearScreen();
                    registrarHospedaje();
                    break;
                case 2:
                    clearScreen();
                    buscarHospedaje();
                    break;
                case 3:
                    clearScreen();
                    eliminarHospedaje();
                    break;
                case 4:
                    clearScreen();
                    listarHospedajes();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

            System.out.println();
        } while (opcion != 0);
    }

    private static void registrarUsuario(Scanner scanner, ArrayList<UsuarioDto> usuarios) {
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

        UsuarioDto usuario = new UsuarioDto(codigo, nombre, apellido, dni, telefono);
        usuarios.add(usuario);
        System.out.println("¡Usuario registrado exitosamente!");
    }

    private static void registrarProducto(Scanner scanner, ArrayList<ProductosDto> productos) {
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

        ProductosDto producto = new ProductosDto(id, detalles, stock, precioUnitario);
        productos.add(producto);
        System.out.println("¡Producto registrado exitosamente!");
    }

    private static void eliminarUsuario(Scanner scanner, ArrayList<UsuarioDto> usuarios) {
        System.out.println("=== Eliminar Usuario===");
        System.out.print("Ingrese el código del usuario a eliminar: ");
        int codigo = scanner.nextInt();

        boolean usuarioEliminado = false;
        for (UsuarioDto usuario : usuarios) {
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

    /*private static void listarUsuarios(ArrayList<UsuarioDto> usuarios) {
        UsuarioArray usuarioArray;
        System.out.println("=== Listado de Usuarios ===");
        for (UsuarioDto usuario : usuarios) {
            System.out.println(usuario);
        }
    }*/
    private static void listarUsuarios() {
        List<UsuarioDto> usuarioDtos = usuarioFacade.getAllBungalow();
       if (usuarioDtos.isEmpty()) {
           System.out.println("No hay clientes!");
       } else {
           System.out.println("Lista de Clientes!");
           for (UsuarioDto usuario : usuarioDtos) {
               System.out.println("CODIGO: " + usuario.getUserId());
               System.out.println("NOMBRE: " + usuario.getName());
               System.out.println("APELLIDO: " + usuario.getLastName());
               System.out.println("DNI: " + usuario.getDni());
               System.out.println("TELEFONO: " + usuario.getTelefono());
               System.out.println("---------------------");
           }
       }
    }

    /*private static void listarProductos(ArrayList<ProductosDto> productos) {
        System.out.println("=== Listado de Productos ===");
       // for (ProductosDto producto : productos) {
           // System.out.println(producto);
       // }
        List<ProductosDto> productosDto = productoFacade.getAllProducto();
        if (productosDto.isEmpty()) {
            System.out.println("No hay productos registrados");
        } else {
            System.out.println("Lista de stock de productos!");
            for (ProductosDto producto : productosDto) {
                System.out.println("CODIGO: " + producto.getProductId());
                System.out.println("DETALLE DE PRODUCTO: " + producto.getDetail());
                System.out.println("STOCK: " + producto.getStock());
                System.out.println("PRECIO UNITARIO: " + producto.getPriceUnit());
                System.out.println("---------------------");
            }
        }
    }*/

    private static void listarProductos() {
        System.out.println("=== Listado de Productos ===");
        // for (ProductosDto producto : productos) {
        // System.out.println(producto);
        // }
        List<ProductosDto> productosDto = productoFacade.getAllProducto();
        if (productosDto.isEmpty()) {
            System.out.println("No hay productos registrados");
        } else {
            System.out.println("Lista de stock de productos!");
            for (ProductosDto producto : productosDto) {
                System.out.println("CODIGO: " + producto.getProductId());
                System.out.println("DETALLE DE PRODUCTO: " + producto.getDetail());
                System.out.println("STOCK: " + producto.getStock());
                System.out.println("PRECIO UNITARIO: " + producto.getPriceUnit());
                System.out.println("---------------------");
            }
        }
    }
    /*private static void listarHospedajes(ArrayList<Bungalow> hospedajes) {
        System.out.println("=== Listado de Hospedajes ===");
        for (Bungalow hospedaje : hospedajes) {
            System.out.println(hospedaje);
        }
    }*/
    private static void listarHospedajes() {
        List<BungalowDto> bungalowDto = bungalowFacade.getAllBungalow();
        if (bungalowDto.isEmpty()) {
            System.out.println("No hay habitaciones registradas");
        } else {
            System.out.println("Lista de Habitaciones Disponible!");
            for (BungalowDto bungalow : bungalowDto) {
                System.out.println("CODIGO: " + bungalow.getBungalowId());
                System.out.println("CATEGORIA: " + bungalow.getCategory());
                System.out.println("PRECIO: " + bungalow.getPriceDay());
                System.out.println("ESTADO: " + bungalow.getStatusRoom());
                System.out.println("---------------------");
            }
        }
    }

    /*private static void registrarHospedaje(Scanner scanner, ArrayList<BungalowDto> hospedajes) {
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

        BungalowDto bungalow = new BungalowDto(codigo, categoria, precioDia, estado);
        hospedajes.add(bungalow);
        System.out.println("¡Hospedaje registrado exitosamente!");
    }*/

    private static void registrarHospedaje() {
        System.out.println("=== Registrar Hospedaje ===");
        System.out.print("Ingresa el código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese categoría: ");
        int categoria = scanner.nextInt();
        System.out.print("Ingrese Precio por día: ");
        double precioDia = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese Estado: ");
        int estado = scanner.nextInt();

        BungalowDto bungalowDto = new BungalowDto();
        bungalowDto.setBungalowId(codigo);
        bungalowDto.setCategory(categoria);
        bungalowDto.setPriceDay(precioDia);
        bungalowDto.setStatusRoom(estado);

        bungalowFacade.registerBungalow(bungalowDto);
        System.out.println("¡Hospedaje registrado exitosamente!");
    }

    private static void buscarUsuario(Scanner scanner, ArrayList<UsuarioDto> usuarios) {
        System.out.println("=== Buscar Usuario ===");
        System.out.print("Ingrese el código del usuario: ");
        int codigo = scanner.nextInt();

        UsuarioDto usuarioEncontrado = null;
        for (UsuarioDto usuario : usuarios) {
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

   /* private static void buscarProductos(Scanner scanner, ArrayList<ProductosDto> producto) {
        System.out.println("=== Buscar Producto ===");
        System.out.print("Ingrese el código del producto: ");
        int id = scanner.nextInt();

        ProductosDto productoEncontrado = null;
        for (ProductosDto product : producto) {
            if (product.getProductId() == id) {
                productoEncontrado = product;
                break;
            }
        }

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println(productoEncontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }*/

   private static void buscarProductos() {
       System.out.println("=== Buscar Producto ===");
       System.out.print("Ingrese el código del producto: ");
       int id = scanner.nextInt();
       ProductosDto productosDto = productoFacade.getProducto(id);
       if (productosDto != null) {
           System.out.println("Código: " + productosDto.getProductId());
           System.out.println("Detalle del producto: " + productosDto.getDetail());
           System.out.println("Stock del producto: " + productosDto.getStock());
           System.out.println("Precio unitario: " + productosDto.getPriceUnit());
       } else {
           System.out.println("No existe ese codigo de Producto");
       }

   }

    /*private static void buscarHospedaje(Scanner scanner, ArrayList<BungalowDto> bungalows) {
        System.out.println("=== Buscar Hospedaje ===");
        System.out.print("Ingrese el código del hospedaje: ");
        int codigo = scanner.nextInt();

        BungalowDto hospedajeEncontrado = null;
        for (BungalowDto bungalow : bungalows) {
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
    }*/

    private static void buscarHospedaje() {
        System.out.println("=== Buscar Hospedaje ===");
        System.out.print("Ingrese el código del hospedaje: ");
        int codigo = scanner.nextInt();

        BungalowDto bungalowDto = bungalowFacade.getBungalow(codigo);
        if (bungalowDto != null) {
            System.out.println("Codigo: " + bungalowDto.getBungalowId());
            System.out.println("Categoria: " + bungalowDto.getCategory());
            System.out.println("Precio x Dia: " + bungalowDto.getPriceDay());
            System.out.println("Estado: " + bungalowDto.getStatusRoom());
        } else {
            System.out.println("No existe ese codigo de Bungalow");
        }
    }

    /*private static void eliminarProductos(Scanner scanner, ArrayList<ProductosDto> productos) {
        System.out.println("=== Eliminar Producto ===");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();

        boolean productoEliminado = false;
        for (ProductosDto producto : productos) {
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
    }*/

    private static void eliminarProductos() {
        System.out.println("=== Eliminar Producto ===");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        ProductosDto productosDto = productoFacade.getProducto(id);
        if (productosDto != null) {
            productoFacade.deleteProducto(id);
            System.out.println("El Producto se elimino correctamente");
        } else {
            System.out.println("No se encontro el producto con ese codigo");
        }
    }
    /*private static void eliminarHospedaje(Scanner scanner, ArrayList<BungalowDto> bungalows) {
        System.out.println("=== Eliminar Hospedaje ===");
        System.out.print("Ingrese el código del hospedaje a eliminar: ");
        int codigo = scanner.nextInt();

        boolean hospedajeEliminado = false;
        for (BungalowDto bungalow : bungalows) {
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
    }*/

    private static void eliminarHospedaje() {
        System.out.println("=== Eliminar Hospedaje ===");
        System.out.print("Ingrese el código del hospedaje a eliminar: ");
        int codigo = scanner.nextInt();
        BungalowDto bungalowDto = bungalowFacade.getBungalow(codigo);
        if (bungalowDto != null) {
            bungalowFacade.deleteBungalow(codigo);
            System.out.println("El Bungalow se elimino correctamente");
        } else {
            System.out.println("No se encontro Bungalow con ese codigo");
        }
    }

    private static void registrarProductos() {
        System.out.println("=== Registrar Producto ===");
        System.out.print("Ingresa el código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese detalle del producto: ");
        String detalle = scanner.next();
        System.out.print("Ingrese el stock del producto: ");
        int stock= scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Ingrese Precio unitario: ");
        double PriceUnitario = scanner.nextInt();

        ProductosDto productosDto = new ProductosDto();
        productosDto.setProductId(codigo);
        productosDto.setDetail(detalle);
        productosDto.setStock(stock);
        productosDto.setPriceUnit(PriceUnitario);

        productoFacade.registerProducto(productosDto);
        System.out.println("¡Producto registrado exitosamente!");
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