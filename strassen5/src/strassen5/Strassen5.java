
package strassen5;
 import java.io.*;
import java.util.Scanner;
public class Strassen5 {
public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
public Strassen5() throws IOException
{  
    Scanner scan = new Scanner(System.in);
int n;
int[][] a, b, c;
System.out.print("Enter the number  Rows 1 : ");
int num1=scan.nextInt();
System.out.print("Enter the number or Colomuns 1 : ");
    int num2=scan.nextInt();
a = new int[num1][num2];

System.out.print("\n\n\n Enter values for 1st Matrix:\n\n");
for(int i=0; i<num1; i++)
{
for(int j=0; j<num2; j++)
{
//System.out.print("Enter the value of cell("+(i+1)+","+(j+1)+"): ");
a[i][j] = scan.nextInt();
}
}

System.out.print("Enter the number Rows 2: ");
 int num3=scan.nextInt();
    
System.out.print("Enter the number Colomuns 2 : ");
int num4=scan.nextInt();
b = new int[num3][num4];
c = new int[num1][num4];
System.out.print("\n\n\n Enter values for 2nd Matrix:\n ");
for(int i=0; i<num3; i++)
{
for(int j=0; j<num4; j++)
{
//System.out.print("Enter the value of cell ("+(i+1)+","+(j+1)+"): ");
//b[i][j] = Integer.parseInt(br.readLine());
b[i][j] = scan.nextInt();
}
}
if (num1==num4){
    System.out.println(" Successful  operation  ^_^  ");
System.out.print("\n\n By Strassen Matrix Multiplication method:\n");
c = strassenMatrixMultiplication(a, b);
printArray(c);
}else {
    System.out.println(" ERROR  :: becouse the number of Rows in array1 not equal the columon of array2 ");
}
}  
public int [][] strassenMatrixMultiplication(int [][] A, int [][] B)
{
int n = A.length;
int [][] result = new int[n][n];
if((n%2 != 0 ) && (n !=1))
{
int[][] a1, b1, c1;
int n1 = n+1;
a1 = new int[n1][n1];
b1 = new int[n1][n1];
c1 = new int[n1][n1];
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
{
a1[i][j] =A[i][j];
b1[i][j] =B[i][j];
}
c1 = strassenMatrixMultiplication(a1, b1);
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
result[i][j] =c1[i][j];
return result;
}
if(n == 1)
{
result[0][0] = A[0][0] * B[0][0];
}
else
{
int [][] A11 = new int[n/2][n/2];
int [][] A12 = new int[n/2][n/2];
int [][] A21 = new int[n/2][n/2];
int [][] A22 = new int[n/2][n/2];
int [][] B11 = new int[n/2][n/2];
int [][] B12 = new int[n/2][n/2];
int [][] B21 = new int[n/2][n/2];
int [][] B22 = new int[n/2][n/2];
divideArray(A, A11, 0 , 0);
divideArray(A, A12, 0 , n/2);
divideArray(A, A21, n/2, 0);
divideArray(A, A22, n/2, n/2);
divideArray(B, B11, 0 , 0);
divideArray(B, B12, 0 , n/2);
divideArray(B, B21, n/2, 0);
divideArray(B, B22, n/2, n/2);
int [][] P1 = strassenMatrixMultiplication(addMatrices(A11, A22), addMatrices(B11, B22));
int [][] P2 = strassenMatrixMultiplication(addMatrices(A21, A22), B11);
int [][] P3 = strassenMatrixMultiplication(A11, subtractMatrices(B12, B22));
int [][] P4 = strassenMatrixMultiplication(A22, subtractMatrices(B21, B11));
int [][] P5 = strassenMatrixMultiplication(addMatrices(A11, A12), B22);
int [][] P6 = strassenMatrixMultiplication(subtractMatrices(A21, A11), addMatrices(B11, B12));
int [][] P7 = strassenMatrixMultiplication(subtractMatrices(A12, A22), addMatrices(B21, B22));
int [][] C11 = addMatrices(subtractMatrices(addMatrices(P1, P4), P5), P7);
int [][] C12 = addMatrices(P3, P5);
int [][] C21 = addMatrices(P2, P4);
int [][] C22 = addMatrices(subtractMatrices(addMatrices(P1, P3), P2), P6);
copySubArray(C11, result, 0 , 0);
copySubArray(C12, result, 0 , n/2);
copySubArray(C21, result, n/2, 0);
copySubArray(C22, result, n/2, n/2);
}
return result;
}
public int [][] addMatrices(int [][] A, int [][] B)
{
int n = A.length;
int [][] result = new int[n][n];
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
result[i][j] = A[i][j] + B[i][j];
return result;
}
public int [][] subtractMatrices(int [][] A, int [][] B)
{
int n = A.length;
int [][] result = new int[n][n];
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
result[i][j] = A[i][j] - B[i][j];
return result;
}
public void divideArray(int[][] parent, int[][] child, int iB, int jB)
{
for(int i1 = 0, i2=iB; i1<child.length; i1++, i2++)
for(int j1 = 0, j2=jB; j1<child.length; j1++, j2++)
{
child[i1][j1] = parent[i2][j2];
}
}
public void copySubArray(int[][] child, int[][] parent, int iB, int jB)
{
for(int i1 = 0, i2=iB; i1<child.length; i1++, i2++)
for(int j1 = 0, j2=jB; j1<child.length; j1++, j2++)
{
parent[i2][j2] = child[i1][j1];
}
}
public void printArray(int [][] array)
{
int n = array.length;
System.out.println();
for(int i=0; i<n; i++)
{
for(int j=0; j<n; j++)
{
System.out.print(array[i][j] + "\t");
}
System.out.println();
}
System.out.println();
}

public static void main(String[] args) throws IOException
{

new Strassen5();
}
}

