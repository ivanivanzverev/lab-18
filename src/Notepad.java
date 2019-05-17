//http://java-online.ru/swing-jtextfield.xhtml

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notepad {

    JLabel jlab;
    JTextPane textPane;

    Notepad() {
        JFrame jfrm = new JFrame("Notepad");
        //jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220, 200);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlab = new JLabel();
        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("File");
        JMenuItem jmiOpen = new JMenuItem("Open");
        JMenuItem jmiClose = new JMenuItem("Close");
        JMenuItem jmiSave = new JMenuItem("Save");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        //jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);

        textPane = new JTextPane();
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comStr = e.getActionCommand();
                if (comStr.equals("Exit")) {
                    JDialog jDialog = new JDialog();
                    jDialog.setLayout(new FlowLayout());
                    jDialog.setSize(100, 40);
                    JLabel question = new JLabel("Are you sure?");
                    JButton jbtnYes = new JButton("Yes");
                    JButton jbtnNo = new JButton("No");

                    jbtnYes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });

                    jbtnNo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    jDialog.add(question);
                    jDialog.add(jbtnYes);
                    jDialog.add(jbtnNo);
                    jDialog.setVisible(true);
                    //System.exit(0);
                }
                jlab.setText(comStr + " selected");
            }
        };

        jmiOpen.addActionListener(actionListener);
        jmiClose.addActionListener(actionListener);
        jmiSave.addActionListener(actionListener);
        jmiExit.addActionListener(actionListener);

        jfrm.add(jlab);
        jfrm.setJMenuBar(jmb);
        jfrm.add(textPane);
        jfrm.setVisible(true);
    }


    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Notepad();
            }
        });
    }
}
