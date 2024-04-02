package Sd_Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class ChatClientGUI {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private JFrame loginFrame;
    private JFrame chatFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField inputField;
    private JTextArea chatArea;
    private HashMap<String, String> userMap;

    public ChatClientGUI() {
        userMap = new HashMap<>();
        loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        loginPanel.add(new JLabel("ID "));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password "));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel(""));
        loginPanel.add(signupButton);
        loginFrame.add(loginPanel);

        // 로그인 버튼에 대한 클릭 및 Enter 키 입력 처리
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        loginButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "login");
        loginButton.getActionMap().put("login", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // 회원가입 버튼에 대한 클릭 및 Enter 키 입력 처리
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup();
            }
        });
        signupButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "signup");
        signupButton.getActionMap().put("signup", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                signup();
            }
        });

        JLabel titleLabel = new JLabel("Party Land", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginFrame.getContentPane().add(titleLabel, BorderLayout.NORTH);
        
        loginFrame.setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (!username.isEmpty() && !password.isEmpty()) {
            if (login(username, password)) {
                openChatWindow(username);
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Sign Up
    private void signup() {
        JFrame signupFrame = new JFrame("Sign Up");
        signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signupFrame.setSize(300, 200);

        JTextField newUserField = new JTextField(20);
        JPasswordField newPasswordField = new JPasswordField(20);
        JTextField newNameField = new JTextField(20);
        JTextField newPhoneField = new JTextField(20);
        JButton createButton = new JButton("Create");

        JPanel signupPanel = new JPanel(new GridLayout(5, 2));
        signupPanel.add(new JLabel("New ID: "));
        signupPanel.add(newUserField);
        signupPanel.add(new JLabel("New Password: "));
        signupPanel.add(newPasswordField);
        signupPanel.add(new JLabel("Name: "));
        signupPanel.add(newNameField);
        signupPanel.add(new JLabel("Phone: "));
        signupPanel.add(newPhoneField);
        signupPanel.add(new JLabel(""));
        signupPanel.add(createButton);
        signupFrame.add(signupPanel);

        // 회원가입 버튼에 대한 클릭 및 Enter 키 입력 처리
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUserField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                String newName = newNameField.getText();
                String newPhone = newPhoneField.getText();
                if (!newUsername.isEmpty() && !newPassword.isEmpty() && !newName.isEmpty() && !newPhone.isEmpty()) {
                    signupFrame.dispose();
                    userMap.put(newUsername, newPassword);
                    JOptionPane.showMessageDialog(loginFrame, "Sign up successful. You can now login.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(signupFrame, "Please enter all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        createButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "create");
        createButton.getActionMap().put("create", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String newUsername = newUserField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                String newName = newNameField.getText();
                String newPhone = newPhoneField.getText();
                if (!newUsername.isEmpty() && !newPassword.isEmpty() && !newName.isEmpty() && !newPhone.isEmpty()) {
                    signupFrame.dispose();
                    userMap.put(newUsername, newPassword);
                    JOptionPane.showMessageDialog(loginFrame, "Sign up successful. You can now login.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(signupFrame, "Please enter all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signupFrame.setVisible(true);
    }

    private boolean login(String username, String password) {
        String savedPassword = userMap.get(username);
        return savedPassword != null && savedPassword.equals(password);
    }

    private void openChatWindow(String username) {
        loginFrame.dispose();

        chatFrame = new JFrame("Chat Client - " + username);
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setSize(400, 300);

        inputField = new JTextField();
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        JButton sendButton = new JButton("Send");

        chatFrame.setLayout(new BorderLayout());
        chatFrame.add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        chatFrame.add(bottomPanel, BorderLayout.SOUTH);

        ActionListener sendMessageAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        };
        sendButton.addActionListener(sendMessageAction);
        inputField.addActionListener(sendMessageAction);

        try {
            socket = new Socket("192.168.0.178", 9002);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new ReceiverThread()).start();

        chatFrame.setVisible(true);
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            writer.println(message);
            inputField.setText("");
        }
    }

    private class ReceiverThread implements Runnable {
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    chatArea.append(message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatClientGUI();
            }
        });
    }
}
