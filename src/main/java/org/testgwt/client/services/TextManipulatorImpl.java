package org.testgwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import org.testgwt.client.gui.SomeTestToShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public class TextManipulatorImpl implements TextManipulatorInt {
    TextManipulatorAsync server;
    private SomeTestToShow someTestToShow;

    public TextManipulatorImpl(String url) {
        server = GWT.create(TextManipulator.class);
        ServiceDefTarget entrypoint = (ServiceDefTarget) server;
        entrypoint.setServiceEntryPoint(url);
        someTestToShow = new SomeTestToShow(this);
    }

    public SomeTestToShow getSomeTestToShow() {
        return someTestToShow;
    }

    @Override
    public void afterManipulate(String text) {
        server.afterManipulate(text, new CollBack());
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
                someTestToShow.updateLabel(text);
            }
        }
    }
}
