package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ai.MiniMaxImproved;
import ai.Minimax;
import game.Board;
import game.Mark;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OnePlayerMode extends JFrame {

	private JPanel contentPane;
	private JTextField textScoreX;
	private JTextField textScoreO;
	private boolean level; // Easy: true Difficult: false
	private static Board board = new Board();
	private boolean check = false;
	private int scoreX = 0, scoreO = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnePlayerMode frame = new OnePlayerMode();
					frame.setLocationByPlatform(true);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setLevel(boolean level) {
		this.level = level;
	}

	public void checkWin(int row, int colunm) {
		boolean checkMark = board.placeMark(row, colunm);
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++)
				System.out.print(board.getMarkAt(i, j) + " ");
			System.out.println("");
		}
		System.out.println("-------");
		if (checkMark) {
			if (board.getWinningMark() == Mark.O) {
				oWin();
				check = true;

			} else if (board.getWinningMark() == Mark.X) {
				xWin();
				check = true;
			}

		} else if (board.isGameOver()) {
			draw();
			check = true;
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
	public OnePlayerMode() {
		setBackground(Color.WHITE);
		setTitle("Tic - Tac - Toe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 668);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("One Layer Mode");
		lblNewLabel.setForeground(new Color(0, 102, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(258, 33, 311, 49);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setInheritsPopupMenu(true);
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setBounds(330, 128, 367, 354);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnCheck1 = new JButton("");
		btnCheck1.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck1.setBackground(Color.WHITE);
		btnCheck1.setBounds(10, 10, 114, 105);
		panel_1.add(btnCheck1);

		JButton btnCheck2 = new JButton("");
		btnCheck2.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck2.setBackground(Color.WHITE);
		btnCheck2.setBounds(134, 10, 107, 105);
		panel_1.add(btnCheck2);

		JButton btnCheck3 = new JButton("");
		btnCheck3.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck3.setBackground(Color.WHITE);
		btnCheck3.setBounds(251, 10, 107, 105);
		panel_1.add(btnCheck3);

		JButton btnCheck4 = new JButton("");
		btnCheck4.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck4.setBackground(Color.WHITE);
		btnCheck4.setBounds(10, 125, 114, 105);
		panel_1.add(btnCheck4);

		JButton btnCheck7 = new JButton("");
		btnCheck7.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck7.setBackground(Color.WHITE);
		btnCheck7.setBounds(10, 240, 114, 105);
		panel_1.add(btnCheck7);

		JButton btnCheck8 = new JButton("");
		btnCheck8.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck8.setBackground(Color.WHITE);
		btnCheck8.setBounds(134, 240, 107, 105);
		panel_1.add(btnCheck8);

		JButton btnCheck5 = new JButton("");
		btnCheck5.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck5.setBackground(Color.WHITE);
		btnCheck5.setBounds(134, 125, 107, 105);
		panel_1.add(btnCheck5);

		JButton btnCheck6 = new JButton("");
		btnCheck6.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck6.setBackground(Color.WHITE);
		btnCheck6.setBounds(251, 125, 107, 105);
		panel_1.add(btnCheck6);

		JButton btnCheck9 = new JButton("");
		btnCheck9.setFont(new Font("Arial", Font.PLAIN, 50));
		btnCheck9.setBackground(Color.WHITE);
		btnCheck9.setBounds(251, 240, 107, 105);
		panel_1.add(btnCheck9);

		btnCheck1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(0, 0)) {
						btnCheck1.setText("X");
						checkWin(0, 0);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				} else {
					if (!board.isTileMarked(0, 0)) {
						btnCheck1.setText("X");
						checkWin(0, 0);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(0, 1)) {
						btnCheck2.setText("X");
						checkWin(0, 1);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
							System.out.println(board.isCrossTurn());
						}
					}
				} else {
					if (!board.isTileMarked(0, 1)) {
						btnCheck2.setText("X");
						checkWin(0, 1);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " "  +bestMove[1]);

							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(0, 2)) {
						btnCheck3.setText("X");
						checkWin(0, 2);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);

						}
					}
				} else {
					if (!board.isTileMarked(0, 2)) {
						btnCheck3.setText("X");
						checkWin(0, 2);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);

						}
					}
				}
			}
		});

		btnCheck4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(1, 0)) {
						btnCheck4.setText("X");
						checkWin(1, 0);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				} else {
					if (!board.isTileMarked(1, 0)) {
						btnCheck4.setText("X");
						checkWin(1, 0);

						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(2, 0)) {
						btnCheck7.setText("X");
						checkWin(2, 0);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}else {
					if (!board.isTileMarked(2, 0)) {
						btnCheck7.setText("X");
						checkWin(2, 0);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(2, 1)) {
						btnCheck8.setText("X");
						checkWin(2, 1);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}else {
					if (!board.isTileMarked(2, 1)) {
						btnCheck8.setText("X");
						checkWin(2, 1);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(1, 1)) {
						btnCheck5.setText("X");
						checkWin(1, 1);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);

						}
					}
				}
				else {
					if (!board.isTileMarked(1, 1)) {
						btnCheck5.setText("X");
						checkWin(1, 1);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(1, 2)) {
						btnCheck6.setText("X");
						checkWin(1, 2);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
				else {
					if (!board.isTileMarked(1, 2)) {
						btnCheck6.setText("X");
						checkWin(1, 2);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 2) {
								btnCheck9.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

		btnCheck9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (level) {
					if (!board.isTileMarked(2, 2)) {
						btnCheck9.setText("X");
						checkWin(2, 2);
						if (!check) {
							int bestMove[] = Minimax.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
				else {
					if (!board.isTileMarked(2, 2)) {
						btnCheck9.setText("X");
						checkWin(2, 2);
						if (!check) {
							int bestMove[] = MiniMaxImproved.getBestMove(board);
							System.out.println(bestMove[0] + " " + bestMove[1]);
							if (bestMove[0] == 0 && bestMove[1] == 0) {
								btnCheck1.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 1) {
								btnCheck2.setText("O");
							} else if (bestMove[0] == 0 && bestMove[1] == 2) {
								btnCheck3.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 0) {
								btnCheck4.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 1) {
								btnCheck5.setText("O");
							} else if (bestMove[0] == 1 && bestMove[1] == 2) {
								btnCheck6.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 0) {
								btnCheck7.setText("O");
							} else if (bestMove[0] == 2 && bestMove[1] == 1) {
								btnCheck8.setText("O");
							}
							checkWin(bestMove[0], bestMove[1]);
						}
					}
				}
			}
		});

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
				check = false;
				System.out.println("Play game");
			}
		});
		btnPlayAgain.setInheritsPopupMenu(true);
		btnPlayAgain.setForeground(new Color(255, 255, 255));
		btnPlayAgain.setBounds(135, 517, 169, 47);
		contentPane.add(btnPlayAgain);
		btnPlayAgain.setVerifyInputWhenFocusTarget(false);
		btnPlayAgain.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPlayAgain.setHideActionText(true);
		btnPlayAgain.setFont(new Font("Arial", Font.BOLD, 20));
		btnPlayAgain.setFocusPainted(false);
		btnPlayAgain.setDefaultCapable(false);
		btnPlayAgain.setBackground(new Color(60, 179, 113));

		JButton btnFinish = new JButton("Finish");
		btnFinish.setInheritsPopupMenu(true);
		btnFinish.setForeground(new Color(255, 255, 255));
		btnFinish.setBounds(333, 517, 169, 47);
		contentPane.add(btnFinish);
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
				check = false;
				System.out.println("Play game");
			}
		});
		btnFinish.setVerifyInputWhenFocusTarget(false);
		btnFinish.setHorizontalTextPosition(SwingConstants.CENTER);
		btnFinish.setHideActionText(true);
		btnFinish.setFont(new Font("Arial", Font.BOLD, 20));
		btnFinish.setFocusPainted(false);
		btnFinish.setDefaultCapable(false);
		btnFinish.setBackground(new Color(60, 179, 113));

		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.setInheritsPopupMenu(true);
		btnBackToMenu.setForeground(new Color(255, 255, 255));
		btnBackToMenu.setBounds(528, 517, 169, 47);
		contentPane.add(btnBackToMenu);
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setLocationByPlatform(true);
				menu.setLocationRelativeTo(null);
				menu.setVisible(true);
				board = new Board();
				check = false;
				OnePlayerMode.this.dispose();
			}
		});
		btnBackToMenu.setVerifyInputWhenFocusTarget(false);
		btnBackToMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBackToMenu.setHideActionText(true);
		btnBackToMenu.setFont(new Font("Arial", Font.BOLD, 20));
		btnBackToMenu.setFocusPainted(false);
		btnBackToMenu.setDefaultCapable(false);
		btnBackToMenu.setBackground(new Color(60, 179, 113));

		JPanel panel = new JPanel();
		panel.setInheritsPopupMenu(true);
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(82, 128, 222, 354);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("AI");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(54, 88, 89, 47);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(150, 39, 32, 30);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Player");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(54, 31, 89, 47);
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
		textScoreX.setHorizontalAlignment(SwingConstants.CENTER);
		textScoreX.setFont(new Font("Arial", Font.PLAIN, 20));
		textScoreX.setText("0");
		textScoreX.setBounds(87, 205, 96, 24);
		panel.add(textScoreX);
		textScoreX.setColumns(10);

		textScoreO = new JTextField();
		textScoreO.setText("0");
		textScoreO.setHorizontalAlignment(SwingConstants.CENTER);
		textScoreO.setFont(new Font("Arial", Font.PLAIN, 20));
		textScoreO.setColumns(10);
		textScoreO.setBounds(87, 250, 96, 24);
		panel.add(textScoreO);
	}
}
