package org.testgwt.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import org.testgwt.client.services.TextManipulatorImpl;

import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public class SomeTestToShow extends Composite{
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Button button = new Button("Submit");
    private TextBox textBox = new TextBox();
    private FlexTable flexTable = new FlexTable();
    private TextManipulatorImpl textManipulator;

    public SomeTestToShow(TextManipulatorImpl textManipulator) {
        this.textManipulator = textManipulator;
        initWidget(verticalPanel);
        button.addClickHandler(new ClickButton());

        verticalPanel.add(textBox);
        verticalPanel.add(button);
        verticalPanel.add(flexTable);
    }

    public void updateLabel(List<String> text) {
        flexTable.removeAllRows();
        for (String s : text) {
            int row = flexTable.getRowCount();
            flexTable.setText(row, 0, s);
        }
    }

    private class ClickButton implements ClickHandler {
        @Override
        public void onClick(ClickEvent clickEvent) {
            String text = textBox.getText();
            textManipulator.afterManipulate(text);
        }
    }
}
