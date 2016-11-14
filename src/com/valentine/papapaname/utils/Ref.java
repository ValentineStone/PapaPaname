package com.valentine.papapaname.utils;

import java.util.*;

public abstract class Ref<TYPE extends Object>
{
	private TYPE val = null;
	
	private List<RefListener<TYPE>> listeners = new ArrayList<>();

	public TYPE get()
	{
		return val;
	}

	public void set(TYPE _val)
	{
		val = _val;
		
		for (RefListener<TYPE> listener : listeners)
		{
			listener.change(this);
		}
	}

	public void addListener(RefListener<TYPE> _element)
	{
		listeners.add(_element);
	}

	public boolean removeListener(RefListener<TYPE> _element)
	{
		return listeners.remove(_element);
	}
}
