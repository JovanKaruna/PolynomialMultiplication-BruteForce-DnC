package Library;

public class BruteForce extends Global{
    public BruteForce(){
        jumlahkali = 0;
        jumlahtambah =0;
    }

    public int[] Solve(int polynom1[], int polynom2[]){
        int n = polynom1.length;
        int m = polynom2.length;
        int product[] = new int[n+m-1]; //initialize array
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < m ; j++){
                if(product[i+j] != 0){  //if the array is not zero then using + operation
                    jumlahtambah++;
                }
                product[i+j] += polynom1[i] * polynom2[j];
                jumlahkali ++;
            }
        }
        return product;
    }

}