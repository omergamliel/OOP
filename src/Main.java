import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static Clothing createClothing() {
        System.out.println("----------------------------------\n**** Creating a new clothing item: ****");
        System.out.println("1) Clothing Type: ");
        System.out.println("Note: Only letters at least 5 in length");
        System.out.print("Enter: ");
        String inputType = input.next();

        System.out.println("2) Clothing BarCode: ");
        System.out.println("Note: Contains numbers and letters, longer than 8");
        System.out.print("Enter: ");
        String inputBarCode = input.next();

        System.out.println("3) Clothing Price: ");
        System.out.println("Note: Price higher than 50 NIS");
        System.out.print("Enter: ");
        double inputPrice = input.nextDouble();

        System.out.println("4) Clothing Gender: ");
        System.out.println("Note: Gender Values- [Male,Female,Both]");
        System.out.print("Enter: ");
        String inputGender = input.next();

        System.out.println("5) Clothing Sale: ");
        System.out.println("Note: Values- [true,false]");
        System.out.print("Enter: ");
        boolean inputSale = input.nextBoolean();

        System.out.println("\n** The garment has been created successfully! **");
        System.out.println("----------------------------------");
        return new Clothing(inputType, inputBarCode, inputPrice, inputGender, inputSale);
    }

    public static Store createStore() {
        System.out.println("----------------------------------\n**** Creating a new store: ****");
        System.out.println("1) Store Name: ");
        System.out.println("Note: Only letters at least 2 in length");
        System.out.print("Enter: ");
        String inputName = input.next();

        input.nextLine();

        System.out.println("2) Store Address: ");
        System.out.println("Note: The location of the store");
        System.out.print("Enter: ");
        String inputAddress = input.nextLine();

        System.out.println("3) Store Style: ");
        System.out.println("Note: Values- [Day,Night]");
        System.out.print("Enter: ");
        String inputStyle = input.next();

        System.out.println("4) Store Open Hours: ");
        System.out.println("Note: Format- [HH:MM] (24 hour clock)");
        System.out.print("Enter: ");
        String inputOpenHours = input.next();

        System.out.println("\n** The store was successfully created! **");
        System.out.println("----------------------------------");
        return new Store(inputName, inputAddress, inputStyle, inputOpenHours);
    }


    public static void main(String[] args) {
        System.out.println("********************************************");
        System.out.println("*     EX_3_ID_209052786 | OMER GAMLIEL     *");
        System.out.println("*        Welcome to Clothing Store         *");
        System.out.println("*           Management Software            *");
        System.out.println("********************************************");
        //Creating clothes type objects:
        Clothing Dress = createClothing();
        Clothing Shirt = createClothing();
        Clothing Pants = createClothing();
        Clothing Skirt = createClothing();
        Clothing Scarf = createClothing();

        //Creating clothing store type objects:
        Store Renuar = createStore();
        Store Castro = createStore();
        Store[] arrayStores = { Renuar, Castro };

        //Adding clothes to stores:
        System.out.println();
        Renuar.addClothing(Dress);
        Renuar.addClothing(Shirt);
        Castro.addClothing(Pants);
        Castro.addClothing(Skirt);
        Castro.addClothing(Scarf);

        System.out.println();

        //Using the methods of the garment:
        // Print the clothing type of Dress and set a new value for it
        System.out.println("The clothing type of Dress is " + Dress.getClothingType());
        Dress.setClothingType("Natural");
        System.out.println("The clothing type of Dress has been updated to " + Dress.getClothingType());

        System.out.println();

        // Print the barcode of Shirt and set a new value for it
        System.out.println("The barcode of Shirt is " + Shirt.getBarCode());
        Shirt.setBarCode("A9G6C4J2XZ");
        System.out.println("The barcode of Shirt has been updated to " + Shirt.getBarCode());

        System.out.println();

        // Print the price of Pants and set a new value for it
        System.out.println("The price of Pants is " + Pants.getPrice());
        Pants.setPrice(120.5);
        System.out.println("The price of Pants has been updated to " + Pants.getPrice());

        System.out.println();

        // Print the gender fit of Skirt and set a new value for it
        System.out.println("The gender fit of Skirt is " + Skirt.getGender_fit());
        Skirt.setGender_fit("Both");
        System.out.println("The gender fit of Skirt has been updated to " + Skirt.getGender_fit());

        System.out.println();

        // Print whether Scarf is on sale or not and set a new value for it
        System.out.println("Is Scarf on sale? " + Scarf.isSale());
        Scarf.setSale(false);
        System.out.println("The sale status of Scarf has been updated to " + Scarf.isSale());

        System.out.println();

        // Check if Dress is equal to Shirt and print the result
        System.out.println("Is Dress equal to Shirt? " + Dress.equals(Shirt));

        System.out.println();

        // Print the string representation of Pants
        System.out.println("Here are the details of Pants: " + Pants.toString());

        System.out.println();

        // Check if Scarf is a great deal and print the result
        System.out.println("Is Scarf a great deal? " + Scarf.greatDeal());

        System.out.println();

        //Using the store's methods:
        // Print the current store name and set it to a new value
        System.out.println("Current store name: " + Renuar.getStoreName());
        Renuar.setStoreName("RenuarKing");
        System.out.println("New store name: " + Renuar.getStoreName());

        System.out.println();

        // Print the current address and set it to a new value
        System.out.println("Current address: " + Renuar.getAddress());
        Renuar.setAddress("Haifa");
        System.out.println("New address: " + Renuar.getAddress());

        System.out.println();

        // Print the current open hours and set it to a new value
        System.out.println("Current open hours: " + Renuar.getOpenHours());
        Renuar.setOpenHours("10:00");
        System.out.println("New open hours: " + Renuar.getOpenHours());

        System.out.println();

        // Print the current type of clothing sold and set it to a new value
        System.out.println("Current day/night clothing type: " + Renuar.getDayNightCloth());
        Renuar.setDayNightCloth("Night");
        System.out.println("New day/night clothing type: " + Renuar.getDayNightCloth());

        System.out.println();

        // Print the list of clothes in the Renuar store
        System.out.println("List of clothes in Renuar store: " + Renuar.getClothesList());

        System.out.println();

        // Check if the Renuar and Castro stores are equal
        System.out.println("Are the Renuar and Castro stores equal? " + Renuar.equals(Castro));

        System.out.println();

        // Print a string representation of the Renuar store
        System.out.println("String representation of the Renuar store: " + Renuar.toString());

        System.out.println();

        // Find a clothing item in the Renuar store by barcode
        System.out.println("Finding clothing item with barcode A9G6C4J2XZ in Renuar store: " + Renuar.findClothing("A9G6C4J2XZ"));

        System.out.println();

        // Add a clothing item (Pants) to the Renuar store
        Renuar.addClothing(Pants);
        System.out.println("Added Pants to Renuar store.");

        System.out.println();

        // Remove a clothing item (Dress) from the Renuar store
        Renuar.removeClothing(Dress);
        System.out.println("Removed Dress from Renuar store.");

        System.out.println();

        // Compute the average price of clothing items with the clothing type "Natural" in the Castro store
        System.out.println("Average price of clothing items with clothing type Natural in Castro store: " + Castro.computePriceAvaregeClothingType("Natural"));

        System.out.println();

        // Compute the VAT for a clothing item (Scarf) with a price of 298.5 NIS in the Castro store
        Castro.computeVAT(Scarf, 298.5);

        System.out.println();

        // Compute the discount for a clothing item (Skirt) in the Castro store
        System.out.println("Discount for a clothing item (Skirt) in the Castro store: " + Castro.computeDisscount(Skirt) + "%");

        System.out.println();

        // Compute the percentage of clothing items that fit both genders in the Castro store
        System.out.println("Percentage of clothing items that fit both genders in the Castro store: " + Castro.computePercentageByGender("Both") + "%");

        System.out.println();

        // Check for any great deals in the Renuar store
        System.out.println("Checking for any great deals in the Renuar store...");
        Renuar.checkGreatDeals();

        System.out.println();

        System.out.println("Printing clothing in Renuar store:");
        Renuar.printClothing();

        System.out.println();

        System.out.println("Printing clothing in Castro store:");
        Castro.printClothing();
    }
}
    