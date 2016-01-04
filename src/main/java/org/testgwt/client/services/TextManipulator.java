package org.testgwt.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
@RemoteServiceRelativePath("greet")
public interface TextManipulator extends RemoteService {
    List<String> afterManipulate(String text);
}
