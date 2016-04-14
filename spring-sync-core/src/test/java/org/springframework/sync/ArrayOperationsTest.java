package org.springframework.sync;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTest {
	@Test
	public void replaceElementsOnIntArray() {
		int[] original = new int[]{1, 2, 3};
		int[] modified = new int[]{3, 2, 1};
		Patch diff = Diff.diff(original, modified);
		assertEquals(2, diff.size());
	}

	@Test
	public void replaceElementsOnListOfArrays() {
		List<int[]> original = Arrays.asList(new int[][]{
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
		});
		List<int[]> modified = Arrays.asList(new int[][]{
			{0, 2, 4},
			{6, 8, 1},
			{3, 5, 7},
		});
		Patch diff = Diff.diff(original, modified);
		assertEquals(6, diff.size());
	}
}
