package com.valentine.papapaname.swing.windows;

import java.awt.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

public class MainWindow
{

	private JFrame frmOrder;
	private JTextField textField;
	private JTextField textField23;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField dateField;
	private JTextField textField6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frmOrder.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmOrder = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frmOrder.getContentPane().getLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		frmOrder.setTitle("Order");
		frmOrder.setBounds(100, 100, 770, 760);
		frmOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel basePane = new JPanel();
		basePane.setLayout(new BorderLayout());
		basePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmOrder.getContentPane().add(basePane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		basePane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Basic", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_4);
		GridLayout gl_panel_4 = new GridLayout(1,5);
		gl_panel_4.setHgap(5);
		gl_panel_4.setVgap(5);
		panel_4.setLayout(gl_panel_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBorder(new TitledBorder(null, "Order Num.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(textField);
		
		textField6 = new JTextField();
		textField6.setBorder(new TitledBorder(null, "TEL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(textField6);
		
		textField3 = new JTextField();
		textField3.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(textField3);

		textField4 = new JTextField();
		textField4.setBorder(new TitledBorder(null, "Surname", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(textField4);
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Calendar calobj = Calendar.getInstance();
		
		dateField = new JTextField(df.format(calobj.getTime()));
		dateField.setEditable(false);
		dateField.setBorder(new TitledBorder(null, "Date", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(dateField);
		
		JPanel commitPaddingPane = new JPanel();
		commitPaddingPane.setLayout(new BorderLayout());
		commitPaddingPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JButton btnNewButton = new JButton("Commit");
		commitPaddingPane.add(btnNewButton, BorderLayout.CENTER);
		panel.add(commitPaddingPane, BorderLayout.EAST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "Order details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		basePane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Simple", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Advanced", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Custom", null, panel_3, null);
	}

}
