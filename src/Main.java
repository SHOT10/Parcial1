import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();


        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar el producto");
            System.out.println("2. Vender el producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();


            switch (opcion) {
                case 1 :
                    inventario.agregarProducto(scanner);
                    break;
                case 2 :
                    inventario.venderProducto(scanner);
                    break;
                case 3 :
                    inventario.mostrarInventario();
                    break;
                case 4 :
                    System.out.println("Saliendo del programa");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}

class Producto {
    private String nombre;
    private double cantidad;
    private double precio;

    public Producto(String nombre, double cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}

class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    public void agregarProducto(Scanner scanner) {
        System.out.println("Ingresar el nombre del producto:");
        String nombre = scanner.next();
        System.out.println("Ingresar la cantidad inicial:");
        double cantidad = Double.parseDouble(scanner.next());
        System.out.println("Ingresar el precio por unidad:");
        double precio = Double.parseDouble(scanner.next());

        Producto producto = new Producto(nombre, cantidad, precio);
        productos.put(nombre, producto);
    }

    public void venderProducto(Scanner scanner) {
        System.out.println("Ingresar el nombre del producto a vender:");
        String nombre = scanner.next();

        if (!productos.containsKey(nombre)) {
            System.out.println("Producto no encontrado.");
            return;
        }

        Producto producto = productos.get(nombre);

        if (producto.getCantidad() == 0) {
            System.out.println("No hay stock para este/os producto/s.");
            return;
        }

        producto.setCantidad(producto.getCantidad() - 1);
        System.out.println("Venta realizada exitosamente.");
    }

    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (Producto producto : productos.values()) {
            System.out.println("Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad() +
                    ", Precio: $" + producto.getPrecio());
        }
    }
}