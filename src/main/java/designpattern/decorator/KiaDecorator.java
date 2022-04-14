package designpattern.decorator;

public class KiaDecorator implements ICar {

	protected ICar kia;
	protected String modelName;
	protected int modelPrice;

	public KiaDecorator(ICar kia, String modelName, int modelPrice) {
		this.kia = kia;
		this.modelName = modelName;
		this.modelPrice = modelPrice;
	}

	@Override
	public int getPrice() {
		return kia.getPrice() + modelPrice;
	}

	@Override
	public void showPrice() {
		System.out.println(modelName + "'s price is : " + getPrice() + ".");
	}
}
