/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wicket.util.convert.converters;

import java.util.Locale;

import wicket.util.convert.ITypeConverter;

/**
 * Converts from Object to Character.
 * 
 * @author Eelco Hillenius
 * @author Jonathan Locke
 */
public final class CharacterConverter extends AbstractConverter
{
	private static final long serialVersionUID = 1L;

	/**
	 * The singleton instance for a character converter
	 */
	public static final ITypeConverter INSTANCE = new CharacterConverter();
	
	/**
	 * @see wicket.util.convert.ITypeConverter#convert(java.lang.Object,java.util.Locale)
	 */
	public Object convert(final Object value, Locale locale)
	{
		final String stringValue = value.toString();
		int length = stringValue.length();
		if (length == 0)
		{
			return null;
		}
		else if (length == 1)
		{
			return new Character(value.toString().charAt(0));
		}
		throw newConversionException("Cannot convert '" + value + "' to Character", value,locale);
	}

	/**
	 * @see wicket.util.convert.converters.AbstractConverter#getTargetType()
	 */
	protected Class getTargetType()
	{
		return Character.class;
	}
}