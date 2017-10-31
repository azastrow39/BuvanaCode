package unl.cse;

public class MatrixUtils {

    public static void main(String args[]){
        int A[][] = new int[2][2];
        A[0][0] = 1;
        A[0][1] = 7;
        A[1][0] = 2;
        A[1][1] = 4;
        int B[][] = new int[2][2];
        B = matrixPower(A, 2);
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                System.out.println(B[i][j]);
            }
        }
    }

    public static boolean isEqual(int A[][], int B[][]) {
        return A.equals(B);
    }

    public static int [] getRow(int A[][], int i) {
        //create array
        int B[] = new int[A.length];
        //copy row to the array
        for(int j = 0; j < A.length; j++){
            B[j] = A[i][j];
        }
        return B;
    }

    public static int [] getCol(int A[][], int j) {
        //create array
        int B[] = new int[A.length];
        //copy column to the array
        for(int i = 0; i < A.length; i++){
            B[i] = A[i][j];
        }
        return B;
    }

    public static int [][] product(int A[][], int B[][]) {
        //make result matrix
        int result[][] = new int[A.length][A.length];
        //loop through the matrix
        for(int i = 0; i < A.length; i++){
            for (int j = 0; j < A.length; j++){
                result[i][j] = 0;
                //calculate summation for each index
                for(int k = 0; k < A.length; k++){
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static int [][] copyMatrix(int A[][]) {
        //create matrix
        int B[][] = new int[A.length][A.length];
        //copy
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                B[i][j] = A[i][j];
            }
        }
        return B;
    }

    public static int [][] matrixPower(int A[][], int n) {
        //copy the matrix
        int finalResult[][] = copyMatrix(A);
        //multiply the number of times for the power
        for(int i = 1; i < n; i++){
            finalResult = product(finalResult, A);
        }
        //return identity matrix if n = 0
        if(n==0){
            for(int i = 0; i<A.length; i++){
                for(int j = 0; j<A.length; j++){
                    if(i==j){
                        finalResult[i][j] = 1;
                    } else {
                        finalResult[i][j] = 0;
                    }
                }
            }
        }
        return finalResult;
    }


}