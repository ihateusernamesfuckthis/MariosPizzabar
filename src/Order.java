import java.util.List;

public class Order {
    private List<Pizza> pizzas;
    private int orderID;
    private boolean completed;
    private static int counter;

    public Order(){

    }
    public List<Pizza> getPizzas(){
        return this.pizzas;
    }
    public int getOrderID(){
        return this.orderID;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completedStatus){
        this.completed = completedStatus;
    }

    public void addPizza(Pizza pizzaToAdded){
        this.pizzas.add(pizzaToAdded);
    }

    public void removePizza(Pizza pizza){
        this.pizzas.remove(pizza);
    }
}
