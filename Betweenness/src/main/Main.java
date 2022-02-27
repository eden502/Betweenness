package main;

/**
 * @author Eden Harel - 205518178
 */

import java.util.ArrayList;

public class Main {

	
	
	/**
	 * Returns a matrix after multiplication
	 * <p>
	 * Iterative approach - time complexity of O(n^3).
	 * @param mat Matrix 1 to be multiplied
	 * @param mat2 Matrix 2 to be multiplied
	 * @return  matrix1*matrix2
	 */
	
	public static int[][] matrixMult(int[][] mat,int [][] mat2) {

		int[][] temp = new int[mat.length][mat2.length];
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					for (int k = 0; k < mat[i].length; k++) {
						temp[i][j] += mat[i][k] * mat2[k][j];
					}
				}
			}		
		return temp;
	}
	
	/**
	 * Returns an ArrayList containing two arrays:
	 * (0) Length of the shortest paths between all nodes
	 * (1) Number of each of the shortest paths
	 * @param paths ArrayList of matrices holding different path lengths
	 * (0) length of 1
	 * (1) length of 2
	 * (2) length of 3
	 * (n) length = n+1
	 * @return ArrayList of shortest paths and number of shortest paths
	 */
	
	public static ArrayList<int[][]> findShortestPath(ArrayList<int[][]> paths){
		
		int length = paths.get(0).length;
		ArrayList<int[][]> sp = new ArrayList<>();
		int[][] shortestPathsCount = new int[length][length];
		
		shortestPathsCount = copyMat(paths.get(0));

		
		int[][] shortestPaths = paths.get(0);
		
		for (int i = 0; i < paths.size()-1; i++) {
			for (int j = 0; j < shortestPaths.length; j++) {
				for (int k = 0; k < shortestPaths.length; k++) {
					if(paths.get(i)[j][k]==0&&paths.get(i+1)[j][k]!=0)
						if(shortestPaths[j][k]==0) {
							shortestPaths[j][k]=i+2;
							shortestPathsCount[j][k] = paths.get(i+1)[j][k];
						}
					if(j==k) {
						shortestPaths[j][k]=0;
						shortestPathsCount[j][k]=0;
					}
				}
			}
		}
		System.out.println("--------Shortest Path--------");
		printMat(shortestPaths);
		System.out.println("-----Num Of Shortest Paths-----");
		printMat(shortestPathsCount);
		
		sp.add(shortestPaths);
		sp.add(shortestPathsCount);
		return sp;
		
		
	}
	/**
	 * Returns a copy of given matrix 
	 * @param mat Matrix to be copied
	 * @return new copy of matrix
	 */
	public static int[][] copyMat(int[][] mat){
		int[][] copy = new int[mat.length][mat.length];
		for (int i = 0; i < mat.length; i++) {
			System.arraycopy(mat[i], 0, copy[i], 0,mat.length);
		}
		return copy;
	}
	/**
	 * Prints a given matrix to console
	 * @param mat Matrix to be printed
	 */
	public static void printMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------");
		
	}
	/**
	 * Checks if a given path is the shortest possible path, and
	 * it runs through a given node
	 * @param shortestPaths Matrix containing the shortest possible paths between nodes
	 * @param vi Source node
	 * @param vj Target node
	 * @param s Betweenness node
	 * @return True if the shortest possible path from node vi to node vj passes through node s
	 */
	public static boolean checkPath(int[][] shortestPaths, int vi, int vj, int s) {
		
		int x = 0;
		int y = 0;
		int r = 0;
		vi--;
		vj--;
		s--;
		x = shortestPaths[vi][s];
		y = shortestPaths[vj][s];
		r = shortestPaths[vi][vj];
		
		return r ==x+y;
		
	}

	public static void main(String[] args) {

		int[][] mat = new int[][] { 
			{ 0, 1, 0, 0, 0, 0 }, 
			{ 1, 0, 1, 0, 0, 0 }, 
			{ 0, 1, 0, 1, 1, 0 },
			{ 0, 0, 1, 0, 1, 1 },
			{ 0, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 1, 0 } };
 
			
		int[][] originalMat = copyMat(mat);
		ArrayList<int[][]> paths = new ArrayList<>();
		
		int pow = 6;
		for (int i = 0; i < pow; i++) {
			paths.add(mat);
			mat = matrixMult(mat,originalMat);
		}		
		for (int i = 0; i < paths.size(); i++) {
			System.out.println("----------------------");
			printMat(paths.get(i));
			System.out.println("----------------------");
		}
		
		
		System.out.println("-------------------------");
		int[][] shortestPaths = findShortestPath(paths).get(0);
		System.out.println(checkPath(shortestPaths,1,6,3));
	}

}
