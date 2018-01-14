Sudoku Solver

To run my Sudoku Solver you must run the Solver.java file and input the puzzle to be solved in the command line. If you were to insert a new puzzle to be solved, you should title it Sudoku7.csv and type "java Solver 7" into the command line to solve the puzzle. I also used 0s as unsolved cells instead of dashes so sorry for that inconvenience.

1. I decided to follow your proposed algorithm to discover a solution to the problem. I decided to use a 2D array of integers to represent the GameBoard. 

2. I created a separate Solver class from the GameBoard to actually execute the solution to the Sudoku board. The solver class uses the methods from the GameBoard class to solve the problem with the algorithm that was provided.

3. My initial variant of the program actually ended up running at a pretty good speed on my computer as the puzzle you provided was solved in about 20 milliseconds. I simplified some loops and got rid of some steps that were not necessary to get the runtime on that puzzle down to an average of about 15 milliseconds on my (rather slow) computer.
