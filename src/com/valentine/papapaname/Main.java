package com.valentine.papapaname;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class Main
{
	public static void main(String[] _args) throws FileNotFoundException
	{
		Path homePath = Paths.get(System.getProperty("user.dir") + "/tmp");
		
		Utils.exitIfPathDoesNotExist(homePath);
		
		Path formJsonPath = homePath.resolve("prntr.json");
		
		Utils.exitIfPathDoesNotExist(formJsonPath);
		
		Reader rdr = new FileReader(formJsonPath.toFile());
		
		Gson gson = new Gson();
		FormPrinter formPrinter = gson.fromJson(rdr, FormPrinter.class);
		
		System.err.println( formPrinter.toString() );
		//Arrays.toString(formPrinter.fields)
		
		formPrinter.assebmle();
	}
	
	/*
	public static void main(String[] _args) throws IOException
	{
		// Path homePath = Paths.get(System.getProperty("user.home") + "/PapaPaname");
		Path homePath = Paths.get(System.getProperty("user.dir") + "/tmp");
		
		Utils.exitIfPathDoesNotExist(homePath);
		//Desktop.getDesktop().open();
		
		Path formImagePath = homePath.resolve("form.png");
		Path formJsonPath = homePath.resolve("form.json");
		
		Utils.exitIfPathDoesNotExist(formImagePath);
		Utils.exitIfPathDoesNotExist(formJsonPath);
		
		BufferedImage formImage = ImageIO.read(formImagePath.toFile());
		
		Graphics g = formImage.getGraphics();
		g.setColor(Color.GREEN);
		g.setFont(g.getFont().deriveFont(300f));
		g.drawString("Hello World!", 100, 100);
		g.dispose();
		
		//Path formImagePathDest = homePath.resolve("dest.png");
		//ImageIO.write(formImage, "png", formImagePathDest.toFile());
		
		Reader rdr = new FileReader(formJsonPath.toFile());
		
		Gson gson = new Gson();
		JsonElement formJsonElement = gson.fromJson(rdr, JsonElement.class);
		
		JsonElement defaultFontJson =
				formJsonElement
				.getAsJsonObject()
				.get("default-font");
		
		Font defaultFont = FontExt.readFromJson(defaultFontJson);
		System.err.println(defaultFont.toString());
	}
	*/
}