import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PizzaBarView {
    public static Scanner scan = new Scanner(System.in);
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
        ArrayList<Pizza> pizzaMenu = PizzaBarRepository.getPizzaMenu();
        boolean editOrderMenu = true;
        while(editOrderMenu) {
            System.out.println("What order ID would you like to edit?\n0. To exit edit order menu");
            int desiredOrderId = scan.nextInt();
            scan.nextLine();
            if(desiredOrderId == 0){
                editOrderMenu = false;
            } else {
                int index = 0;
                boolean found = false;
                for(int i = 0; i < orders.size(); i++){
                    if(orders.get(i).getOrderID() == desiredOrderId) {
                        index = i;
                        found = true;
                    }
                }
                if(found) {
                    boolean editingOptions = true;
                    Order order = orders.get(index);
                    ArrayList<Pizza> pizzasInOrder = order.getPizzas();
                    while(editingOptions) {
                        System.out.println("1. Replace pizza");
                        System.out.println("2. Add pizza");
                        System.out.println("3. Remove pizza");
                        System.out.println("4. Exit to main menu");
                        int desiredOption = scan.nextInt();
                        scan.nextLine();
                        switch (desiredOption) {
                            case 1:
                                replacePizza(pizzasInOrder, pizzaMenu);
                                break;
                            case 2:
                                addPizza(pizzaMenu, pizzasInOrder);
                                break;
                            case 3:
                                removePizzaFromOrder(pizzasInOrder);
                                break;
                            case 4:
                                editOrderMenu = false;
                                editingOptions = false;
                                break;
                        }
                    }
                } else {
                    System.out.println("OrderID does not exist.");
                    break;
                }
            }
        }
    }
    public void replacePizza(ArrayList<Pizza> pizzasInOrder, ArrayList<Pizza> pizzaMenu) {
        while(true) {
            System.out.println("What pizza would you like to replace.\n0. Exit to editing options.");
            int indexInCase1 = 1;
            for(Pizza pizza: pizzasInOrder) {
                System.out.println(indexInCase1 + ". " + pizza);
                indexInCase1++;
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
                pizzasInOrder.remove(editDesiredPizza-1);
                pizzasInOrder.add(pizzaMenu.get(desiredPizzaNum-1));
            }
            System.out.println("Pizza is now replaced.");
            System.out.println("1. Replace more pizzas");
            System.out.println("2. Back to editing options");
            int decision = scan.nextInt();
            scan.nextLine();
            if(decision == 1) {
                continue;
            } else if(decision == 2) {
                break;
            }
        }
    }
    public void addPizza(ArrayList<Pizza> pizzaMenu, ArrayList<Pizza> pizzasInOrder) {
        for(Pizza pizza: pizzaMenu) {
            System.out.println(pizza);
        }
        int decision;
        do {
            System.out.println("What pizza number would you like to add?");
            int desiredPizzaNumber = scan.nextInt();
            scan.nextLine();
            Pizza desiredPizza = pizzaMenu.get(desiredPizzaNumber-1);
            pizzasInOrder.add(desiredPizza);
            System.out.println("Pizza is now added to the order.");
            System.out.println("1. Add more.");
            System.out.println("2. Back to editing options.");
            decision = scan.nextInt();
            scan.nextLine();
        } while (decision == 1);
    }
    public void removePizzaFromOrder(ArrayList<Pizza> pizzasInOrder) {
        int desiredOptionInCase3;
        do {
            for(int i = 0; i < pizzasInOrder.size(); i++) {
                System.out.println(i+1 + ". " + pizzasInOrder.get(i));
            }
            System.out.println("What pizza to remove?");
            int desiredPizza = scan.nextInt();
            scan.nextLine();
            pizzasInOrder.remove(desiredPizza-1);
            System.out.println("Pizza is now removed from the order.");
            System.out.println("1. Remove more.");
            System.out.println("2. Back to editing options");
            desiredOptionInCase3 = scan.nextInt();
            scan.nextLine();

        } while (desiredOptionInCase3 == 1);
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
