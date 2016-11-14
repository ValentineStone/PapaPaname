package com.valentine.papapaname.swing.book;

import java.awt.*;

public class FontData
{
	public static final FontData DEFAULT_FONT_DATA =
		new FontData
		(
			Font.MONOSPACED,
			22,
			"plain",
			new int[]{0,0,0}
		);
	
	
	
	private String name = null;
	private int size = -1;
	private String style = null;
	private int[] color = null;
	
	private transient int style_ = -1;
	private transient Color color_ = null;
	private transient Font font_ = null;
	
	
	
	public FontData(String _name, int _size, String _style, int[] _color)
	{
		name = _name;
		size = _size;
		style = _style;
		color = _color;
	}

	public Font getFont()
	{
		return font_;
	}
	
	public Color getColor()
	{
		return color_;
	}
	
	public void craft()
	{
		craftFont();
		craftColor();
	}
	
	private void craftFont()
	{
		underlay(DEFAULT_FONT_DATA);
		craftStyle();
		font_ = new Font(name, style_, size);
	}
	
	private void craftColor()
	{
		underlay(DEFAULT_FONT_DATA);
		color_ = new Color(color[0], color[1], color[2]);
	}
	
	private void craftStyle()
	{
		underlay(DEFAULT_FONT_DATA);
		
		String fontStyleString =
				isStyleValid()
				? style.replace(" ", "").toLowerCase()
				: "";
		
		switch (fontStyleString)
		{
			case "italic":
				style_ = Font.ITALIC;
				break;
			case "bold":
				style_ = Font.BOLD;
				break;
			case "bold|italic":
			case "italic|bold":
				style_ = Font.BOLD | Font.ITALIC;
				break;
			case "plain":
				style_ = Font.PLAIN;
				break;
			default:
				style_ = Font.PLAIN;
		}
	}
	
	public void overlay(FontData ... _fontDatas)
	{
		for (FontData fontData : _fontDatas)
		{
			overlay(fontData);
		}
	}
	
	private void overlay(FontData _fontData)
	{
		if (_fontData == null) return;
		name  = _fontData.isNameValid()  ? _fontData.name  : name;
		size  = _fontData.isSizeValid()  ? _fontData.size  : size;
		style = _fontData.isStyleValid() ? _fontData.style : style;
		color = _fontData.isColorValid() ? _fontData.color : color;
	}
	
	public void underlay(FontData ... _fontDatas)
	{
		for (FontData fontData : _fontDatas)
		{
			underlay(fontData);
		}
	}
	
	private void underlay(FontData _fontData)
	{
		if (_fontData == null) return;
		name  = isNameValid()  ? name  : _fontData.name;
		size  = isSizeValid()  ? size  : _fontData.size;
		style = isStyleValid() ? style : _fontData.style;
		color = isColorValid() ? color : _fontData.color;
	}
	
	private boolean isColorValid()
	{
		boolean check =
			color != null
			?
				color.length >= 3
				? true
				: false
			: false;
		
		return check;
	}
	
	private boolean isSizeValid()
	{	
		return size > 0;
	}
	
	private boolean isNameValid()
	{	
		return name != null;
	}
	
	private boolean isStyleValid()
	{	
		return style != null;
	}
}