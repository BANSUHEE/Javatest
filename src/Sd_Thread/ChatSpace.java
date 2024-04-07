//package Sd_Thread;
//
//import javax.swing.*;
//import javax.swing.table.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import java.net.*;
//import java.sql.*;
//import java.util.HashMap;
//
//public class ChatSpace {
//   // 소켓 통신에 필요한 변수
//   private Socket socket;
//   private BufferedReader reader;
//   private PrintWriter writer;
//   // 데이터 베이스 연결 변수
//   Connection conn;
//   PreparedStatement pstmt;
//   // 관리자 창 변수
//   private JFrame adminFrame;
//   
//   // 프레임 변수
//   private JFrame loginFrame;
//   private String id;
//
//   // 로그인 창 컴포넌트
//   private JTextField usernameField; // id 입력 창
//   private JPasswordField passwordField;// 비밀번호 입력 창
//   private JButton loginButton;
//   private JButton signupButton;
//
//   // 채팅창 컴포넌트
//   private JTextField inputField;
//   private JTextArea chatArea;
//
//   // List,set,map 중 데이터의 형태를 저장하는 hash와 키+값을 저장하는 map을 사용하여 아이디와 비밀번호 저장.
//   // 회원가입 정보를 저장할 데이터 구조
//   private HashMap<String, String> userMap;
//
//   // 공지
//   private JFrame userNoticeFrame;
//   private JTextArea noticeTextArea;
//   private JTextField newNoticeField;
//   private JTextArea noticeArea;
//   private JFrame mainFrame;
//   private JFrame chatSearchFrame;
//   private JFrame openLoginFrame;
//   private JTextField openLoginField;
//   
//   // 생성자
//   public ChatSpace() {
//      // 데이터베이스 연결
//      this("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root", "qwe123!@#");
//      // 사용자 정보 해시맵 초기화
//      userMap = new HashMap<>();
//      // 로그인 프레임 설정
//      initializeLoginFrame();
//   }
//
//// 데이터베이스 연결 생성자
//   public ChatSpace(String url, String user, String pw) {
//      try {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         conn = DriverManager.getConnection(url, user, pw);
//      } catch (ClassNotFoundException | SQLException e) {
//         e.printStackTrace();
//      }
//   }
//
//   // 로그인 창 초기화 메서드
//   private void initializeLoginFrame() {
//      loginFrame = new JFrame("Login");
//      loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      loginFrame.setSize(300, 200);
//      loginFrame.setLocationRelativeTo(null);
//
//      // 로그인 컴포넌트 초기화
//      usernameField = new JTextField(20);
//      passwordField = new JPasswordField(20);
//      loginButton = new JButton("Login");
//      signupButton = new JButton("Sign Up");
//
//      // 레이아웃 구성
//      JPanel loginPanel = new JPanel(new GridLayout(4, 2));
//      loginPanel.add(new JLabel("        ID "));
//      loginPanel.add(usernameField);
//      loginPanel.add(new JLabel("        Password "));
//      loginPanel.add(passwordField);
//      loginPanel.add(new JLabel(""));
//      loginPanel.add(loginButton);
//      loginPanel.add(new JLabel(""));
//      loginPanel.add(signupButton);
//      loginFrame.add(loginPanel);
//
//      // 로그인 버튼에 대한 이벤트 리스너를 설정하는 부분
//      loginButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            String id = usernameField.getText();
//            String password = new String(passwordField.getPassword());
//            if (!id.isEmpty() && !password.isEmpty()) {
//               if (login(id, password)) {
//               // 데이터베이스에 세션 정보 추가
//                   try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO session (id) VALUES (?)")) {
//
//                       pstmt.setString(1, id);
//                       pstmt.executeUpdate();
//                   } catch (SQLException sqlException) {
//                       sqlException.printStackTrace();
//                   }
//                   
//                  // 관리자
//                  if (id.equalsIgnoreCase("admin")) {
//                     openAdminWindow(id);
//                  }
//                  // 일반 사용자
//                  else {
//                     openChatWindow(id);
//                  }
//
//               } else {
//                  JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//               }
//            } else {
//               JOptionPane.showMessageDialog(loginFrame, "Please enter both username and password.", "Error",
//                     JOptionPane.ERROR_MESSAGE);
//            }
//         }
//      });
//
//      // username 필드에서 Enter 키 입력 시 패스워드 필드로 이동
//      usernameField.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            // 패스워드 필드로 포커스 이동
//            passwordField.requestFocusInWindow();
//         }
//      });
//
//      // 패스워드 필드에서 Enter 키 입력 시 로그인 버튼 클릭
//      passwordField.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            // 로그인 버튼 클릭
//            loginButton.doClick();
//         }
//      });
//
//      // 이벤트 리스너를 회원가입 버튼에 추가하여 클릭 이벤트가 발생하면 회원가입 창을 열도록 설정
//      signupButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            openSignupWindow();
//         }
//      });
//
//      JLabel titleLabel = new JLabel("Party Land", SwingConstants.CENTER);
//      titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//      loginFrame.getContentPane().add(titleLabel, BorderLayout.NORTH);
//
//      loginFrame.setVisible(true);
//   
//      // 반짝임 효과를 주기 위해 타이머를 사용합니다.
//      Timer timer = new Timer(500, new ActionListener() {
//          boolean isRed = true;
//
//          @Override
//          public void actionPerformed(ActionEvent e) {
//              if (isRed) {
//                  titleLabel.setForeground(Color.BLUE); // 다른 색으로 변경
//              } else {
//                  titleLabel.setForeground(Color.RED); // 이전 색으로 변경
//              }
//              isRed = !isRed;
//          }
//      });
//      timer.start(); // 타이머 시작
//
//  }
//   
//
//   // 회원가입 창 열기
//   private void openSignupWindow() {
//      JFrame signupFrame = new JFrame("Sign Up");
//      signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//      signupFrame.setSize(300, 200);
//      signupFrame.setLocationRelativeTo(null); // 창 가운데 정렬
//
//      System.out.println("check");
//
//      // 새로운 사용자의 ID를 입력할 텍스트 필드를 생성합니다.
//      JTextField newidField = new JTextField(20);
//      // 새로운 사용자의 비밀번호를 입력할 패스워드 필드를 생성합니다.
//      JPasswordField newPasswordField = new JPasswordField(20);
//      // 추가: 새로운 사용자의 이름을 입력할 텍스트 필드를 생성합니다.
//      JTextField newNameField = new JTextField(20);
//      // 추가: 새로운 사용자의 전화번호을 입력할 텍스트 필드를 생성합니다.
//      JTextField newPhoneField = new JTextField(20);
//      // "Create"라는 텍스트를 갖는 버튼을 생성합니다. 이 버튼은 새로운 사용자를 생성하는 역할을 합니다.
//      JButton createButton = new JButton("Create");
//
//      // 레이아웃에 컴포넌트를 추가합니다.
//      JPanel signupPanel = new JPanel(new GridLayout(5, 2));
//      signupPanel.add(new JLabel("New ID: "));
//      signupPanel.add(newidField); // ID 입력
//      signupPanel.add(new JLabel("New Password: "));
//      signupPanel.add(newPasswordField); // 패스워드 입력
//      signupPanel.add(new JLabel("Name: "));
//      signupPanel.add(newNameField); // 이름 입력
//      signupPanel.add(new JLabel("Phone: "));
//      signupPanel.add(newPhoneField); // 전화번호 입력
//      signupPanel.add(new JLabel(""));
//      signupPanel.add(createButton);
//      signupFrame.add(signupPanel);
//
//      // 이벤트 리스너를 정의하는 부분
//      createButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            try {
//               String sql = "insert into USERS ( ID, PASSWORD, NAME, PHONE)\r\n" + "VALUES(?, ?, ?, ?)";
//               // SQL에 데이터 입력되기 위해 쿼리문 작성.
//               pstmt = conn.prepareStatement(sql);
//               // 사용자가 입력한 값 가져오기
//               String newid = newidField.getText();
//               String newPassword = new String(newPasswordField.getPassword());
//               String newName = newNameField.getText(); // 추가: 이름 입력값 가져오기
//               String newPhone = newPhoneField.getText(); // 추가: 전화번호 입력값 가져오기
//
//               pstmt.setString(1, newid);
//               pstmt.setString(2, newPassword);
//               pstmt.setString(3, newName);
//               pstmt.setInt(4, Integer.parseInt(newPhone));
//               pstmt.executeUpdate();
//
//               if (!newid.isEmpty() && !newPassword.isEmpty() && !newName.isEmpty() && !newPhone.isEmpty()) { // 추가:
//
//                  signupFrame.dispose();
//                  userMap.put(newid, newPassword);
//                  JOptionPane.showMessageDialog(loginFrame, "Sign up successful. You can now login.", "Success",
//                        JOptionPane.INFORMATION_MESSAGE);
//               } else {
//                  JOptionPane.showMessageDialog(signupFrame, "Please enter all fields.", "Error",
//                        JOptionPane.ERROR_MESSAGE); // 수정: 모든 필드를 입력하라는 메시지
//               }
//
//            } catch (SQLException e1) {
//               e1.printStackTrace();
//            }
//
//         }
//      });
//
//      signupFrame.setVisible(true); // 회원가입 창을 보이게 설정
//   }
//
//   // 로그인 기능
//   private boolean login(String username, String password) {
//      try {
//         String sql = "select * from users where id = ? and password = ?";
//         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, username);
//         pstmt.setString(2, password);
//
//         ResultSet rs = pstmt.executeQuery();
//         if (rs.next()) {
//           id = rs.getString("id");
//            return true; //
//
//         } else {
//            return false;
//         }
//
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//      return false;
//   }
//
//// 관리자 창 열기
//   private void openAdminWindow(String username) {
//      loginFrame.dispose(); // 로그인 창 닫기
//      adminFrame = new JFrame("Admin Panel");
//      adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      adminFrame.setSize(400, 300);
//      adminFrame.setLocationRelativeTo(null); // 창 가운데 정렬
//      // 버튼 패널 생성
//      JPanel buttonPanel = new JPanel(new GridBagLayout());
//      GridBagConstraints gbc = new GridBagConstraints();
//      gbc.gridx = 0;
//      gbc.gridy = GridBagConstraints.RELATIVE;
//      gbc.fill = GridBagConstraints.HORIZONTAL;
//      gbc.insets = new Insets(5, 5, 5, 5); // 각 버튼 사이의 여백 조정
//
//      // 버튼 생성 및 패널에 추가
//      JButton button1 = new JButton("회원정보");
//      JButton button2 = new JButton("로그인현황");
//      JButton button3 = new JButton("채팅내용검색");
//      JButton button4 = new JButton("공지사항");
//      
//      button1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
//      button2.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
//      button3.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
//      button4.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
//      buttonPanel.add(button1, gbc);
//      buttonPanel.add(button2, gbc);
//      buttonPanel.add(button3, gbc);
//      buttonPanel.add(button4, gbc);
//
//      // 버튼 1 클릭 이벤트 처리
//      button1.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            openUserInfoWindow();
//         }
//      });
//
//      // 버튼 2 클릭 이벤트 처리
//      button2.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            openLoginManage();
//         }
//      });
//      
//      // 버튼 3 클릭 이벤트 처리
//      button3.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            chatSearch();
//         }
//      });
//      
//      // 버튼 4 클릭 이벤트 처리
//      button4.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            openNoticeWindow();
//         }
//      });
//
//      // 버튼 패널을 프레임에 추가
//      adminFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
//
//      adminFrame.setVisible(true);
//   }
//
//    
//   //버튼 2 로그인 현황 클릭 시 활 동 
//   private void openLoginManage() {
//        adminFrame.dispose();
//        JFrame openLoginFrame = new JFrame("openLogin");
//        openLoginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        openLoginFrame.setSize(600, 500);
//        openLoginFrame.setLocationRelativeTo(null);
//
//         // 사용자 정보를 표시할 테이블 생성
//         JTable table = new JTable();
//         DefaultTableModel model = new DefaultTableModel();
//         model.addColumn("Index");
//         model.addColumn("ID");
//         model.addColumn("TIME");
//
//         // 데이터베이스에서 사용자 정보를 가져와 테이블에 추가
//         try {
//            String sql = "select * from session";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//              String index = rs.getString("session_index");
//               String id = rs.getString("id");
//               String inputTime = rs.getString("input_time");
//
//               model.addRow(new Object[] {index, id, inputTime});
//            }
//         } catch (SQLException e) {
//            e.printStackTrace();
//         }
//
//         table.setModel(model);
//
//         // 테이블을 스크롤 가능하도록 스크롤 패널에 추가
//         JScrollPane scrollPane = new JScrollPane(table);
//         
//         openLoginField = new JTextField(20);
//         JButton deleteButton = new JButton("Delete");
//         JButton backButton = new JButton("Back");
//         JPanel noticePanel = new JPanel(new FlowLayout());
//         noticePanel.add(openLoginField);
//         noticePanel.add(deleteButton); // 삭제 버튼 추가
//         noticePanel.add(backButton); // 이전 버튼 추가
//
//         // 삭제 버튼을 포함하는 패널 생성
//         JPanel buttonPanel = new JPanel();
//         buttonPanel.add(deleteButton);
//         
//
//         // 이전 버튼을 포함하는 패널 생성
//         buttonPanel.add(backButton);
//        
//         // 삭제 버튼에 대한 액션 리스너 추가
//         deleteButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               deletelogin(table);
//            }
//         });
//         
//         // 이전 버튼에 대한 액션 리스너 추가
//         backButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               // 이전 단계로 돌아가는 동작 구현
//               openAdminWindow(null); // username은 이전에 저장된 값
//               openLoginFrame.dispose();
//            }
//         });
//
//         // 테이블과 삭제 버튼 패널을 프레임에 추가
//         openLoginFrame.add(scrollPane, BorderLayout.CENTER);
//         openLoginFrame.add(buttonPanel, BorderLayout.SOUTH);
//
//         openLoginFrame.setVisible(true);
//
//      }
// // 로그인 현황 삭제 기능
//   protected void deletelogin(JTable table) {
//      int selectedRow = table.getSelectedRow(); // 선택된 행의 인덱스 가져오기
//      if (selectedRow != -1) { // 선택된 행이 있는 경우
//         DefaultTableModel model = (DefaultTableModel) table.getModel();
//         String session_index = (String) model.getValueAt(selectedRow, 0); // 선택된 행의 ID 가져오기
//
//         // 데이터베이스에서 사용자 삭제
//         try {
//            String sql = "DELETE FROM session WHERE session_index = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            int sessionIndex = Integer.parseInt(session_index);
//            pstmt.setInt(1, sessionIndex);
//            int rowsAffected = pstmt.executeUpdate();
//            if (rowsAffected > 0) {
//               model.removeRow(selectedRow); // 테이블 모델에서 해당 행 제거
//               JOptionPane.showMessageDialog(null, "User  deleted successfully.", "Success",
//                     JOptionPane.INFORMATION_MESSAGE);
//            } else {
//               JOptionPane.showMessageDialog(null, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//         } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
//         }
//      } else { // 선택된 행이 없는 경우
//         JOptionPane.showMessageDialog(null, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
//      }
//
//   }     
//   // 채팅검색 창 열고 검색
//   private void chatSearch() {
//      adminFrame.dispose();
//      chatSearchFrame = new JFrame("ChatSearch");
//      chatSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//      chatSearchFrame.setSize(800, 600);
//      chatSearchFrame.setLocationRelativeTo(null);
//
//      // 사용자 정보를 표시할 테이블 생성
//      JTable table = new JTable();
//      DefaultTableModel model = new DefaultTableModel();
//      model.addColumn("id");
//      model.addColumn("contents");
//      model.addColumn("input_time");
//
//      // 데이터베이스에서 사용자 정보를 가져와 테이블에 추가
//      try {
//         String sql = "select * from chat_messages";
//         PreparedStatement pstmt = conn.prepareStatement(sql);
//         ResultSet rs = pstmt.executeQuery();
//
//         while (rs.next()) {
//            String id = rs.getString("id");
//            String contents = rs.getString("contents");
//            String input_time = rs.getString("input_time");
//
//            model.addRow(new Object[] { id, contents, input_time });
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//
//      table.setModel(model);
//
//      // 테이블을 스크롤 가능하도록 스크롤 패널에 추가
//      JScrollPane scrollPane = new JScrollPane(table);
//
//      // 삭제 버튼을 포함하는 패널 생성
//      JPanel buttonPanel = new JPanel();
//      JButton deleteButton = new JButton("Delete");
//      buttonPanel.add(deleteButton);
//
//      // 이전 버튼을 포함하는 패널 생성
//      JButton backButton = new JButton("Back");
//      buttonPanel.add(backButton);
//
//      // 삭제 버튼에 대한 액션 리스너 추가
//      deleteButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            deleteChat(table);
//         }
//      });
//
//      // 이전 버튼에 대한 액션 리스너 추가
//      backButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            // 이전 단계로 돌아가는 동작 구현
//            openAdminWindow(null);
//            chatSearchFrame.dispose();
//         }
//      });
//
//      // 테이블과 삭제 버튼 패널을 프레임에 추가
//      chatSearchFrame.add(scrollPane, BorderLayout.CENTER);
//      chatSearchFrame.add(buttonPanel, BorderLayout.SOUTH);
//
//      chatSearchFrame.setVisible(true);
//
//   }
//// 대화내용 삭제하는 method
//   protected void deleteChat(JTable table) {
//      int selectedRow = table.getSelectedRow(); // 선택된 행의 인덱스 가져오기
//      if (selectedRow != -1) { // 선택된 행이 있는 경우
//         DefaultTableModel model = (DefaultTableModel) table.getModel();
//         String userId = (String) model.getValueAt(selectedRow, 0); // 선택된 행의 ID 가져오기
//         String input_time = (String) model.getValueAt(selectedRow, 2);
//
//         // 데이터베이스에서 사용자 삭제
//         try {
//            String sql = "DELETE FROM chat_messages WHERE ID = ? AND INPUT_TIME = ?;";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, userId);
//            pstmt.setString(2, input_time);
//            int rowsAffected = pstmt.executeUpdate();
//            if (rowsAffected > 0) {
//               model.removeRow(selectedRow); // 테이블 모델에서 해당 행 제거
//               JOptionPane.showMessageDialog(null, "User deleted successfully.", "Success",
//                     JOptionPane.INFORMATION_MESSAGE);
//            } else {
//               JOptionPane.showMessageDialog(null, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//         } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
//         }
//      } else { // 선택된 행이 없는 경우
//         JOptionPane.showMessageDialog(null, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
//      }
//
//   }
//    // 공지사항 화면 창 열기
//   protected void openNoticeWindow() {
//      adminFrame.dispose();
//      userNoticeFrame = new JFrame("Notice");
//      userNoticeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//      userNoticeFrame.setSize(600, 500);
//      userNoticeFrame.setLocationRelativeTo(null);
//
//      DefaultTableModel model = new DefaultTableModel();
//      model.addColumn("Contents");
//      JTable table = new JTable(model);
//
//      // 데이터베이스에서 공지사항 정보를 가져와서 텍스트 영역에 추가
//      try {
//         String sql = "SELECT CONTENTS FROM Notices";
//         PreparedStatement pstmt = conn.prepareStatement(sql);
//         ResultSet rs = pstmt.executeQuery();
//
//         while (rs.next()) {
//            String contents = rs.getString("Contents");
//            model.addRow(new Object[]{contents});
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//      userNoticeFrame.setVisible(true);
//      
//      JScrollPane scrollPane = new JScrollPane(table);
//
//      // 공지사항 등록화면
//      newNoticeField = new JTextField(20);
//      JButton addButton = new JButton("Add Notice");
//      JButton deleteButton = new JButton("Delete");
//      JButton backButton = new JButton("Back");
//      JPanel noticePanel = new JPanel(new FlowLayout());
//      noticePanel.add(newNoticeField);
//      noticePanel.add(addButton);
//      noticePanel.add(deleteButton); // 삭제 버튼 추가
//      noticePanel.add(backButton); // 이전 버튼 추가
//      
//      // 입력 필드와 버튼에 대한 이벤트 처리
//      addButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            noticesAdd();
//
//         }
//      });
//      
//      // 이전 버튼에 대한 액션 리스너 추가
//      backButton.addActionListener(new ActionListener() {
//          public void actionPerformed(ActionEvent e) {
//             // 이전 단계로 돌아가는 동작 구현
//             openAdminWindow(null); // username은 이전에 저장된 값
//             userNoticeFrame.dispose();
//          }
//       });
//      
//      // 삭제 버튼에 대한 액션 리스너 추가
//      deleteButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            deleteNotice(table);
//         }
//      });
//
//      // 테이블을 프레임에 추가
//      userNoticeFrame.add(scrollPane, BorderLayout.CENTER);
//      userNoticeFrame.add(noticePanel, BorderLayout.SOUTH);
//   }
//   
//   // 공지사항 삭제
//   protected void deleteNotice(JTable table) {
//      int selectedRow = table.getSelectedRow(); // 선택된 행의 인덱스 가져오기
//      if (selectedRow != -1) { // 선택된 행이 있는 경우
//         DefaultTableModel model = (DefaultTableModel) table.getModel();
//         String contents = (String) model.getValueAt(selectedRow, 0); // 선택된 행의 ID 가져오기
//
//         // 데이터베이스에서 사용자 삭제
//         try {
//            String sql = "DELETE FROM notices WHERE contents = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, contents);
//            int rowsAffected = pstmt.executeUpdate();
//            if (rowsAffected > 0) {
//               model.removeRow(selectedRow); // 테이블 모델에서 해당 행 제거
//               JOptionPane.showMessageDialog(null, "User deleted successfully.", "Success",
//                     JOptionPane.INFORMATION_MESSAGE);
//            } else {
//               JOptionPane.showMessageDialog(null, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//         } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
//         }
//      } else { // 선택된 행이 없는 경우
//         JOptionPane.showMessageDialog(null, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
//      }
//
//   }
//
//   // 공지사항 등록 method
//   protected void noticesAdd() {
//      String newContents = newNoticeField.getText();
//      if (newContents.length() < 1) {
//         JOptionPane.showMessageDialog(userNoticeFrame, "Please enter all fields.", "Error",
//               JOptionPane.ERROR_MESSAGE);
//         return;
//
//      }
//      try {
//         String sql = "INSERT INTO notices (contents) VALUES (?);";
//         // SQL에 데이터 입력되기 위해 쿼리문 작성.
//         pstmt = conn.prepareStatement(sql);
//         // 사용자가 입력한 값 가져오기
//
//         pstmt.setString(1, newContents);
//
//         pstmt.executeUpdate();
//
//         if (!newContents.isEmpty()) { // 추가:
//
//            JOptionPane.showMessageDialog(userNoticeFrame, "successful.", "Success",
//                  JOptionPane.INFORMATION_MESSAGE);
//         } else {
//            JOptionPane.showMessageDialog(userNoticeFrame, "Please enter all fields.", "Error",
//                  JOptionPane.ERROR_MESSAGE); // 수정: 모든 필드를 입력하라는 메시지
//         }
//
//      } catch (SQLException e1) {
//         e1.printStackTrace();
//      }
//
//   }
//   /*관리자 창을 닫고 사용자 정보를 보여주는 새로운 창을 열어, 데이터베이스에서 조회한
//    사용자 정보를 표시하는 역할  */
//
//   // 관리자 창에서 회원정보 볼수 있는 창 열기
//   private void openUserInfoWindow() {
//      adminFrame.dispose();
//      JFrame userInfoFrame = new JFrame("User Information");
//      userInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//      userInfoFrame.setSize(400, 300);
//      userInfoFrame.setLocationRelativeTo(null);
//
//      // 사용자 정보를 표시할 테이블 생성
//      JTable table = new JTable();
//      DefaultTableModel model = new DefaultTableModel();
//      model.addColumn("ID");
//      model.addColumn("Name");
//      model.addColumn("Phone");
//
//      // 데이터베이스에서 사용자 정보를 가져와 테이블에 추가
//      try {
//         String sql = "select * from users where ID not IN ('admin')";
//         PreparedStatement pstmt = conn.prepareStatement(sql);
//         ResultSet rs = pstmt.executeQuery();
//
//         while (rs.next()) {
//            String id = rs.getString("ID");
//            String name = rs.getString("NAME");
//            String phone = rs.getString("PHONE");
//
//            model.addRow(new Object[] { id, name, phone });
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//
//      table.setModel(model);
//
//      // 테이블을 스크롤 가능하도록 스크롤 패널에 추가
//      JScrollPane scrollPane = new JScrollPane(table);
//
//      // 삭제 버튼을 포함하는 패널 생성
//      JPanel buttonPanel = new JPanel();
//      JButton deleteButton = new JButton("Delete");
//      buttonPanel.add(deleteButton);
//
//      // 이전 버튼을 포함하는 패널 생성
//      JButton backButton = new JButton("Back");
//      buttonPanel.add(backButton);
//
//      // 삭제 버튼에 대한 액션 리스너 추가
//      deleteButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            deleteSelectedUser(table);
//         }
//      });
//
//      // 이전 버튼에 대한 액션 리스너 추가
//      backButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            // 이전 단계로 돌아가는 동작 구현
//            openAdminWindow(null); // username은 이전에 저장된 값
//            userInfoFrame.dispose();
//         }
//      });
//
//      // 테이블과 삭제 버튼 패널을 프레임에 추가
//      userInfoFrame.add(scrollPane, BorderLayout.CENTER);
//      userInfoFrame.add(buttonPanel, BorderLayout.SOUTH);
//
//      userInfoFrame.setVisible(true);
//
//   }
//
//   // 선택한 user 정보 삭제
//   //회원정보 삭제 기능
//   protected void deleteSelectedUser(JTable table) {
//      int selectedRow = table.getSelectedRow(); // 선택된 행의 인덱스 가져오기
//      if (selectedRow != -1) { // 선택된 행이 있는 경우
//         DefaultTableModel model = (DefaultTableModel) table.getModel();
//         String userId = (String) model.getValueAt(selectedRow, 0); // 선택된 행의 ID 가져오기
//
//         // 데이터베이스에서 사용자 삭제
//         try {
//            String sql = "DELETE FROM USERS WHERE ID = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, userId);
//            int rowsAffected = pstmt.executeUpdate();
//            if (rowsAffected > 0) {
//               model.removeRow(selectedRow); // 테이블 모델에서 해당 행 제거
//               JOptionPane.showMessageDialog(null, "User deleted successfully.", "Success",
//                     JOptionPane.INFORMATION_MESSAGE);
//            } else {
//               JOptionPane.showMessageDialog(null, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//         } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
//         }
//      } else { // 선택된 행이 없는 경우
//         JOptionPane.showMessageDialog(null, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
//      }
//
//   }
//
//   // 채팅 창 열기
//   // 사용자가 로그인한 후 채팅 창을 여는 기능
//   private void openChatWindow(String username) {
//      loginFrame.dispose();
//      // 채팅 패널 초기화
//      JPanel chatPanel = new JPanel(new BorderLayout());
//      inputField = new JTextField();
//      chatArea = new JTextArea();
//      chatArea.setEditable(false);
//      JScrollPane scrollPane = new JScrollPane(chatArea);
//      JButton sendButton = new JButton("Send");
//      chatPanel.add(scrollPane, BorderLayout.CENTER);
//      JPanel bottomPanel = new JPanel(new BorderLayout());
//      bottomPanel.add(inputField, BorderLayout.CENTER);
//      bottomPanel.add(sendButton, BorderLayout.EAST);
//      chatPanel.add(bottomPanel, BorderLayout.SOUTH);
//      
//      
//      // 공지사항 패널 초기화
//      JPanel noticePanel = new JPanel();
//      noticePanel.setLayout(new BorderLayout());
//      noticeArea = new JTextArea("공지사항 공간\n");
//      noticeArea.setEditable(false);
//      JScrollPane noticeScrollPane = new JScrollPane(noticeArea);
//      noticePanel.add(noticeScrollPane, BorderLayout.CENTER);
//      
//      shownotice();
//
//      // 이벤트 리스너 설정
//      ActionListener sendMessageAction = new ActionListener() {
//         public void actionPerformed(ActionEvent e) {
//            sendMessage();
//         }
//      };
//      sendButton.addActionListener(sendMessageAction);
//      inputField.addActionListener(sendMessageAction);
//
//      // 채팅 창과 공지사항 창 분할하여 보여주기
//      JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, chatPanel, noticePanel);
//      splitPane.setResizeWeight(0.8);
//      // 메인 프레임 설정
//      mainFrame = new JFrame("Main");
//      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      mainFrame.setSize(800, 600);
//      mainFrame.setLocationRelativeTo(null);
//      mainFrame.getContentPane().add(splitPane);
//      mainFrame.setVisible(true);
//
//      // 소켓 연결 초기화
//      try {
//         // 서버에 소켓 연결을 시도하고 입력 및 출력 스트림을 생성
//         socket = new Socket("192.168.0.178", 9002);
//        //socket = new Socket("localhost", 9002);
//         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         writer = new PrintWriter(socket.getOutputStream(), true);
//         writer.println(usernameField.getText());   //입력받은 로그인 아이디를 메세지로 보냄 ( Thread 명칭 생성 )
//         
//         
//      } catch (IOException e) {
//         e.printStackTrace(); // 소켓 연결 실패 시 에러 메시지 출력
//      }
//
//      // 채팅 메시지 수신을 위한 스레드 시작
//      new Thread(new ReceiverThread()).start();
//      // 별도의 스레드에서 메시지 수신 처리를 위해 ReceiverThread 실행
//
//   }
//   //사용자가 입력한 메시지를 처리하는 메서드
//
//   private void sendMessage() {
//         String message = inputField.getText();
//         if (!message.isEmpty()) {
//            if (isProfanity(message)) { // 욕설 감지
//                 chatArea.append("# 욕설을 사용하셨습니다. 욕설은 금지되어 있습니다.\n");
//                 Timer timer = new Timer(2000, new ActionListener() { // 타이머 설정
//                     @Override
//                     public void actionPerformed(ActionEvent e) {
//                        String message ="님은 퇴장당하셨습니다.";
//                        writer.println(message);
//                        inputField.setText("");
//                         mainFrame.dispose(); // 일정 시간 후 창 닫기
//                     }
//                 });
//                 timer.setRepeats(false); // 한 번만 실행되도록 설정
//                 timer.start(); // 타이머 시작
//             } else {
//                 writer.println(message);
//                 inputField.setText("");
//             }
//         }
//      }
//   //비속어 리스크
//   private boolean isProfanity(String message) {
//       String[] profanityWords = {"씨발", "병신", "엄마", "아빠"};
//       for (String profanity : profanityWords) {
//           if (message.contains(profanity)) {
//               return true;
//           }
//       }
//       return false;
//   }
//   // 채팅창 화면에서 공지사항 보이게 하는 method
//   
//   //최근 공지사항을 조회하여 인터페이스에 표시하는 기능 (?)
//   private void shownotice() {
//      try {
//         String sql = "SELECT CONTENTS FROM Notices\r\n"
//               + "order by input_time desc limit 3";
//         PreparedStatement pstmt = conn.prepareStatement(sql);
//         ResultSet rs = pstmt.executeQuery();
//
//         while (rs.next()) {
//            String noticeContent = rs.getString("CONTENTS");
//            noticeArea.append(noticeContent + "\n"); // 각 공지사항을 한 줄씩 추가
//         }
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//   }
//
//   
//   
//// 메세지를 읽어오는 역할 
//// -> 별도의 스레드에서 실행되어야 하며, 메세지를 읽어와서 채팅 영역에 추가하는 역할
//   private class ReceiverThread implements Runnable {
//      public void run() {
//         try {
//            String message;
//            while ((message = reader.readLine()) != null) {
//               System.out.println(message);
//
//               // 처음 Thread 활성화 됨 ( 들어온 사람)
//               if (message.startsWith("newUser#")) {
//                  chatArea.append(message.substring(7) + "\n");
//               } else {
//                  String[] arr = message.split(">");
//
//                  // 귓속말(대화 내용)
//                  if (arr[1].startsWith("/w")) {
//                     System.out.println("arr[1]: " + arr[1]);
//                     // arr[1]: /w 수신자 내용
//                     // split으로 배열 3개가 분할.
//                     String sendUser = arr[1].split(" ")[1]; // 받는 대상 정의
//                     System.out.println("sendUser: " + sendUser);
//                     if (sendUser.equals(id) || arr[0].equals(id)) { // arr[0]: 보내는 대상 / sendUser: 받는 대상
//                        System.out.println("귓 대상");
//                        System.out.println(id + " / arr[0]: " + arr[0] + " / sendUser: " + sendUser
//                              + " / arr[1]: " + arr[1]);
//                        chatArea.append(arr[0] + ">" + arr[1].split(" ")[2] + "\n");
//                     }
//                  } else if (arr[1].startsWith("/kick")) {
//                     String targetUser = arr[1].split(" ")[1]; // 추방 대상 정의
//                     if (targetUser.equals(id)) { // 추방 대상과 userId가 아닌 경우
//                        mainFrame.dispose(); //채팅창 닫기
//                     } 
//                  }
//                  else {
//                     System.out.println("good: " + message);
//                     chatArea.append(message + "\n");
//                  }
//               }
//            }
//         } catch (IOException e) {
//            e.printStackTrace();
//         }
//      }
//   }
//
//   public static void main(String[] args) {
//      SwingUtilities.invokeLater(ChatClientGUI::new);
//   }
//}