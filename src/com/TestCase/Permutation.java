package com.TestCase;

public class Permutation {
	// Convert the number to Lth
	// base and print the sequence
	static void convert_To_Len_th_base(int n, int arr[], int len, int L) {
		// Sequence is of length L
		for (int i = 0; i < L; i++) {
			// Print the ith element
			// of sequence
			System.out.print(arr[n % len]);
			n /= len;
		}
		System.out.println();
	}

	// Print all the permuataions
	static void print(int arr[], int len, int L) {
		// There can be (len)^l
		// permutations
		for (int i = 0; i < (int) Math.pow(len, L); i++) {
			// Convert i to len th base
			convert_To_Len_th_base(i, arr, len, L);
		}
	}

	/**
	 * permutation function
	 * 
	 * @param str string to calculate permutation for
	 * @param l   starting index
	 * @param r   end index
	 */
	public void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
