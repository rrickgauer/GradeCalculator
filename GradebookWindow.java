import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GradebookWindow extends JFrame {

        private JButton button;
        JTextField[] weight = new JTextField[6];
        private JTextField[] grade= new JTextField[6];
        private JTextField[] name = new JTextField[6];
        private JLabel display;
        private JLabel finalGrade;

        GradebookWindow()
        {
                super("Gradebook");
                setSize(700, 600);

                JPanel pane1 = new JPanel(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();

                display = new JLabel("Grade Calculator");
                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.ipadx = 10;
                pane1.add(display, constraints);


                display = new JLabel("Assignment Name");
                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.ipady = 10;
                pane1.add(display, constraints);



                display = new JLabel("Percentage of Grade");
                constraints.gridx = 1;
                constraints.gridy = 1;
                pane1.add(display, constraints);


                display = new JLabel("Grade Earned");
                constraints.gridx = 2;
                constraints.gridy = 1;
                pane1.add(display, constraints);


                constraints.ipady = 0;

                String s = "";

                //adds textfields
                int count, place = 0;
                for (count = 2; count < 8; count++)
                {


                        name[place] = new JTextField(10);
                        constraints.gridx = 0;
                        constraints.gridy = count;
                        pane1.add(name[place], constraints);

                        weight[place] = new JTextField(2);
                        constraints.gridx = 1;
                        constraints.gridy = count;
                        pane1.add(weight[place], constraints);

                        grade[place] = new JTextField(3);
                        constraints.gridx = 2;
                        constraints.gridy = count;
                        pane1.add(grade[place], constraints);

                        place++;
                }



                //calculate final grade button
                button = new JButton("Calculate grade");
                constraints.gridx = 0;
                constraints.gridy = 8;
                button.addActionListener(new CustomActionListener());
                pane1.add(button, constraints);


                //displays final grade
                finalGrade = new JLabel("");
                constraints.gridx = 1;
                constraints.gridy = 8;
                pane1.add(finalGrade, constraints);


                add(pane1);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }//constructor end bracket


        class CustomActionListener implements ActionListener{
                public void actionPerformed(ActionEvent e) {

                        String display;
                        int sum = 0;
                        int count1;
                        int finalGrade1;
                        int pointsEarned = 0;
                        int temp1;
                        int temp2;


                        for (count1 = 0; count1 < 6; count1++)
                        {
                                if (weight[count1].getText().isEmpty() == false && grade[count1].getText().isEmpty() == false)
                                {
                                        temp1 = Integer.parseInt(weight[count1].getText());
                                        sum = sum + temp1;

                                        temp2 = Integer.parseInt(grade[count1].getText());

                                        pointsEarned = pointsEarned + (temp1 * temp2);
                                }
                        }

                        finalGrade1 = pointsEarned / sum;

                        display = Integer.toString(finalGrade1);

                        finalGrade.setText(display);

                }


        }
}
