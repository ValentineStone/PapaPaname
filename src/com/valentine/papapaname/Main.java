package com.valentine.papapaname;

import java.io.*;
import java.nio.file.*;

import com.valentine.papapaname.swing.book.*;
import com.valentine.papapaname.swing.windows.*;

public class Main
{
	public static void main(String[] _args) throws IOException
	{
		System.setProperty("PapaPaname.appdata", Paths.get(System.getProperty("user.dir")).resolve("resources").toString());
		
		Book book = Book.craft("Receipt.json");
		
		Form receipt = book.getForm("Receipt");
		
		new ReceiptInputJFrame(receipt);
	}
}