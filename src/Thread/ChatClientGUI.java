package Thread;

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
    private HashMap<String, String> users;

    public ChatClientGUI() {
        users = new HashMap<>();

        loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);

        // Initialize login components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        // Add login components to layout
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        loginPanel.add(new JLabel("Username: "));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel(""));
        loginPanel.add(signupButton);
        loginFrame.add(loginPanel);

        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // Add action listener for signup button
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signup();
            }
        });

        // Add action listener for Enter key in username field
        usernameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        })

        // Add action listener for Enter key in password field
        passwordField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        loginFrame.setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (!username.isEmpty() && !password.isEmpty()) {
            if (users.containsKey(username) && users.get(username).equals(password)) {
                loginFrame.dispose(); // Close the login window
                startChat(username);
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void signup() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (!username.isEmpty() && !password.isEmpty()) {
            if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(loginFrame, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                users.put(username, password);
                JOptionPane.showMessageDialog(loginFrame, "User created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Please enter both username and password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void startChat(String username) {
        // Initialize chat components
        chatFrame = new JFrame("Chat Client - " + username);
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setSize(400, 300);

        inputField = new JTextField();
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        JButton sendButton = new JButton("Send");

        // Add chat components to layout
        chatFrame.setLayout(new BorderLayout());
        chatFrame.add(scrollPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        chatFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Event listener for send button
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Add action listener for Enter key in input field (message)
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Initialize socket connection
        try {
            socket = new Socket("192.168.0.178", 9002);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start a thread to listen for incoming messages
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

