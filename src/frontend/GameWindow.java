package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import backend.units.Swordman;
import backend.units.Unit;

public class GameWindow extends JFrame {
    private JSplitPane unitFieldSplit;// holds the COntainer for the Units and the Playingfield
    private JPanel unitPane;
    private JPanel fieldPane;
    /*
     * ise this vairable to set what to do after the player makes an action like
     * clikcing on the map
     * for example for building a unit
     */
    private String currentActionWaitingForUser;
    /*
     * for use in buying a unit
     */
    @SuppressWarnings("rawtypes")
    public Class selectedUnitType;

    public static void main(String[] args) {
        GameWindow x = new GameWindow();
        x.repaint();
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

    private void initailizeField() {
        fieldPane = new JPanel();
        unitFieldSplit.setRightComponent(fieldPane);
        fieldPane.setLayout(getLayout());
    }

    public void mapClicked() {
        switch (currentActionWaitingForUser) {
            case "placeUnit":
                break;

            default:
                break;
        }
    }

    private void initailizeUnitCards() {
        unitPane = new JPanel();
        unitFieldSplit.setLeftComponent(unitPane);
        GridBagLayout layout = new GridBagLayout();
        unitPane.setLayout(layout);

        // initalize all buttons for unit recruitment
        ArrayList<JButton> allUnitButtons = new ArrayList<JButton>();
        allUnitButtons.add(getUnitRecruitmentButton("Test1", null, "/images/black.png"));
        allUnitButtons.add(getUnitRecruitmentButton("Test2", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test3", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null, null));
        allUnitButtons.add(getUnitRecruitmentButton("Test4", null, null));
        for (int i = 0; i < allUnitButtons.size(); i++) {
            JButton current = allUnitButtons.get(i);

            GridBagConstraints tmp = new GridBagConstraints();
            tmp.gridwidth = 1;
            tmp.gridheight = 1;
            tmp.gridx = i % 2;
            tmp.gridy = (int) Math.floor(i / 2);
            tmp.insets = new Insets(10, 10, 10, 10);

            current.setPreferredSize(new Dimension(75, 75));
            // TODO Setname with line break
            unitPane.add(current, tmp);
        }
    }

    /*
     * configures and returns a button used for Unit Recruitment
     */
    // TODO ICONS NOT WORKING
    @SuppressWarnings("rawtypes")
    private JButton getUnitRecruitmentButton(String name, Class unit, String iconPath) {
        JButton x = new JButton();
        x.setName(name);
        // set the icon
        if (iconPath != null) {
            try {
                Icon icon = new ImageIcon(iconPath);
                x.setIcon(icon);
            } catch (Exception e) {
                throw e;
            }
        }
        x.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                source.setBackground(new Color(255, 215, 0));
                selectedUnitType = unit;
            }
        });
        return x;
    }

}
