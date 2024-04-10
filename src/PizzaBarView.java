import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PizzaBarView {

    public PizzaBarView (){

    }
    public void view() throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList();
        boolean running = true;
        while (running) {
            System.out.println("Enter 1: take order");
            System.out.println("Enter 2: edit order");
            System.out.println("Enter 3: delete order");
            System.out.println("Enter 4: handle order");
            System.out.println("Enter 5: view statistics");
            System.out.println("Enter 6: show orders");
            System.out.println("Enter 7: close program");

            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    takeOrder(orders);
                    break;
                case 2:
                    editOrder(orders);
                    break;
                case 3:
                    deleteOrder(orders);
                    break;
                case 4:
                    handleOrder(orders);
                    break;
                case 5:
                    getStatistic(orders);
                    break;
                case 6:
                    showQueue(orders);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("try again");
            }
        }
        scan.close();
        PizzaBarRepository.
                saveOrders(orders);

    }

    public void showMenu(ArrayList<Pizza> pizzaMenu) throws FileNotFoundException {
        System.out.println("Showing the menu");
        for (Pizza pizza : pizzaMenu) {
            System.out.println(pizza);
        }
        System.out.println();
    }

    public void takeOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Order order = new Order();
        ArrayList<Pizza> pizzaMenu = PizzaBarRepository.getPizzaMenu();
        showMenu(pizzaMenu);
        String orderMore;
        do {
            System.out.println("What number would you like to order?");
            int desiredPizzaNumber = scan.nextInt();
            scan.nextLine();

            for (Pizza pizza : pizzaMenu) {
                if (pizza.getNumber() == desiredPizzaNumber) {
                    order.addPizza(pizza);
                    break;
                }
            }
            System.out.println("If anything else type y");
            orderMore = scan.nextLine().toLowerCase();
        } while (orderMore.equals("y"));
        System.out.println("Order created");
        System.out.println("Your order ID is: " + order.getOrderID());
        orders.add(order);
        System.out.println();
    }


    public void editOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("What order ID would you like to edit?");
        ArrayList<Pizza> pizzaMenu = PizzaBarRepository.getPizzaMenu();
        for(Order order: orders) {
            if(order.getOrderId() == desiredOrderId) {
                while(true) {
                    System.out.println("What pizza would you like to replace.\n0. To exit.");
                    ArrayList<Pizza> pizzas = order.getPizzas();
                    int index = 1;
                    for(Pizza pizza: pizzas) {
                        System.out.println(index + ". " + pizza);
                    }
                    int editDesiredPizza = scan.nextInt();
                    scan.nextLine();
                    if(editDesiredPizza == 0) {
                        break;
                    } else {
                        for(Pizza pizza: pizzaMenu) {
                            System.out.println(pizza);
                        }
                        System.out.println("What pizza number to replace with?");
                        int desiredPizzaNum = scan.nextInt();
                        scan.nextLine();
                        pizzas.remove(editDesiredPizza-1);
                        pizzas.add(pizzaMenu.get(desiredPizzaNum-1))
                    }
                }
            }
        }

    }

    public void deleteOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your orderId?");
        int customerId = scan.nextInt();
        Order orderToDelete = findOrder(customerId, orders);
        if (orderToDelete == null) {
            System.out.println("Your order was not found\n");
            return;
        }
        orders.remove(orderToDelete);
        System.out.println("Your order has been deleted\n");
    }


    public void handleOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hello, what is your order ID?");
        int customerOrderId = scan.nextInt();
        Order order = findOrder(customerOrderId, orders);
        if (order == null){
            System.out.println("No order found for customer.");
            return;
        }
        order.setCompleted(true);
        System.out.println("Order " + customerOrderId + " is now picked up\n");
    }


    public void showQueue(ArrayList<Order> orders) {
        for (Order order : orders){
            if (!order.getCompleted()){
                System.out.println(order);
            }
        }
        System.out.println();
    }


    public void getStatistic(ArrayList<Order> orders) {
        Scanner scan = new Scanner(System.in);
        Statistic statistic = new Statistic();
        ArrayList<PizzaStatistic> mostSoldPizzas = statistic.getMostSoldPizzas(orders);
        int revenue = statistic.getRevenue(orders);

        System.out.println("What statistic would you like to view?");
        System.out.println("Enter 1: for most sold pizzas");
        System.out.println("Enter 2: for most revenue");

        int choseStatistic = scan.nextInt();
        switch (choseStatistic) {
            case 1:
                System.out.println("The most sold pizza is ");
                for(PizzaStatistic mostSold : mostSoldPizzas){
                    System.out.println(mostSold.getPizza().getName() + ": " + mostSold.getQuantity());
                }
                break;
            case 2:
                System.out.println("The total earnings " + revenue + " kr");
                break;
            default:
                System.out.println("Try again");

        }
        System.out.println();
    }

    private Order findOrder(int orderID, ArrayList<Order> orders) {
        for (Order order : orders) {
            if (orderID == order.getOrderID()) {
                return order;
            }
        }
        return null;
    }
}
// s
