package org.testgwt.server;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-05.
 */
public class TextManipulatorImplTest {
    private String[] wordsToSentence = {"one", "two", "three"};

    @Test
    public void shouldReturnListOfAllWordsInSentence() throws Exception {
        TextManipulatorImpl manipulator = new TextManipulatorImpl();
        String sentenceToCheck = prepareSentence(wordsToSentence);

        List<String> result;
        result = manipulator.afterManipulate(sentenceToCheck);

        for (int i = 0; i < wordsToSentence.length; i++) {
            String wordInResult = result.get(i);
            String wordToCheck = wordsToSentence[i];

            Assert.assertEquals(wordInResult, wordToCheck);
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