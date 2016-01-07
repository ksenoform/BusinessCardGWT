package org.testgwt.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by RSzczygielski on 2016-01-07.
 */
public class TextPositionSimplyImpl implements TextPosition {
    private HorizontalPanel hPanelForRadioButton = new HorizontalPanel();
    private String[] buttonsName = {"left", "center", "right"};
    private String selectedRadio;

    private VerticalPanel vPanelForRadioButtons = new VerticalPanel();

    public TextPositionSimplyImpl() {
        for (String s : buttonsName) {
            final RadioButton radioButton = new RadioButton("radioGroup", s);

            radioButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent clickEvent) {
                    checkRadio(radioButton);
                }
            });

            hPanelForRadioButton.add(radioButton);
        }

        vPanelForRadioButtons.add(hPanelForRadioButton);
    }

    private void checkRadio(RadioButton radioButton) {
        selectedRadio = radioButton.getText();
    }

    @Override
    public VerticalPanel getPanelWithButtons() {
        return vPanelForRadioButtons;
    }

    @Override
    public String getSelectedRadio() {
        return selectedRadio;
    }
}
