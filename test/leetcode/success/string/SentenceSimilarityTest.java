package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class SentenceSimilarityTest {
    @Test
    public void test1() {
        SentenceSimilarity s = new SentenceSimilarity();
        String[] words1;
        String[] words2;
        String[][] pairs;
        boolean expect;
        boolean output;
        int seq = 0;

        words1 = new String[]{"great", "acting", "skills"};
        words2 = new String[]{"fine", "drama", "talent"};
        pairs = new String[][]{{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"}};
        expect = true;
        output = s.areSentencesSimilar(words1, words2, pairs);
        verify(expect, output, seq++);

        words1 = new String[]{"great"};
        words2 = new String[]{"great"};
        pairs = new String[][]{};
        expect = true;
        output = s.areSentencesSimilar(words1, words2, pairs);
        verify(expect, output, seq++);

        words1 = new String[]{"great"};
        words2 = new String[]{"doubleplus", "good"};
        pairs = new String[][]{};
        expect = false;
        output = s.areSentencesSimilar(words1, words2, pairs);
        verify(expect, output, seq++);

        words1 = new String[]{"great"};
        words2 = new String[]{"good"};
        pairs = new String[][]{{"great", "fine"}, {"fine", "good"}};
        expect = false;
        output = s.areSentencesSimilar(words1, words2, pairs);
        verify(expect, output, seq++);


        words1 = new String[]{"great", "acting", "skills"};
        words2 = new String[]{"fine", "painting", "talent"};
        pairs = new String[][]{{"great", "fine"}, {"drama", "acting"}, {"skills", "talent"}};
        expect = false;
        output = s.areSentencesSimilar(words1, words2, pairs);
        verify(expect, output, seq++);


    }
}
