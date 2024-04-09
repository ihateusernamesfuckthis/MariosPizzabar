import java.util.ArrayList;

public class PizzaStatistic {
    private Pizza pizza;
    private int quantity;

    public PizzaStatistic(Pizza pizza){
        this.pizza = pizza;
        this.quantity = 1;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
