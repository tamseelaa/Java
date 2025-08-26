package week1.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GroceryItem {
    String name;
    double cost;
    String category;
    int quantity;

    GroceryItem(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    void displayInfo() {
        System.out.println(name + " | $" + cost + " | " + category + " | Qty: " + quantity);
    }
}

public class GroceryListManager {

    //1: basic grocery list (names only)
    private ArrayList<String> groceryList = new ArrayList<>();

    //2: grocery list with cost
    private HashMap<String, Double> groceryCostMap = new HashMap<>();

    //3 & 4: grocery list with category & quantity
    private ArrayList<GroceryItem> groceryItems = new ArrayList<>();

    //  Task 1
    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
            System.out.println(item + " added to basic list.");
        } else {
            System.out.println(item + " already exists in the basic list.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println(item + " removed from basic list.");
        } else {
            System.out.println(item + " not found in basic list.");
        }
    }

    public void displayList() {
        if (groceryList.isEmpty()) {
            System.out.println("Basic grocery list is empty.");
        } else {
            System.out.println("Basic Grocery List:");
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    //Task 2
    public void addItem(String item, double cost) {
        groceryCostMap.put(item, cost);
        System.out.println(item + " added with cost $" + cost);
    }

    public void displayCostList() {
        if (groceryCostMap.isEmpty()) {
            System.out.println("Cost list is empty.");
        } else {
            System.out.println("Grocery List with Costs:");
            for (Map.Entry<String, Double> entry : groceryCostMap.entrySet()) {
                System.out.println("- " + entry.getKey() + ": $" + entry.getValue());
            }
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (double cost : groceryCostMap.values()) {
            total += cost;
        }
        return total;
    }

    // Task 3,4
    public void addItem(String name, double cost, String category, int quantity) {
        groceryItems.add(new GroceryItem(name, cost, category, quantity));
        System.out.println(name + " added with category & quantity.");
    }

    public void updateQuantity(String name, int newQuantity) {
        for (GroceryItem item : groceryItems) {
            if (item.name.equals(name)) {
                item.quantity = newQuantity;
                System.out.println("Updated " + name + " quantity to " + newQuantity);
                return;
            }
        }
        System.out.println(name + " not found in grocery items.");
    }

    public void displayFullList() {
        if (groceryItems.isEmpty()) {
            System.out.println("No detailed items in grocery list.");
        } else {
            System.out.println("Detailed Grocery List:");
            for (GroceryItem item : groceryItems) {
                item.displayInfo();
            }
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category: " + category);
        for (GroceryItem item : groceryItems) {
            if (item.category.equalsIgnoreCase(category)) {
                item.displayInfo();
            }
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available items (Qty > 0):");
        for (GroceryItem item : groceryItems) {
            if (item.quantity > 0) {
                item.displayInfo();
            }
        }
    }

    public double calculateTotalCostWithQuantity() {
        double total = 0;
        for (GroceryItem item : groceryItems) {
            total += item.cost * item.quantity;
        }
        return total;
    }

    //main
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        System.out.println("\nBasic Grocery List");
        manager.addItem("Apples");
        manager.addItem("Milk");
        manager.addItem("Bread");
        manager.displayList();
        System.out.println("\nIs Milk in list? " + manager.checkItem("Milk"));
        manager.removeItem("Milk");
        manager.displayList();

        System.out.println("\n\nGrocery List with Costs");
        manager.addItem("Eggs", 0.5);
        manager.addItem("Butter", 4.2);
        manager.addItem("Cheese", 7);
        manager.displayCostList();
        System.out.println("Total cost = $" + manager.calculateTotalCost());

        //Task 3,4
        System.out.println("\n\nDetailed Items (Category + Quantity)");
        manager.addItem("Banana", 1.5, "Fruits", 12);
        manager.addItem("Milk", 2.5, "Dairy", 5);
        manager.addItem("Bread", 1.2, "Bakery", 1);

        manager.displayFullList();
        manager.updateQuantity("Banana", 10);
        manager.displayAvailableItems();
        manager.displayByCategory("Fruits");
        System.out.println("\nTotal cost (with quantities) = $" + manager.calculateTotalCostWithQuantity());
    }
}