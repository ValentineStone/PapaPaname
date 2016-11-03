package com.valentine.papapaname;

import java.nio.file.*;

import javax.swing.*;

public abstract class Utils
{
	private Utils(){}
	
	public static void exitIfPathDoesNotExist(Path _path)
	{
		if (!Files.exists(_path))
		{
			JOptionPane.showMessageDialog(null, "Path not found, quitting.\n" + _path.toAbsolutePath());
			System.exit(0);
		}
	}
}
