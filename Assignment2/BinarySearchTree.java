public class BinarySearchTree {
  private Node root;

  /**
   * Inserts a key into this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to insert.
   */
  public Node insert(Node root, int key) {
    // Please implement this method.
	  if (root == null) {
		  root = new Node(key);
		  return root;
	  }
	  
	  if (key > root.key) {
		  root.right = insert(root.right, key);
	  } else if (key < root.key) {
		  root.left = insert(root.left, key);
	  }
	  
	  return root;
  }

  /**
   * Checks whether or not a key exists in this binary search tree.
   * If there are n nodes in the tree, then the average runtime of this method should be log(n).
   * 
   * @param key The key to check for.
   * @return true if the key is present in this binary search tree, false otherwise.
   */
  public boolean find(Node root, int key) {
    // Please implement this method.
	  if (root == null) {
		  return false;
	  }
	  
	  if (root.key == key) {
		  return true;
	  }
	  
	  if (root.key < key) {
	       return find(root.right, key);
	  }
	 
	  return find(root.left, key);
  }

  public static class Node {
    public int key;
    public Node left;
    public Node right;
    
    Node(int data) {
    	key = data;
    	left = null;
    	right = null;
    }
  }
}
