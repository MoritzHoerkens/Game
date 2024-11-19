package frontend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import backend.units.*;

public class GameWindow extends JFrame {
    private JSplitPane unitFieldSplit;// holds the COntainer for the Units and the Playingfield
    private JPanel unitPane;

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
        unitPane = new JPanel();
        unitFieldSplit.setLeftComponent(unitPane);
        unitPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.gridwidth = 9;
        /*
         * 0BBB0BBB0
         * BBB ist ein button mit 3 Kästen
         * und 0 ist ein paltzhalter für Padding
         */

        // initalize all buttons for unit recriutment
        ArrayList<JButton> allUnitButtons = new ArrayList<JButton>();
        allUnitButtons.add(getUnitRecruitmentButton("Test1", null));
        allUnitButtons.add(getUnitRecruitmentButton("Test2", null));
        allUnitButtons.add(getUnitRecruitmentButton("Test3", null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null));
        for (int i = 0; i < allUnitButtons.size(); i++) {
            GridBagConstraints tmp = new GridBagConstraints();
            tmp.gridwidth = 3;
            tmp.gridheight = 3;
            tmp.gridx = 0;
            tmp.gridy = allUnitButtons.indexOf(i) * 3 + 1;
            tmp.weightx = 1;
            tmp.weighty = 0.5;

            unitPane.add(i, tmp);

        }
    }

    /*
     * configures and returns a button used for Unit Recruitment
     */
    private JButton getUnitRecruitmentButton(String name, Class unit) {
        JButton x = new JButton();
        x.setName(name);
        return x;
    }

}
