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
		//sharing information with the player
		System.out.println("Tossing the coin to see who will play first.");
		System.out.println("Head - you are player 1 and computer is player 2");
		System.out.println("Tails - Computer is player 1 and you are player 2");
		
		Random rand = new Random();
		// 0 is heads and 1 is tails in random number generation
		player = rand.nextInt(2);
		//player value 1 means player is playing first
		//player value 2 means player is playing second
		player+=1;
		if (player==1){
			//player is starting the game
			computer = 2;
			System.out.println("It is heads");
		} else {
			//computer is starting the game
			computer = 1;
			System.out.println("It is tails");
		}
		//start the input scanner for responses from the player
		inputScanner = new Scanner(System.in);
		//displays the tic tac toe board
		displayBoard();
		//if player is playing first
		if (player == 1){
			//continue the cycle for next moves until some one wins - breaks at that time
			while (true){
				//find player's move and updates the board
				nextMovePlayer();
				//displays the board after the player's move
				displayBoard();
				//check if the player's move made the player win the game
				if (didWin(player)){ 
					System.out.println("Player Won");
					//player won - breaks the cycle - no more next moves
					break;
				}
				//find computer's next move and updates the board
				nextMoveComputer();
				//displays the board after computer's move
				displayBoard();
				//check if the computer's move made the computer win the game
				if(didWin(computer)){
					System.out.println("Computer Won");
					//computer won - breaks the cycle - no more next moves
					break;
				}
			}
		} else { // if computer is playing first
			//continue the cycle for next moves until some one wins - breaks at that time
			while (true){
				//find computer's next move and updates the board
				nextMoveComputer();
				//displays the board after computer's move
				displayBoard();
				if(didWin(computer)){
					System.out.println("Computer Won");
					//computer won - breaks the cycle - no more next moves
					break;
				}
				//find player's move and updates the board
				nextMovePlayer();
				//displays the board after the player's move
				displayBoard();
				//check if the player's move made the player win the game
				if (didWin(player)){
					System.out.println("Player Won");
					//player won - breaks the cycle - no more next moves
					break;
				}
			}
		}
		//closes the input Scanner to release the memory
		inputScanner.close();
	}
	//checks to see is the given player has won the game or not
	boolean didWin(int playerChecking){
		//checks the centre of the grid - if it was marked by the player 
		//then check the corresponding positions otherwise skip this step
		if (gameArray[1][1] == playerChecking){
			//check the top left and bottom right (diagonal left to right) - if marked by the player
			// return true - WON the game
			if ((gameArray[0][0] == playerChecking) && (gameArray[2][2] == playerChecking))
				return true;
			// check the top right and bottom left (diagonal right to left) - if marked by the player
			// return true - WON the game
			if ((gameArray[2][0] == playerChecking) && (gameArray[0][2] == playerChecking)) 
				return true;
			//check the left middle and right middle (horizontal middle ) - if marked by the player
			// return true - WON the game
			if ((gameArray[0][1] == playerChecking) && (gameArray[2][1] == playerChecking)) 
				return true;
			//check the top middle and bottom middle (vertical middle) - if marked by the player
			// return true - WON the game
			if ((gameArray[1][0] == playerChecking) && (gameArray[1][2] == playerChecking)) 
				return true;
		} // check if the upper left position was marked by the player 
		//then check the corresponding positions otherwise skip the step
		else if (gameArray[0][0] == playerChecking){
			//check the left middle and bottom (vertical left) - if marked by the player
			//return true - WON the game
			if ((gameArray[0][1] == playerChecking) && (gameArray[0][2] == playerChecking)) 
				return true;
			//check the top middle and top right (horizontal top) - if marked by the player
			// return true - WON the game
			if ((gameArray[1][0] == playerChecking) && (gameArray[2][0] == playerChecking)) 
				return true;
		} //check the bottom right position - if marked by the player
		//then check the corresponding positions - otherwise skip the step
		else if (gameArray[2][2] == playerChecking){
			//check the bottom middle and right (horizontal bottom) - if marked by the player
			//return true - WON the game
			if ((gameArray[1][2] == playerChecking) && (gameArray[0][2] == playerChecking)) 
				return true;
			//check the top right and middle right (vertical right) - if marked by the player
			// return true - WON the game
			if ((gameArray[2][0] == playerChecking) && (gameArray[2][1] == playerChecking)) 
				return true;
		} 
		//if none of the rules were not true then the game is still not won by the player
		//send false - means NOT WON
		return false;
	}
	//implementing the rules of TIC TAC TOE
	//computer figuring out its next move
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
	//displays the board
	void displayBoard(){
		System.out.println("_______");
		System.out.println("|"+gameArray[0][0]+","+gameArray[0][1]+","+gameArray[0][2]+"|");
		System.out.println("|"+gameArray[1][0]+","+gameArray[1][1]+","+gameArray[1][2]+"|");
		System.out.println("|"+gameArray[2][0]+","+gameArray[2][1]+","+gameArray[2][2]+"|");
		System.out.println("-------");
	}
}
