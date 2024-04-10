import java.io.FileNotFoundException;
import java.util.*;

public class PizzaBarView {

    public void view() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList();
        boolean running = true;
        while (running) {
            System.out.print("What Would You Like to Change?");
            System.out.print("Enter 1: take order");
            System.out.print("Enter 2: edit order");
            System.out.print("Enter 3: cancel order");
            System.out.print("Enter 4: view statistics");
            System.out.print("Enter 5: sort");

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
                    getStatistic(orders);
                    break;
                case 5:
                    sortOrders(orders);
                    break;
                default:
                    System.out.println("try again");
            }
        }
        scan.close();

    }

    public void showMenu(ArrayList<Pizza> pizzaMenu) throws FileNotFoundException {
        System.out.print("Showing the menu");
        for (Pizza pizza : pizzaMenu) {
            System.out.print(pizza);
        }
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
        orders.add(order);
    }


    public void editOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("What order ID would you like to edit?");

        for (Pizza pizza : orders) {
            System.out.print(pizza);
        }

        try {
            System.out.println("Hello!\n what pizza would you like to remove?");
            int customerRemove = scan.nextInt();
            orders.remove(customerRemove - 1);
            System.out.println("what pizza would you like to get instead");
            int customerAdd = scan.nextInt();
            orders.add(customerAdd);
            System.out.println("your order is updated now");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");
            scan.nextLine();
        }
    }

    public void deleteOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Pizza> pizzaMenu = PizzaBarRepository.getDeleteOrder();

        System.out.println("What is your name?");
        String customerName = scan.nextLine();
        System.out.println("Perfect. I found you in my system");

        try {
            System.out.println("What would you like to remove from your order?");
            String removePizza = scan.nextLine();
            pizzaMenu.remove(removePizza);
            System.out.println("Your order looks like  as you preferred");
            for (Pizza pizza : pizzaMenu) {
                System.out.println(pizza);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid pizza name.");
            scan.nextLine();
        }
    }


    public void handleOrder(ArrayList<Order> orders) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hello, let me take your order\nWhat is your name?");
        String matchCustomer = scan.nextLine();

        for (Order order : orders) {
            if (order.getName().equals(matchCustomer)) {
                order.setCompleted(true);
                orders.remove(order);
                System.out.println("Order for customer " + matchCustomer + " is now removed from the list.");
            }
        }
        System.out.println("No order found for customer. Try again.");
    }


    public void sortOrders(ArrayList<Order> orders) {
        //  ArrayList<Pizza> sortOrder = Order.setCompleted();

        /*
        sortOrder.add(Pizza.of());
        collection.sort(sortOrder);


         System.out.println("Sorted after time:");
        for (Pizza time : sortOrder) {
            System.out.println(time);
        }
        * */
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
                System.out.println("The most sold pizza is " + mostSoldPizzas);
                break;
            case 2:
                System.out.println("The total earnings " + revenue + " kr");
                break;
            default:
                System.out.println("Try again");

        }
    }
}
