package java1016;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=2; i<=a; i++) {
            System.out.print("*");
            for(int j = 1; j<=b; j++) {
            	System.out.print("*");
            	 System.out.print("\n");
            }
        }
        System.out.println(a + b);
	}

}
