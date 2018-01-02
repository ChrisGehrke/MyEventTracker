package data;


	import java.util.List;

	import entities.Budget;

	public interface budgetTrackerDAO {

		List<Budget> show();

		Budget getBudget(int id);

		Budget addBudget(String json);

		Budget updateBudget(String json, int id);
		
		boolean deleteBudget(int id);

	}

