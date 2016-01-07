package org.testgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import org.testgwt.client.services.TextManipulatorImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt_t implements EntryPoint {
  public void onModuleLoad() {
    TextManipulatorImpl label = new TextManipulatorImpl(GWT.getModuleBaseURL() + "greet");
    RootPanel.get("xyz").add(label.getSomeTextToShow());
  }
}
