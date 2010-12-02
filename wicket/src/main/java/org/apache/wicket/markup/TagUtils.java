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
package org.apache.wicket.markup;


/**
 * Some utils to handle tags which otherwise would bloat the Tag AP.
 * 
 * @author Juergen Donnerstag
 */
public class TagUtils
{
	/**
	 * Constructor
	 */
	public TagUtils()
	{
	}

	/**
	 * @return True, if tag name equals '&lt;body ...&gt;'
	 * 
	 * @param tag
	 */
	public static final boolean isBodyTag(final ComponentTag tag)
	{
		return ("body".equalsIgnoreCase(tag.getName()) && (tag.getNamespace() == null));
	}

	/**
	 * @return True, if tag name equals '&lt;head ...&gt;'
	 * 
	 * @param tag
	 */
	public static final boolean isHeadTag(final ComponentTag tag)
	{
		return ("head".equalsIgnoreCase(tag.getName()) && (tag.getNamespace() == null));
	}

	/**
	 * 
	 * @param markup
	 * @param i
	 * @return True if the markup element at index 'i' is a WicketTag
	 */
	public static final boolean isWicketTag(final IMarkupFragment markup, final int i)
	{
		MarkupElement elem = markup.get(i);
		return elem instanceof WicketTag;
	}

	/**
	 * 
	 * @param markup
	 * @param i
	 * @return True if the markup element at index 'i' is a &lt;wicket:extend&gt; tag
	 */
	public static final boolean isExtendTag(final IMarkupFragment markup, final int i)
	{
		MarkupElement elem = markup.get(i);
		if (elem instanceof WicketTag)
		{
			WicketTag wtag = (WicketTag)elem;
			return wtag.isExtendTag();
		}
		return false;
	}
}