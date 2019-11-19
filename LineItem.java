import java.io.Serializable;

/**
 * This is the LineItem classed used for assignment 3. 
 * This class exhibits the single line item that is in a pizza order. 
 * It is associated with the pizza objext and the number of pizzas being ordered. 
 */

public class LineItem implements Comparable<LineItem>, Serializable {


	Pizza pizza;
	private int zaNum;
	/** 
	 * @param the object pizza
	 * @throws IllegalPizza when nothing is selected. Null item.
	 * @return is pizza is "illegal" it returns a lineItem
	 */
	public LineItem(Pizza p1zza) throws IllegalPizza {
		if (p1zza == null) {
			throw new IllegalPizza("Invalid pizza selection, you need to order a minimum of one pizza.");
		}
		this.zaNum = 1;
		this.pizza = p1zza; 
	} // end LineItem
	
	
	/**
	 * @param amount of pizza and the pizza object
	 * @return lineItem of user input for the amount of pizza and the valid pizza object
	 * @throws IllegalPizza if pizza option is none or if the amount does NOT fall within the range of 1-100.
	 */
	public LineItem(int zaNums, Pizza p1zza) throws IllegalPizza { 
		if (p1zza == null) {
			throw new IllegalPizza("Invalid amount of pizza, it cannot none.");
		}
		if (zaNums < 1 || zaNums > 100) {
			throw new IllegalPizza("Invalid amount of pizza. Please stay within 1 to 100 range.");
		}
		this.zaNum = zaNums;
		this.pizza = p1zza;
	} // end LineItem
	
	
	/**
	 * @param nothing
	 * @return LineItem of the instance pizza attribute.
	 */
	public Pizza getPizza() {
		return this.pizza;
	} //  end getPizza
	
	
	/**
	 * @param none
	 * @return LineItem number of pizza instance.
	 */
	public int getNumber() {
		return this.zaNum;
	} // end getNumber
	
	
	/**
	 * @param nothing as it can be retrieved through instantiation
	 * @return the final cost of the total amount of pizza given by a specific description
	 * discounts are also added.
	 */
	public double getCost() {
		double cost = zaNum * this.pizza.getCost();
		if (zaNum > 9 & zaNum < 21) {
			cost = cost * 0.90; // 10% discount for orders between 10 to 20
		}
		if (zaNum > 21) {
			cost = cost * 0.85; // 15% discount for orders above 20
		}
		return cost;
	} // end getCost
	
	
	/**
	 * @param zaNums (amount of pizza)
	 * @throws IllegalPizza if amount of pizza entered is out of the range. ie. less than 1 but greater than 100.
	 * @return sets zaNum to desired number of pizza entered by the user.
	 */
	public void setNumber(int zaNums) throws IllegalPizza {
		if (zaNums < 1 | zaNums > 100) {
			throw new IllegalPizza("Invalid amount of pizza, please stay within the 1 to 100 range.");
		}
		this.zaNum = zaNums;
	} // end setNumber
	
	
	/**
	 * @param nothing
	 * @return a string according to the number of pizza based on the description with the total cost
	 */
	@Override
	public String toString() {
		String str;
		if (zaNum < 10) {
			str =  " "+zaNum + " " + this.pizza.toString();
		}
		else {
			str = zaNum + " " +this.pizza.toString();
		}
		return str;
	} // end toString
	
	
	/**
	 * @param object of LineItem
	 * @return 1 if parameter costs more than the Line1tem object, -1 for the vice versa instance of 1, 
	 * or 0 if the cost of the two pizza is the same, difference is negligible. 
	 */
	public int compareTo(LineItem Line1tem) {
		if (Math.abs(this.getCost() - Line1tem.getCost()) < 1) {
			return 0;
		}
		if (this.getCost() > Line1tem.getCost() ) {
			return -1;
		}
		return 1;
	} // end compareTo
} // End public class LineItem