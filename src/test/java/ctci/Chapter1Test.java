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
}