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

import java.math.BigDecimal;

import net.sf.jasperreports.engine.JRVariable;
import net.sf.jasperreports.engine.util.BigDecimalUtils;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRBigDecimalIncrementerFactory.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JRBigDecimalIncrementerFactory extends JRAbstractExtendedIncrementerFactory
{


	/**
	 *
	 */
	protected static final BigDecimal ZERO = new BigDecimal("0");
	protected static final BigDecimal ONE = new BigDecimal("1");


	/**
	 *
	 */
	private static JRBigDecimalIncrementerFactory mainInstance = new JRBigDecimalIncrementerFactory();


	/**
	 *
	 */
	private JRBigDecimalIncrementerFactory()
	{
	}


	/**
	 *
	 */
	public static JRBigDecimalIncrementerFactory getInstance()
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
			case JRVariable.CALCULATION_COUNT :
			{
				incrementer = JRBigDecimalCountIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_SUM :
			{
				incrementer = JRBigDecimalSumIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_AVERAGE :
			{
				incrementer = JRBigDecimalAverageIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_LOWEST :
			case JRVariable.CALCULATION_HIGHEST :
			{
				incrementer = JRComparableIncrementerFactory.getInstance().getExtendedIncrementer(calculation);
				break;
			}
			case JRVariable.CALCULATION_STANDARD_DEVIATION :
			{
				incrementer = JRBigDecimalStandardDeviationIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_VARIANCE :
			{
				incrementer = JRBigDecimalVarianceIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_DISTINCT_COUNT :
			{
				incrementer = JRBigDecimalDistinctCountIncrementer.getInstance();
				break;
			}
			case JRVariable.CALCULATION_SYSTEM :
			case JRVariable.CALCULATION_NOTHING :
			case JRVariable.CALCULATION_FIRST :
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
class JRBigDecimalCountIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRBigDecimalCountIncrementer mainInstance = new JRBigDecimalCountIncrementer();

	/**
	 *
	 */
	private JRBigDecimalCountIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRBigDecimalCountIncrementer getInstance()
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
		BigDecimal value = (BigDecimal)variable.getIncrementedValue();

		if (value == null || variable.isInitialized())
		{
			value = JRBigDecimalIncrementerFactory.ZERO;
		}

		if (expressionValue == null)
		{
			return value;
		}

		return value.add(JRBigDecimalIncrementerFactory.ONE);
	}

	
	public Object combine(JRCalculable calculable, JRCalculable calculableValue, AbstractValueProvider valueProvider)
	{
		BigDecimal value = (BigDecimal)calculable.getIncrementedValue();
		BigDecimal combineValue = (BigDecimal) calculableValue.getValue();

		if (value == null || calculable.isInitialized())
		{
			value = JRBigDecimalIncrementerFactory.ZERO;
		}

		if (combineValue == null)
		{
			return value;
		}

		return value.add(combineValue);
	}

	
	public Object initialValue()
	{
		return JRBigDecimalIncrementerFactory.ZERO;
	}
}


/**
*
*/
class JRBigDecimalDistinctCountIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRBigDecimalDistinctCountIncrementer mainInstance = new JRBigDecimalDistinctCountIncrementer();

	/**
	 *
	 */
	private JRBigDecimalDistinctCountIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRBigDecimalDistinctCountIncrementer getInstance()
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
		DistinctCountHolder holder = 
			(DistinctCountHolder)valueProvider.getValue(variable.getHelperVariable(JRCalculable.HELPER_COUNT));
		
		if (variable.isInitialized())
		{
			holder.init();
		}

		return new BigDecimal(holder.getCount());
	}

	public Object combine(JRCalculable calculable, JRCalculable calculableValue, AbstractValueProvider valueProvider)
	{
		DistinctCountHolder holder = 
			(DistinctCountHolder)valueProvider.getValue(calculable.getHelperVariable(JRCalculable.HELPER_COUNT));
		
		return new BigDecimal(holder.getCount());
	}
	
	public Object initialValue()
	{
		return JRBigDecimalIncrementerFactory.ZERO;
	}
}


/**
 *
 */
class JRBigDecimalSumIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRBigDecimalSumIncrementer mainInstance = new JRBigDecimalSumIncrementer();

	/**
	 *
	 */
	private JRBigDecimalSumIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRBigDecimalSumIncrementer getInstance()
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
		BigDecimal value = (BigDecimal)variable.getIncrementedValue();
		BigDecimal newValue = (BigDecimal)expressionValue;

		if (newValue == null)
		{
			if (variable.isInitialized())
			{
				return null;
			}

			return value;
		}

		if (value == null || variable.isInitialized())
		{
			value = JRBigDecimalIncrementerFactory.ZERO;
		}

		return value.add(newValue);
	}

	
	public Object initialValue()
	{
		return JRBigDecimalIncrementerFactory.ZERO;
	}
}


/**
 *
 */
class JRBigDecimalAverageIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRBigDecimalAverageIncrementer mainInstance = new JRBigDecimalAverageIncrementer();

	/**
	 *
	 */
	private JRBigDecimalAverageIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRBigDecimalAverageIncrementer getInstance()
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
		if (expressionValue == null)
		{
			if (variable.isInitialized())
			{
				return null;
			}
			return variable.getValue();
		}
		BigDecimal countValue = (BigDecimal)valueProvider.getValue(variable.getHelperVariable(JRCalculable.HELPER_COUNT));
		BigDecimal sumValue = (BigDecimal)valueProvider.getValue(variable.getHelperVariable(JRCalculable.HELPER_SUM));
		return BigDecimalUtils.divide(sumValue, countValue);
	}

	
	public Object initialValue()
	{
		return JRBigDecimalIncrementerFactory.ZERO;
	}
}


/**
 *
 */
class JRBigDecimalStandardDeviationIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRBigDecimalStandardDeviationIncrementer mainInstance = new JRBigDecimalStandardDeviationIncrementer();

	/**
	 *
	 */
	private JRBigDecimalStandardDeviationIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRBigDecimalStandardDeviationIncrementer getInstance()
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
		if (expressionValue == null)
		{
			if (variable.isInitialized())
			{
				return null;
			}
			return variable.getValue(); 
		}
		Number varianceValue = (Number)valueProvider.getValue(variable.getHelperVariable(JRCalculable.HELPER_VARIANCE));
		return new BigDecimal( Math.sqrt(varianceValue.doubleValue()) );
	}

	
	public Object initialValue()
	{
		return JRBigDecimalIncrementerFactory.ZERO;
	}
}


/**
 *
 */
class JRBigDecimalVarianceIncrementer extends JRAbstractExtendedIncrementer
{
	/**
	 *
	 */
	private static JRBigDecimalVarianceIncrementer mainInstance = new JRBigDecimalVarianceIncrementer();

	/**
	 *
	 */
	private JRBigDecimalVarianceIncrementer()
	{
	}

	/**
	 *
	 */
	public static JRBigDecimalVarianceIncrementer getInstance()
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
		BigDecimal value = (BigDecimal)variable.getIncrementedValue();
		BigDecimal newValue = (BigDecimal)expressionValue;
		
		if (newValue == null)
		{
			if (variable.isInitialized())
			{
				return null;
			}
			return value;
		}
		else if (value == null || variable.isInitialized())
		{
			return JRBigDecimalIncrementerFactory.ZERO;
		}
		else
		{
			BigDecimal countValue = (BigDecimal)valueProvider.getValue(variable.getHelperVariable(JRCalculable.HELPER_COUNT));
			BigDecimal sumValue = (BigDecimal)valueProvider.getValue(variable.getHelperVariable(JRCalculable.HELPER_SUM));

			BigDecimal x1 = BigDecimalUtils.divide(
					countValue.subtract(JRBigDecimalIncrementerFactory.ONE).multiply(value), 
					countValue);
			BigDecimal avg = BigDecimalUtils.divide(sumValue, countValue);
			BigDecimal avg2 = avg.subtract(newValue);
			return x1.add(
					BigDecimalUtils.divide(avg2.multiply(avg2), 
							countValue.subtract(JRBigDecimalIncrementerFactory.ONE)));
		}
	}

	
	public Object combine(JRCalculable calculable, JRCalculable calculableValue, AbstractValueProvider valueProvider)
	{
		BigDecimal value = (BigDecimal)calculable.getIncrementedValue();
		
		if (calculableValue.getValue() == null)
		{
			if (calculable.isInitialized())
			{
				return null;
			}

			return value;
		}
		else if (value == null || calculable.isInitialized())
		{
			return (BigDecimal) calculableValue.getIncrementedValue();
		}

		BigDecimal v1 = value;
		BigDecimal c1 = (BigDecimal) valueProvider.getValue(calculable.getHelperVariable(JRCalculable.HELPER_COUNT));
		BigDecimal s1 = (BigDecimal) valueProvider.getValue(calculable.getHelperVariable(JRCalculable.HELPER_SUM));

		BigDecimal v2 = (BigDecimal) calculableValue.getIncrementedValue();
		BigDecimal c2 = (BigDecimal) valueProvider.getValue(calculableValue.getHelperVariable(JRCalculable.HELPER_COUNT));
		BigDecimal s2 = (BigDecimal) valueProvider.getValue(calculableValue.getHelperVariable(JRCalculable.HELPER_SUM));

		c1 = c1.subtract(c2);
		s1 = s1.subtract(s2);
		
		BigDecimal c = c1.add(c2);
		BigDecimal t1 = c1.multiply(c2).multiply(c).multiply(c1.multiply(v1).add(c2.multiply(v2)));
		BigDecimal t2 = c1.multiply(s2).subtract(c2.multiply(s1));
		BigDecimal t3 = c1.multiply(c2).multiply(c).multiply(c);
		return BigDecimalUtils.divide(t1.add(t2.multiply(t2)), t3);
	}

	
	public Object initialValue()
	{
		return JRBigDecimalIncrementerFactory.ZERO;
	}
}
