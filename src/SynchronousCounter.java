/**
 * 
 * @author Varit Assavavisidchai
 *
 */
public class SynchronousCounter extends Counter {
	@Override
	public synchronized void add(int amount) {
		 super.total += amount;
	 }
}
