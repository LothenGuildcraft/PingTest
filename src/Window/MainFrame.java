package Window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import Logic.Ping;

public class MainFrame extends JFrame {

    private JLabel prompt;
    private JTextField userInput;
    private JButton confirm;
    private JLabel requestTime;
    private JLabel requestCode;

    /**
     * Initializes the MainFrame class and creates the initial viewable window.
     */
    public MainFrame() {
        super("Server Test");
        setSize(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    /**
     * Initializes the components found within the Main Frame
     */
    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
        
        prompt = new JLabel("URL: ");
        userInput = new JTextField("Enter your URL"); 
        confirm = new JButton("Process");
        requestTime = new JLabel();
        requestCode = new JLabel();

        confirm.addActionListener((ActionEvent evt) -> {
            try {
                Ping url = new Ping(userInput.getText());
                url.testURL();
                requestTime.setText("Time (ms): " + String.valueOf(url.getTime()));
                requestCode.setText("Request Code: " + String.valueOf(url.getCode()));
            } catch (Exception e) {
                requestTime.setText(e.toString());
            }
        });

        JPanel userData = new JPanel();
        GroupLayout userDataLayout = new GroupLayout(userData);
        userData.setLayout(userDataLayout);

        userDataLayout.setHorizontalGroup(userDataLayout.createSequentialGroup()
            .addGroup(userDataLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(userDataLayout.createSequentialGroup()
                    .addComponent(prompt)
                    .addComponent(userInput)
                )
                .addComponent(confirm)
                .addComponent(requestTime)
                .addComponent(requestCode)
            )
        );

        userDataLayout.setVerticalGroup(userDataLayout.createSequentialGroup()
            .addGroup(userDataLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(prompt)
                .addComponent(userInput)
            )
            .addGap(5)
            .addComponent(confirm)
            .addGap(5)
            .addComponent(requestTime)
            .addComponent(requestCode)
        );

        add(userData);
    }
    
}
