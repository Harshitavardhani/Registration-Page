package Ecom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registrationpage {

	private JFrame frame;
	private JTextField n1;
	private JTextField r1;
	private JTextField m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrationpage window = new registrationpage();
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
	public registrationpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(238, 11, 164, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(67, 113, 74, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Roll");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(67, 167, 97, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Marks");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(67, 222, 74, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		n1 = new JTextField();
		n1.setBounds(140, 121, 110, 20);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		r1 = new JTextField();
		r1.setBounds(140, 175, 110, 20);
		frame.getContentPane().add(r1);
		r1.setColumns(10);
		
		m1 = new JTextField();
		m1.setBounds(140, 226, 110, 20);
		frame.getContentPane().add(m1);
		m1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=n1.getText(); 
				
				String r=r1.getText();
				int roll=Integer.parseInt(r);
				
				String m=m1.getText();
				int marks=Integer.parseInt(m);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","mrec");
					String q="Insert into reg values('"+name+"','"+roll+"','"+marks+"')";
					Statement Sta=con.createStatement();
					Sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			      
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(238, 298, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
