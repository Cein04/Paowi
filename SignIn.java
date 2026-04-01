import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame{
    private JButton confirmButton;
    private JTextField email2;
    private JPasswordField pass2;
    private JPanel Main;

    public SignIn() {
        setContentPane(Main);
        setVisible(true);
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pas2 = new String(pass2.getPassword()).trim();

                if(pas2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter Password!");
                } else {

                    Login.SIGNIN_PASSWORD = pas2;

                    JOptionPane.showMessageDialog(null, "You have now Created an Account Your Password is " + pas2);

                    new Login().setVisible(true);
                    dispose();
                }
            }
        });
    }
}