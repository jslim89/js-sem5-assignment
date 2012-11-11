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

/*
 * Contributors:
 * Adrian Jackson - iapetus@users.sourceforge.net
 * David Taylor - exodussystems@users.sourceforge.net
 * Lars Kristensen - llk@users.sourceforge.net
 */
package net.sf.jasperreports.engine;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRPrintImage.java 3033 2009-08-27 11:46:22Z teodord $
 */
public interface JRPrintImage extends JRPrintGraphicElement, JRPrintAnchor, JRPrintHyperlink, JRAlignment, JRBox, JRCommonImage
{


	/**
	 *
	 */
	public JRRenderable getRenderer();
		
	/**
	 *
	 */
	public void setRenderer(JRRenderable renderer);
		
	/**
	 *
	 */
	public void setScaleImage(byte scaleImage);
	
	/**
	 *
	 */
	public void setScaleImage(Byte scaleImage);
	
	/**
	 *
	 */
	public boolean isUsingCache();

	/**
	 *
	 */
	public void setUsingCache(boolean isUsingCache);
	
	/**
	 *
	 */
	public boolean isLazy();

	/**
	 *
	 */
	public void setLazy(boolean isLazy);

	/**
	 *
	 */
	public byte getOnErrorType();

	/**
	 *
	 */
	public void setOnErrorType(byte onErrorType);

	/**
	 * @deprecated Replaced by {@link JRBoxContainer#getLineBox()}
	 */
	public JRBox getBox();

	/**
	 * @deprecated Replaced by {@link JRBoxContainer#getLineBox()}
	 */
	public void setBox(JRBox box);


}
