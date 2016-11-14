package com.valentine.papapaname.utils;

public interface RefListener<TYPE extends Object>
{
	public void change(Ref<TYPE> _ref);
}
