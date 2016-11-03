package com.valentine.papapaname;

import java.awt.Font;

public class FontData
{	
	private String fontName;
	private String fontStyle;
	private int fontSize;
	private Font font;
	
	public String toString()
	{
		/*
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
			.append("FONTDATA:[")
			.append(fontName)
			.append(", ")
			.append(fontSize)
			.append(", ")
			.append(fontStyle)
			.append("]")
			;
			
		return stringBuilder.toString();
		
		*/
		
		return getFont().toString();
	}
	
	public Font getFont()
	{
		if (font != null)
			return font;
		
		String fontName =
				this.fontName != null
				? this.fontName
				: FontExt.DEFAULT_FONT_NAME;
		
		int fontSize =
				this.fontSize > 0
				? this.fontSize
				: FontExt.DEFAULT_FONT_SIZE;
				
		int fontStyle;
		
		String fontStyleString =
				this.fontStyle != null
				? this.fontStyle.replace(" ", "").toLowerCase()
				: "";
		
		switch (fontStyleString)
		{
			case "italic":
				fontStyle = Font.ITALIC;
				break;
			case "bold":
				fontStyle = Font.BOLD;
				break;
			case "bold|italic":
			case "italic|bold":
				fontStyle = Font.BOLD | Font.ITALIC;
				break;
			case "plain":
				fontStyle = Font.PLAIN;
				break;
			default:
				fontStyle = FontExt.DEFAULT_FONT_STYLE;
		}
		
		font = new Font(fontName, fontStyle, fontSize);
		
		return font;
	}
	
	
}
