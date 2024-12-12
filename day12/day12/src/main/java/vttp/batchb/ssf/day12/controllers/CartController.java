package vttp.batchb.ssf.day12.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.batchb.ssf.day12.models.LineItem;
import vttp.batchb.ssf.day12.models.Constants;

@Controller // Marks this class as a Spring MVC controller.
@RequestMapping("/cart") // Base URL mapping for all endpoints in this controller.
public class CartController {

   // Handles GET requests to "/cart"
   @GetMapping
   public String getCart(
      @RequestParam(required = false) String name, // Optional query parameter "name".
      //@RequestParam(defaultValue = "4") int count, // Optional query parameter "count" with a default value (commented out).
      @RequestParam(required = false) String count, // Optional query parameter "count" as a String for parsing.
      Model model) { // Model object to pass data to the view.

      int itemCount = 3; // Default item count.
      try {
         itemCount = Integer.parseInt(count); // Attempt to parse "count" as an integer.
      } catch (Exception ex) { } // If parsing fails, retain the default itemCount.

      // Generate a list of LineItems based on the item count.
      List<LineItem> items = Constants.generateLineItems(itemCount);

      // Add the name (converted to uppercase) to the model.
      model.addAttribute("name", name.toUpperCase());
      // Add the generated items list to the model.
      model.addAttribute("items", items);
      // Add a static count value (9) to the model.
      model.addAttribute("count", 9);

      return "cart"; // Return the view name "cart".
   }

   // Handles GET requests to "/cart/map"
   @GetMapping("/map")
   public String getCart(
      @RequestParam MultiValueMap<String, String> form, // Accepts multiple query parameters as a map.
      Model model) { // Model object to pass data to the view.

      // Retrieve the first value of the "name" parameter from the map.
      String name = form.getFirst("name");
      // Retrieve the first value of the "count" parameter from the map.
      String count = form.getFirst("count");

      // Print the first "delivery" parameter value and the list of "delivery" parameter values to the console.
      System.out.printf(">>>>>   get first: %s\n", form.getFirst("delivery"));
      System.out.printf(">>>>>   get: %s\n", form.get("delivery"));

      int itemCount = 3; // Default item count.
      try {
         itemCount = Integer.parseInt(count); // Attempt to parse "count" as an integer.
      } catch (Exception ex) { } // If parsing fails, retain the default itemCount.

      // Generate a list of LineItems based on the item count.
      List<LineItem> items = Constants.generateLineItems(itemCount);

      // Add the name (converted to uppercase) to the model.
      model.addAttribute("name", name.toUpperCase());
      // Add the generated items list to the model.
      model.addAttribute("items", items);
      // Add a static count value (9) to the model.
      model.addAttribute("count", 9);

      return "cart"; // Return the view name "cart".
   }
}

// Big Idea Behind the Code
// Controller Purpose:

// This controller manages cart-related endpoints (/cart and /cart/map).
// It retrieves data from query parameters, processes it, and populates the Model with attributes to be rendered in a view named cart.
// Query Parameter Handling:

// For /cart, individual query parameters (name and count) are used.
// For /cart/map, a MultiValueMap is used to handle multiple query parameters flexibly.
// Line Item Generation:

// A list of LineItem objects is generated dynamically based on the count parameter. These items simulate the contents of a shopping cart.
// View Data:

// The processed data, including name, items, and a static count, is added to the Model for display in the view.
// Can This Code Always Be the Same?
// Annotations: The use of @Controller, @RequestMapping, and @GetMapping remains the same for most Spring MVC projects.
// Dynamic Behavior:
// The @RequestParam parameters can vary depending on the application's requirements. For example, you might add or remove parameters.
// The Constants.generateLineItems method is specific to your application's logic and may not exist elsewhere.
// Model Attributes: The attributes added to the Model (e.g., name, items, count) can vary based on what data the view needs.
// Error Handling: The current implementation silently ignores exceptions when parsing count. In some scenarios, logging or error messages may be preferred.