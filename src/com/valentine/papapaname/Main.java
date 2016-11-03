package com.valentine.papapaname;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] _args) throws IOException
	{
		File path = new File(System.getProperty("user.home") + "/PapaPaname/texty.txt");
		path.mkdirs();
		Desktop.getDesktop().open(path);
	}

}
