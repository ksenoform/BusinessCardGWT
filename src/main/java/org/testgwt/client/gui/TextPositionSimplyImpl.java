package org.testgwt.client.gui;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by RSzczygielski on 2016-01-07.
 */
public class TextPositionSimplyImpl implements TextPosition {
    private HorizontalPanel hPanelForRadioButton = new HorizontalPanel();
    private RadioButton rButtonLeft = new RadioButton("radioGroup", "left");
    private RadioButton rButtonRight = new RadioButton("radioGroup", "right");
    private RadioButton rButtonCenter = new RadioButton("radioGroup", "center");

    private VerticalPanel vPanelForRadioButtons = new VerticalPanel();

    public TextPositionSimplyImpl() {
        hPanelForRadioButton.add(rButtonLeft);
        hPanelForRadioButton.add(rButtonCenter);
        hPanelForRadioButton.add(rButtonRight);

        vPanelForRadioButtons.add(hPanelForRadioButton);
    }

    @Override
    public VerticalPanel getPanelWithButtons() {
        return vPanelForRadioButtons;
    }
}
