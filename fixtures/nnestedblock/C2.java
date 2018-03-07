package nnestedblock;

public class C2 {

	int a = 0;

	{	
		return;
	}
	
	public void m2() {
	
			if (a > 10) {
				a++;
			} else {
				a--;
			}
	
			{
				
				return;
			}
			
	}
}
