import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class E_Commerce_Layout {

/**
 * Main application: frame
 */
	private JFrame frame;
	private CardLayout frameContentPaneLayout;
	
/**
 * frame -> frame_Card0_Content
 */
	private JPanel frame_Card0_Content;
	private JPanel scrollableItems;
	private JList list;
	private JScrollBar scrollBar;	 
	 
/**
 * frame -> frame_Card1_Login
 */
	private JPanel frame_Card1_Login;
	private JButton btn_frame_Card1_Login_return;
	
/**
 * frame -> frame_Card1_Login->sub_Login Panel
 */
	private JPanel sub_Login;
	private GridBagConstraints gbc_Sub_Login;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JButton btnLogin;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	
/**
 * frame -> frame_Card0_Content -> header Panel
 */
	private JPanel header;
	private JLabel lblLogo;
	private JTextField txtSearchBar;
	private JButton btnNewButton_search;
	
/**
 * frame -> frame_Card0_Content -> header -> subHeader Panel
 */
	private JPanel subHeader;
	private JLabel lblAccountInformation;
	private JButton btnShoppingCart;
	
/**
 * frame -> sideBar Panel
 */
	private JPanel sideBar;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	
/**
 * frame -> bodyContent Panel
 */
	private JPanel bodyContent;
	private CardLayout bodyContentLayout;
	
/**
 * frame -> bodyContent -> user Panel
 */
	private JPanel user;
	
/**
 * frame -> bodyContent -> guest Panel
 */
	private JPanel guest;
	
/**
 * frame -> bodyContent -> admin Panel
 */
	private JPanel admin;
	
	

/**
 * Launch the application.
 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					E_Commerce_Layout window = new E_Commerce_Layout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public E_Commerce_Layout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
	/*
	 * Main Application: frame
	 */
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameContentPaneLayout = new CardLayout();
		frame.getContentPane().setLayout(frameContentPaneLayout);

	/*
	 * frame -> frame_Card0_Content Panel
	 */
		frame_Card0_Content = new JPanel();
		frame_Card0_Content.setLayout(new BorderLayout(5,5));
		frame.getContentPane().add(frame_Card0_Content, "Card0_Content");
		
	/*
	 * frame -> frame_Card0_Content -> header Panel
	 */
		header = new JPanel();
		header.setPreferredSize(new Dimension(1024, 100));
		header.setBorder(new EmptyBorder(0,0,50,0));
		frame_Card0_Content.add(header, BorderLayout.PAGE_START);
		header.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		lblLogo = new JLabel("LOGO");
		lblLogo.setBorder(new EmptyBorder(0,25,0,25));
		lblLogo.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bodyContentLayout.next(bodyContent);
			}
		});
		header.add(lblLogo);

		txtSearchBar = new JTextField();
		txtSearchBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtSearchBar.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtSearchBar.setText("Search Bar...");
			}
		});
		txtSearchBar.setPreferredSize(new Dimension(300, 40));
		txtSearchBar.setText("Search Bar...");
		header.add(txtSearchBar);
		txtSearchBar.setColumns(30);

		btnNewButton_search = new JButton("...");
		btnNewButton_search.setPreferredSize(new Dimension(25, 40));
		btnNewButton_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		header.add(btnNewButton_search);

	/*
	 * frame -> frame_Card0_Content -> header -> subHeader Panel
	 */
		subHeader = new JPanel();
		subHeader.setPreferredSize(new Dimension(400, 80));
		header.add(subHeader);
		subHeader.setLayout(null);

		lblAccountInformation = new JLabel("Account Information");
		lblAccountInformation.setPreferredSize(new Dimension(120,30));
		lblAccountInformation.setBounds(35,0,lblAccountInformation.getPreferredSize().width,lblAccountInformation.getPreferredSize().height);
		subHeader.add(lblAccountInformation);

		btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(120,30));
		btnLogin.setBounds(280,0,btnLogin.getPreferredSize().width,btnLogin.getPreferredSize().height);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameContentPaneLayout.show(frame.getContentPane(), "Card1_Login");
			}
		});
		subHeader.add(btnLogin);
		
		btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.setPreferredSize(new Dimension(120,30));
		btnShoppingCart.setBounds(280,50,btnShoppingCart.getPreferredSize().width,btnShoppingCart.getPreferredSize().height);
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		subHeader.add(btnShoppingCart);

	/*
	 * frame -> frame_Card0_Content -> sideBar Panel
	 */
		sideBar = new JPanel();
		sideBar.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		sideBar.setPreferredSize(new Dimension(160, 585));
		sideBar.setBorder(new LineBorder(Color.BLACK));
		frame_Card0_Content.add(sideBar, BorderLayout.LINE_START);
		
		btnNewButton_1 = new JButton("Best Sellers");
		btnNewButton_1.setPreferredSize(new Dimension(144, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		sideBar.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Recently Added");
		btnNewButton_2.setPreferredSize(new Dimension(144, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		sideBar.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Daily Deals");
		btnNewButton_3.setPreferredSize(new Dimension(144, 25));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		sideBar.add(btnNewButton_3);
		
	/*
	 * frame -> frame_Card0_Content -> bodyContent Panel
	 */
		bodyContent = new JPanel();
		bodyContent.setPreferredSize(new Dimension(800, 585));
		bodyContent.setBorder(new LineBorder(Color.BLACK));
		bodyContentLayout = new CardLayout();
		bodyContent.setLayout(bodyContentLayout);
		frame_Card0_Content.add(bodyContent, BorderLayout.CENTER);

	/*
	 * frame -> frame_Card0_Content -> bodyContent -> scrollableItems Panel
	 */
		scrollableItems = new JPanel();
		scrollableItems.setPreferredSize(new Dimension(850, 535));
		scrollableItems.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		bodyContent.add(scrollableItems);

		list = new JList();
		list.setPreferredSize(new Dimension(765, 535));
		scrollableItems.add(list);

		scrollBar = new JScrollBar();
		scrollBar.setPreferredSize(new Dimension(15, 530));
		scrollableItems.add(scrollBar);

	/*
	 * frame -> frame_Card0_Content -> bodyContent -> user Panel
	 */
		user = new JPanel();
		bodyContent.add(user);

	/*
	 * frame -> frame_Card0_Content -> bodyContent -> guest Panel
	 */		
		guest = new JPanel();
		bodyContent.add(guest);

	/*
	 * frame -> frame_Card0_Content -> bodyContent -> admin Panel
	 */
		admin = new JPanel();
		bodyContent.add(admin);
		
	/*
	 * frame -> frame_Card1_Login Panel
	 */
		frame_Card1_Login = new JPanel();
		frame.getContentPane().add(frame_Card1_Login, "Card1_Login");
		frame_Card1_Login.setLayout(new BorderLayout(5,5));
		
		btn_frame_Card1_Login_return = new JButton("Return");
		btn_frame_Card1_Login_return.setFont(new Font("Arial",Font.PLAIN,20));
		frame_Card1_Login.add(btn_frame_Card1_Login_return, BorderLayout.PAGE_START);
		btn_frame_Card1_Login_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameContentPaneLayout.show(frame.getContentPane(), "Card0_Content");
			}
		});
		
	/*
	 * frame -> frame_Card1_Login -> sub_Login Panel
	 */
		sub_Login = new JPanel();
		frame_Card1_Login.add(sub_Login);
		sub_Login.setLayout(new GridBagLayout());
		
		gbc_Sub_Login = new GridBagConstraints();
		gbc_Sub_Login.insets = new Insets(0,0,5,0);
		gbc_Sub_Login.ipady = 20;
		
		gbc_Sub_Login.gridx = 0;
		gbc_Sub_Login.gridy = 0;
		gbc_Sub_Login.weightx = 1;
		sub_Login.add(new JLabel(""), gbc_Sub_Login);
		
		gbc_Sub_Login.gridx = 2;
		gbc_Sub_Login.gridy = 5;
		gbc_Sub_Login.weightx = 1;
		sub_Login.add(new JLabel(""), gbc_Sub_Login);
		
		textField_Username = new JTextField();
		textField_Username.setColumns(15);
		textField_Username.setFont(new Font("Arial",Font.PLAIN,20));
		textField_Username.setHorizontalAlignment(JTextField.CENTER);
		gbc_Sub_Login.gridx = 1;
		gbc_Sub_Login.gridy = 1;
		gbc_Sub_Login.weightx = 1;
		sub_Login.add(textField_Username, gbc_Sub_Login);
		
		textField_Password = new JTextField();
		textField_Password.setColumns(15);
		textField_Password.setFont(new Font("Arial",Font.PLAIN,20));
		textField_Password.setHorizontalAlignment(JTextField.CENTER);
		gbc_Sub_Login.gridx = 1;
		gbc_Sub_Login.gridy = 2;
		gbc_Sub_Login.weightx = 1;
		sub_Login.add(textField_Password, gbc_Sub_Login);
		
		btnNewButton_4 = new JButton("Login");
		btnNewButton_4.setPreferredSize(new Dimension(175, 25));
		btnNewButton_4.setFont(new Font("Arial",Font.PLAIN,20));
		gbc_Sub_Login.gridx = 1;
		gbc_Sub_Login.gridy = 3;
		gbc_Sub_Login.weightx = 1;
		gbc_Sub_Login.ipady = 10;
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});	
		sub_Login.add(btnNewButton_4, gbc_Sub_Login);
		
		btnNewButton_5 = new JButton("Create Account");
		btnNewButton_5.setPreferredSize(new Dimension(175, 25));
		btnNewButton_5.setFont(new Font("Arial",Font.PLAIN,20));
		gbc_Sub_Login.gridx = 1;
		gbc_Sub_Login.gridy = 4;
		gbc_Sub_Login.weightx = 0.5;
		gbc_Sub_Login.ipady = 10;
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});	
		sub_Login.add(btnNewButton_5, gbc_Sub_Login);

	}
}
