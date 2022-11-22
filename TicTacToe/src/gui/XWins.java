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

public class XWins extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XWins frame = new XWins();
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
	public XWins() {
		setTitle("Tic- Tac- Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayerXWin = new JLabel("Player X Win");
		lblPlayerXWin.setForeground(new Color(0, 102, 0));
		lblPlayerXWin.setFont(new Font("Arial", Font.BOLD, 40));
		lblPlayerXWin.setBounds(112, 51, 243, 59);
		contentPane.add(lblPlayerXWin);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XWins.this.setVisible(false);
			}
		});
		btnOk.setVerifyInputWhenFocusTarget(false);
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Arial", Font.BOLD, 30));
		btnOk.setFocusPainted(false);
		btnOk.setDefaultCapable(false);
		btnOk.setBounds(new Rectangle(2, 2, 0, 0));
		btnOk.setBackground(new Color(60, 179, 113));
		btnOk.setBounds(174, 148, 128, 47);
		contentPane.add(btnOk);
	}
}
