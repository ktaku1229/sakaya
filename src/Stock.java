import java.util.ArrayList;

public class Stock {

	private ArrayList<Drink> stock = new ArrayList<Drink>();

	public ArrayList<Drink> getStock() {
		return stock;
	}

	public void setStock(Drink drink) {
		this.stock.add(drink);
	}
}
