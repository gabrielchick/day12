package vttp.batchb.ssf.day12.models;

import java.util.LinkedList;
import java.util.List;

public class Constants { // Defines a utility class with constant data and methods for generating line items.
    
    public static final String[] ITEMS = { // Array of item names, defined as a constant.
        "apple", "orange", "pear", "grapes", "plum" // A list of fruit names.
    };

    public static final int[] QUANTITY = { // Array of quantities corresponding to the items, defined as a constant.
        10, 5, 8, 3, 7 // Quantities for the items in the same order as the ITEMS array.
    };

    public static List<LineItem> generateLineItems(int count) { // Method to generate a list of LineItem objects.
        List<LineItem> items = new LinkedList<>(); // Create a LinkedList to hold LineItem objects.

        if (count > ITEMS.length) // If the count exceeds the number of items available...
            count = ITEMS.length; // Limit the count to the length of the ITEMS array.

        for (int i = 0; i < count; i++) { // Loop from 0 to count (exclusive).
            LineItem li = new LineItem(); // Create a new LineItem object.
            li.setName(ITEMS[i]); // Set the name of the LineItem to the corresponding item in the ITEMS array.
            li.setQuantity(QUANTITY[i]); // Set the quantity of the LineItem to the corresponding value in the QUANTITY array.
            items.add(li); // Add the LineItem object to the list.
        }

        return items; // Return the list of generated LineItem objects.
    }

    public static List<LineItem> generateLineItems() { // Overloaded method to generate all line items.
        return generateLineItems(ITEMS.length); // Calls the other method with the maximum count of items.
    }
}

// Big Idea Behind the Code
// Utility Class for Line Items:

// This class provides a centralized way to define and generate LineItem objects using constant arrays for item names and their corresponding quantities.
// Generating Line Items:

// The generateLineItems(int count) method allows creating a specified number of line items, ensuring the count does not exceed the available data.
// The overloaded generateLineItems() method simplifies the process by generating line items for all available items.
// Constants for Data:

// The ITEMS and QUANTITY arrays act as predefined data for items and their quantities, ensuring consistency and ease of updates.
// Use of LinkedList:

// A LinkedList is used to store the generated LineItem objects, which might be preferred for its dynamic sizing and fast insertion.
// Can This Code Always Be the Same?
// General Structure:

// The pattern of using constants and utility methods for generating objects can remain the same in similar use cases.
// The logic for limiting the count to the size of available data and looping to generate objects is universal.
// Specific Implementation:

// The ITEMS and QUANTITY arrays are specific to this application and will vary depending on the domain (e.g., inventory items in an e-commerce system).
// The LineItem class methods (setName, setQuantity) depend on the structure of the LineItem class.
// Potential Customizations:

// The choice of LinkedList over ArrayList or other collections may vary based on performance considerations or other requirements.
// This is a reusable design pattern but is tailored to the specific context of the LineItem class and its associated data.