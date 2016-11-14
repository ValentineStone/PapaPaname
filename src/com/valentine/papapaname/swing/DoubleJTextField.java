package com.valentine.papapaname.swing;

import javax.swing.*;
import javax.swing.event.*;

import com.valentine.papapaname.*;
import com.valentine.papapaname.utils.*;

public class DoubleJTextField extends DoubleRef implements DocumentListener
{
	private JTextField jTextField;
	
	public DoubleJTextField(JTextField _jTextField)
	{
		this(_jTextField, null);
	}
	
	public DoubleJTextField(JTextField _jTextField, DoubleRefChangeListener _listener)
	{
		super(_listener);
		jTextField = _jTextField;
		
		jTextField
			.getDocument()
			.addDocumentListener(this);
	}
	
	public boolean change()
	{
		try
		{
			set(Double.valueOf(jTextField.getText()));
			return true;
		}
		catch(Exception _exc)
		{
			return false;
		}
	}

	public void insertUpdate(DocumentEvent _e)
	{ change(); }

	public void removeUpdate(DocumentEvent _e)
	{ change(); }

	public void changedUpdate(DocumentEvent _e)
	{ change(); }
	
}