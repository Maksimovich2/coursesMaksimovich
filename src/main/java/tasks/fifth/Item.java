package tasks.fifth;

public class Item {
    private final String name;
    private final int capacity;
    private final int price;

    public Item(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n" +
                "название: " +  name + "\n" + "параметры: " +
                "объём = " + capacity +
                " ценность = " + price;
    }
}
