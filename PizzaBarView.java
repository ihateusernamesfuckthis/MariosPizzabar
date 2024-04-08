import java.util.*;

public class PizzaBarView {
    private PizzaBarOrder pizzaBar;

    public PizzaBarView(PizzaBarOrder pizzaBar) {
        this.pizzaBar = pizzaBar;
    }

    public void showMenu() {
        System.out.print("Showing the menu");
        for(Pizza pizza : pizzaMenu) {
            System.out.print(pizzaBar.getName() + "-" + pizzaBar.getNumber() + "-" + pizzaBar.getPrice() + "kr");
        }
    }

    public void takeOrder() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name?");
        String customerName = scan.nextLine();
        System.out.println("What would you like to order?");
        String order = scan.nextLine();
        System.out.println("Anything else? y/n");
        String orderMore = scan.nextLine();
        if (orderMore.equals("y")) {
            System.out.println("Perfect!\n" + customerName + " I will call you when your order is finished");
        }
        System.out.println("Perfect!\n" + customerName + " I will call you when your order is finished");
        pizzaBar.add(order, orderMore);
        scan.close();
    }

    public void editOrder() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("What Would You Like to Change?");
            System.out.print("Enter 1: delete order");
            System.out.print("Enter 2: add order");
            System.out.print("Enter 3: cancel order");
            System.out.print("Enter 4: no changes");

            int choose = scan.nextInt();
            switch (choose) {
                case 1:
                    // Add en ordrer
                    System.out.println("What is your name?");
                    String customerName = scan.nextLine();
                    System.out.println("Perfect. I found you in my system");
                    System.out.println("This is your order");
                    System.out.print(pizza.order());
                    System.out.println("What would you like to add from your order");
                    String addMore = scan.nextLine();
                    pizzaBar.add(addMore);
                    break;
                case 2:
                    // Slet en ordrer
                    System.out.println("What is your name?");
                    customerName = scan.nextLine();
                    System.out.println("Perfect. I found you in my system");
                    System.out.println("What would you like to remove from your order");
                    String removePizza = scan.nextLine();
                    pizzaBar.remove(removePizza);
                    System.out.println("Your order looks like as you preferred");
                    System.out.print(pizza.order()); // mangler customer id number for verify
                    break;
                case 3:
                    pizzaBar.clear();
                    System.out.print("Your order has been cancelled");
                    break;
                case 4:
                    running = false;
                    System.out.println("Perfect!\n I will call you when your order is finished");
                    break;
                default:
                    System.out.println("Perfect!\n I will call you when your order is finished");
            }
        }
        scan.close();
    }

    public void handleOrder() {
        // Fjernet fra listen
        order.setCompleted(true); // Er ordren færdig?
        pizzaBar.remove(order);
        System.out.print("Order " + orderId + " is now removed from the list");
    }

    public void getStatistic() {
        int revenue = 0;
        int mostSoldPizzas = 0;

        for (Order order : pizzaBar.orders) { //korrekt?
            mostSoldPizzas += order.size();
        }
        for (PizzaPrices pizzaPrice : pizzaBar.getPizza()) {
            revenue += pizzaPrice.getPrice();
        }

        System.out.print("The most sold pizza is " + mostSoldPizzas); // Lav top 5
        System.out.print("The total earnings " + revenue + " kr");
    }
}
