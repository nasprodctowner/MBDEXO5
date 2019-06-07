package messageExo5;

import javax.ejb.Local;

@Local()
public interface convertItfLocale {
	public int euroToDollar(int euros);
	public int dollarToEuro(int dollars);
}
