import model.Client;
import model.Order;
import model.Product;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<Client> clients = new HashSet<>();
    private static final Set<Order> orders = new HashSet<>();
    private static final Set<Product> products = new HashSet<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        menuPrincipal();
    }

    //-------------------------------Menu Principal ----------------------------------
    public static void menuPrincipal() throws IOException, InterruptedException {
        int option;
        do{
            System.out.println("""
                    Menu:
                    1.Clientes
                    2.Pedidos
                    3.Productos
                    4.Salir
                    """);

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    menuClient();
                    break;
                case 2:
                    menuOrder();
                    break;
                case 3:
                    menuProduct();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...\n");
                    break;
                default:
                    System.out.println("No ingresaste una opción correcta\n");

            }
        }while (option != 4);
    }

    //--------------------------------Menus Secondary ---------------------------------
    public static void menuClient() throws IOException, InterruptedException {
        int option;
        clearConsole();
        do{
            System.out.println("""
                    1.Crear cliente
                    2.Activar cliente
                    3.Desactivar cliente
                    4.Listar clientes
                    5.Regresar a menu principal
                    """);
            option = scanner.nextInt();
            scanner.nextLine();

            int repeat;
            switch (option){
                case 1:
                    do{
                        clearConsole();
                        createClient();
                        System.out.println("""
                                Queres continuar agregando clientes?
                                1)Si
                                2)No
                                """);
                        repeat = scanner.nextInt();
                        scanner.nextLine();
                    }while (repeat == 1);
                    break;
                case 2:
                    do{
                        clearConsole();
                        activeClient();
                        System.out.println("""
                                Queres continuar activando clientes?
                                1)Si
                                2)No
                                """);
                        repeat = scanner.nextInt();
                        scanner.nextLine();
                    }while (repeat == 1);
                    break;
                case 3:
                    do{
                        clearConsole();
                        inactiveClient();
                        System.out.println("""
                                Queres continuar desactivando clientes?
                                1)Si
                                2)No
                                """);
                        repeat = scanner.nextInt();
                        scanner.nextLine();
                    }while (repeat == 1);
                    break;
                case 4:
                        clearConsole();
                        listClients();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("No ingresaste una opción correcta\n");
                    break;
            }
        }while ( option != 5);

    }

    public static void menuOrder() throws IOException, InterruptedException {
        int option;
        clearConsole();
        do{
            System.out.println("""
                    1.Crear pedidos
                    2.Pagar pedidos
                    3.Listar pedidos
                    4.Regresar a menu principal
                    """);
            option = scanner.nextInt();
            scanner.nextLine();

            int repeat;
            switch (option){
                case 1:
                    do{
                        clearConsole();
                        createOrder();
                        System.out.println("""
                                Queres continuar agregando pedidos?
                                1)Si
                                2)No
                                """);
                        repeat = scanner.nextInt();
                        scanner.nextLine();
                    }while (repeat == 1);
                    break;
                case 2:
                    do{
                        clearConsole();
                        paidOrder();
                        System.out.println("""
                                Queres continuar pagando pedidos?
                                1)Si
                                2)No
                                """);
                        repeat = scanner.nextInt();
                        scanner.nextLine();
                    }while (repeat == 1);
                    break;
                case 3:
                        clearConsole();
                        listOrders();
                        break;
                case 4:
                    break;
                default:
                    System.out.println("No ingresaste una opción correcta\n");
                    break;
            }
        }while ( option != 4);

    }

    public static void menuProduct() throws IOException, InterruptedException {
        int option;
        clearConsole();
        do{
            System.out.println("""
                    1.Crear producto
                    2.Listar productos
                    3.Regresar a menu principal
                    """);
            option = scanner.nextInt();
            scanner.nextLine();

            int repeat;
            switch (option){
                case 1:
                    do{
                        clearConsole();
                        createProduct();
                        System.out.println("""
                                Queres continuar agregando productos?
                                1)Si
                                2)No
                                """);
                        repeat = scanner.nextInt();
                        scanner.nextLine();
                    }while (repeat == 1);
                    break;
                case 2:
                    clearConsole();
                    listProducts();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("No ingresaste una opción correcta\n");
                    break;
            }
        }while ( option != 3);
    }

    //----------------------------Clients options -------------------------------------
    public static void createClient(){
        System.out.println("Nombre: ");
        var name = scanner.nextLine();
        System.out.println("\n");

        System.out.println("Apellido: ");
        var lastname = scanner.nextLine();
        System.out.println("\n");

        System.out.println("Ciudad: ");
        var city = scanner.nextLine();
        System.out.println("\n");

        System.out.println("Codigo Postal: ");
        var postalCode = scanner.nextLine();
        System.out.println("\n");

        System.out.println("Direccion: ");
        var address = scanner.nextLine();
        System.out.println("\n");

        Client client = new Client(name,lastname,city,postalCode,address);
        clients.add(client);
        System.out.println("Cliente agregado correctamente.\n");
    }

    public static void activeClient(){
        System.out.println("Ingresa el id del cliente: ");
        var id = scanner.nextInt();
        scanner.nextLine();
        var iterator = clients.stream().filter(c -> c.getId() == id).iterator();
        if (iterator.hasNext()){
            iterator.next().active();
            System.out.println("Se modifico el estado del cliente a activo.\n");
        }else {
            System.out.println("No existe un cliente con ese id.\n");
        }
    }

    public static void inactiveClient(){
        System.out.println("Ingresa el id del cliente: ");
        var id = scanner.nextInt();
        scanner.nextLine();
        var iterator = clients.stream().filter(c -> c.getId() == id).iterator();
        if (iterator.hasNext()){
            iterator.next().inactive();
            System.out.println("Se modifico el estado del cliente a inactivo.\n");
        }else {
            System.out.println("No existe un cliente con ese id.\n");
        }
    }

    public static void listClients(){
        if(!clients.isEmpty()){
            for(Client client : clients){
                System.out.println("-------------------------------------------------------\n");
                System.out.println("Id: " + client.getId()+ "\n" +
                        "Nombre: " + client.getName() + "\n" +
                        "Apellido: " + client.getLastName() + "\n" +
                        "Ciudad: " + client.getCity() + "\n" +
                        "Codigo Postal: " + client.getPostalCode() + "\n" +
                        "Direccion: " + client.getAddress() + "\n" +
                        "Estado: " + client.getStatusClient() + "\n");
                System.out.println("-------------------------------------------------------\n");
            }
        }else {
            System.out.println("No hay clientes cargados.\n");
        }
    }

    //----------------------------Order options -------------------------------------
    public static void createOrder(){
        System.out.println("Total: ");
        var total = scanner.nextFloat();
        System.out.println("\n");

        boolean repeat = false;

        Product product = null;
        do {
            System.out.println("Id del Producto: ");
            var idProduct = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");
            var iterator = products.stream().filter(p -> p.getId() == idProduct).iterator();
            var exist = iterator.hasNext();
            if (exist){
                product = iterator.next();
            }else{
                repeat = true;
                System.out.println("No existe un producto con el id: " + idProduct);
            }

        }while (repeat);

        Client client = null;
        do {
            System.out.println("Id del Cliente: ");
            var idClient = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");

            var iterator = clients.stream().filter(c -> c.getId() == idClient).iterator();
            var exist = iterator.hasNext();
            if (exist){
                repeat = false;
                client = iterator.next();
            }else{
                repeat = true;
                System.out.println("No existe un cliente con el id: " + idClient);
            }

        }while (repeat);

        Order order = new Order(total,product,client);
        orders.add(order);
        System.out.println("Cliente agregado correctamente.\n");
    }

    public static void paidOrder(){
        System.out.println("Ingresa el id del Pedido: ");
        var id = scanner.nextInt();
        scanner.nextLine();
        var iterator = orders.stream().filter(c -> c.getId() == id).iterator();
        if (iterator.hasNext()){
            iterator.next().paid();
            System.out.println("Se pago el Pedido.\n");
        }else {
            System.out.println("No existe un Pedido con ese id.\n");
        }
    }

    public static void listOrders(){
        if(!orders.isEmpty()){
            for(Order order : orders){
                System.out.println("-------------------------------------------------------\n");
                System.out.println("Id: " + order.getId()+ "\n" +
                        "Total: " + order.getTotal() + "\n" +
                        "Status: " + order.getStatusOrder() + "\n" +
                        "Producto: " + order.getProduct().getTitle() + "\n" +
                        "Cliente: " + order.getClient().getName() + " " + order.getClient().getLastName() + "\n");
                System.out.println("-------------------------------------------------------\n");
            }
        }else {
            System.out.println("No hay pedidos cargados.\n");
        }

    }

    //----------------------------Product options -------------------------------------
    public static void createProduct(){
        System.out.println("Titulo: ");
        var title = scanner.nextLine();
        System.out.println("\n");

        System.out.println("Precio: ");
        var price = scanner.nextFloat();
        System.out.println("\n");

        System.out.println("Descripcion: ");
        var description = scanner.nextLine();
        System.out.println("\n");



        Product product = new Product(title,price,description);
        products.add(product);
        System.out.println("Producto agregado correctamente.\n");
    }

    public static void listProducts(){
        if(!products.isEmpty()){
            for(Product product : products){
                System.out.println("-------------------------------------------------------\n");
                System.out.println("Id: " + product.getId()+ "\n" +
                        "Titulo: " + product.getTitle() + "\n" +
                        "Precio: " + product.getPrice() + "\n" +
                        "Descripcion: " + product.getDescription() + "\n");
                System.out.println("-------------------------------------------------------\n");
            }
        }else {
            System.out.println("No hay productos cargados.\n");
        }
    }

    //----------------------------Other functions-------------------------------------------
    public static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

}