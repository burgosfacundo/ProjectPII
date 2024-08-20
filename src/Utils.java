import model.Client;
import model.Order;
import model.Product;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<Client> clients = new HashSet<>();
    private static final Set<Order> orders = new HashSet<>();
    private static final Set<Product> products = new HashSet<>();

    //----------------------------Clients options -------------------------------------
    public void createClient(){
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
    public void activeClient(){
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
    public void inactiveClient(){
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
    public void listClients(){
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
    public void createOrder(){
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
                System.out.println("No existe un producto con el id: " + idProduct + "\n");
                System.out.println("""
                    Desea volver a intentarlo?
                    1)Si
                    2)No
                    """);
                var option = scanner.nextInt();
                scanner.nextLine();
                if (option == 1){
                    repeat = true;
                }else{
                    return;
                }
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
                System.out.println("No existe un cliente con el id: " + idClient);
                System.out.println("""
                    Desea volver a intentarlo?
                    1)Si
                    2)No
                    """);
                var option = scanner.nextInt();
                scanner.nextLine();
                if (option == 1){
                    repeat = true;
                }else{
                    return;
                }
            }

        }while (repeat);

        Order order = new Order(total,product,client);
        orders.add(order);
        System.out.println("Cliente agregado correctamente.\n");
    }
    public void paidOrder(){
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
    public void listOrders(){
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
    public void createProduct(){
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
    public void listProducts(){
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
}
