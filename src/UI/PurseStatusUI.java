package UI;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import coinpurse.*;
public class PurseStatusUI implements Observer{
	
	private JFrame frame;
	private JTextField balance;
	
	public void initComponent(){
		frame = new JFrame();
		balance = new JTextField();
		balance.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
		balance.setForeground(Color.BLUE);
		balance.setText("0.0");
		frame.add(balance);
		frame.pack();
		
	}
	
	public void run(){
		initComponent();
		frame.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		Purse purse = (Purse)o;
		balance.setText(String.valueOf(purse.getBalance()));
		frame.pack();
		
	}
}
