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
package net.sf.jasperreports.engine.fill;

import net.sf.jasperreports.engine.JRVariable;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRComparableIncrementerFactory.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JRComparableIncrementerFactory extends JRAbstractExtendedIncrementerFactory
{


	/**
	 *
	 */
	private static JRComparableIncrementerFactory mainInstance = new JRComparableIncrementerFactory();


	/**
	 *
	 */
	private JRComparableIncrementerFactory()
	{
	}


	/**
	 *
	 */
	public static JRComparableIncrementerFactory getInstance()
	{
		return mainInstance;
	}


	/**
	 *
	 */
	public JRExtendedIncrementer getExtendedIncrementer(byte calculation)
	{
		JRExtendedIncrementer incrementer = null;

		switch (calculation)
		{
			case JRVariable.CALCULATION_LOWEST :
			{
				incrementer = JRComparableLowestIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_HIGHEST :
			{
				incrementer = JRComparableHighestIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_SYSTEM :
			case JRVariable.CALCULATION_NOTHING :
			case JRVariable.CALCULATION_COUNT :
			case JRVariable.CALCULATION_SUM :
			case JRVariable.CALCULATION_AVERAGE :
			case JRVariable.CALCULATION_STANDARD_DEVIATION :
			case JRVariable.CALCULATION_VARIANCE :
			case JRVariable.CALCULATION_FIRST :
			case JRVariable.CALCULATION_DISTINCT_COUNT :
			default :
			{
				incrementer = JRDefaultIncrementerFactory.getInstance().getExtendedIncrementer(calculation);
				break;
			}
		}
		
		return incrementer;
	}
}


/**
 *
 */
class JRComparableLowestIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRComparableLowestIncrementer mainInstance = new JRComparableLowestIncrementer();

	/**
	 *
	 */
	private JRComparableLowestIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRComparableLowestIncrementer getInstance()
	{
		return mainInstance;
	}

	/**
	 *
	 */
	public Object increment(
		JRCalculable variable, 
		Object expressionValue,
		AbstractValueProvider valueProvider
		)
	{
		Comparable value = (Comparable)variable.getIncrementedValue();
		Comparable newValue = (Comparable)expressionValue;

		if (
			value != null && !variable.isInitialized() &&
			(newValue == null || value.compareTo(newValue) < 0)
			)
		{
			newValue = value;
		}
				
		return newValue;
	}

	
	public Object initialValue()
	{
		return null;
	}
}


/**
 *
 */
class JRComparableHighestIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRComparableHighestIncrementer mainInstance = new JRComparableHighestIncrementer();

	/**
	 *
	 */
	private JRComparableHighestIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRComparableHighestIncrementer getInstance()
	{
		return mainInstance;
	}

	/**
	 *
	 */
	public Object increment(
		JRCalculable variable, 
		Object expressionValue,
		AbstractValueProvider valueProvider
		)
	{
		Comparable value = (Comparable)variable.getIncrementedValue();
		Comparable newValue = (Comparable)expressionValue;

		if (
			value != null && !variable.isInitialized() &&
			(newValue == null || value.compareTo(newValue) > 0)
			)
		{
			newValue = value;
		}
				
		return newValue;
	}

	
	public Object initialValue()
	{
		return null;
	}
}
