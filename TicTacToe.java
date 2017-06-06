import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	int[][] gameArray;
	int player;
	int computer;
	Scanner inputScanner;
	
	TicTacToe(){
		gameArray = new int[3][3];
	}
	
	public static void main(String args[]){
		TicTacToe game = new TicTacToe();
		game.play();
	}
	
	void play(){
		System.out.println("Tossing the coin to see who will play first.");
		System.out.println("Head - you are player 1 and computer is player 2");
		System.out.println("Tails - I (Computer) am player 1 and you are player 2");
		
		Random rand = new Random();
		// 0 is heads and 1 is tails
		player = rand.nextInt(2);
		player+=1;
		if (player==1){
			//human is starting the game
			computer = 2;
			System.out.println("It is heads");
		} else {
			//computer is starting the game
			computer = 1;
			System.out.println("It is tails");
		}
		inputScanner = new Scanner(System.in);
		displayBoard();
		if (player == 1){
			while (true){
				nextMovePlayer();
				displayBoard();
				if (didWin(player)){ 
					System.out.println("Player Won");
					break;
				}
				nextMoveComputer();
				displayBoard();
				if(didWin(computer)){
					System.out.println("Computer Won");
					break;
				}
			}
		} else {
			while (true){
				nextMoveComputer();
				displayBoard();
				if(didWin(computer)){
					System.out.println("Computer Won");
					break;
				}
				nextMovePlayer();
				displayBoard();
				if (didWin(player)){
					System.out.println("Player Won");
					break;
				}
			}
		}
		inputScanner.close();
	}
	
	boolean didWin(int playerChecking){
		if (gameArray[1][1] == playerChecking){
			if ((gameArray[0][0] == playerChecking) && (gameArray[2][2] == playerChecking))
				return true;
			if ((gameArray[2][0] == playerChecking) && (gameArray[0][2] == playerChecking)) 
				return true;
			if ((gameArray[0][1] == playerChecking) && (gameArray[2][1] == playerChecking)) 
				return true;
			if ((gameArray[1][0] == playerChecking) && (gameArray[1][2] == playerChecking)) 
				return true;
		} else if (gameArray[0][0] == playerChecking){
			if ((gameArray[0][1] == playerChecking) && (gameArray[0][2] == playerChecking)) 
				return true;
			if ((gameArray[1][0] == playerChecking) && (gameArray[2][0] == playerChecking)) 
				return true;
		} else if (gameArray[2][2] == playerChecking){
			if ((gameArray[1][2] == playerChecking) && (gameArray[0][2] == playerChecking)) 
				return true;
			if ((gameArray[2][0] == playerChecking) && (gameArray[2][1] == playerChecking)) 
				return true;
		} 
		return false;
	}
	void nextMoveComputer(){
		boolean tookTurn = false;
		if (gameArray[0][0]==computer) {
			if (gameArray[2][0] == computer && gameArray[1][0]==0){
				gameArray[1][0] = computer; tookTurn = true;
			}
			if (!tookTurn && gameArray[0][2] == computer && gameArray[0][1]==0){
				gameArray[0][1] = computer; tookTurn = true;
			}
			if (!tookTurn && gameArray[2][2] == computer && gameArray[0][0]==0){
				gameArray[0][0] = computer; tookTurn = true;
			}
			if (!tookTurn && gameArray[0][2] == 0){
				gameArray[0][2] = computer; tookTurn = true;
			}
			if (!tookTurn && gameArray[2][0] == 0){
				gameArray[2][0] = computer; tookTurn = true;
			}
		}
		if (!tookTurn && gameArray[2][2] == computer){
			if (!tookTurn && gameArray[0][2]==computer && gameArray[1][2]==0){
				gameArray[1][2] = computer; tookTurn=true;
			}
			if (!tookTurn && gameArray[2][0] == computer && gameArray[2][1]==0){
				gameArray[2][1] = computer; tookTurn = true;
			}
			if (!tookTurn && gameArray[0][2] == 0){
				gameArray[0][2] = computer; tookTurn = true;
			}
			if (!tookTurn && gameArray[2][0] == 0){
				gameArray[2][0] = computer; tookTurn = true;
			}
		}
		if (!tookTurn && gameArray[1][1]==0){
			gameArray[1][1] = computer; tookTurn = true;
		}
		if (!tookTurn && gameArray[0][0] == 0){
			gameArray[0][0] = computer; tookTurn = true;
		}
		if (!tookTurn && gameArray[2][2] == 0){
			gameArray[2][2] = computer; tookTurn = true;
		}
			
	}
	void nextMovePlayer(){
		System.out.println("enter row for the next move");
		int row = inputScanner.nextInt();
		System.out.println("enter column for the next move");
		int column = inputScanner.nextInt();
		if (gameArray[row][column]==0)
			gameArray[row][column] = player;
		else {
			System.out.println("please enter the position that is open");
			nextMovePlayer();
		}
	}
	void displayBoard(){
		System.out.println("_______");
		System.out.println("|"+gameArray[0][0]+","+gameArray[0][1]+","+gameArray[0][2]+"|");
		System.out.println("|"+gameArray[1][0]+","+gameArray[1][1]+","+gameArray[1][2]+"|");
		System.out.println("|"+gameArray[2][0]+","+gameArray[2][1]+","+gameArray[2][2]+"|");
		System.out.println("-------");
	}
}
