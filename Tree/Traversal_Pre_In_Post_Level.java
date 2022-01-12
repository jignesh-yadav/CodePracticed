import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
public class Hw {
	public static void main(String args[]) {
		Node root = new Node(9);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(6);
		root.left.right = new Node(5);	
		root.left.right.left = new Node(3);
		
		printPreOrderTraversal(root);
		printInOrderTraversal(root);
		printPostOrderTraversal(root);
		
		levelOrderTraversal(root);
	}
	
	private static void printPostOrderTraversal(Node root) {
		System.out.println("printPostOrderTraversal");
		Stack<Node> stack = new Stack<Node>();
		Node currNode = root;
		while (!stack.isEmpty() || currNode != null) {
			if(currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
			else {
				Node topRightNode = stack.peek().right;
				if(topRightNode != null) {
					currNode = topRightNode;
				}
				else {
					Node poppedOutNode = stack.pop();
					System.out.print(poppedOutNode.value);
					while (!stack.isEmpty() && poppedOutNode == stack.peek().right) {
						poppedOutNode = stack.pop();
						System.out.print(poppedOutNode.value);	
					}
				}
			}
		}
		System.out.println("");
	}
	
	private static void printInOrderTraversal(Node root) {
		System.out.println("printInOrderTraversal");
		Node currNode = root;
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() || currNode != null) {
			if(currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
			else {
				Node poppedOutNode = stack.pop();
				System.out.print(poppedOutNode.value);
				currNode = poppedOutNode.right;
				/*if(!stack.isEmpty()) {
					poppedOutNode = stack.pop();
					System.out.print(poppedOutNode.value);
					currNode = poppedOutNode.right;
				}*/
			}
		}
		System.out.println();
	}
	
	private static void printPreOrderTraversal(Node root) {
		System.out.println("printPreOrderTraversal");
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node poppedOutNode = stack.pop();
			System.out.print(poppedOutNode.value);

			if(poppedOutNode.right != null) {
				stack.push(poppedOutNode.right);
			}
			if(poppedOutNode.left != null) {
				stack.push(poppedOutNode.left);
			}
		}
		System.out.println("");
	}
	
	
	private static void levelOrderTraversal(Node root) {
		System.out.println("levelOrderTraversal");
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node currElem = queue.remove();
			System.out.print(currElem.value);
			if(currElem.left != null) {
				queue.add(currElem.left);
			}
			if(currElem.right != null) {
				queue.add(currElem.right);	
			}
		}

		System.out.print("");
	}

}

class Node{
	Node left;
	Node right;
	int value;
	
	Node(int Value){
		value = Value;
		left = right = null;
	}
}
