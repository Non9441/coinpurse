package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import coinpurse.Purse;

public class SizeUI implements Observer{
	private JFrame frame;
	private JTextField space;
	private Purse purse;
	private JProgressBar percent;
	
	public SizeUI(Purse p){
		this.purse = p;
	}
	public void initComponent(){
		frame = new JFrame();
		space = new JTextField();
		percent = new JProgressBar();
		frame.setLayout(new BorderLayout());
		space.setText("EMPTY");
		space.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		space.setForeground(Color.red);
		percent.setMinimum(0);
		percent.setMaximum(purse.getCapacity());
		frame.add(space,BorderLayout.NORTH);
		frame.add(percent);
		frame.setLocationByPlatform(true);
		frame.pack();
	}
	public void run(){
		initComponent();
		frame.setVisible(true);
	}
	@Override
	public void update(Observable o, Object arg) {
		Purse purse = (Purse)o;
		double n = purse.count();
		if(n!=0 &&n!=purse.getCapacity()){
			space.setText(""+n);
		}
		else if(n >= purse.getCapacity()){
			space.setText("FULL");
		} else if(n==0){
			space.setText("EMPTY");
		}
		percent.setValue((int)(n));
		frame.pack();
		
	}
}
