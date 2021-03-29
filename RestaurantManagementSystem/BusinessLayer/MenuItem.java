package BusinessLayer;

import java.io.Serializable;

public interface MenuItem extends Serializable {
	int computePrice();
	String getName();
	void setName(String n);
	void setPrice(int pret);

}
