package Library;

public class DnC extends Global{
    public DnC(){
        jumlahkali = 0;
        jumlahtambah =0;
    }

    public int[] DivideAndConquer(int poly1[], int poly2[]) //Divide and Conquer polynomial multiplication
    {
        int n = poly1.length;
        if (n == 1) {   //if length is 1
            int temp[] = {poly1[0]*poly2[0]};
            jumlahkali++;
            return temp;
        }
        // half of the length
        int d = n/2;
        
        // Split half the poly1 and poly2
        int A1[] = new int[d+n%2];
        int B1[] = new int[d+n%2];        
        int A0[] = new int[d+n%2];
        int B0[] = new int[d+n%2];
        
        //Assign the array
        for (int i = 0; i < d; i++) 
        {
            A1[i] = poly1[i+d+(n%2)];
            B1[i] = poly2[i+d+(n%2)];
        }
    
        if (d != d+(n%2)){ //if the half is not the same
            A1[d] = 0;
            B1[d] = 0;
        }
    
        for (int i = 0; i < d+(n%2); i++) 
        {
            A0[i] = poly1[i];
            B0[i] = poly2[i];
        }
        
        int A0A1[] = new int[d+(n%2)];
        int B0B1[] = new int[d+(n%2)];
        //add A0 and A1
        for(int i = 0 ; i< d+(n%2) ; i++)
        {
            A0A1[i] = A0[i]+A1[i];
            B0B1[i] = B0[i]+B1[i];
            jumlahtambah +=2;
        }
                
        // Recursive A0 and B0
        int U[] = DivideAndConquer(A0,B0);  
        
        // Recursive middle part A0A1 and B0B1
        int Y[] = DivideAndConquer(A0A1,B0B1);  
        
        // Recursive A1 and B1
        int Z[] = DivideAndConquer(A1,B1);
    
        //Make the polynomial U + (Y-U-Z)x^n/2 + Zx^n
        int middle[] = substract(substract(Y, U),Z);
        int middle1[] = Pangkat(middle, n/2 +(n%2));
        int high[] = Pangkat(Z, n+(n%2));
        int product[] = add(add(U,middle1),high);
        
        return product;
    }
    public static int max(int a, int b){ //Find the max from 2 integers
        if(a>b){
            return a;
        }else{
            return b;
        }
    }

    public int[] add(int A[], int B[]) { //Add two polynomials
        int size = max(A.length, B.length);
        int sum[] = new int[size]; 

        for (int i = 0; i < A.length; i++) { 
            sum[i] = A[i]; 
        } 
  
        for (int i = 0; i < B.length; i++) { 
            if(sum[i] != 0){
                jumlahtambah++;
            }
            sum[i] += B[i]; 
        } 
        return sum; 
    }

    public int[] substract(int A[], int B[]) { //Substract two polynomials
        int sum[] = new int[A.length]; 
        for (int i = 0; i < A.length; i++) { 
            sum[i] = A[i]; 
        } 
  
        for (int i = 0; i < B.length; i++) { 
            if(sum[i] != 0){
                jumlahtambah++;
            }
            sum[i] -= B[i]; 
        } 
        return sum; 
    } 

    public static int[] Pangkat(int A[], int n){ //Change the Degree of polynomial with n degree
        int sum[] = new int[A.length+n];
        for (int i = 0; i < A.length; i++) { 
            sum[i+n] = A[i]; 
        } 
        return sum;
    }


}