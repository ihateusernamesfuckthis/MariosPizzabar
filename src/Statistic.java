import java.util.ArrayList;

public class Statistic {

    public int getRevenue(ArrayList<Order> orders) {
        int totalRevenue = 0;
        for (Order order : orders) {
            if (order.getCompleted()) {
                for (Pizza pizza : order.getPizzas()) {
                    totalRevenue += pizza.getPrice();
                }
            }
        }
        return totalRevenue;
    }

    public ArrayList<PizzaStatistic> getMostSoldPizzas(ArrayList<Order> orders) {
        ArrayList<PizzaStatistic> mostSoldPizzas = new ArrayList<>();

        for (Order order : orders) {
            for (Pizza pizza : order.getPizzas()) {
                PizzaStatistic existingStat = null;
                for (PizzaStatistic soldPizza : mostSoldPizzas) {
                    if (soldPizza.getPizza().equals(pizza)) {
                        existingStat = soldPizza;
                        break;
                    }
                }
                if (existingStat != null) {
                    existingStat.addQuantity(1);
                } else {
                    mostSoldPizzas.add(new PizzaStatistic(pizza));
                }
            }
        }
        return mostSoldPizzas;
    }
}
