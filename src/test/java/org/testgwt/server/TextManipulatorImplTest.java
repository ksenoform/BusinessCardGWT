package org.testgwt.server;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-05.
 */
public class TextManipulatorImplTest {
    private String[] wordsToSentence = {"one", "two", "three"};
    private TextManipulatorImpl manipulator;
    private String sentenceToCheck;

    @Before
    public void Setup() {
        manipulator = new TextManipulatorImpl();
        sentenceToCheck = prepareSentence(wordsToSentence);
    }

    @Test
    public void shouldReturnListOfAllWordsInSentence() throws Exception {
        List<String> result = manipulator.afterManipulate(sentenceToCheck);

        for (int i = 0; i < wordsToSentence.length; i++) {
            String wordInResult = result.get(i);
            String wordToCheck = wordsToSentence[i];

            Assert.assertEquals(wordInResult, wordToCheck);
        }
    }

    @Test
    public void checkIfTheFirstLineIsFilledOnlyByStars() {
        List<String> result = manipulator.afterManipulate(sentenceToCheck);

        String oneLine = result.get(0);
        Assert.assertTrue(oneLine.contains("*"));
        oneLine = oneLine.replaceAll("\\*","");
        Assert.assertTrue(oneLine.isEmpty());
    }

    @Test
    public void checkIfTheNumbersOfStarsInFirstLineIsEqualsToLettersInWorldPlus4() {
        sentenceToCheck = "ab";
        List<String> result = manipulator.afterManipulate(sentenceToCheck);

        String oneLine = result.get(0);
        Assert.assertEquals(sentenceToCheck.length() + 4, oneLine.length());
    }

    @Test
    public void checkIfTheLastLineIsFilledOnlyByStars() {
        List<String> result = manipulator.afterManipulate(sentenceToCheck);

        String oneLine = result.get(result.size() - 1);
        Assert.assertTrue(oneLine.contains("*"));
        oneLine = oneLine.replaceAll("\\*","");
        Assert.assertTrue(oneLine.isEmpty());
    }

    @Test
    public void checkIfTheNumbersOfStarsInLastLineIsEqualsToLettersInWorldPlus4() {
        sentenceToCheck = "ab";
        List<String> result = manipulator.afterManipulate(sentenceToCheck);

        String oneLine = result.get(result.size() - 1);
        Assert.assertEquals(sentenceToCheck.length() + 4, oneLine.length());
    }


    private String prepareSentence(String[] wordsToSentence) {
        StringBuilder builder = new StringBuilder();

        for (String s : wordsToSentence) {
            builder.append(s);
            builder.append(" ");
        }

        return builder.toString();
    }
}