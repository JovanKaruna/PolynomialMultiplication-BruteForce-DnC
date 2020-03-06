import Library.*;

import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void PrintPolynom(int polynom[]){
        int n = polynom.length;
        for (int i = 0; i < n; i++){
            if(i == 0){
                System.out.print(polynom[i]);
            }else{
                if(polynom[i] != 0){ 
                    System.out.print(" + "); 
                     
                    System.out.print(polynom[i]); 
                    if (i != 0){ 
                        System.out.print("x^" + i); 
                    } 
                }
            }
        } System.out.print("\n"); 
    }

    public static void Randomgenerator(int koef[]){ //Randomgenerator
        int n = koef.length;
        for (int i = 0; i < n; i++){
            Random rand = new Random();
            int x = rand.nextInt(20);
            while(x == 0){
                x = rand.nextInt(20);
            }
            koef[i] = x;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        long start,end;
        //Input n
        System.out.print("Input banyaknya derajat : ");
        n = s.nextInt();
        int poly1[] = new int[n+1];
        int poly2[] = new int[n+1];
        Randomgenerator(poly1);
        Randomgenerator(poly2);
        System.out.println("Polinom 1 :");
        PrintPolynom(poly1);
        System.out.println("Polinom 2 :");
        PrintPolynom(poly2);
        s.close();

        //BruteForce
        System.out.println("\nBruteForce Output :");
        BruteForce A = new BruteForce();
        start = System.nanoTime();
        int a[] = A.Solve(poly1, poly2);
        end = System.nanoTime();
        PrintPolynom(a);
        System.out.println("Time needed : "+ (end - start)/1000 + " mikroseconds");
        System.out.print("Jumlah perkalian : "); System.out.println(A.jumlahkali);
        System.out.print("Jumlah pertambahan : "); System.out.println(A.jumlahtambah);

        //Divide And Conquer
        System.out.println("\nDivide and Conquer Output :");
        DnC B = new DnC();
        start = System.nanoTime();
        int b[] = B.DivideAndConquer(poly1, poly2);
        end = System.nanoTime();
        PrintPolynom(b);
        System.out.println("Time needed : "+ (end - start)/1000 + " mikroseconds");
        System.out.print("Jumlah perkalian : "); System.out.println(B.jumlahkali);
        System.out.print("Jumlah pertambahan : "); System.out.println(B.jumlahtambah);
    }
}
