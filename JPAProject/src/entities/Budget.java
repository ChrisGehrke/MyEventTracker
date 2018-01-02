
package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="expenses")
@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private double moneyspent;
	private double moneysaved;
	
	
	
	

public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getMoneyspent() {
		return moneyspent;
	}
	public void setMoneyspent(double moneyspent) {
		this.moneyspent = moneyspent;
	}
	public double getMoneysaved() {
		return moneysaved;
	}
	public void setMoneysaved(double moneysaved) {
		this.moneysaved = moneysaved;
	}
	@Override
	public String toString() {
		return "Budget [id=" + id + ", category=" + category + ", moneyspent=" + moneyspent + ", moneysaved="
				+ moneysaved + "]";
	}

}