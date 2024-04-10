import java.io.*;
import java.util.*;

public class PizzaBarRepository {
    public static ArrayList<Pizza> getPizzaMenu() throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("./src/pizzamenu.txt"));
        ArrayList<Pizza> pizzaMenu = new ArrayList<Pizza>();

        while (fileRead.hasNextLine()) {
            String line = fileRead.nextLine();
            Scanner lineScan = new Scanner(line);

            int pizzaID = lineScan.nextInt();
            String name = lineScan.next();
            int price = Integer.valueOf(lineScan.next());

            Pizza pizzaFromMenu = new Pizza(name, pizzaID, price);
            pizzaMenu.add(pizzaFromMenu);
        }

        return pizzaMenu;
    }

    public static ArrayList<Order> getOrders() throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("./src/orderlist.txt"));
        ArrayList<Order> orders = new ArrayList<>();

        while (fileRead.hasNextLine()) {
            String line = fileRead.nextLine();
            String[] splitOrder = line.split("//");
            String[] splitOrderPizzas = splitOrder[0].split(",");

            Order order = new Order(Integer.parseInt(splitOrder[1]), Boolean.parseBoolean(splitOrder[2]));

            for (String orderPizza : splitOrderPizzas) {
                Scanner lineScan = new Scanner(orderPizza);
                Pizza pizza = new Pizza(lineScan.next(), lineScan.nextInt(), lineScan.nextInt());
                order.addPizza(pizza);
            }
            orders.add(order);
        }
        return orders;
    }

    public static void addOrder(Order order) throws IOException {
        FileWriter writer = new FileWriter("./src/orderlist.txt", true);
        writeOrderToFile(order, writer);
        writer.close();
    }

    public static void saveOrders(ArrayList<Order> orders) throws IOException {
        FileWriter writer = new FileWriter("./src/orderlist.txt");
        for (Order order : orders) {
            writeOrderToFile(order, writer);
        }
        writer.close();
    }

    public static void deleteOrder(int orderID) throws IOException {
        ArrayList<Order> orders = getOrders();
        for (Order order : orders) {
            if (orderID == order.getOrderID()) {
                orders.remove(order);
            }
        }
        saveOrders(orders);
    }

    public static void updateOrder(int orderID, ArrayList<Pizza> pizzas) throws IOException {
        ArrayList<Order> orders = getOrders();
        for (Order order : orders) {
            if (orderID == order.getOrderID()) {
                order.setPizzas(pizzas);
            }
        }
        saveOrders(orders);
    }

    public static void updateOrder(int orderID, boolean completed) throws IOException {
        ArrayList<Order> orders = getOrders();
        for (Order order : orders) {
            if (orderID == order.getOrderID()) {
                order.setCompleted(completed);
            }
        }
        saveOrders(orders);
    }

    private static void writeOrderToFile(Order order, FileWriter writer) throws IOException {
        int size = order.getPizzas().size();
        int counter = 0;

        for (Pizza pizza : order.getPizzas()) {
            writer.write(pizza.getName() + " " + pizza.getNumber() + " " + pizza.getPrice());
            counter++;
            if (counter != size) {
                writer.write(" , ");
            }
        }
        writer.write(" //" + order.getOrderID() + " // " + order.getCompleted() + "\n");

    }
}
