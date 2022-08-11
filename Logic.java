package assignment_Game_2048_Miras_Khamit;

import java.util.*;

public class Logic {
	int score = 0;
	int num = 0; 
	int emptyNum = 16;
	String[] empty;
	boolean won = false;
	Random rand = new Random();
	private int unitValue;

	//array output in console 
	//inside SCORE CALCULATOR
	public void outputArray(int[] [] x) {
		score = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(x[i][j] + " \t");
				score += x[i][j];
			}
			System.out.println();
		}
		System.out.println("Score = " + getScore());
	}
	
	//get for score
	public int getScore() {
		return score;
	}
	
	//set score = 0
	public void setScore0() {
		score = 0;
	}
	
	//insert new value in array
	public void insertValue(int[] [] x) {
		getEmptyList(x);
		shuffleEmptyList();
		insert2or4(x, empty[0]);//use first value from shuffled empty list(array)
	}

	//list of indexes in array with 0 values
	public void getEmptyList(int[] [] x) {
		emptyNum = 16;
		num = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if (x[i][j] != 0){
					emptyNum--;
				}
			}
		}
		empty = new String[emptyNum];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if (x[i][j] == 0){
					String value = i + ", " + j; 
					empty[num] = value;  
				    num++;				
				}
			}
		} 
	}
	
	//shuffle array( instead can use random class)
	public void shuffleEmptyList() { 
		for (int i = 0; i < empty.length; i++) {
			int randomIndexToSwap = rand.nextInt(empty.length);
			String temp = empty[randomIndexToSwap];
			empty[randomIndexToSwap] = empty[i];
			empty[i] = temp;
		}	
	} 
	
	//insert new value in multiArray
	public void insert2or4(int[][] x, String empt) {
		int i = Character.getNumericValue(empt.charAt(0));
		int j = Character.getNumericValue(empt.charAt(3));
		int rr = rand.nextInt(100);
		
		if (rr < 75) {
			x[i][j] = 2;
			System.out.println("cr v 2 at [" + i + "][" + j + "]");
			unitValue = 2;
		}
		else {
			x[i][j] = 4;
			System.out.println("cr v 4 at [" + i + "][" + j + "]");
			unitValue = 4;
		}
	}
	
	//get first value from shuffled empty list(array)
	//(where new value in multiArray where inserted)
	public String getInsertIndex() {
		return empty[0];
	}
	
	//get for new value in multiAray
	public int getUnitValue() {
		return unitValue;
	}
	
	
	//move all value in array to left(equal values will combine)
	public void moveLeft(int[][] x) {  
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if (x[i][j] == 0 && x[i][j+1] != 0) {
					x[i][j] = x[i][j+1];
					x[i][j+1] = 0;
				 }
			}
		}
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if (x[i][j] == 0 && x[i][j+1] != 0) {
					x[i][j] = x[i][j+1];
					x[i][j+1] = 0;
				 }
			}
		}
		//combine equal values
		boolean a = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(x[i][j] == x[i][j+1] && x[i][j] != 0 && a != true) {
					x[i][j] *= 2;
					//x[i][j-1] = x[i][j] + x[i][j-1];
					x[i][j+1] = 0;
					a = true;
				}
				else a = false;
			}
			a = false;
		}
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if (x[i][j] == 0 && x[i][j+1] != 0) {
					x[i][j] = x[i][j+1];
					x[i][j+1] = 0;
				}
			}
		}
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if (x[i][j] == 0 && x[i][j+1] != 0) {
					x[i][j] = x[i][j+1];
					x[i][j+1] = 0;
				}
			}
		}
	}
	
	
	//move all value in array to right(equal values will combine)
	public void moveRight(int[][] x) {
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 0; j--) {
				if (x[i][j] == 0 && x[i][j-1] != 0) {
					x[i][j] = x[i][j-1];
					x[i][j-1] = 0;
				}
			}
		}
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 0; j--) {
				if (x[i][j] == 0 && x[i][j-1] != 0) {
					x[i][j] = x[i][j-1];
					x[i][j-1] = 0;
				}
			}
		}
		//combine equal values
		boolean a = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 0; j--) {
				if(x[i][j] == x[i][j-1] && x[i][j] != 0 && a != true) {
					x[i][j] *= 2; 
					x[i][j-1] = 0;
					a = true;
				}
				else a = false;
			}
			a = false;
		}
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 0; j--) {
				if (x[i][j] == 0 && x[i][j-1] != 0) {
					x[i][j] = x[i][j-1];
					x[i][j-1] = 0;
				}
			}
		}
		//remove 0s
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 0; j--) {
				if (x[i][j] == 0 && x[i][j-1] != 0) {
					x[i][j] = x[i][j-1];
					x[i][j-1] = 0;
				}
			}
		}
	}
	
	//move all value in array to up(equal values will combine)
	public void moveUp(int[][] x) {
		rotateArray90plus(x);//rotate array
		moveRight(x);
		rotateArray90minus(x);//rotate back
	}
	
	//move all value in array to down(equal values will combine)
	public void moveDown(int[][] x) {
		rotateArray90plus(x);//rotate array
		moveLeft(x);
		rotateArray90minus(x);//rotate back
	}
	
	public void rotateArray90plus(int[][] x){ //rotate miltiArray
		transpose(x);
		reverseRows(x);
	}
	
	public void rotateArray90minus(int[][] x) {// rotate back
		reverseRows(x);
        transpose(x);      
	}
	
	public void transpose(int[][] x){
        int ret[][] = new int[4][4];
	    for(int row = 0; row < x[0].length; row++) {
	        for(int col = 0; col < x.length; col++) {
	            ret[row][col] = x[col][row];
	        }
	    }
	    //save
	    for (int i = 0; i < 4; ++i) {
	        for (int j = 0; j < 4; ++j) {
	        	x[i][j] = ret[i][j];
	        }
	    }
	}
	
	public static void reverseRows(int[][] x){
		int ret[][] = new int[4][4];
        for(int row = 0; row < x.length; row++){
            for(int col = 0; col < x[row].length / 2; col++) {
                int temp = x[row][col];
                ret[row][col] = x[row][x[row].length - col - 1];
                ret[row][x[row].length - col - 1] = temp;
            }
        } 
        //save
        for (int i = 0; i < 4; ++i) {
	        for (int j = 0; j < 4; ++j) {
	        	x[i][j] = ret[i][j];
	        }
	    }
	}
	
	//copy MultiArray
	public void copyMas(int[][] x, int[][] y) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				x[i][j] = y[i][j];
			}
		}
	}
	
	//check arrays for equality
	public boolean isMoved(int[][] x, int[][] y) {  //probably same as array.equal or ==
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(x[i][j] != y[i][j]){
					return true;
				}
			}
		}
		return false;
	}
	
	//check array for 0 values
	public boolean containEmpty(int[][] x) { //or if empty list null
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(x[i][j] == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	//check array foe equal and adjacent values
	public boolean canMove(int[][] x) { 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				if (x[i][j] == x[i+1][j]) {
					return true;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if (x[i][j] == x[i][j+1]) {
					return true;
				}
			}
		}
		return false;
	}
	
	//check array for value 2048
	public boolean contain2048(int[][] x) { //or if empty list null
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(x[i][j] == 2048){
					won = true;//if contains - won = true
					return true;
				}
			}
		}
		return false;
	}

	//set for won false
	public void setWonFalse() {
		won = false;
	}
	
	//get for won
	public boolean getWon() {
		return won;
	}
	
}
