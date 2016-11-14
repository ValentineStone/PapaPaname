package com.valentine.papapaname.utils;

public class DoubleRef
{
	private double val = 0;
	
	private DoubleRefChangeListener listener = null;
	
	public DoubleRef(DoubleRefChangeListener _listener)
	{
		listener = _listener;
	}

	public double get()
	{
		return val;
	}

	public void set(double _val)
	{
		val = _val;
		if (listener != null)
		{
			listener.change(this);
		}
	}

	public DoubleRefChangeListener getListener()
	{
		return listener;
	}

	public DoubleRef setListener(DoubleRefChangeListener _listener)
	{
		listener = _listener;
		return this;
	}
}
