package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseExit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseExit frame = new ChooseExit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChooseExit() {
		setTitle("Tic- Tac- Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouWant = new JLabel("Do you want to exit the game?");
		lblDoYouWant.setForeground(new Color(0, 102, 0));
		lblDoYouWant.setFont(new Font("Arial", Font.BOLD, 25));
		lblDoYouWant.setBounds(30, 51, 380, 59);
		contentPane.add(lblDoYouWant);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnYes.setVerifyInputWhenFocusTarget(false);
		btnYes.setForeground(Color.WHITE);
		btnYes.setFont(new Font("Arial", Font.BOLD, 25));
		btnYes.setFocusPainted(false);
		btnYes.setDefaultCapable(false);
		btnYes.setBounds(new Rectangle(2, 2, 0, 0));
		btnYes.setBackground(new Color(60, 179, 113));
		btnYes.setBounds(251, 152, 108, 47);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseExit.this.setVisible(false);
			}
		});
		btnNo.setVerifyInputWhenFocusTarget(false);
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Arial", Font.BOLD, 25));
		btnNo.setFocusPainted(false);
		btnNo.setDefaultCapable(false);
		btnNo.setBounds(new Rectangle(2, 2, 0, 0));
		btnNo.setBackground(new Color(60, 179, 113));
		btnNo.setBounds(55, 152, 108, 47);
		contentPane.add(btnNo);
	}
}
