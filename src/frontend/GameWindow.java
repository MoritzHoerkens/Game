package frontend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import backend.units.*;

public class GameWindow extends JFrame {
    private JSplitPane unitFieldSplit;// holds the COntainer for the Units and the Playingfield
    private JScrollPane unitPane;

    public static void main(String[] args) {
        GameWindow x = new GameWindow();
    }

    /*
     * calls methods to initailize a GameWindow
     */
    public GameWindow() {
        initailizeFrame();
        initailizeUnitCards();
        this.pack();
        this.repaint();
    }

    /*
     * sets up the frame and the Splitpane that holds all other components
     */
    private void initailizeFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        unitFieldSplit = new JSplitPane();
        this.add(unitFieldSplit);
        unitFieldSplit.setDividerLocation(0.2);
    }

    private void initailizeUnitCards() {
        unitPane = new JScrollPane();
        unitPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        // initalize all buttons for unit recriutment

    }

    /*
     * configures and returns a button used for Unit Recruitment
     */
    private JButton getUnitRecruitmentButton(String name, Class unit) {

    }

}
