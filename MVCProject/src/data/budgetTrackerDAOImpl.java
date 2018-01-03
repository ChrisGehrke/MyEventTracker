
package data;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Budget;

@Transactional
@Repository
public class budgetTrackerDAOImpl implements budgetTrackerDAO {
		@PersistenceContext
		private EntityManager em;
		
		@Override
		public List<Budget> show(){
			String query = "SELECT s FROM Budget s";
			List<Budget> spending = em.createQuery(query, Budget.class).getResultList();
			return spending;
		}
		
		@Override
		public Budget getBudget(int id) {
			return em.find(Budget.class, id);
		}
		@Override
		public Budget addBudget(String json) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				Budget newBudget = mapper.readValue(json, Budget.class);
				em.persist(newBudget);
				return newBudget;
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		@Override
		public Budget updateBudget(String json, int id) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				Budget moreSpend = mapper.readValue(json, Budget.class);	
				Budget lastSpend = em.find(Budget.class, id);
				lastSpend.setCategory(moreSpend.getCategory());
				lastSpend.setMoneyspent(moreSpend.getMoneyspent());
				lastSpend.setMoneysaved(moreSpend.getMoneysaved());
				em.persist(lastSpend);
				return lastSpend;
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		@Override
		public boolean deleteBudget(int id) {
			try {
				em.remove(getBudget(id));
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		
		
}