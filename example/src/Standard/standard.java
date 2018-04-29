package Standard;
import java.util.Random;
import java.util.Scanner;
public class standard {		
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 Random r = new Random();
		 System.out.println(" Enter The Array 1 Raw and Colomns : ");
			System.out.print(" The Rows is :");
			int num1 =scan.nextInt();
			System.out.print(" The colomns is :");
			int num2 = scan.nextInt();
			int stand1 [][] = new int [num1][num2];	
			System.out.println(" The Array 1 is :");
			for ( int i =0 ; i<num1 ; i++) {
				for (int y=0; y<num2 ; y++) {
					stand1 [i] [y] = r.nextInt(4);
					System.out.print(stand1[i][y] +"\t");
				}
				System.out.println();
			}
			System.out.println("====================================");
			System.out.println(" Enter The Array 2 Raw and Colomns : ");
			System.out.print(" The Rows is :");
			int num3 =scan.nextInt();
			System.out.print(" The colomns is :");
			int num4 = scan.nextInt();
			System.out.println(" The Array 2 is :");
			int stand2 [][]= new int[num3][num4];
			for (int q=0 ; q<num3; q++) {
				for (int p=0; p<num4; p++) {
					stand2[q][p] = r.nextInt(4);
				
					System.out.print(stand2[q][p]+"\t");
				}
				System.out.println();
			}
			scan.close();
			System.out.println("====================================== ");
			if ( num1==num4) {
				System.out.println(" Successful  operation  ^_^  ");
				System.out.println(" ");
				int stand3 [] [] = new int [num1][num4];
				for (int m=0;m<num1;m++) {
					for (int n=0; n<num4; n++) {
						for(int v=0 ; v<stand3.length ;v++) {		
					stand3[m][n]= stand3[m][n]+stand1[m][v]* stand2[v][n];	
						
					}
						System.out.print(stand3[m][n] +"\t");
					}
					System.out.println();
				}			
			}else {
				System.out.println(" A failed hit operation ");
			}
			}
	}

	
		
	

