import java.util.LinkedList;
import java.util.List;

public class gitsTest {
	public static void main(String[] args) {
		System.out.println("Hello GITHUB");
		
		
		List<Long> list = new LinkedList<Long>();
		for(Long i=0L; i<20; i++) {
			list.add(i);
			
		}
		for(Long l: list) {
			System.out.print(l+" ");
		}
		
		System.out.println("Check stash");
		
 	}
}
