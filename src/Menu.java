import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Utils utils = new Utils();

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
                        utils.createClient();
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
                        utils.activeClient();
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
                        utils.inactiveClient();
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
                    utils.listClients();
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
                        utils.createOrder();
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
                        utils.paidOrder();
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
                    utils.listOrders();
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
                        utils.createProduct();
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
                    utils.listProducts();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("No ingresaste una opción correcta\n");
                    break;
            }
        }while ( option != 3);
    }

    //----------------------------Other functions-------------------------------------------
    public static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
