package org.testgwt.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Created by RSzczygielski on 2016-01-07.
 */
public class InsertTextSimplyImpl implements IntertText {
    private Button button = new Button("Submit");
    private TextBox textBox = new TextBox();
    private HorizontalPanel hPanelForTextBoxAndButton = new HorizontalPanel();
    private VerticalPanel vPanelMain = new VerticalPanel();

    private SomeTextToShow someTextToShow;

    public InsertTextSimplyImpl(SomeTextToShow someTextToShow) {
        this.someTextToShow = someTextToShow;
        button.addClickHandler(new ClickButton());

        hPanelForTextBoxAndButton.add(textBox);
        hPanelForTextBoxAndButton.add(button);

        vPanelMain.add(hPanelForTextBoxAndButton);
    }

    private class ClickButton implements ClickHandler {
        @Override
        public void onClick(ClickEvent clickEvent) {
            String text = textBox.getText();
            someTextToShow.sendTextToManipulate(text);
        }
    }

    @Override
    public VerticalPanel getTextBoxAndButton() {
        return vPanelMain;
    }
}
