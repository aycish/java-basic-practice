package designpattern.decorator;

public class Kia implements ICar {

	private int price;

	public Kia(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void showPrice() {
		System.out.println("Kia's price is " + this.price + ".");
	}
}
