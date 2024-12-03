package frontend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Map extends JPanel implements ActionListener {
    private int[] dimensions;
    private int[] selected;
    private JButton[][] buttonMap;

    public Map(int[] dimensions) {
        this.dimensions = dimensions;
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        // create ButtonMap
        buttonMap = new JButton[dimensions[0]][dimensions[1]];

        // create buttons
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[0]; j++) {
                JButton current = new JButton();
                this.add(current);
                gbc.gridx = i;
                gbc.gridy = j;

                buttonMap[i][j] = current;
                // configure buttons
            }
        }

    }

    @Override
    /*
     * returns the coordinates of the pressed button
     */
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[0]; j++) {
                if (e.getSource().equals(buttonMap[i][j])) {
                    selected = new int[] { i, j };
                    ((GameWindow) this.getParent()).mapClicked();
                    break;
                }
            }
        }
        throw new RuntimeException("The button pressed is not on the map");
    }
}