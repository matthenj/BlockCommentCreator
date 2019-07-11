import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CommentCreator {
    private JPanel mainPanel;
    private JTextField filenameTextBox;
    private JTextField authorTextBox;
    private JTextArea descriptionTextArea;
    private JButton okayButton;
    private JButton exitButton;
    private JLabel filenameLabel;
    private JLabel authorLabel;
    private JLabel descriptionlabel;
    private JButton copyButton;
    private JButton clearButton;
    private static JFrame frame;

    public CommentCreator() {



        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });


        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String formattedComment = Launcher.format(filenameTextBox.getText(), authorTextBox.getText(), descriptionTextArea.getText());
                System.out.println(formattedComment);
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String formattedComment = Launcher.format(filenameTextBox.getText(), authorTextBox.getText(), descriptionTextArea.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(new StringSelection(formattedComment), null);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                filenameTextBox.setText("");
                descriptionTextArea.setText("");
            }
        });

        descriptionTextArea.setColumns(Launcher.COMMENT_WIDTH-7);
    }

    public static void createAndShowGUI() {
        frame = new JFrame("Comment Creator");
        CommentCreator cc = new CommentCreator();

        frame.setContentPane(cc.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
