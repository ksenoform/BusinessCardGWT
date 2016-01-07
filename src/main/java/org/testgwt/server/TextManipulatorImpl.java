package org.testgwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.testgwt.client.services.TextManipulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public class TextManipulatorImpl extends RemoteServiceServlet implements TextManipulator, CorrectorLines{
    private Integer longestWordInSentence;

    @Override
    public List<String> afterManipulate(String text, String textPosition) {
        String[] afterSplit = text.split("\\s");
        List<String> sList = new ArrayList<String>();
        longestWordInSentence = 0;

        sList.add("*");

        for (String s : afterSplit) {
            if (longestWordInSentence < s.length()) {
                longestWordInSentence = s.length();
            }

            sList.add(s);
        }

        sList.add("*");

        correctLinesWithStars(sList);

        return sList;
    }

    @Override
    public void correctLinesWithStars(List<String> listToCorrect) {
        char[] starsList = new char[longestWordInSentence + 4];
        Arrays.fill(starsList, '*');
        listToCorrect.set(0, String.valueOf(starsList));
        listToCorrect.set(listToCorrect.size() - 1, String.valueOf(starsList));
    }
}
