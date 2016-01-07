package org.testgwt.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import org.testgwt.client.services.TextManipulatorImpl;

import java.util.List;

/**
 * Created by RSzczygielski on 2016-01-04.
 */
public class SomeTextToShow extends Composite{
    private VerticalPanel vPanelMain = new VerticalPanel();
    private FlexTable flexTable = new FlexTable();
    private TextPosition textPositionRadioButtons = new TextPositionSimplyImpl();
    private IntertText intertText;

    private TextManipulatorImpl textManipulator;

    public SomeTextToShow(TextManipulatorImpl textManipulator) {
        this.textManipulator = textManipulator;
        initWidget(vPanelMain);
        intertText = new InsertTextSimplyImpl(this);
        VerticalPanel radioButtons = textPositionRadioButtons.getPanelWithButtons();
        VerticalPanel vPanelForTextBoxAndButton = intertText.getTextBoxAndButton();

        vPanelMain.add(vPanelForTextBoxAndButton);
        vPanelMain.add(radioButtons);
        vPanelMain.add(flexTable);
    }

    public void updateLabel(List<String> text) {
        flexTable.removeAllRows();

        for (String s : text) {
            int row = flexTable.getRowCount();
            flexTable.setText(row, 0, s);
        }
    }

    public void sendTextToManipulate(String text) {
        String textPosition = textPositionRadioButtons.getSelectedRadio();
        textManipulator.afterManipulate(text, textPosition);
    }
}
