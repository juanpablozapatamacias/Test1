package training.arboles.implementation.generics;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	
	static Nodo<Integer> root;
	
	public static List<String> binaryTreeDFS(Nodo<Integer> root){
		List<String> paths = new ArrayList<>();
		
		if (root == null) return paths;
		
		dfs(root, "", paths);
		return paths;
	}

	private static void dfs(Nodo<Integer> root, String path, List<String> paths) {
		// TODO Auto-generated method stub
		path += root.getData();
		
		if(root.getLeft() == null && root.getRight() == null) {
			paths.add(path);
			return;
		}
		
		if(root.getLeft() != null)
			dfs(root.getLeft(), path + "->", paths);
		
		if(root.getRight()!= null)
			dfs(root.getRight(), path + "->", paths);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Nodo<Integer>(3);
		root.setLeft(new Nodo<Integer>(9));
		root.setRight(new Nodo<Integer>(20));
		root.getRight().setLeft(new Nodo<Integer>(15));
		root.getRight().setRight(new Nodo<Integer>(7));
		
		System.out.println(binaryTreeDFS(root));
	}

}
