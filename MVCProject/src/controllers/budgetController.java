
	
	package controllers;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	
import data.budgetTrackerDAO;
import entities.Budget;

	@RestController
	public class budgetController {
		@Autowired
		private budgetTrackerDAO dao;
		
		@RequestMapping(path="/exspenses", method =RequestMethod.GET)
		public List<Budget> spend() {
			return dao.show();
		}
		
		@RequestMapping(path="/exspenses/{id}", method =RequestMethod.GET)
		public Budget spend(@PathVariable int id) {
			return dao.getBudget(id);
		}
		
		@RequestMapping(path="/exspenses/{id}", method =RequestMethod.DELETE)
		public boolean delete(@PathVariable int id) {
			return dao.deleteBudget(id);
		}
		
		@RequestMapping(path="/expenses", method =RequestMethod.POST)
		public Budget add(@RequestBody String json) {
			return dao.addBudget(json);
		}
		
		@RequestMapping(path="/expenses/{id}", method =RequestMethod.PUT)
		public Budget update(@RequestBody String json, @PathVariable int id) {
			return dao.updateBudget(json,id);
		}	
		

	}


