package org.testgwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.testgwt.client.services.TextManipulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public class TextManipulatorImpl extends RemoteServiceServlet implements TextManipulator{

    @Override
    public List<String> afterManipulate(String text) {
        String[] afterSplit = text.split("\\s");
        List<String> sList = new ArrayList<String>();

        sList.add("*");

        for (String s : afterSplit) {
            sList.add(s);
        }

        sList.add("*");
        
        return sList;
    }
}
