package com.valentine.papapaname.utils;

import java.nio.file.*;

import javax.swing.*;

public abstract class Utils
{
	private Utils(){}
	
	public static void exitIfPathDoesNotExist(Path _path)
	{
		if (!Files.exists(_path))
		{
			exitWithMessage("Path not found, quitting.\n" + _path.toAbsolutePath());
		}
	}
	
	public static void exitWithMessage(String _message)
	{
		JOptionPane.showMessageDialog(null, _message);
		System.exit(0);
	}
}
