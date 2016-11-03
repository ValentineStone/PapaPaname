package com.valentine.papapaname;

import java.awt.*;

import com.google.gson.*;

public abstract class FontExt
{
	private FontExt(){}
	
	public static final String DEFAULT_FONT_NAME = Font.MONOSPACED;
	public static final int DEFAULT_FONT_SIZE = 12;
	public static final int DEFAULT_FONT_STYLE = Font.PLAIN;
	
	public static final Font DEFAULT_FONT =
	new Font
	(
		DEFAULT_FONT_NAME,
		DEFAULT_FONT_STYLE,
		DEFAULT_FONT_SIZE
	); 
	
	public static Font readFromJson(JsonElement _fontJsonElem, Font _defaultFont)
	{
		if (_fontJsonElem == null || !_fontJsonElem.isJsonObject())
		{
			return
				_defaultFont == null
				?
				DEFAULT_FONT
				:
				_defaultFont
				;
		}
		
		JsonObject fontJsonObj = _fontJsonElem.getAsJsonObject();
		
		
		JsonElement fontNameJson = 
			fontJsonObj
			.get("font-name");
		
		boolean fontNameReal = false;
		
		if (fontNameJson != null)
		{
			fontNameReal =
				fontNameJson.isJsonPrimitive()
				?
				fontNameJson.getAsJsonPrimitive().isString()
				:
				false
				;
		}
		
		String fontName =
			fontNameReal
			?
			fontNameJson
			.getAsJsonPrimitive()
			.getAsString()
			:
			(
				_defaultFont == null
				?
				DEFAULT_FONT_NAME
				:
				_defaultFont.getFontName()
			)
			;
		
			
			
			
			
		JsonElement fontSizeJson =
			fontJsonObj
			.get("font-size");
			
			boolean fontSizeReal = false;
			
			if (fontSizeJson != null)
			{
				fontSizeReal =
					fontSizeJson.isJsonPrimitive()
					?
					fontSizeJson.getAsJsonPrimitive().isNumber()
					:
					false
					;
			}
			
			int fontSize =
				fontSizeReal
				?
				fontSizeJson
				.getAsJsonPrimitive()
				.getAsNumber()
				.intValue()
				:
				(
					_defaultFont == null
					?
					DEFAULT_FONT_SIZE
					:
					_defaultFont.getSize()
				)
				;
		
		
		
		
		
		JsonElement fontStyleJson = 
				fontJsonObj
				.get("font-style");
			
		boolean fontStyleReal = false;
		
		if (fontStyleJson != null)
		{
			fontStyleReal =
				fontStyleJson.isJsonPrimitive()
				?
				fontStyleJson.getAsJsonPrimitive().isString()
				:
				false
				;
		}
		
		String fontStyleString = "";
		
		if (fontStyleReal)
		{
			fontStyleString = 
				fontStyleJson
				.getAsString()
				.replaceAll(" ", "")
				.toLowerCase();
		}
		
		int fontStyle;
		
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
				fontStyle = DEFAULT_FONT_STYLE;
		}
		
		
		
		
		
		return new Font(fontName, fontStyle, fontSize);
		
		
	}
	
	public static Font readFromJson(JsonElement _fontJsonElem)
	{
		return readFromJson(_fontJsonElem, null);	
	}
}
