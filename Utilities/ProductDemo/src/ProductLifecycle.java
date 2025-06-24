public class ProductLifecycle {

    // prints a labeled banner
    private static void banner(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    public static void main(String[] args) {

        banner("Step 1: create product");
        Product apple = new Product("Apple", 0.40, 3);
        System.out.println("Created -> " + apple);

        banner("Step 2: add inventory (+10)");
        int before = apple.getCount();
        apple.setCount(before + 10);                      // simulate addInventory
        System.out.printf("Before: %d | After: %d%n", 
                          before, apple.getCount());

        banner("Step 3: sell inventory (-5)");
        before = apple.getCount();
        apple.setCount(before - 5);                       // simulate sellInventory
        System.out.printf("Before: %d | After: %d%n", 
                          before, apple.getCount());

        banner("Step 4: update fields");
        System.out.println("Before setters -> " + apple);
        String newCode  = "Golden Delicious Apple";
        double newPrice = 0.55;
        int    newQty   = 4;

        apple.setCode(newCode);
        apple.setPrice(newPrice);
        apple.setCount(newQty);

        System.out.println("After setters  -> " + apple);
        banner("Demo complete");
    }
}
