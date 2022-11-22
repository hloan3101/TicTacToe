package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Board;
import game.Mark;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TwoPlayerMode extends JFrame {

	private JPanel contentPane;
	private JTextField textScoreX;
	private JTextField textScoreO;
	private static Board board = new Board();
	private int scoreX = 0, scoreO = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoPlayerMode frame = new TwoPlayerMode();
					frame.setLocationByPlatform(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public void checkWin(int row, int colunm) {
		boolean check = board.placeMark(row, colunm);
		if (check) {
			if (board.getWinningMark() == Mark.O) {
				oWin();
				return;

			} else if (board.getWinningMark() == Mark.X) {
				xWin();
				return;
			}

		}
		if (board.isGameOver()) {
			draw();
		}
	}

	public void oWin() {
		OWins frame = new OWins();
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		scoreO++;
		textScoreO.setText(String.valueOf(scoreO));
	}

	public void xWin() {
		XWins frame = new XWins();
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		scoreX++;
		textScoreX.setText(String.valueOf(scoreX));
	}

	public void draw() {
		Draw frame = new Draw();
		frame.setLocationByPlatform(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TwoPlayerMode() {

		setTitle("Tic - Tac - Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Two Layer Mode");
		lblNewLabel.setForeground(new Color(0, 102, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(259, 40, 338, 49);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(94, 133, 222, 354);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Player 1");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(54, 31, 89, 47);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(150, 39, 32, 30);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Player 2");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(54, 88, 89, 47);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("O");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(150, 96, 32, 30);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("Score");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(87, 157, 66, 24);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_2_2 = new JLabel("X");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(54, 201, 32, 30);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("O");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(54, 250, 32, 30);
		panel.add(lblNewLabel_2_1_1);

		textScoreX = new JTextField();
		textScoreX.setText("0");
		textScoreX.setHorizontalAlignment(SwingConstants.CENTER);
		textScoreX.setFont(new Font("Arial", Font.PLAIN, 20));
		textScoreX.setColumns(10);
		textScoreX.setBounds(87, 205, 96, 24);
		panel.add(textScoreX);

		textScoreO = new JTextField();
		textScoreO.setText("0");
		textScoreO.setHorizontalAlignment(SwingConstants.CENTER);
		textScoreO.setFont(new Font("Arial", Font.PLAIN, 20));
		textScoreO.setColumns(10);
		textScoreO.setBounds(87, 250, 96, 24);
		panel.add(textScoreO);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setBounds(342, 133, 367, 354);
		contentPane.add(panel_1);

		JButton btnCheck1 = new JButton("");
		btnCheck1.setFocusPainted(false);
		btnCheck1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(0, 0)) {
					if (board.isCrossTurn()) {
						btnCheck1.setText("X");
					} else {
						btnCheck1.setText("O");
					}
					checkWin(0, 0);
				}

			}
		});
		btnCheck1.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck1.setBackground(Color.WHITE);
		btnCheck1.setBounds(10, 10, 114, 105);
		panel_1.add(btnCheck1);

		JButton btnCheck2 = new JButton("");
		btnCheck2.setFocusPainted(false);
		btnCheck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(0, 1)) {
					if (board.isCrossTurn()) {
						btnCheck2.setText("X");
					} else {
						btnCheck2.setText("O");
					}
					checkWin(0, 1);
				}

			}
		});
		btnCheck2.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck2.setBackground(Color.WHITE);
		btnCheck2.setBounds(134, 10, 107, 105);
		panel_1.add(btnCheck2);

		JButton btnCheck3 = new JButton("");
		btnCheck3.setFocusPainted(false);
		btnCheck3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(0, 2)) {
					if (board.isCrossTurn()) {
						btnCheck3.setText("X");
					} else {
						btnCheck3.setText("O");
					}
					checkWin(0, 2);
				}

			}
		});
		btnCheck3.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck3.setBackground(Color.WHITE);
		btnCheck3.setBounds(251, 10, 107, 105);
		panel_1.add(btnCheck3);

		JButton btnCheck4 = new JButton("");
		btnCheck4.setFocusPainted(false);
		btnCheck4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(1, 0)) {
					if (board.isCrossTurn()) {
						btnCheck4.setText("X");
					} else {
						btnCheck4.setText("O");
					}

					checkWin(1, 0);
				}

			}
		});
		btnCheck4.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck4.setBackground(Color.WHITE);
		btnCheck4.setBounds(10, 125, 114, 105);
		panel_1.add(btnCheck4);

		JButton btnCheck7 = new JButton("");
		btnCheck7.setFocusPainted(false);
		btnCheck7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(2, 0)) {
					if (board.isCrossTurn()) {
						btnCheck7.setText("X");
					} else {
						btnCheck7.setText("O");
					}
					checkWin(2, 0);
				}

			}
		});
		btnCheck7.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck7.setBackground(Color.WHITE);
		btnCheck7.setBounds(10, 240, 114, 105);
		panel_1.add(btnCheck7);

		JButton btnCheck8 = new JButton("");
		btnCheck8.setFocusPainted(false);
		btnCheck8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(2, 1)) {
					if (board.isCrossTurn()) {
						btnCheck8.setText("X");
					} else {
						btnCheck8.setText("O");
					}

					checkWin(2, 1);
				}

			}
		});
		btnCheck8.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck8.setBackground(Color.WHITE);
		btnCheck8.setBounds(134, 240, 107, 105);
		panel_1.add(btnCheck8);

		JButton btnCheck5 = new JButton("");
		btnCheck5.setFocusPainted(false);
		btnCheck5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(1, 1)) {
					if (board.isCrossTurn()) {
						btnCheck5.setText("X");
					} else {
						btnCheck5.setText("O");
					}
					checkWin(1, 1);
				}

			}
		});
		btnCheck5.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck5.setBackground(Color.WHITE);
		btnCheck5.setBounds(134, 125, 107, 105);
		panel_1.add(btnCheck5);

		JButton btnCheck6 = new JButton("");
		btnCheck6.setFocusPainted(false);
		btnCheck6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(1, 2)) {
					if (board.isCrossTurn()) {
						btnCheck6.setText("X");
					} else {
						btnCheck6.setText("O");
					}

					checkWin(1, 2);
				}

			}
		});
		btnCheck6.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck6.setBackground(Color.WHITE);
		btnCheck6.setBounds(251, 125, 107, 105);
		panel_1.add(btnCheck6);

		JButton btnCheck9 = new JButton("");
		btnCheck9.setFocusPainted(false);
		btnCheck9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!board.isTileMarked(2, 2)) {
					if (board.isCrossTurn()) {
						btnCheck9.setText("X");
					} else {
						btnCheck9.setText("O");
					}

					checkWin(2, 2);
				}

			}
		});
		btnCheck9.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck9.setBackground(Color.WHITE);
		btnCheck9.setBounds(251, 240, 107, 105);
		panel_1.add(btnCheck9);

		JButton btnPlayAgain = new JButton("Play again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheck1.setText("");
				btnCheck2.setText("");
				btnCheck3.setText("");
				btnCheck4.setText("");
				btnCheck5.setText("");
				btnCheck6.setText("");
				btnCheck7.setText("");
				btnCheck8.setText("");
				btnCheck9.setText("");
				board = new Board();
			}
		});
		btnPlayAgain.setVerifyInputWhenFocusTarget(false);
		btnPlayAgain.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlayAgain.setHideActionText(true);
		btnPlayAgain.setForeground(Color.WHITE);
		btnPlayAgain.setFont(new Font("Arial", Font.BOLD, 20));
		btnPlayAgain.setFocusPainted(false);
		btnPlayAgain.setDefaultCapable(false);
		btnPlayAgain.setBackground(new Color(60, 179, 113));
		btnPlayAgain.setBounds(132, 522, 169, 47);
		contentPane.add(btnPlayAgain);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheck1.setText("");
				btnCheck2.setText("");
				btnCheck3.setText("");
				btnCheck4.setText("");
				btnCheck5.setText("");
				btnCheck6.setText("");
				btnCheck7.setText("");
				btnCheck8.setText("");
				btnCheck9.setText("");
				board = new Board();
				scoreX = 0;
				scoreO = 0;
				textScoreO.setText("0");
				textScoreX.setText("0");
			}
		});
		btnFinish.setVerifyInputWhenFocusTarget(false);
		btnFinish.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFinish.setHideActionText(true);
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("Arial", Font.BOLD, 20));
		btnFinish.setFocusPainted(false);
		btnFinish.setDefaultCapable(false);
		btnFinish.setBackground(new Color(60, 179, 113));
		btnFinish.setBounds(345, 522, 169, 47);
		contentPane.add(btnFinish);

		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setLocationByPlatform(true);
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
				board = new Board();
				TwoPlayerMode.this.dispose();

			}
		});
		btnBackToMenu.setVerifyInputWhenFocusTarget(false);
		btnBackToMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBackToMenu.setHideActionText(true);
		btnBackToMenu.setForeground(Color.WHITE);
		btnBackToMenu.setFont(new Font("Arial", Font.BOLD, 20));
		btnBackToMenu.setFocusPainted(false);
		btnBackToMenu.setDefaultCapable(false);
		btnBackToMenu.setBackground(new Color(60, 179, 113));
		btnBackToMenu.setBounds(540, 522, 169, 47);
		contentPane.add(btnBackToMenu);

	}

}
