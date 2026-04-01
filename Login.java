import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JTextField email;
    private JPasswordField pass;
    private JButton signInButton;
    private JLabel Renta;
    private JLabel login;
    private JButton ENTERButton;
    private JPanel Main;


    public static String SIGNIN_PASSWORD = "";

    public Login() {
        setContentPane(Main);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setTitle("Log In Form");

        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String em = email.getText().trim();
                String pas = new String(pass.getPassword()).trim();

                if(em.isEmpty() || pas.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields");
                }else if(!pas.equals(SIGNIN_PASSWORD)){
                    JOptionPane.showMessageDialog(null, "Account Not Found!");
                    JOptionPane.showMessageDialog(null,"You Don't have an Account? Click the SIGN IN");
                }else {
                   new registrationForm();
                   dispose();

                }
            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignIn().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}