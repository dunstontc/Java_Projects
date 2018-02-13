public class BSTree {
  private class BSTreeNode {
    String data;
    BSTreeNode leftChild;
    BSTreeNode rightChild;

    BSTreeNode(String data) {
      this.data = data;
      leftChild = rightChild = null;
    }
  }

  private BSTreeNode root;

  public BSTree() {
    root = null;
  }

  public void add(String data) {
    if (root == null) {
      root = new BSTreeNode(data);
    } else {
      addWorker(root, data);
    }
  }

  private BSTreeNode addWorker(BSTreeNode node, String data) {
    BSTreeNode result = node;
    if (node == null) {
      result = new BSTreeNode(data);
    } else {
      int cmp = data.compareTo(node.data);
      if (cmp != 0) {
        if (cmp < 0) {
          node.leftChild = addWorker(node.leftChild, data);
        } else {
          node.rightChild = addWorker(node.rightChild, data);
        }
      }
    }
    return result;
  }

  public void dump() {
    if (root != null) {
      traversal(root);
    }
  }

  private void traversal(BSTreeNode node) {
    if (node != null) {
      traversal(node.leftChild);
      System.out.println(node.data);
      traversal(node.rightChild);
    }
  }
}
