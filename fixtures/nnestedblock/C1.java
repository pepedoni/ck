package nnestedblock;

public class C1 {

	int a = 0;

	public void m1() {
		if (a > 10) {
			a++;
			for(;;) {
				return;
			}
			
		} else {
			a--;
			for (int i = 0; i < 10; i++) {
				a++;
				
				
			}
		}
	}
}
