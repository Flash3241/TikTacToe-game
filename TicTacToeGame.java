import java.util.Scanner;
import java.util.Arrays;
public class TicTacToeGame {
    private final static String GRID_DELIMITER = "_______";
    private final static String COL_DELIMITER = "|";
    private final static String WELCOME_MSG = 
        "Welcome to TicTacToeGame!";
    private final static String ASK_X_ROW_MSG  = 
        "What row would player X like to play? Enter an int: ";
    private final static String ASK_X_COL_MSG  = 
        "What column would player X like to play? Enter an int: ";
    private final static String ASK_O_ROW_MSG  = 
        "What row would player O like to play? Enter an int: ";
    private final static String ASK_O_COL_MSG  = 
        "What column would player O like to play? Enter an int: ";
    private final static String INVALID_PLAY_MSG = 
        "Invalid play! Please try again.";        
    private final static String X_WON_MSG  = 
        "Player X won! Game over! :)";
    private final static String O_WON_MSG  = 
        "Player O won! Game over! :)";
    private final static String MAX_TURNS_MSG  = 
        "No more turns can be made. Game over! :)";

    // Constants for game (grid instance variable
    private final static char SPACE_CHAR = ' ';
    private final static char X_CHAR = 'X';
    private final static char O_CHAR = 'O';

    // Constants for return value of checkWinner() method
    private final static int INT_NO_WINNER_YET = 0;
    private final static int INT_X_WINS = 1;
    private final static int INT_O_WINS = 2;
    private final static int INT_MAX_TURNS_REACHED = 3;

    // Instance variables for TicTacToeGame object
    public char[][] grid;
    public int numTurns;

    public TicTacToeGame() {
        grid = new char[3][3];                                  //initializing/setting bounds for the game grid
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid[i][j]= SPACE_CHAR;
            }
        }
        numTurns=0;                                             //where we count the turns
    }

    public boolean putX(int row, int col) {                                                     //function used to input X
        if (row < 3 && row >=0 && col >= 0 && col<3 && grid[row][col] == SPACE_CHAR) {          //setting if the input is valid to place X
            grid[row][col] = X_CHAR;
            numTurns+=1;                                                                        //if valid place X and add 1 to number of turns
            return true;
        }
        else {
            return false;                                                                       //anything else return false
        }
    }

    public boolean putO(int row, int col) {                                                     //function used to input O
        if (row < 3 && row >=0 && col >= 0 && col<3 && grid[row][col] == SPACE_CHAR) {          //setting if the input is valid to place O
            grid[row][col] = O_CHAR;
            numTurns+=1;                                                                        //if valid place O and add 1 to number of turns
            return true;
        }
        else {
            return false;                                                                       //anything else return false
        }
    }

    public static void print2DArray(char[][] arr) {                                             //printing the grid and inputing X and O
        System.out.println(GRID_DELIMITER);
        for (int row=0;row<3;row++) {
            for (int col=0;col<3;col++) {
            System.out.print(COL_DELIMITER+arr[row][col]);                                          //setting the grid 
            }
            System.out.println(COL_DELIMITER);
        }
        System.out.println(GRID_DELIMITER);
    }

    public int checkWinner(int row, int col) {                                        //checking the winner
        if (grid[0][0]==X_CHAR && grid[0][1]==X_CHAR && grid[0][2]==X_CHAR) {                //checking if X wins
            return INT_X_WINS;
        }
        else if (grid[1][0]==X_CHAR && grid[1][1]==X_CHAR && grid[1][2]==X_CHAR) {
            return INT_X_WINS;
        }
        else if (grid[2][0]==X_CHAR && grid[2][1]==X_CHAR && grid[2][2]==X_CHAR) {
            return INT_X_WINS;
        }
        else if (grid[0][0]==X_CHAR && grid[1][0]==X_CHAR && grid[2][0]==X_CHAR) {
            return INT_X_WINS;
        }
        else if (grid[0][1]==X_CHAR && grid[1][1]==X_CHAR && grid[2][1]==X_CHAR) {
            return INT_X_WINS;
        }
        else if (grid[0][2]==X_CHAR && grid[1][2]==X_CHAR && grid[2][2]==X_CHAR) {
            return INT_X_WINS;
        }
        else if (grid[0][0]==X_CHAR && grid[1][1]==X_CHAR && grid[2][2]==X_CHAR) {
            return INT_X_WINS;
        }
        else if (grid[0][2]==X_CHAR && grid[1][1]==X_CHAR && grid[2][0]==X_CHAR) {
            return INT_X_WINS;
        }
          //O character win
        else if (grid[0][0]==O_CHAR && grid[0][1]== O_CHAR && grid[0][2]==O_CHAR) {        //checking if O wins
            return INT_O_WINS;
        }
        else if (grid[1][0]==O_CHAR && grid[1][1]==O_CHAR && grid[1][2]==O_CHAR) {
            return INT_O_WINS;
        }
        else if (grid[2][0]==O_CHAR && grid[2][1]==O_CHAR && grid[2][2]==O_CHAR) {
            return INT_O_WINS;
        }
        else if (grid[0][0]==O_CHAR && grid[1][0]==O_CHAR && grid[2][0]==O_CHAR) {
            return INT_O_WINS;
        }
        else if (grid[0][1]==O_CHAR && grid[1][1]==O_CHAR && grid[2][1]==O_CHAR) {
            return INT_O_WINS;
        }
        else if (grid[0][2]==O_CHAR && grid[1][2]==O_CHAR && grid[2][2]==O_CHAR) {
            return INT_O_WINS;
        }
        else if (grid[0][0]==O_CHAR && grid[1][1]==O_CHAR && grid[2][2]==O_CHAR) {
            return INT_O_WINS;
        }
        else if (grid[0][2]==O_CHAR && grid[1][1]==O_CHAR && grid[2][0]==O_CHAR) {
            return INT_O_WINS;
        }
        //max turns or no winner yet
        else if (numTurns==9) {                                                             //checking if the grid is full
            return INT_MAX_TURNS_REACHED;
        }
        else {                                                                              //if not then game is still going
            return INT_NO_WINNER_YET;
        }

    }

    public static void main(String[] args) {                        //main function
        TicTacToeGame work = new TicTacToeGame();           //setting static
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MSG);                    //welcoming and printing the grid
        print2DArray(work.grid);
        while (work.numTurns<=9) {                          //setting limit to turns
            System.out.println(ASK_X_ROW_MSG);              //X row and column message
            int xr1 = scanner.nextInt();
            System.out.println(ASK_X_COL_MSG);
            int xc1 = scanner.nextInt();
            boolean placex = work.putX(xr1,xc1);            //implementing the X using earliers function
            while (placex == false) {                       //repeating the message until giving a valid answer
                System.out.println(INVALID_PLAY_MSG);
                System.out.println(ASK_X_ROW_MSG);
                xr1 = scanner.nextInt();
                System.out.println(ASK_X_COL_MSG);
                xc1 = scanner.nextInt();
                placex = work.putX(xr1,xc1);
            }
            print2DArray(work.grid);                            //printing grid after turn and checking if win or not
            if (work.checkWinner(xr1,xc1)==INT_X_WINS) {
                System.out.println(X_WON_MSG);
                break;                                          //if win the game ends
            }
            if (work.checkWinner(xr1,xc1)==INT_MAX_TURNS_REACHED) {   //if grid is full game ends
                System.out.println(MAX_TURNS_MSG);
                break;
            }
            System.out.println(ASK_O_ROW_MSG);                      //message for O rows and columns
            int or1 = scanner.nextInt();
            System.out.println(ASK_O_COL_MSG);
            int oc1 = scanner.nextInt();
            boolean placeo = work.putO(or1,oc1);                    //implementing the O using ealiers function
            while (placeo == false) {                               //repeating the message untile giving a valid answer
                System.out.println(INVALID_PLAY_MSG);
                System.out.println(ASK_O_ROW_MSG);
                or1 = scanner.nextInt();
                System.out.println(ASK_O_COL_MSG);
                oc1 = scanner.nextInt();
                placeo = work.putO(or1,oc1);
            }
            print2DArray(work.grid);                            //printing grid after giving a valid answer
            if (work.checkWinner(or1,oc1)==INT_O_WINS) {        //checking if O won
                System.out.println(O_WON_MSG);
                break;
            }
        }
        scanner.close();
    }

}