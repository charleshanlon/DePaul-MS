package hw8;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * A class used to determine if a path exists from the top of a grid to the
 * bottom
 */
public class PathCheck {

	// IMPORTANT:
	// Use the uf field below to help you solve the problem.
	// Note, however, that this one field is not enough.
	// You will need to have additional fields, but you must use
	// the uf field in solving the probem.
	private final boolean[] grid; // True if that position has been selected before, false otherwise
	private WeightedQuickUnionUF uf;
	private final int size;	//size given by user
	private final int top;	//number connected to top row
	private final int bottom; //number connected to bottom row

	/**
	 * Models an initial <code>size</code> by <code>size</code> grid with no cells
	 * selected.
	 * 
	 * @param size the length and width of the grid.
	 */
	public PathCheck(int size) {
		this.size = size;
		grid = new boolean[size*size];
		uf = new WeightedQuickUnionUF(size*size+2);
		top = size*size;
		bottom = top+1;
		int last = size*size-1;
		//connect top to every position in the top row
		// connect bottom to every position in the bottom row
		for (int i = 0; i < size; i++) {
			uf.union(top,  i);;
			uf.union(bottom, last-i);
		}
	}
	/**
	 * Selects the cell in given <code>row</code> and <code>col</code> and returns
	 * <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * 
	 * @param row the row of the cell to be selected.
	 * @param col the column of the cell to be selected.
	 * @return <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException if either <code>row</code> or
	 *                                  <code>col</code> is out of bounds (greater
	 *                                  than or equal to size or negative).
	 */
	public boolean select(int row, int col) throws IllegalArgumentException {
		
		//verify row an col are valid
		if (row < 0 || row >= size)
			throw new IllegalArgumentException("Row is out of bounds :" + row);
		if (col < 0 || col >= size)
			throw new IllegalArgumentException("Col is out of bounds: " + col);
			
		int position = row * size + col;
		
		// remember that this grid position has been selected
		grid[position] = true;
		
		if (row > 0 && grid[position-size])
			uf.union(position, position-size);
		if (row < size-1 && grid[position+size])
			uf.union(position, position+size);
		if (col > 0 && grid[position-1])
			uf.union(position, position-1);
		if (col < size-1 && grid[position+1])
			uf.union(position, position+1);
		
		// check for neighbors that have been selected in the past
		// union with any previously selected neighbors
		
		
		return uf.find(top) == uf.find(bottom);
	}
}
