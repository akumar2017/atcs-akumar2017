import java.util.ArrayList;

/**
This class contains a main methods which runs the solving process of the board.
@author Akash Kumar
@version 11/07/16
*/
public class Solver
{
	/**
	Takes in a sudoku board through the command line and solves it
	@param args The number of the SudokuBoard the user wants to solve
	*/
	public static void main(String[] args)
	{
		GameBoard input = new GameBoard("Sudoku" + Integer.parseInt(args[0]) + ".csv");
		Stack<GameBoard> stack = new LinkedList<GameBoard>();
		stack.push(input);
		final long start = System.currentTimeMillis();
		while (stack.isEmpty() != true)
		{
			GameBoard current = stack.pop();
			if (current.solved())
			{
				System.out.println("\n" + "This is the solution to the board" + "\n" + current);
				final long end = System.currentTimeMillis();
				System.out.println("Total run time: " + (end - start) + " milliseconds" + "\n");
				return;
			}
			int[] mostConstrained = current.mostConstrainedSpot();
			if (mostConstrained[0] != -1)
			{
				for (int i = 0; i < 9; i++)
				{
					if (mostConstrained[i + 3] != 0)
						stack.push(new GameBoard(current, mostConstrained[0], mostConstrained[1], mostConstrained[i + 3]));
				}
			}
		}
		System.out.println("The board is not solvable");
	}
}
