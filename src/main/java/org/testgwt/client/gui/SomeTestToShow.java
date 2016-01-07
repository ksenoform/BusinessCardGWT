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
    private VerticalPanel vPanelMain = new VerticalPanel();
    private HorizontalPanel hPanelForTextBoxAndButton = new HorizontalPanel();
    private Button button = new Button("Submit");
    private TextBox textBox = new TextBox();
    private FlexTable flexTable = new FlexTable();
    private HorizontalPanel hPanelForRadioButton = new HorizontalPanel();
    private RadioButton rButtonLeft = new RadioButton("radioGroup", "left");
    private RadioButton rButtonRight = new RadioButton("radioGroup", "right");
    private RadioButton rButtonCenter = new RadioButton("radioGroup", "center");

    private TextManipulatorImpl textManipulator;

    public SomeTestToShow(TextManipulatorImpl textManipulator) {
        this.textManipulator = textManipulator;
        initWidget(vPanelMain);
        button.addClickHandler(new ClickButton());

        hPanelForTextBoxAndButton.add(textBox);
        hPanelForTextBoxAndButton.add(button);

        hPanelForRadioButton.add(rButtonLeft);
        hPanelForRadioButton.add(rButtonCenter);
        hPanelForRadioButton.add(rButtonRight);

        vPanelMain.add(hPanelForTextBoxAndButton);
        vPanelMain.add(hPanelForRadioButton);
        vPanelMain.add(flexTable);
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
