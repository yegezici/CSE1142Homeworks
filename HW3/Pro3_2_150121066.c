#include <stdio.h>
#include <math.h>
//Yunus Emre Gezici
//150121066

double calculateIterative(int row, int col) {
    double weight = 80;
	//The array was created with sizes of 30 and 30 because in the homework pdf, it was said the level could be max 30	double array[30][30];
    double array[30][30];
	array[0][0] = weight;
	int i;
	int k;	
	for(i = 1; i <= row; i++) {
		for(k = 0; k <= i; k++){
	        if((k == 0)||(k == row)){
		    weight = (array[i - 1][0] )+ 80/ pow(2,i);        	
 	        array[i][k] = weight;
            }else{
    	    weight = (array[i - 1][k - 1] + array[i - 1][k])  / 2.0 + 80;
            array[i][k] = weight;
            }
		}	
		
	}
    return array[row][col] - 80;
}


double calculateRecursive(int row, int col){
	if(row == 0 && col == 0){
		return 80;
	}else if((row == col)){
		return calculateRecursive(row - 1, col - 1)/ 2 + 80;
	}else if(row != 0 && col == 0){
		return calculateRecursive(row - 1, 0) / 2 + 80;
	}
	else{
		return (calculateRecursive(row - 1, col -1) + calculateRecursive(row -  1, col)) / 2 + 80;
	}
}


int main() {
    int row;
    int col;
    printf("Enter row and column: ");
    scanf("%d %d", &row,&col);
    printf("Result of iterative function: %.2f", calculateIterative(row, col));
    printf("\nResult of recursive function: %.2f", calculateRecursive(row, col) - 80);
    return 0;
}
