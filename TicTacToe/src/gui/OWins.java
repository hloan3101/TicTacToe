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

public class OWins extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OWins frame = new OWins();
					frame.setLocationRelativeTo(null);
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
	public OWins() {
		setTitle("Tic - Tac- Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayerOWin = new JLabel("Player O Win");
		lblPlayerOWin.setForeground(new Color(0, 102, 0));
		lblPlayerOWin.setFont(new Font("Arial", Font.BOLD, 40));
		lblPlayerOWin.setBounds(119, 42, 260, 59);
		contentPane.add(lblPlayerOWin);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OWins.this.setVisible(false);
			}
		});
		btnOk.setVerifyInputWhenFocusTarget(false);
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Arial", Font.BOLD, 30));
		btnOk.setFocusPainted(false);
		btnOk.setDefaultCapable(false);
		btnOk.setBounds(new Rectangle(2, 2, 0, 0));
		btnOk.setBackground(new Color(60, 179, 113));
		btnOk.setBounds(178, 137, 138, 47);
		contentPane.add(btnOk);
	}
}
