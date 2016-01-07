package org.testgwt.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public interface TextManipulatorAsync {
    void afterManipulate(String text, String textPosition, AsyncCallback asyncCallback);
}
