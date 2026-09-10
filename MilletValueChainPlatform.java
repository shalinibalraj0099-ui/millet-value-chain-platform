import java.util.*;

class Farmer {
    int id;
    String name;
    String location;

    Farmer(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    void display() {
        System.out.println("Farmer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
    }
}

class MilletProduct {
    int productId;
    String name;
    double price;
    int quantity;
    String certification;
    String farmerName;

    MilletProduct(int productId, String name, double price,
                  int quantity, String certification, String farmerName) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.certification = certification;
        this.farmerName = farmerName;
    }

    void displayProduct() {
        System.out.println("--------------------------------");
        System.out.println("Product ID : " + productId);
        System.out.println("Product    : " + name);
        System.out.println("Price/kg   : Rs." + price);
        System.out.println("Quantity   : " + quantity + " kg");
        System.out.println("Quality    : " + certification);
        System.out.println("Farmer     : " + farmerName);
    }
}

class Buyer {
    String name;

    Buyer(String name) {
        this.name = name;
    }

    void purchase(MilletProduct product, int quantity) {
        if (product.quantity >= quantity) {
            product.quantity -= quantity;
            double amount = quantity * product.price;

            System.out.println("\nPurchase Successful");
            System.out.println("Buyer : " + name);
            System.out.println("Product : " + product.name);
            System.out.println("Quantity : " + quantity + " kg");
            System.out.println("Amount Paid : Rs." + amount);
        } else {
            System.out.println("Insufficient Stock");
        }
    }
}

class Traceability {
    void showTrace(MilletProduct product) {
        System.out.println("\n---- Farm To Fork Traceability ----");
        System.out.println("Farm : " + product.farmerName);
        System.out.println("Crop : " + product.name);
        System.out.println("Quality Certification : " + product.certification);
        System.out.println("Processing : Verified");
        System.out.println("Consumer : Delivered");
    }
}

public class MilletValueChainPlatform {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Farmer> farmers = new ArrayList<>();
    static ArrayList<MilletProduct> products = new ArrayList<>();

    public static void main(String args[]) {
        while (true) {
            System.out.println("\n===== MILLETS VALUE CHAIN PLATFORM =====");
            System.out.println("1. Register Farmer");
            System.out.println("2. Add Millet Product");
            System.out.println("3. View Marketplace");
            System.out.println("4. Buy Product");
            System.out.println("5. Product Traceability");
            System.out.println("6. View Registered Farmers");
            System.out.println("7. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Farmer ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Farmer Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Location : ");
                    String loc = sc.nextLine();

                    farmers.add(new Farmer(id, name, loc));
                    System.out.println("Farmer Registered Successfully");
                    break;

                case 2:
                    System.out.print("Product ID : ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Millet Name : ");
                    String millet = sc.nextLine();

                    System.out.print("Price per Kg : ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity : ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Quality Certification : ");
                    String cert = sc.nextLine();

                    System.out.print("Farmer Name : ");
                    String farmer = sc.nextLine();

                    products.add(new MilletProduct(pid, millet, price, qty, cert, farmer));
                    System.out.println("Product Added");
                    break;

                case 3:
                    System.out.println("\nAVAILABLE MILLET PRODUCTS");
                    for (MilletProduct p : products) {
                        p.displayProduct();
                    }
                    break;

                case 4:
                    System.out.print("Enter Buyer Name : ");
                    sc.nextLine();
                    String buyerName = sc.nextLine();

                    System.out.print("Enter Product ID : ");
                    int search = sc.nextInt();

                    System.out.print("Enter Quantity : ");
                    int quantity = sc.nextInt();

                    for (MilletProduct p : products) {
                        if (p.productId == search) {
                            Buyer b = new Buyer(buyerName);
                            b.purchase(p, quantity);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter Product ID : ");
                    int trace = sc.nextInt();

                    for (MilletProduct p : products) {
                        if (p.productId == trace) {
                            Traceability t = new Traceability();
                            t.showTrace(p);
                        }
                    }
                    break;

                case 6:
                    System.out.println("\nREGISTERED FARMERS");
                    if (farmers.isEmpty()) {
                        System.out.println("No farmers registered.");
                    } else {
                        for (Farmer registeredFarmer : farmers) {
                            registeredFarmer.display();
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
