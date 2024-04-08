import java.util.*;
public class PizzaBarView {
    Private pizzaBarOrder pizzaBar;
    public static void pizzaBarView(pizzaBarOrder pizzaBar){//konstruktør
    this.pizzaBar = pizzaBar;

    }
    public static void showMenu(){
        System.out.print("Showing the menu");
        for(pizzas pizza : pizzaMenu){
            System.out.print(pizza.getName() + "-" + + pizza.getNumber + "-" + pizza.getPrice() + "kr")

        }
    }

    public static void takeOrder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("what would you like to order?");
        String order = scan.nextLine();
        System.out.println("Anything else? y/n");
        String orderMore = scan.nextLine();
        if (orderMore.equals("y")){
            else{
                //System.out.println("perfect!\n i will call you when your order is finished");
            }
            System.out.print("What is your name?");
            String CustomerName = scan.nextLine();
        }
        System.out.println("perfect!\n " + CustomerName + " I will call you when your order is finished");
        pizzaBar.add(order, orderMore);
    }

    public static void editOrder(){
        Scanner scan = new Scanner(System.in);
        booling running = true;
        while(running) {
            System.out.print("What Would You Like to Change?");
            System.out.print("Enter 1: delete order");
            System.out.print("Enter 2: add order");
           // System.out.print("Enter 3: change pick up time");
            System.out.print("Enter 4: no changes")

            int choose = scan.input.nextInt();
            switch (choose){
                case 1:
                    //add en ordrer
                    System.out.println("What is your name?");
                    String CustomerName = scan.nextLine(); // hvad hvis de ikke kan finde den i systemet
                    System.out.println("Perfect. I found you in my system");
                    System.out.println("This is your order");
                    ystem.out.print(pizza.order());
                    System.out.println("What would you like to add from your order");
                    String addMore = scan.nextLine();
                    pizzaBar.add(addMore);

                    break;
                case 2:
                    //slette en ordrer
                    System.out.println("What is your name?");
                    String CustomerName = scan.nextLine(); // hvad hvis de ikke kan finde den i systemet
                    System.out.println("Perfect. I found you in my system");
                    System.out.println("What would you like to remove from your order");
                    String removePizza = scan.nextLine();
                    pizzaBar.remove(removePizza);
                    System.out.println("Your order looks like as you preffered");
                    System.out.print(pizza.order()); //Mangler customer id number for verify

                    break;
                case 3:
                    //ændre afhentningstidpunktet?
                    break;
                case 4:
                    booling running = false;
                    System.out.println("perfect!\n i will call you when your order is finished");
                    break;
                default:
                    System.out.println("perfect!\n i will call you when your order is finished");
            }
        }
    }
    public static void handleOrder(){
        //fjernet fra listen
        order.setCompleted(true); //ordren er færdig?
        pizzaBar.remove(order);
        System.out.print("Order" + orderId + "is now removed from the list");
    }

    public static void getStatistick(){
        int revenue = 0;
        int mostSoldPizzas = 0;

        /*
        for(orders order : pizzaBar.orders) {
             mostSoldPizzas += order.isCompleted.size();
        }
        for(pizzaPrices pizzaPrice : order.getPizza)
        revenue += pizza.getPrice();

         */

        System.out.print("The most sold pizza is " + mostSoldPizzas); //lav top 5
        System.out.print("The total earnings " + revenue " kr");
    }
}
