public class Pizza {
    private String name;
    private int number;
    private int price;

    public Pizza(String name, int number, int price){
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }
    public String toString(){
        StringBuilder formattedString = new StringBuilder(this.number + ". " + this.name + ": ");
        for (int i = 0; i < 30 - this.name.length(); i++) {
            formattedString.append(".");
        }
        formattedString.append(this.price);
        formattedString.append(",-");

        return formattedString.toString();
    }
}
