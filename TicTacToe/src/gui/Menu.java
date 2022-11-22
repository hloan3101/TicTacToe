package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnTwoPlayer;
	private JButton btnOnePlayer;
	private JButton btnExit;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setLocationByPlatform(true);
		setForeground(Color.WHITE);
		setTitle("Tic- Tac-Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 544);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnTwoPlayer = new JButton("Two Player");
		btnTwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoPlayerMode frame = new TwoPlayerMode();
				frame.setLocationByPlatform(true);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				Menu.this.setVisible(false);
			}
		});
		btnTwoPlayer.setForeground(Color.WHITE);
		btnTwoPlayer.setFocusPainted(false);
		btnTwoPlayer.setBounds(new Rectangle(2, 2, 0, 0));
		btnTwoPlayer.setBackground(new Color(60, 179, 113));
		btnTwoPlayer.setDefaultCapable(false);
		btnTwoPlayer.setVerifyInputWhenFocusTarget(false);
		btnTwoPlayer.setFont(new Font("Arial", Font.BOLD, 30));
		btnTwoPlayer.setBounds(279, 262, 243, 47);
		contentPane.add(btnTwoPlayer);
		
		btnOnePlayer = new JButton("One Player");
		btnOnePlayer.setForeground(Color.WHITE);
		btnOnePlayer.setFocusPainted(false);
		btnOnePlayer.setHideActionText(true);
		btnOnePlayer.setDefaultCapable(false);
		btnOnePlayer.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOnePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseLevel fram = new ChooseLevel();
				fram.setLocationByPlatform(true);
				fram.setLocationRelativeTo(null);
				fram.setVisible(true);
				Menu.this.setVisible(false);
			}
		});
		btnOnePlayer.setVerifyInputWhenFocusTarget(false);
		btnOnePlayer.setFont(new Font("Arial", Font.BOLD, 30));
		btnOnePlayer.setBounds(new Rectangle(2, 2, 0, 0));
		btnOnePlayer.setBackground(new Color(60, 179, 113));
		btnOnePlayer.setBounds(279, 177, 243, 47);
		contentPane.add(btnOnePlayer);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setFocusPainted(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseExit frame =  new ChooseExit();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnExit.setVerifyInputWhenFocusTarget(false);
		btnExit.setFont(new Font("Arial", Font.BOLD, 30));
		btnExit.setDefaultCapable(false);
		btnExit.setBounds(new Rectangle(2, 2, 0, 0));
		btnExit.setBackground(new Color(60, 179, 113));
		btnExit.setBounds(279, 351, 243, 47);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("Tic - Tac - Toe");
		lblNewLabel.setForeground(new Color(0, 102, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblNewLabel.setBounds(220, 82, 355, 47);
		contentPane.add(lblNewLabel);
	}
}
