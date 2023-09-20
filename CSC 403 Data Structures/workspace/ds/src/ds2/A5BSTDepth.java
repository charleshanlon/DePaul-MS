package ds2;

import java.awt.Font;

import algs4.Queue;
import algs4.StdDraw;
import algs4.StdOut;

/*
 * This is a simplified version of the BST class
 * from the algs4 package.
 *
 */

public class A5BSTDepth<Key extends Comparable<? super Key>, Value> {

	private Node<Key, Value> root; // root of BST
	private int size;

	private static class Node<Key extends Comparable<? super Key>, Value> {
		public Key key; // sorted by key
		public Value val; // associated data
		public Node<Key, Value> left, right; // left and right subtrees
		public int depth; // added for A5

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	public A5BSTDepth() {
		this.root = null;
		this.size = 0;
	}

	/*
	 * *********************************************************************
	 * Return the number of key-values pairs in the BST.
	 ***********************************************************************/
	public int size() {
		return this.size;
	}

	/*
	 * *********************************************************************
	 * Does there exist a key-value pair with given key?
	 ***********************************************************************/
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/*
	 * *********************************************************************
	 * Search BST for given key, and return associated value if found,
	 * return null if not found (recursive version)
	 ***********************************************************************/

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node<Key, Value> x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/*
	 * *********************************************************************
	 * Search BST for given key, and return associated value if found,
	 * return null if not found (iterative version)
	 ***********************************************************************/
	/*
	 * public Value get(Key key) {
	 * Node<Key,Value> x = root;
	 * while (x != null) {
	 * int cmp = key.compareTo(x.key);
	 * if (cmp < 0) x = x.left;
	 * else if (cmp > 0) x = x.right;
	 * else return x.val;
	 * }
	 * return null;
	 * }
	 */
	/*
	 * *********************************************************************
	 * Insert key-value pair into BST
	 * If key already exists, update with new value
	 ***********************************************************************/
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node<Key, Value> put(Node<Key, Value> x, Key key, Value val) {
		if (x == null) {
			this.size++;
			return new Node<>(key, val);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		return x;
	}

	/*
	 * *********************************************************************
	 * Delete a key-value pair, given the key.
	 ***********************************************************************/

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node<Key, Value> delete(Node<Key, Value> x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			this.size--;
			// x is the node to be deleted.
			// The value returned in each of these cases below
			// becomes the value of the child reference from
			// the parent of x. Returning a null makes that
			// reference a null and so cuts x off, causing its
			// automatic deletion.

			// Determine how many children x has.
			if (x.right == null && x.left == null) {
				// This is a leaf node. Change its
				// reference from its parent to null.
				return null;
			} else if (x.right == null) {
				// One child, to the left. Make that
				// the new child of x's parent.
				return x.left;
			} else if (x.left == null) {
				// One child, to the right. Make that
				// the new child of x's parent.
				return x.right;
			} else {
				// Node x has two children.
				// Find the node in x's left subtree with
				// the maximum key.
				Node<Key, Value> leftTreeMaxNode = findMax(x.left);
				// Copy the key and value from that maximum
				// key node to x, thereby overwriting x's
				// original key and value.
				x.key = leftTreeMaxNode.key;
				x.val = leftTreeMaxNode.val;
				// Delete the node copied from.
				x.left = delete(x.left, leftTreeMaxNode.key);
			}
		}
		return x;
	}

	private Node<Key, Value> findMax(Node<Key, Value> x) {
		Node<Key, Value> temp = x;
		// Follow right children until you get to
		// a node with no right child. That node
		// has the maximum key in the tree rooted at x.
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}

	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<>();
		inOrder(root, q);
		return q;
	}

	// This is an in-order traversal: visit left, visit x, visit right
	// Pre-order: visit x, visit left, visit right
	// Post-order: visit left, visit right, visit x
	private void inOrder(Node<Key, Value> x, Queue<Key> q) {
		if (x == null)
			return;
		inOrder(x.left, q);
		q.enqueue(x.key);
		inOrder(x.right, q);
	}

	public int countValue(Value value) {
		return countValue(root, value);
	}

	private int countValue(Node<Key, Value> x, Value value) {
		if (x == null)
			return 0;

		int count = 0;
		if (x.val.equals(value))
			count++;
		count += countValue(x.left, value);
		count += countValue(x.right, value);
		return count;

	}

	public int height() {
		return height(root);
	}

	private int height(Node<Key, Value> x) {
		if (x == null)
			return -1;
		return 1 + Math.max(height(x.left), height(x.right));
	}

	/****************************************************************************
	 * ASSIGNMENT 5 METHODS WRITTEN BY CHARLES HANLON *
	 *****************************************************************************/
	public void assignDepths() {
		assignDepths(root, 0);
	}

	private void assignDepths(Node<Key, Value> node, int depth) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			assignDepths(node.left, node.left.depth = depth + 1);
		}
		if (node.right != null) {
			assignDepths(node.right, node.right.depth = depth + 1);
		}
	}

	public double averageDepth() {
		int total = totalDepths(root);
		double avg = ((double) total) / this.size;
		return avg;
	}

	private int totalDepths(Node<Key, Value> node) {
		int total = 0;
		if (node == null) {
			return 0;
		}
		if (node.left != null) {
			total += node.left.depth + totalDepths(node.left);
		}
		if (node.right != null) {
			total += node.right.depth + totalDepths(node.right);
		}
		return total;
	}

	/*
	 * ***************************************************************************
	 * Visualization
	 *****************************************************************************/

	public void drawTree() {
		if (root != null) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.setCanvasSize(2000, 1500);
			drawTree(root, .5, 0.95, .2, 0);
		}
	}

	private void drawTree(Node<Key, Value> n, double x, double y, double range, int depth) {
		int CUTOFF = 10;
		Font font = new Font("Arial", Font.BOLD, 30);
		StdDraw.setFont(font);
		StdDraw.text(x, y, n.key.toString() + ":" + n.val.toString() + ":" + n.depth);
		StdDraw.setPenRadius(.01);
		if (n.left != null && depth != CUTOFF) {
			StdDraw.line(x - range, y - .08, x - .01, y - .01);
			drawTree(n.left, x - range, y - .1, range * .5, depth + 1);
		}
		if (n.right != null && depth != CUTOFF) {
			StdDraw.line(x + range, y - .08, x + .01, y - .01);
			drawTree(n.right, x + range, y - .1, range * .5, depth + 1);
		}
	}
}
