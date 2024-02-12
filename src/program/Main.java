package program;

import entitites.Client;
import entitites.Order;
import entitites.OrderItem;
import entitites.Product;
import enumerate.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyu");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());

        Order order = new Order(new Date(), status, client);
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<n; i++) {
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem it = new OrderItem(quantity, productPrice, product);
            order.addItem(it);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}