package Array;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

	public class TowerOfHanoi {
		private int ND = 0;
		private int FP = 0;
		private int TP = 0;
		private int count = 0;
		private int AUG = 3;

		public TowerOfHanoi(int numberOfDisks, int fromPeg, int toPeg) {
			this.ND = numberOfDisks;
			this.FP = fromPeg;
			this.TP = toPeg;
			this.count = numMoves(numberOfDisks, fromPeg, toPeg, this.AUG);
		}

		public int numMoves(int numberOfDisks, int fromPeg, int toPeg, int AUG) {
			int other = getAUG(fromPeg, toPeg);
			int count = 0;

			// if same move, return 0
			if (fromPeg == toPeg) {
				return 0;
			}
			if (numberOfDisks == 0) {
				return 0;
			}
			// base case n = 1
			if (numberOfDisks > 0) {
				// move n-1 discs from A to B
				count += numMoves(numberOfDisks - 1, fromPeg, toPeg, other);
				// move nth disc to C (1 move)
				count += 1;
				// move n-1 discs from B to C
				count += numMoves(numberOfDisks - 1, other, toPeg, fromPeg);
			}

			return count;
		}

		public int getAUG(int source, int dest) {
			if (source == 1) {
				if (dest == 1) {
					return 0;
				} else if (dest == 2) {
					return 3;
				} else {
					return 2;
				}
			}

			else if (source == 2) {
				if (dest == 1) {
					return 3;
				} else if (dest == 2) {
					return 0;
				} else {
					return 1;
				}
			}

			else {
				if (dest == 1) {
					return 2;
				} else if (dest == 2) {
					return 0;
				} else {
					return 1;
				}
			}
		}

		public int getNumCounts() {
			return count;
		}
		public static void main(String args[]) throws IOException {
			int numDisk, fromPeg, toPeg;
			ArrayList<Integer> numMoves = new ArrayList<Integer>();
			BufferedReader text = new BufferedReader(new FileReader("Tower-of-Hanoi_InputForSubmission_3.txt"));

			String input;
			while ((input = text.readLine()) != null) {
				String[] line = input.split(",");
				numDisk = Integer.parseInt(line[0]);
				fromPeg = Integer.parseInt(line[1]);
				toPeg = Integer.parseInt(line[2]);

				TowerOfHanoi TOH = new TowerOfHanoi(numDisk, fromPeg, toPeg);
				numMoves.add(TOH.getNumCounts());
			}

			for (int i : numMoves) {
				System.out.println(i);
			}

			text.close();
		}
	}

