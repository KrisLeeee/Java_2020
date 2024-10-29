import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;



public class Puzzle extends JFrame implements ActionListener {

	public int[] btn_num = {1, 2, 3, 4, 5, 6, 7, 8, 0};
	JButton[] btn = new JButton[9];
	JButton b1;
	JPanel panel = new JPanel();
	
	public void Puzzle() {
		setTitle("Puzzle");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		b1 = new JButton("reset");
		add(b1, BorderLayout.SOUTH);
		b1.addActionListener(this);
		
		add(panel, "Center");
		panel.setLayout(new GridLayout(3,3));
		for (int i=0; i<9; i++) {
			panel.add(btn[i] = new JButton(String.valueOf(btn_num[i])));
			btn[i].setFont(new Font("Times New Roman", Font.PLAIN, 30));
			btn[i].setEnabled(true);
			btn[i].addActionListener(this);
			}
		btn[8].setText("");
		
		
		setVisible(true);
	
	}
	
	
	public int[][] num = new int[5][5];
	public void some() {
		int k = 1;
		for (int i=0; i<5;i++) {
			for (int j=0; j<5; j++) {
				if (i==0 || i==4 || j ==0 || j==4) {
					num[i][j] = -1;
				}
				else {
					num[i][j] = k;
					k++;
				}
			num[3][3] = 0;
					
			}
		}
		
		int h = 0;
		for (int i=1; i<4; i++) {
			for (int j=1; j<4; j++) {
				btn_num[h] = num[i][j];
				h++;
			}
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		int x,y,xr,yr;
		JButton b = (JButton)e.getSource();
		
		if(b == b1) {
			for (int i=0; i<8; i++) {
				btn[i].setText(String.valueOf(i+1));
			}
			btn[8].setText("");
			some();
			
		}
		else {
			int id = 0;
			while (b != btn[id])
				id++;
	
			x = id/3+1;
			y = id%3+1;
			xr = x;
			yr = y;
			
			if (num[x+1][y] == 0) {
				xr = x+1; }
			else if (num[x-1][y] == 0) {
				xr = x-1; }
			else if (num[x][y+1] == 0) {
				yr = y+1; }
			else if (num[x][y-1] == 0) {
				yr = y-1; }
			
			if (x != xr || y != yr) {
				int tmp = num[x][y];
				num[x][y] = num[xr][yr];
				num[xr][yr] = tmp;
			
				
				JButton act, inact;
				act = btn[(xr-1)*3+yr-1];
				inact = btn[(x-1)*3+y-1];
				
				act.setText(String.valueOf(num[xr][yr]));
				inact.setText("");
				
				}
			}
		
		}
		

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Puzzle obj = new Puzzle();
		obj.some();
		obj.Puzzle();
		
		Puzzle p = new Puzzle();
	}

}
