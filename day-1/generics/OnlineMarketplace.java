
import java.util.ArrayList;
import java.util.List;

interface ProductCategory {
    String getCategoryName();
}

class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadget";
    }
}

class Product<C extends ProductCategory> {
    private String name;
    private double price;
    private C category;

    public Product(String name, double price, C category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public C getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Category: " + category.getCategoryName() + ", Price: $" + String.format("%.2f", price);
    }
}

class ProductCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public List<Product<?>> getAllProducts() {
        return products;
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountFactor = 1 - (percentage / 100.0);
        double discountedPrice = product.getPrice() * discountFactor;
        product.setPrice(discountedPrice);
        System.out.println("Discount of " + percentage + "% applied to " + product.getName() + ". New price: $" + String.format("%.2f", product.getPrice()));
    }

    public void displayCatalog() {
        System.out.println("--- Product Catalog ---");
        for (Product<?> product : products) {
            System.out.println(product);
        }
        System.out.println("-----------------------");
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        Product<BookCategory> book1 = new Product<>("The Great Gatsby", 10.99, new BookCategory());
        Product<ClothingCategory> shirt1 = new Product<>("T-Shirt", 25.50, new ClothingCategory());
        Product<GadgetCategory> phone1 = new Product<>("Smartphone X", 999.99, new GadgetCategory());

        catalog.addProduct(book1);
        catalog.addProduct(shirt1);
        catalog.addProduct(phone1);

        catalog.displayCatalog();

        ProductCatalog.applyDiscount(book1, 10.0);
        ProductCatalog.applyDiscount(shirt1, 20.0);
        ProductCatalog.applyDiscount(phone1, 5.0);

        catalog.displayCatalog();
    }
}

