package org.example.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.example.pizzeria.pojo.Pizza;
import org.example.pizzeria.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PizzaController {

		@Autowired
		private PizzaService pizzaService;
		
		@GetMapping("/")
		public String home() {
			return "home";
		}
		
		@GetMapping("/pizze")
		public String getHome(Model model) {
			
			List<Pizza> pizze = pizzaService.findAll();
			
			model.addAttribute("pizze", pizze);
			
			return "pizza_index";
		}
		
		@GetMapping("/pizze/{id}")
		public String getPizza(
				Model model,
				@PathVariable("id") int id
		) {
			
			Optional<Pizza> optPizza = pizzaService.findById(id);
			Pizza pizza = optPizza.get();
			
			model.addAttribute("pizza", pizza);
			
			return "pizza_show";
		}
}
