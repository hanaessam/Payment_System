package refunds;

import java.util.List;

public interface Observer {
	public boolean requestRefund(int amount);
	public void update();
}