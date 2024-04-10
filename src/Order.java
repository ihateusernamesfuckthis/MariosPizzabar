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

    public Order(int orderID, boolean completed){
        this.orderID = orderID;
        this.completed = completed;
        this.pizzas = new ArrayList<>();
    }
    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }

    public void setPizzas (ArrayList<Pizza> pizzas){
        this.pizzas = pizzas;
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

    public String toString(){
        StringBuilder order = new StringBuilder();
        order.append(this.orderID);
        order.append("[");
        int counter = 1;
        for (Pizza pizza : this.pizzas){
            order.append(pizza.getNumber());
            if (counter != this.pizzas.size()){
                order.append(", ");
            }
            counter++;
        }
        order.append("]");
        return order.toString();
    }
}
