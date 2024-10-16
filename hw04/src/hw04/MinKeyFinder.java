package hw04;

/**
 * Find the key associated with the minimum value in a tree.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {
	private Integer currentMin;
	private String keyOfCurrentMin;


	public MinKeyFinder() {
		currentMin = Integer.MAX_VALUE;
		keyOfCurrentMin = null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void visit(String key, Integer value) {
		if (value < currentMin) {
			currentMin = value;
			keyOfCurrentMin = key;
		}
	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {
		return keyOfCurrentMin;
	}
	
	public static void main(String[] args) {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
		Integer[] vals = {10, 34, 564, 2, 5, 56, 55, 10001, 1, 109, 308};

		CS232LinkedBinaryTree<String, Integer> t = new CS232LinkedBinaryTree<String, Integer>(keys, vals);
		MinKeyFinder mkf = new MinKeyFinder();
		t.visitPreOrder(mkf);

		System.out.println("The key associated with the minimum value in the tree is: " + mkf.getMinKey());
	}
}
