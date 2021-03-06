package com.valentine.papapaname.swing.book;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.google.gson.*;
import com.valentine.papapaname.*;
import com.valentine.papapaname.utils.*;

public class Book implements Iterable<Form>
{
	public String name = "";
	public List<Form> forms = new ArrayList<>();
	public FontData font;

	private transient Map<String,Form> formMap = new HashMap<>();
	private transient boolean assebmled = false;
	
	public void assebmle()
	{
		if (assebmled) return;
		assebmled = true;
		
		if (font == null)
		{
			font = FontData.DEFAULT_FONT_DATA;
		}
		
		for (Form form : this)
		{
			if (form.font == null)
				form.font = font;
			else
				form.font.underlay(font);
			
			form.assebmle();
			formMap.put(form.name, form);
		}
	}
	
	
	
	
	public Iterator<Form> iterator()
	{
		return forms.iterator();
	}
	
	
	public Form getForm(String _name)
	{
		return formMap.get(_name);
	}
	
	
	
	public static Book craft(String _file)
	{
		Path homePath = Paths.get(System.getProperty("PapaPaname.appdata"));
		
		Utils.exitIfPathDoesNotExist(homePath);
		
		Path bookJsonPath = homePath.resolve(_file);
		
		Utils.exitIfPathDoesNotExist(bookJsonPath);
		
		Reader rdr = null;
		try
		{
			rdr = new FileReader(bookJsonPath.toFile());
		}
		catch (FileNotFoundException _e)
		{
			Utils.exitWithMessage("File not found:\n" + bookJsonPath.toFile());
		}
		
		Gson gson = new Gson();
		Book book = gson.fromJson(rdr, Book.class);
		
		book.assebmle();
		
		return book;
	}
}
