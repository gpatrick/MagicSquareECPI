package edu.ecpi.MagicSquare;

public class Square {
	protected int n; //Number of elements/dimension
	protected int[][] squareData;
	protected int currentNumber;
	protected int currentRow;
	protected int currentCol;
	
	public Square(int n){
		if(n % 2 == 0){
			System.out.println("Square dimensions must be odd");
			System.exit(1);
		}
		
		this.n = n;
		currentNumber = 1;
		squareData = new int[n][n];
		currentRow = 0;
		currentCol = (n - 1) / 2;
	}
	
	public void compute(){
		squareData[currentRow][currentCol] = currentNumber;
		currentNumber++; //currentNumber = currentNumber + 1
		
		int numberOfElements = n*n;
		while(currentNumber <= numberOfElements){
			int nextRow = getNextRow();
			int nextCol = getNextCol();
			
			if(squareData[nextRow][nextCol] == 0){
				currentRow = nextRow;
				currentCol = nextCol;
				squareData[currentRow][currentCol] = currentNumber;
			}
			else{//Cell is occupied
				currentRow = getNextValueOnSquare(currentRow + 1);
				squareData[currentRow][currentCol] = currentNumber;
			}
			currentNumber++;
		}
	}
	
	private int getNextRow(){
		return getNextValueOnSquare(currentRow - 1);
	}
	
	private int getNextCol(){
		return getNextValueOnSquare(currentCol + 1);
	}
	
	private int getNextValueOnSquare(int value){
		int result = value % n;
		
		if(result >= 0){
			return result;
		}
		else{
			return n + result;
		}
	}
	
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++){
				stringBuilder.append(squareData[row][col] + "\t");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
