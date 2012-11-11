/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.util;

import java.awt.BasicStroke;
import java.awt.Stroke;

import net.sf.jasperreports.engine.JRGraphicElement;
import net.sf.jasperreports.engine.JRPen;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRPenUtil.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JRPenUtil
{

	/**
	 * 
	 */
	public static void setLinePenFromPen(byte pen, JRPen linePen)
	{
		setLinePenFromPen(new Byte(pen), linePen);
	}
	
	/**
	 * 
	 */
	public static void setLinePenFromPen(Byte pen, JRPen linePen)
	{
		if (pen != null)
		{
			switch (pen.byteValue())
			{
				case JRGraphicElement.PEN_THIN :
				{
					linePen.setLineWidth(0.5f);
					linePen.setLineStyle(JRPen.LINE_STYLE_SOLID);
					break;
				}
				case JRGraphicElement.PEN_1_POINT :
				{
					linePen.setLineWidth(1f);
					linePen.setLineStyle(JRPen.LINE_STYLE_SOLID);
					break;
				}
				case JRGraphicElement.PEN_2_POINT :
				{
					linePen.setLineWidth(2f);
					linePen.setLineStyle(JRPen.LINE_STYLE_SOLID);
					break;
				}
				case JRGraphicElement.PEN_4_POINT :
				{
					linePen.setLineWidth(4f);
					linePen.setLineStyle(JRPen.LINE_STYLE_SOLID);
					break;
				}
				case JRGraphicElement.PEN_DOTTED :
				{
					linePen.setLineWidth(1f);
					linePen.setLineStyle(JRPen.LINE_STYLE_DASHED);
					break;
				}
				case JRGraphicElement.PEN_NONE :
				{
					linePen.setLineWidth(0f);
					linePen.setLineStyle(JRPen.LINE_STYLE_SOLID);
					break;
				}
			}
		}
	}

	/**
	 * 
	 */
	public static byte getPenFromLinePen(JRPen linePen)
	{
		float lineWidth = linePen.getLineWidth().floatValue();
		if (lineWidth <= 0f)
		{
			return JRGraphicElement.PEN_NONE;
		}
		else if (0f < lineWidth && lineWidth < 1f)
		{
			return JRGraphicElement.PEN_THIN;
		}
		else if (1f <= lineWidth && lineWidth < 2f)
		{
			if (linePen.getLineStyle().byteValue() == JRPen.LINE_STYLE_DASHED)
			{
				return JRGraphicElement.PEN_DOTTED;
			}
			else
			{
				return JRGraphicElement.PEN_1_POINT;
			}
		}
		else if (2f <= lineWidth && lineWidth < 4f)
		{
			return JRGraphicElement.PEN_2_POINT;
		}

		return JRGraphicElement.PEN_4_POINT;
	}

	/**
	 * 
	 */
	public static Byte getOwnPenFromLinePen(JRPen linePen)
	{
		if (linePen.getOwnLineWidth() == null && linePen.getOwnLineStyle() == null)
		{
			return null;
		}
		
		return new Byte(getPenFromLinePen(linePen));
	}

	/**
	 *
	 */
	public static Stroke getStroke(JRPen pen, int lineCap)
	{
		float lineWidth = pen.getLineWidth().floatValue();
		
		if (lineWidth > 0f)
		{
			byte lineStyle = pen.getLineStyle().byteValue();
			
			switch (lineStyle)
			{
				case JRPen.LINE_STYLE_DOUBLE :
				{
					return 
						new BasicStroke(
							lineWidth / 3,
							lineCap,
							BasicStroke.JOIN_MITER
							);
				}
				case JRPen.LINE_STYLE_DOTTED :
				{
					switch (lineCap)
					{
						case BasicStroke.CAP_SQUARE :
						{
							return
								new BasicStroke(
									lineWidth,
									lineCap,
									BasicStroke.JOIN_MITER,
									10f,
									new float[]{0, 2 * lineWidth},
									0f
									);
						}
						case BasicStroke.CAP_BUTT :
						{
							return
								new BasicStroke(
									lineWidth,
									lineCap,
									BasicStroke.JOIN_MITER,
									10f,
									new float[]{lineWidth, lineWidth},
									0f
									);
						}
					}
				}
				case JRPen.LINE_STYLE_DASHED :
				{
					switch (lineCap)
					{
						case BasicStroke.CAP_SQUARE :
						{
							return
								new BasicStroke(
									lineWidth,
									lineCap,
									BasicStroke.JOIN_MITER,
									10f,
									new float[]{4 * lineWidth, 4 * lineWidth},
									0f
									);
						}
						case BasicStroke.CAP_BUTT :
						{
							return
								new BasicStroke(
									lineWidth,
									lineCap,
									BasicStroke.JOIN_MITER,
									10f,
									new float[]{5 * lineWidth, 3 * lineWidth},
									0f
									);
						}
					}
				}
				case JRPen.LINE_STYLE_SOLID :
				default :
				{
					return 
						new BasicStroke(
							lineWidth,
							lineCap,
							BasicStroke.JOIN_MITER
							);
				}
			}
		}
		
		return null;
	}
}
