// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra 
{
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)) + " is 2 + 4*2");  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5) + "is 3^5");      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5) + "is 5/5");    // 5 / 5  
   		System.out.println(div(25,7) + "is 25/7");   // 25 / 7
   		System.out.println(mod(25,7) +"is 25%7");   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(times(5,8));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		for(int i = 0; i<x2; i++)
			x1++;
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		for(int i = 0; i<x2; i++)
			x1--;
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mult = 0;
		for(int i = 0; i<x2; i++)
			mult = plus(mult,x1);
		return mult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		for(int i = 0; i<n; i++)
			sum = times(sum,x);
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
		for (int num = 0; num <= x1 ; num++) {
			if (x1 == times(x2, num)) {
				return num;
			} 
			else
				if (x1 < times(x2, num)) {
					return (num--);
				}
	    }		
		return 0;			
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2)
	{
		int num = div(x1,x2);
		int rmnd = minus(x1, times(x2,num));
		return rmnd;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		boolean tobe = false;
		int number = 0;
		for(int num = 0; num < x && !tobe; num++)
		{
		    int nextnum = num++; 
			if(pow(num,2)==x || pow(nextnum,2) >x)
			{
				tobe = true ; 
				number = num;
			}
		}
	    return number;
	}	  	  
}