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
    private String textPosition = "right";

    @Before
    public void Setup() {
        manipulator = new TextManipulatorImpl();
        sentenceToCheck = prepareSentence(wordsToSentence);
    }

    @Test
    public void shouldReturnListOfAllWordsInSentence() throws Exception {
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);

        for (int i = 0; i < wordsToSentence.length; i++) {
            String wordInResult = result.get(i+1);
            String wordToCheck = wordsToSentence[i];

            Assert.assertEquals(wordInResult, wordToCheck);
        }
    }

    @Test
    public void checkIfTheFirstLineIsFilledOnlyByStars() {
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);

        String oneLine = result.get(0);
        Assert.assertTrue(oneLine.contains("*"));
        oneLine = oneLine.replaceAll("\\*","");
        Assert.assertTrue(oneLine.isEmpty());
    }

    @Test
    public void checkIfTheNumbersOfStarsInFirstLineIsEqualsToLettersInWorldPlus4() {
        sentenceToCheck = "ab";
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);

        String oneLine = result.get(0);
        Assert.assertEquals(sentenceToCheck.length() + 4, oneLine.length());
    }

    @Test
    public void checkIfTheLastLineIsFilledOnlyByStars() {
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);

        String oneLine = result.get(result.size() - 1);
        Assert.assertTrue(oneLine.contains("*"));
        oneLine = oneLine.replaceAll("\\*","");
        Assert.assertTrue(oneLine.isEmpty());
    }

    @Test
    public void checkIfTheNumbersOfStarsInLastLineIsEqualsToLettersInWorldPlus4() {
        sentenceToCheck = "ab";
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);

        String oneLine = result.get(result.size() - 1);
        Assert.assertEquals(sentenceToCheck.length() + 4, oneLine.length());
    }

    @Test
    public void checkIfTheTextPositionIsLeft() {
        String textPosition = "left";
        int leftAndRightMargine = 2;
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);

        for (int i=0; i<result.size() - 2; i++) {
            String oneLine = result.get(i+1);
            String firstPart = oneLine.substring(0, leftAndRightMargine);
            String secondPart = oneLine.substring(leftAndRightMargine, wordsToSentence[i].length() + leftAndRightMargine);

            Assert.assertEquals(leftAndRightMargine, firstPart.length());
            Assert.assertTrue(firstPart.matches("^\\s+$"));
            Assert.assertEquals(wordsToSentence[i].length(), secondPart.length());
            Assert.assertTrue(secondPart.matches(wordsToSentence[i]));
        }
    }

    @Test
    public void checkIfTheTextPositionIsRight() {
        String textPosition = "right";
        int leftAndRightMargine = 2;
        List<String> result = manipulator.afterManipulate(sentenceToCheck, textPosition);
        String oneLine = result.get(0);
        int lineLength = oneLine.length();

        for (int i=0; i<result.size() - 2; i++) {
            oneLine = result.get(i+1);
            int lengthOfExpectedWord = wordsToSentence[1].length();
            int lengthOfFirstPart = lineLength
                    - leftAndRightMargine
                    - lengthOfExpectedWord;
            String firstPart = oneLine.substring(0, lengthOfFirstPart);
            String secondPart = oneLine.substring(lengthOfFirstPart, lengthOfExpectedWord + leftAndRightMargine);

            Assert.assertEquals(lengthOfFirstPart, firstPart.length());
            Assert.assertTrue(firstPart.matches("^\\s+$"));
            Assert.assertEquals(lengthOfExpectedWord, secondPart.length());
            Assert.assertTrue(secondPart.matches(wordsToSentence[i]));
        }
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