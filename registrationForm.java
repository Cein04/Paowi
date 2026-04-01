import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrationForm extends JFrame{
    private JComboBox<String> Cars;  // Added generic type
    private JTextField age;
    private JTextField sex;
    private JTextField num;
    private JTextField eacc;
    private JCheckBox yesCheckBox;
    private JCheckBox noCheckBox;
    private JTextField numDay;
    private JButton submitButton;
    private JPanel Main;
    private JTextField carPrice;
    private JTextField name;
    private JLabel tPrice;
    private JButton checkDurationButton;

    // Price mapping for each car
    private final double[] CAR_PRICES = {
            0,
            1000,
            3500,
            5000,
            9000,
            30000,
            38000
    };

    public registrationForm() {
        setContentPane(Main);
        setTitle("Car Registration");
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add ItemListener to Cars JComboBox to auto-fill price
        Cars.addItemListener(e -> {
            if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                int selectedIndex = Cars.getSelectedIndex();
                if (selectedIndex >= 0 && selectedIndex < CAR_PRICES.length) {
                    carPrice.setText(String.valueOf(CAR_PRICES[selectedIndex]));
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
                String Name = name.getText();
                String Num = num.getText();
                String Age = age.getText();
                String Sex = sex.getText();
                String Email = eacc.getText();
                String CarPrice = carPrice.getText();
                String NumDay = numDay.getText();
                String Car = Cars.getSelectedItem().toString();

                JOptionPane.showMessageDialog(Main,
                        "=======Rental Receipt========\n" +
                                "Name: " + Name + "\n" +
                                "Number: " + Num + "\n" +
                                "Age: " + Age + "\n" +
                                "Sex: " + Sex + "\n" +
                                "Email: " + Email + "\n" +
                                "Car Rented: " + Car + "\n" +
                                "Duration: " + NumDay + " Day(s)" + "\n" +
                                "Car Price per Day: Php:" + CarPrice + "\n" +
                                "Total Price: " + tPrice.getText() + "\n" +
                                "========Thank You=========");
            }

            public void add() {
                try {
                    double cp = Double.parseDouble(carPrice.getText());
                    double nb = Double.parseDouble(numDay.getText());
                    double mult = cp * nb;

                    if (yesCheckBox.isSelected()) {
                        double discount = mult * 0.20;
                        double total = mult - discount;
                        tPrice.setText(String.valueOf(total)); // Format to 2 decimal places
                    } else {
                        tPrice.setText(String.valueOf(mult)); // Format to 2 decimal places
                    }
                } catch (NumberFormatException ex) {
                    tPrice.setText("Invalid Input");
                }
            }
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new registrationForm());
    }
}