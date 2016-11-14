package com.valentine.papapaname.swing.windows;

import java.awt.*;

import javax.swing.*;

import com.valentine.papapaname.*;
import com.valentine.papapaname.swing.*;
import com.valentine.papapaname.swing.book.*;
import com.valentine.papapaname.utils.*;

public class ReceiptInputJFrame extends JFrame implements DoubleRefChangeListener
{
	private static final long serialVersionUID = -1611093432819076785L;
	
	private Form receipt;
	
	private DoubleRef thikness;
	private DoubleRef width;
	private DoubleRef height;
	private DoubleRef framePrice;
	private DoubleRef workPrice;
	
	private JPanel contents;
	
	public ReceiptInputJFrame(Form _receipt)
	{
		contents = new JPanel();
		contents.setLayout(new GridLayout(8, 1));
		contents.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		receipt = _receipt;
		
		Dimension preferedSize = new Dimension(200, 30);
		JTextField tf;
		
		contents.add(new JLabel("Толщина багета"));
		tf = new JTextField();
		tf.setPreferredSize(preferedSize);
		thikness = new DoubleJTextField(tf).setListener(this);
		contents.add(tf);
		
		JPanel sizeHost = new JPanel(new GridLayout(1, 2));
		sizeHost.add(new JLabel("Ширина"));
		sizeHost.add(new JLabel("Вы�?ота"));
		contents.add(sizeHost);
		sizeHost = new JPanel(new GridLayout(1, 2));
		sizeHost.setPreferredSize(preferedSize);
		tf = new JTextField();
		width = new DoubleJTextField(tf).setListener(this);
		sizeHost.add(tf);
		tf = new JTextField();
		height = new DoubleJTextField(tf).setListener(this);
		sizeHost.add(tf);
		contents.add(sizeHost);
		
		contents.add(new JLabel("Цена багета"));
		tf = new JTextField();
		tf.setPreferredSize(preferedSize);
		framePrice = new DoubleJTextField(tf).setListener(this);
		contents.add(tf);
		
		contents.add(new JLabel("Цена работы"));
		tf = new JTextField();
		tf.setPreferredSize(preferedSize);
		workPrice = new DoubleJTextField(tf).setListener(this);
		contents.add(tf);
		
		setContentPane(contents);
		
		pack();
		
		setVisible(true);
		
	}

	public void change(DoubleRef _double)
	{
		System.err.println("S=" + (width.get() * height.get()));
	}
}