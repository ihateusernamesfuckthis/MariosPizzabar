import java.io.FileNotFoundException;
import java.util.*;

public class PizzaBarView {

    public void view () throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("What Would You Like to Change?");
            System.out.print("Enter 1: take order");
            System.out.print("Enter 2: add order");
            System.out.print("Enter 3: cancel order");
            System.out.print("Enter 4: view statistics");
            System.out.print("Enter 5: sort");

            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                   takeOrder();
                    break;
                case 2:
                   editOrder();
                    break;
                case 3:
                    deleteOrder();
                    break;
                case 4:
                    getStatistic();
                    break;
                case 5:
                    sortOrders();
                    break;
                default:
                    System.out.println("try again");
            }
        }
        scan.close();

    }

    public void showMenu() throws FileNotFoundException {
        ArrayList<Pizza> pizzaMenu = PizzaBarRepository.getPizzaMenu();
        System.out.print("Showing the menu");
        for(Pizza pizza : pizzaMenu) {
            System.out.print(pizza);
        }
    }

    public void takeOrder() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> order = PizzaBarRepository.getOrders();
        System.out.print("What is your name?");
        String customerName = scan.nextLine();
        System.out.println("What would you like to order?");
        String firstOrder = scan.nextLine();
        System.out.println("Anything else? y/n");
        String orderMore = scan.nextLine().toLowerCase();
        if (orderMore.equals("y")) {
            System.out.println("Perfect!\n" + customerName + " I will call you when your order is finished");
        } else {
            System.out.println("Wrong input only type y/n");
        }
        order.add(firstOrder);

    }


    public void editOrder() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Pizza> orderList = PizzaBarRepository.getPizzaMenu();
        System.out.println("Here is the menu again");

        for(Pizza pizza : orderList) {
            System.out.print(pizza);
        }

        try {
            System.out.println("Hello!\n what pizza would you like to remove?");
            int customerRemove = scan.nextInt();
            orderList.remove(customerRemove - 1);
            System.out.println("what pizza would you like to get instead");
            int customerAdd = scan.nextInt();
            orderList.add(customerAdd);
            System.out.println("your order is updated now");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");
            scan.nextLine();
        }
    }

    public void deleteOrder() throws FileNotFoundException {
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


    public void handleOrder() throws FileNotFoundException {
        ArrayList<Order> orders = PizzaBarRepository.getOrders();
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



    public void sortOrders(){
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


    public  void getStatistic(int mostSoldPizzas, int revenue) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What statistic would you like to view?");
        System.out.println("Enter 1: for most sold pizzas");
        System.out.println("Enter : for most sold pizzas");

        int choseStatistic = scan.nextInt();
        switch(choseStatistic) {
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
