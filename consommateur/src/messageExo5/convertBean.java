package messageExo5;

import javax.ejb.Stateless;

@Stateless
public class convertBean implements convertItfLocale {
	private int euroRate = 1;
	private int dollarRate = 1;
	public int euroToDollar(int euros) {
		return euros*dollarRate;
	}
	public int dollarToEuro(int dollars) {
		return dollars*euroRate;
	}
}
