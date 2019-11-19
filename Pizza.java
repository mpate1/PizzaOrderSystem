import java.io.Serializable;
import java.util.Objects;

/**
 * This is the pizza class for assignment 3. The class creates a pizza, containing the size, 
 * the amount of cheese, ham, green pepper and pineapple whether it's none, single, (double or triple (for cheese)). 
 * This class is also able to generate the cost of the created pizza using hard-coded prices.
 */

public class Pizza implements Serializable {


	final private String size;
	final private String cheese;
	final private String ham;
	final private String greenPepper;
	final private String pineapple;

	/**
	 * @param woulc be the default constructor which creates a small single cheese pizza with single ham.
	 */
	public Pizza() {
		this.size = "small";
		this.cheese = "single";
		this.ham = "single";
		this.greenPepper = "none";
		this.pineapple = "none";
	} // end Pizza

	/**
	 * @param size must be small, medium or large
	 * @param cheese must be single, double or triple
	 * @param ham must be none or single
	 * @param greenPepper must be none or single
	 * @param pineapple must be none or single
	 * @throws IllegalPizza
	 */
	public Pizza(String size, String cheese, String pineapple, String greenPepper, String ham) throws IllegalPizza {
		if (cheese == null || greenPepper == null || ham == null || size == null || pineapple == null ) {
			throw new IllegalPizza("Cannot enter null.");
		}
		size = size.toLowerCase();
		cheese = cheese.toLowerCase();
		ham = ham.toLowerCase();
		greenPepper = greenPepper.toLowerCase();
		pineapple = pineapple.toLowerCase();
		if (!size.equals("small") && !size.equals("medium") && !size.equals("large")) {
			throw new IllegalPizza("You selected an invalid size.");
		}
		if (!cheese.equals("single") && !cheese.equals("double") && !cheese.equals("triple")) {
			throw new IllegalPizza("You selected an invalid selection for the cheese topping, it will be defaulted to single cheese.");
		}
		if (!ham.equals("none") && !ham.equals("single")) {
			throw new IllegalPizza("You selected an invalid selection for the ham topping, it will default to no ham.");
		}
		if (!greenPepper.equals("single") && !greenPepper.equals("none")) {
			throw new IllegalPizza("You selected an invalid selection for the green pepper topping, it will default to green pepper.");
		}
		if (!pineapple.equals("single") && !pineapple.equals("none")) {
			throw new IllegalPizza("You selected an invalid selection for the pineapple topping, it will default to pineapple");
		}
		if (ham.equals("none") && !greenPepper.equals("none")) {
			throw new IllegalPizza("You need to have ham in order to select green pepper.");
		}
		if (ham.equals("none") && !pineapple.equals("none")) {
			throw new IllegalPizza("You need to have ham in order to select pineapple.");
		}

		this.size = size;
		this.cheese = cheese;
		this.ham = ham;
		this.greenPepper = greenPepper;
		this.pineapple = pineapple;

	} // end Pizza
	/**
	 * @param There are no parameters passed
	 * @return The total topping price is returned 
	 */
	public double toppingPrice() { 
		double cost = 0;
		if (cheese.equals("double")) {
			cost += 1.50;
		}
		if (cheese.equals("triple")) {
			cost += 3;
		}
		if (ham.equals("single")) {
			cost += 1.50;
		}
		if (greenPepper.equals("single")) {
			cost += 1.50;
		}
		if (pineapple.equals("single")) {
			cost += 1.50;
		}
		return cost;
	} // end toppingPrice

	/**
	 * @param no parameters passed
	 * @return cost of pizza based on the size, and the amount of toppings (can be referred through the toppingPrice method).
	 */
	public double getCost() {
		double cost = 0;
		if (size.equals("small")) {
			cost += 7;
		}
		if (size.equals("medium")) {
			cost += 9;
		}
		if (size.equals("large")) {
			cost += 11;
		}
		cost += toppingPrice();
		return cost;
	} // end getCost

	/**
	 * @param pizza object is passed through 
	 * @return boolean based on similarity (.equals) of the object passed in as a parameter and the instance of pizza.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pizza))
			return false;
		Pizza p = (Pizza) obj;
		return Objects.equals(p.cheese, this.cheese)
				&& Objects.equals(p.ham,  this.ham)
				&& Objects.equals(p.size,  this.size)
				&& Objects.equals(p.greenPepper,  this.greenPepper)
				&& Objects.equals(p.pineapple,  this.pineapple);
	} //end equals

	@Override
	/** 
	 * @param No parameters
	 * @return a string with the description of the pizza order and the associated cost.
	 * Uses .equals to compare the strings
	 */
	public String toString() {
		return String.format(
				"%s pizza, %s cheese%s%s%s. Cost: $%.2f each.", 
				size,
				cheese,
				pineapple.equals("none")?"":", pineapple",
				greenPepper.equals("none")?"":", green pepper",
				ham.equals("none")?"":", ham",
				getCost()
				);
	} // end toString

	/**
	 * @param nothing
	 * @return the copy of the present pizza object.
	 */
	@Override
	public Pizza clone() {
		Pizza pizza1 = null;
		try {
			pizza1 = new Pizza(size, cheese, pineapple, greenPepper, ham);
		} catch (IllegalPizza __) { 
			// This should not occur
			return null;
		} // end try/catch
		return pizza1;
	} // end clone








}