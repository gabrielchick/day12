package vttp.batchb.ssf.day12.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Marks this class as a Spring MVC controller.
@RequestMapping("/weather") // Base URL mapping for all endpoints in this controller.
public class WeatherController {

   // Handles GET requests to "/weather"
   @GetMapping
   public String getWeather(
         @RequestParam(defaultValue = "metrics") String unit, // Query parameter "unit" with default value "metrics".
         Model model) { // Model object to pass data to the view.

      // Add "singapore" as the default city to the model.
      model.addAttribute("city", "singapore");
      // Add the "unit" query parameter value (or default value) to the model.
      model.addAttribute("unit", unit);

      return "weather"; // Return the view name "weather".
   }
   
   // Handles GET requests to "/weather/{city}"
   @GetMapping("{city}")
   public String getWeather(
         @PathVariable String city, // Path variable to capture the city from the URL.
         @RequestParam(defaultValue = "metrics") String unit, // Query parameter "unit" with default value "metrics".
         Model model) { // Model object to pass data to the view.

      // Add the captured city name to the model.
      model.addAttribute("city", city);
      // Add the "unit" query parameter value (or default value) to the model.
      model.addAttribute("unit", unit);

      return "weather"; // Return the view name "weather".
   }
}

// Big Idea Behind the Code
// Controller Purpose:

// This controller provides weather-related functionality.
// It maps requests to URLs such as /weather and /weather/{city} and prepares data for the weather view.

// Dynamic City Handling:
// The /weather endpoint uses a default city (singapore) and allows a unit parameter (e.g., metrics or imperial units).
// The /weather/{city} endpoint dynamically sets the city based on the URL and allows a unit parameter as well.

// Model Data:
// Both methods populate the Model with city and unit attributes, which can be used in the weather view for rendering weather-related information.

// Can This Code Always Be the Same?
// Annotations: The @Controller, @RequestMapping, and @GetMapping annotations are standard and will remain the same in most Spring MVC applications.
// Path and Query Parameters:
// The @PathVariable annotation is used for capturing dynamic URL segments like {city}, which is common in REST-like designs.
// The @RequestParam with a default value is a standard way to handle optional query parameters.
// Default Values:
// The default city ("singapore") and unit ("metrics") are specific to this application. These values might change based on the application's requirements.
// View Name:
// The view name weather may vary based on your application’s structure or theming needs.