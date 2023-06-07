package Formes;

public class Morpion {
	
	public static String[][] board = { { "-", "-", "-" }, { "-", "-", "-" }, { "-", "-", "-" } };
	public static boolean turnO = true;
	

	public static void main(String[] args) {
		
		//display();

		// À changer pour l'événement victoire
		computerFirstMove();
		play();
	}

	public static void display() {
		System.out.println("   1  2  3");
		System.out.printf("1  %s  %s  %s", board[0][0], board[0][1], board[0][2]);
		System.out.println();
		System.out.printf("2  %s  %s  %s", board[1][0], board[1][1], board[1][2]);
		System.out.println();
		System.out.printf("3  %s  %s  %s", board[2][0], board[2][1], board[2][2]);
		System.out.println();
	}

	public static void play() {
		String[] move = { "", "" };
		for (int i = 0; i > -1; i++) {
			
			// Ajout //
			 
			//display();
			System.out.println(Console.ANSI_RED +  "Quelle case voulez-vous jouer ? n°colonne+n°ligne");
			String decision = Console.nextLine();
			move[0] = decision.substring(0, 1);
			move[1] = decision.substring(1, 2);
			int vertical = Integer.parseInt(move[0]);
			int horizontal = Integer.parseInt(move[1]);
			// Différenciation des joueurs
			
			board[vertical - 1][horizontal - 1] = turnO ? "O" : "X";
			
			display();
			if (checkWin()) {
				System.out.println((turnO ? "O" : "X") + " a gagner");
				break;
			}
			
			turnO = !turnO;
			
			
			for (int k = 0; k < board.length; k++) {
				int defensiveLine = 0;
				int emptyLineCase = 0;
				int defensiveColumn = 0;
				int emptyColumnCase = 0;
				
				int attackLine = 0;
				int attackColumn = 0;
				
				
				for (int j = 0; j < board.length; j++) {
					if (board[k][j] == "X") defensiveLine++;
					if (board[k][j] == "-") emptyLineCase = j;
					if (board[j][k] == "X") defensiveColumn++;
					if (board[j][k] == "-") emptyColumnCase = j;
					if (board[k][j] == "O") attackLine++;
					if (board[j][k] == "O") attackColumn++; 
				}
				
				if (i%2 == 0 && attackLine == 2) {
					board[k][emptyLineCase] = "O";
					display();
					turnO = !turnO;
				} else if (i%2 ==0 && attackColumn == 2) {
					board[emptyColumnCase][k] = "O";
					display();
					turnO = !turnO;
				} else if (i%2 ==0 && defensiveLine == 2) {
					board[emptyColumnCase][k] = "O";
					display();
					turnO = !turnO;
				} else if (i%2 ==0 && defensiveColumn == 2) {
					board[emptyColumnCase][k] = "O";
					display();
					turnO = !turnO;
				}
			}			
							if(i % 2 == 0) {
								if(board[2][0] == board[1][1] && board[2][0] == "X" && board[0][2] != "O") {
									board[0][2] = "O" ;
									display();
									turnO = !turnO;
									break;
								} else if(board[2][0] == board[0][2] && board[2][0] == "X" && board[1][1] != "O") {
									board[1][1] = "O" ;
									display();
									turnO = !turnO;
									break;
								} else if(board[0][2] == board[1][1] && board[0][2] == "X" && board[2][0] != "O") {
									board[2][0] = "O" ;
									display();
									turnO = !turnO;
									break;
								}
							}
							} 
			}
	
	public static void computerFirstMove() {
		board[0][0] = turnO ? "O" : "X";
		turnO = !turnO;
		display();
	}
	
	
	public static boolean checkWin() {
		for (int j = 0; j <= 2; j++) {
			if (board[j][0] == board[j][1] && board[j][1] == board[j][2] && board[j][0] != "-"
				|| board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != "-"
				|| board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != "-"
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != "-")) {

				return true;
			}
		}
		return false;
	}
}
