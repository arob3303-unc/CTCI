package ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Chapter1Test {

    @Test
    void isUnique() {

        // put tests here
        assertTrue(Chapter1.isUnique("abcdef"));
        assertFalse(Chapter1.isUnique("aa"));
        assertTrue(Chapter1.isUnique(""));
        assertFalse(Chapter1.isUnique("hello"));
    }

    @Test
    void optimalIsUnique() {
        assertTrue(Chapter1.optimalIsUnique("abcdef"));
        assertFalse(Chapter1.optimalIsUnique("aa"));
        assertTrue(Chapter1.optimalIsUnique(""));
        assertFalse(Chapter1.optimalIsUnique("hello"));
    }

    @Test
    void permutation() {
        assertTrue(Chapter1.permutation("aaa", "aaa"));
        assertFalse(Chapter1.permutation("aab", "aaa"));
        assertFalse(Chapter1.permutation("abc", "aaa"));
        assertTrue(Chapter1.permutation("abc", "cba"));
        assertTrue(Chapter1.permutation("", ""));
    }

    @Test
    void optimalPermutation() {
        assertTrue(Chapter1.permutation("aaa", "aaa"));
        assertFalse(Chapter1.permutation("aab", "aaa"));
        assertFalse(Chapter1.permutation("abc", "aaa"));
        assertTrue(Chapter1.permutation("abc", "cba"));
        assertTrue(Chapter1.permutation("", ""));
    }

    @Test
    void stringCompression() {
        assertEquals("a2b1c5a3", Chapter1.stringCompression("aabcccccaaa"));
    }

    @Test
    void rotateMatrix() {
        int[][] arr2d = {{1, 2},
                         {3, 4}
        };
        Chapter1.rotateMatrix(arr2d, 2); // changes arr2d
        assertArrayEquals(new int[][] {{3,1}, {4,2}}, arr2d);
    }

    @Test
    void rotateMatrixMine() {
        int[][] arr2d = {{1, 2},
                {3, 4}
        };
        Chapter1.rotateMatrixMine(arr2d); // changes arr2d
        assertArrayEquals(new int[][] {{3,1}, {4,2}}, arr2d);
    }

    @Test
    void zeroMatrix() {
        int[][] m = {
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0}
        };

        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        Chapter1.zeroMatrix(m);
        assertArrayEquals(expected, m);
    }
}