import java.util.ArrayList;

//******************************************************
// Nathan Schnitzer
// Stretch.java
// 2/23/19
// ACSL Contest #3
//******************************************************

public class Stretch 
{
	boolean[][] validMatrix;
	Shape[][] matrix;
	int rows, cols;
	int cursor = 0;
	ArrayList<Character> path = new ArrayList<Character>();

	//Instantiates a new Stretch object
	public Stretch(int r, int c)
	{
		validMatrix = new boolean[r][c];
		//set all values to true
		for (int i = 0; i < r; i++)
		{
			for (int k = 0; k < c; k++)
			{
				validMatrix[i][k] = true;
			}
		}
		matrix = new Shape[r][c];
		rows = r;
		cols = c;
	}

	//Sets a location in validMatrix to false (invalid)
	public void setInvalid(int x)
	{
		x = x-1;
		int r = x/cols;
		int c = x % cols;

		validMatrix[r][c] = false;
	}

	//Adds the A piece (3 straight)
	//x is the end of the last piece
	//Left To Right
	public boolean addA(int x) throws Exception
	{
		x = x-1;
		//Check for bounds errors
		if (x%cols + 3 > cols)
		{
			return false;
		}

		int r = x/cols;
		int c = x%cols;

		//Check for invalid pieces in the way
		for (int i = c ; i < c+2; i++)
		{
			if (validMatrix[r][i] == false)
			{
				return false;
			}
		}

		//Cleared checking
		int i = c;
		if (i+2 == cols - 1)
		{
			path.add('A');
			System.out.println(path.toString());
			matrix[x/cols][i] = new Shape("A", true, true);
			matrix[x/cols][i+1] = new Shape("A", false, false);
			matrix[x/cols][i+2] = new Shape("A", true, false);
			System.exit(0);
		}
		matrix[x/cols][i] = new Shape("A", true, true);
		matrix[x/cols][i+1] = new Shape("A", false, false);
		matrix[x/cols][i+2] = new Shape("A", true, false);
		cursor = x + 4;

		path.add('A');
		return true;

	}

	//Adds a B piece to the matrix (3 down/up)
	//Left To Right
	public boolean addB(int x) throws Exception
	{
		x = x-1;
		int r = x/cols;
		int c = x%cols;

		//Check if it can go down

		//Check bounds
		if (r + 2 < rows)
		{
		//Check for blocked pieces
		for (int i = x/cols; i < x/cols+3; i++)
		{
			if (validMatrix[i][x%cols] == false)
			{
				return false;
			}


			//Passed checks
			if (x%cols + 1 == cols)
			{
				path.add('B');
				System.out.println(path.toString());
				matrix[x/cols][x%cols] = new Shape("B", true, true);
				matrix[x/cols+1][x%cols] = new Shape("B", false, false);
				matrix[x/cols+2][x%cols] = new Shape("B", true, false);
				System.exit(0);
			}
			path.add('B');
			matrix[x/cols][x%cols] = new Shape("B", true, true);
			matrix[x/cols+1][x%cols] = new Shape("B", false, false);
			matrix[x/cols+2][x%cols] = new Shape("B", true, false);
			cursor = (x + cols * 2) + 2;
			return true;
		}
		}

		//Has to go up
		//Check if there is a piece in the way
		for (int k = x/cols; k > x/cols-3; k--)
		{
			if (validMatrix[k][x%cols] == false)
			{
				return false;
			}
		}
		if (x%cols == cols -1)
		{
			path.add('B');
			System.out.println(path.toString());
			matrix[x/cols][x%cols] = new Shape("B", true, true);
			matrix[x/cols-1][x%cols] = new Shape("B", false, false);
			matrix[x/cols-2][x%cols] = new Shape("B", true, false);
			System.exit(0);
		}

		path.add('B');
		matrix[x/cols][x%cols] = new Shape("B", true, true);
		matrix[x/cols-1][x%cols] = new Shape("B", false, false);
		matrix[x/cols-2][x%cols] = new Shape("B", true, false);
		cursor = (x - cols * 2) + 2;
		return true;


	}

	//Adds C piece (3 piece L)
	//Left To Right
	public boolean addC(int x) throws Exception
	{
		x = x-1;
		int r = x/cols;
		int c = x % cols;

		//Check Bounds
		if (c + 1 > cols)
		{
			return false;
		}

		if (r+1 > rows)
			return false;

		if (validMatrix[r+1][c] == false)
		{
			return false;
		}
		else if (validMatrix[r+1][c+1] == false)
		{
			return false;
		}
		if (matrix[r+1][c-1] != null)
		{
			return false;
		}

		//Cleared checks
		if (c + 1 == cols -1)
		{
			path.add('C');
			System.out.println(path.toString());
			matrix[x/cols][x%cols] = new Shape("C", true, true);
			matrix[x/cols+1][x%cols] = new Shape("C", false, false);
			matrix[x/cols+1][x%cols+1] = new Shape("C", true, false);
			System.exit(0);
		}

		path.add('C');
		matrix[x/cols][x%cols] = new Shape("C", true, true);
		matrix[x/cols+1][x%cols] = new Shape("C", false, false);
		matrix[x/cols+1][x%cols+1] = new Shape("C", true, false);
		cursor = cursor + cols +2;
		return true;
	}

	//Adds a D piece - 1 right 2 down
	//Left To Right
	public boolean addD(int x) throws Exception
	{
		x = x - 1;
		int r = x / cols;
		int c = x % cols;

		if (c + 1 >= cols)
		{
			return false;
		}
		if (r + 2 >= rows)
		{
			return false;
		}

		if (validMatrix[r][c] == false)
		{
			return false;
		}
		if (validMatrix[r][c+1] == false)
		{
			return false;
		}
		if (validMatrix[r+1][c+1] == false)
		{
			return false;
		}

		if (validMatrix[r+2][c+1] == false)
		{
			return false;
		}
		if (matrix[r][c] != null)
		{
			return false;
		}
		if (matrix[r][c+1] != null)
		{
			return false;
		}
		if (matrix[r+1][c+1] != null)
		{
			return false;
		}
		if (matrix[r+2][c+1] != null)
		{
			return false;
		}

		//Passed error catching
		if (c + 1 == cols -1)
		{
			path.add('D');
			System.out.println(path.toString());
			matrix[r][c] = new Shape("D", true, true);
			matrix[r][c+1] = new Shape("D",false, false);
			matrix[r+1][c+1] = new Shape("D", false, false);
			matrix[r+2][c+1] = new Shape("D", true, false);
			System.exit(0);
		}

		path.add('D');
		matrix[r][c] = new Shape("D", true, true);
		matrix[r][c+1] = new Shape("D", false, false);
		matrix[r+1][c+1] = new Shape("D",false, false);
		matrix[r+2][c+2] = new Shape("D", true, false);
		cursor = cursor + cols + cols + 2;
		return true;
	}

	//Adds E piece - sigzag
	//Left To Right
	public boolean addE(int x) throws Exception
	{
		x = x-1;
		int	r = x/cols;
		int c = x % cols;

		//Exception Catching
		if (c + 2 >= cols)
		{
			return false;
		}

		if (r + 1 >= rows)
		{
			return false;
		}

		if (validMatrix[r][c] == false)
		{
			return false;
		}

		if (validMatrix[r][c+1] == false)
		{
			return false;
		}

		if (validMatrix[r+1][c+1] == false)
		{
			return false;
		}

		if (validMatrix[r+1][c+2] == false)
		{
			return false;
		}

		//Passed exception catching
		if (c + 2 == cols -1)
		{
			path.add('E');
			System.out.println(path.toString());
			matrix[r][c] = new Shape("E", true, true);
			matrix[r][c+1] = new Shape("E", false, false);
			matrix[r+1][c+1] = new Shape("E", false, false);
			matrix[r+1][c+2] = new Shape("E", true, false);
			System.exit(0);
		}

		path.add('E');
		matrix[r][c] = new Shape("E", true, true);
		matrix[r][c+1] = new Shape("E", false, false);
		matrix[r+1][c+1] = new Shape("E", false, false);
		matrix[r+1][c+2] = new Shape("E", true, false);
		cursor = cursor + cols + 3;
		return true;
	}
	
	public boolean addARL(int x) throws Exception
	{
		x = x-1;
		//Check for bounds errors
		if (x%cols - 2 < 0)
		{
			return false;
		}

		int r = x/cols;
		int c = x%cols;
		
		if (c == 0)
		{
			c =cols;
		}

		//Check for invalid pieces in the way
		for (int i = c ; i > c-2; i--)
		{
			if (validMatrix[r][i] == false)
			{
				return false;
			}
		}

		//Cleared checking
		int i = c;
		if (i-2 == 0)
		{
			path.add('A');
			System.out.println(path.toString());
			matrix[x/cols][i] = new Shape("A", true, true);
			matrix[x/cols][i-1] = new Shape("A", false, false);
			matrix[x/cols][i-2] = new Shape("A", true, false);
			System.exit(0);
		}
		matrix[x/cols][i] = new Shape("A", true, true);
		matrix[x/cols][i-1] = new Shape("A", false, false);
		matrix[x/cols][i-2] = new Shape("A", true, false);
		cursor = x - 2;
		path.add('A');
		return true;
	}

	public boolean addBRL(int x) throws Exception
	{
		x = x-1;
		int r = x/cols;
		int c = x%cols;

		//Check if it can go down

		//Check bounds
		if ((r + 2) < rows)
		{
		//Check for blocked pieces
		for (int i = r; i < x/cols+3; i++)
		{

			System.out.println(path.toString());
			if (validMatrix[i][x%cols] == false)
			{
				return false;
			}
		}
			//Passed checks
			if (x%cols == 0)
			{
				path.add('B');
				System.out.println(path.toString());
				matrix[x/cols][x%cols] = new Shape("B", true, true);
				matrix[x/cols+1][x%cols] = new Shape("B", false, false);
				matrix[x/cols+2][x%cols] = new Shape("B", true, false);
				System.exit(0);
			}
			path.add('B');
			matrix[x/cols][x%cols] = new Shape("B", true, true);
			matrix[x/cols+1][x%cols] = new Shape("B", false, false);
			matrix[x/cols+2][x%cols] = new Shape("B", true, false);
			cursor = (cursor + cols * 2) - 1;
			return true;
		}

		//Has to go up
		//Check if there is a piece in the way
		for (int k = x/cols; k > x/cols-3; k--)
		{
			if (validMatrix[k][x%cols] == false)
			{
				return false;
			}
		}
		if (x%cols == 0)
		{
			path.add('B');
			System.out.println(path.toString());
			matrix[x/cols][x%cols] = new Shape("B", true, true);
			matrix[x/cols-1][x%cols] = new Shape("B", false, false);
			matrix[x/cols-2][x%cols] = new Shape("B", true, false);
			System.exit(0);
		}
		path.add('B');
		matrix[x/cols][x%cols] = new Shape("B", true, true);
		matrix[x/cols-1][x%cols] = new Shape("B", false, false);
		matrix[x/cols-2][x%cols] = new Shape("B", true, false);
		cursor = (cursor - cols * 2) - 1;
		return true;
	}
	
	public boolean addCRL(int x) throws Exception
	{
		x = x-1;
		int r = x/cols;
		int c = x % cols;

		//Check Bounds
		if (c -1  < 0)
		{
			return false;
		}

		if (r-1 < 0)
			return false;

		if (validMatrix[r-1][c-1] == false)
		{
			return false;
		}
		else if (validMatrix[r][c-1] == false)
		{
			return false;
		}
		if (validMatrix[r][c] == false)
		{
			return false;
		}

		//Cleared checks
		if (c -1 == 0)
		{
			path.add('C');
			System.out.println(path.toString());
			matrix[x/cols][x%cols] = new Shape("C", true, true);
			matrix[x/cols][x%cols-1] = new Shape("C", false, false);
			matrix[x/cols-1][x%cols-1] = new Shape("C", true, false);
			System.exit(0);
		}

		path.add('C');
		matrix[x/cols][x%cols] = new Shape("C", true, true);
		matrix[x/cols][x%cols-1] = new Shape("C", false, false);
		matrix[x/cols-1][x%cols-1] = new Shape("C", true, false);
		cursor = cursor - cols -2;
		return true;
	}
	
	public boolean addDRL(int x) throws Exception
	{
		x = x - 1;
		int r = x / cols;
		int c = x % cols;

		if (c - 1 < 0)
		{
			return false;
		}
		if (r - 2 < 0)
		{
			return false;
		}

		if (validMatrix[r][c] == false)
		{
			return false;
		}
		if (validMatrix[r-1][c] == false)
		{
			return false;
		}
		if (validMatrix[r-2][c] == false)
		{
			return false;
		}

		if (validMatrix[r-2][c-1] == false)
		{
			return false;
		}
		if (matrix[r][c] != null)
		{
			return false;
		}
		if (matrix[r-2][c] != null)
		{
			return false;
		}
		if (matrix[r-1][c-1] != null)
		{
			return false;
		}
		if (matrix[r-2][c-1] != null)
		{
			return false;
		}

		//Passed error catching
		if (c - 1 == 0)
		{
			path.add('D');
			System.out.println(path.toString());
			matrix[r][c] = new Shape("D", true, true);
			matrix[r-1][c] = new Shape("D",false, false);
			matrix[r-2][c] = new Shape("D", false, false);
			matrix[r-2][c-1] = new Shape("D", true, false);
			System.exit(0);
		}

		path.add('D');
		matrix[r][c] = new Shape("D", true, true);
		matrix[r-1][c] = new Shape("D", false, false);
		matrix[r-2][c] = new Shape("D",false, false);
		matrix[r-2][c-1] = new Shape("D", true, false);
		cursor = cursor - cols - cols - 2;
		return true;
	}
	
	public boolean addERL(int x) throws Exception
	{
		x = x-1;
		int	r = x/cols;
		int c = x % cols;

		//Exception Catching
		if (c - 2 < 0)
		{
			return false;
		}

		if (r -1 < 0)
		{
			return false;
		}

		if (validMatrix[r][c] == false)
		{
			return false;
		}

		if (validMatrix[r][c-1] == false)
		{
			return false;
		}

		if (validMatrix[r-1][c-1] == false)
		{
			return false;
		}

		if (validMatrix[r-1][c-2] == false)
		{
			return false;
		}

		//Passed exception catching
		if (c - 2 == 0)
		{
			path.add('E');
			System.out.println(path.toString());
			matrix[r][c] = new Shape("E", true, true);
			matrix[r][c-1] = new Shape("E", false, false);
			matrix[r-1][c-1] = new Shape("E", false, false);
			matrix[r-1][c-2] = new Shape("E", true, false);
			System.exit(0);
		}

		path.add('E');
		matrix[r][c] = new Shape("E", true, true);
		matrix[r][c-1] = new Shape("E", false, false);
		matrix[r-1][c-1] = new Shape("E", false, false);
		matrix[r-1][c-2] = new Shape("E", true, false);
		cursor = cursor - cols -3 ;
		return true;
	}

	public void printValidMatrix()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int k = 0; k < cols; k++)
			{
				System.out.print(validMatrix[i][k] + "\t");
			}
			System.out.println();
		}
	}

	public void printMatrix()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int k = 0; k < cols; k++)
			{
				System.out.print("[" + (i*cols + k + 1) + "] " + matrix[i][k] + "\t");
			}
			System.out.println();
		}

	}

	//Returns the cursor
	public int getCursor()
	{
		return cursor;
	}
	
	public void throwException() throws Exception
	{
		System.exit(0);
	}

}
