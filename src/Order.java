import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<Pizza> pizzas;
    private int orderID;
    private boolean completed;
    private static int counter;
    private LocalDateTime timeOfCompletion;
    private LocalDateTime timeOfCreation;

    public Order(){
        counter++;
        this.orderID = counter;
        this.pizzas = new ArrayList<>();
        this.timeOfCreation = LocalDateTime.now();
        this.completed = false;
    }
    public ArrayList<Pizza> getPizzas(){
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
        if (this.completed){
            this.timeOfCompletion = LocalDateTime.now();
        }
    }

    public void addPizza(Pizza pizzaToAdded){
        this.pizzas.add(pizzaToAdded);
    }

    public void removePizza(Pizza pizza){
        this.pizzas.remove(pizza);
    }
}
