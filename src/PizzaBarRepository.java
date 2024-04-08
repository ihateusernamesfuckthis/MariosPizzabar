import java.io.*;
import java.util.*;
public class PizzaBarRepository {
    public static ArrayList<Pizza> getPizzaMenu() throws FileNotFoundException {
        Scanner fileRead = new Scanner(new File("./src/pizzamenu.txt"));
        ArrayList<Pizza> pizzaMenu = new ArrayList<Pizza>();

        while(fileRead.hasNextLine()) {
            String line = fileRead.nextLine();
            Scanner lineScan = new Scanner(line);

            int pizzaID = lineScan.nextInt();
            String name = lineScan.next();
            int price = Integer.valueOf(lineScan.next());

            Pizza pizzaFromMenu = new Pizza(name, pizzaID, price);
            pizzaMenu.add(pizzaFromMenu);
        }
        return pizzaMenu;
        /*
        Hvis dette skal fungere optimalt i PizzabarView,
        skal pizza klassen have en følgende toString metode:
        public String toString() {
            return number + ". " + name + " " + price + ",-";
        }
        */

    }
}
