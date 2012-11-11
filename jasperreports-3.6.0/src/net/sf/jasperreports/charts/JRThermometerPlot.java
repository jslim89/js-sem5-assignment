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
package net.sf.jasperreports.charts;

import java.awt.Color;

import net.sf.jasperreports.engine.JRChartPlot;

/**
 * Represents the display options of a Thermometer chart.  A Thermometer chart
 * consists of the outline of a thermometer, a scale showing the reading of
 * the thermometer, three optional ranges corresponding to "good", "warning"
 * and "critical", and the textual display of the value.
 *
 * @author Barry Klawans (bklawans@users.sourceforge.net)
 * @version $Id: JRThermometerPlot.java 3032 2009-08-27 11:32:28Z teodord $
 */
public interface JRThermometerPlot extends JRChartPlot
{
	/**
	 * The value should not be displayed.
	 */
	public static final byte LOCATION_NONE = 0;

	/**
	 * The value should be displayed to the left of the thermometer.
	 */
	public static final byte LOCATION_LEFT = 1;

	/**
	 * The value should be displayed to the right of the thermometer.
	 */
	public static final byte LOCATION_RIGHT = 2;

	/**
	 * The value should be displayed in the bulb of the thermometer.  When
	 * using this option make sure the font is small enough or the value short
	 * enough so the value fits in the bulb.
	 */
	public static final byte LOCATION_BULB = 3;

	/**
	 * Returns the range of values displayed by this thermometer.  This range
	 * corresponds with the scale on the thermometer.
	 *
	 * @return the range of values displayed by this thermometer
	 */
	public JRDataRange getDataRange();

	/**
	 * Returns formatting information for the textual representation of the value.
	 *
	 * @return formatting information for the value
	 */
	public JRValueDisplay getValueDisplay();

	/**
	 * @deprecated No longer used.
	 */
	public boolean isShowValueLines();

	/**
	 * @deprecated Replaced by {@link #getValueLocationByte()}
	 */
	public byte getValueLocation();

	/**
	 * Returns the location where the value of the thermometer will be shown.  The
	 * return value will be one of <code>LOCATION_NONE</code>,
	 * <code>LOCATION_LEFT</code>, <code>LOCATION_RIGHT</code> or
	 * <code>LOCATION_BULB</code>.
	 *
	 * @return the location where the value of the thermometer will be shown
	 */
	public Byte getValueLocationByte();

	/**
	 * Returns the color of the "mercury" in the thermometer when the value is
	 * not in a defined range.
	 *
	 * @return the default color of the mercury in the thermometer
	 */
	public Color getMercuryColor();

	/**
	 * Returns the low range, or <code>null</code> if undefined.
	 *
	 * @return the low range, or <code>null</code> if undefined.
	 */
	public JRDataRange getLowRange();

	/**
	 * Returns the medium range, or <code>null</code> if undefined.
	 *
	 * @return the medium range, or <code>null</code> if undefined.
	 */
	public JRDataRange getMediumRange();

	/**
	 * Returns the high range, or <code>null</code> if undefined.
	 *
	 * @return the high range, or <code>null</code> if undefined.
	 */
	public JRDataRange getHighRange();
}
