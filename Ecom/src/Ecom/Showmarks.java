package Ecom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Showmarks {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Showmarks window = new Showmarks();
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
	public Showmarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 643, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Roll");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(89, 72, 101, 31);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(200, 79, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lb1 = new JLabel("Name");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb1.setBounds(89, 183, 229, 31);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb2.setBounds(89, 245, 176, 31);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r=t1.getText();
				int roll=Integer.parseInt(r);
			    try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","mrec");
					 String q="Select name,marks from reg where roll=?";
					    PreparedStatement ps=con.prepareStatement(q);
					    ps.setInt(1, roll);
					    ResultSet rs=ps.executeQuery();
					    rs.next();
					    lb1.setText("Name:"+rs.getString(1));
					    lb2.setText("Marks:"+rs.getString(2));
					    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(200, 123, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
