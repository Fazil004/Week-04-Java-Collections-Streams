
import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private String itemId;

    public WarehouseItem(String name, String itemId) {
        this.name = name;
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "Item: " + name + " (ID: " + itemId + ")";
    }
}

class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String itemId, String brand) {
        super(name, itemId);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String itemId, String expiryDate) {
        super(name, itemId);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Expires on: " + expiryDate;
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String itemId, String material) {
        super(name, itemId);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getAllItems() {
        return items;
    }

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("--- All Items in Storage ---");
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
        System.out.println("--------------------------");
    }
}

public class WarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", "EL001", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "EL002", "Samsung"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples", "GR001", "2025-05-15"));
        groceriesStorage.addItem(new Groceries("Bread", "GR002", "2025-05-05"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Table", "FU001", "Wood"));
        furnitureStorage.addItem(new Furniture("Chair", "FU002", "Metal"));

        Storage.displayAllItems(electronicsStorage.getAllItems());
        Storage.displayAllItems(groceriesStorage.getAllItems());
        Storage.displayAllItems(furnitureStorage.getAllItems());
    }
}

