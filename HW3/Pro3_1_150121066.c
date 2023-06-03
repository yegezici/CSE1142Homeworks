#include <stdio.h>
//Yunus Emre Gezici
//150121066
int main(){
	
	int *number;
	int N;
	printf("Enter two numbers: ");
	scanf("%d %d",&number,&N);
	reverseN(&number,N);
	printf("%d", number);
		
	}
void reverseN(int *number, int N){
	int num = *number;
	int temp = num;
	int total = 0;
	//rightmost digit of number
	int ld = temp % 10;
	//Nth digit of number
	int nd;
	//Digit number
	int i = 0;
	while(temp > 0){
		temp /= 10;
		i++;
	}
	if(i < N){
		printf("N must be less than %d\n", i + 1);
	}else if(i == N){
		temp = num;
		int x;
		for(x = 0; x < N - 1; x++)
			temp /= 10;
		nd = temp % 10;
		temp = num;
		total = temp % 10;
		int rNum = 0;
		while(temp > 0)
		{
			int remainder = temp % 10;
			rNum = rNum * 10 + remainder;
			temp /= 10;
		}
		int k; 
		rNum /= 10;
		for(k = 0; k < i - 2; k++)
		{
			total = total * 10 + rNum % 10;
			rNum /= 10;
		}
		total *= 10;
		total += nd;
		*number = total;
	}else{
	temp = num;
	int x;
	for(x = 0; x < i - N; x++)
		temp /= 10;
	nd = temp % 10;
	temp /= 10;
	total = temp * 10 + ld;
	temp = num;
	int y;
	for(y = 0; y < i - N - 1; y++){
		temp /= 10;
		total = total * 10 + temp % 10;
	}
	total *= 10;
	total += nd;
	*number = total;	
	}
}
