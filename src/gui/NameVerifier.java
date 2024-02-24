package gui;

import javax.swing.*;

/**
 * The NameVerifier class verifies the input in a JTextField component.
 * It extends the InputVerifier class.
 */

public class NameVerifier  extends InputVerifier {

    /**
     * Verifies the input in the JTextField component: text field must be visible and must contain a text.
     *
     * @param textfield The JTextField component to verify.
     * @return True if the input is valid, false otherwise.
     */
    @Override
    public boolean verify(JComponent textfield) {
        JTextField tf = (JTextField) textfield;
        return (!tf.isVisible() || !(tf.getText().equals("")));
    }
}
