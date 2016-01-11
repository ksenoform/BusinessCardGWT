package org.testgwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import org.testgwt.client.gui.SomeTextToShow;

import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public class TextManipulatorImpl implements TextManipulatorInt {
    private TextManipulatorAsync server;
    private SomeTextToShow someTextToShow;

    public TextManipulatorImpl(String url) {
        server = GWT.create(TextManipulator.class);
        ServiceDefTarget entrypoint = (ServiceDefTarget) server;
        entrypoint.setServiceEntryPoint(url);
        someTextToShow = new SomeTextToShow(this);
    }

    public SomeTextToShow getSomeTextToShow() {
        return someTextToShow;
    }

    @Override
    public void afterManipulate(String text, String textPosition) {
        server.afterManipulate(text, textPosition, new CollBack());
    }

    private class CollBack implements AsyncCallback {
        @Override
        public void onFailure(Throwable throwable) {
            System.out.println("Problem !!!");
        }

        @Override
        public void onSuccess(Object o) {
            if (o instanceof List<?>) {
                List<String> text = (List<String>) o;
                someTextToShow.updateLabel(text);
            }
        }
    }
}
