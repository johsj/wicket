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
package wicket.util.string;

import junit.framework.TestCase;

/**
 * @author jcompagner
 */
public class AppendingStringBufferTest extends TestCase
{

	/**
	 * Test method for 'wicket.util.string.AppendingStringBuffer.append(String)'
	 */
	public void testAppend()
	{
		AppendingStringBuffer asb = new AppendingStringBuffer();
		asb.append("test1");
		assertEquals("test1", asb.toString());
		asb.append("test2");
		asb.append("test3");
		asb.append("test4");
		assertEquals("test1test2test3test4", asb.toString());
	}
	
	/**
	 * @throws Exception
	 */
	public void testLargeBegin() throws Exception
	{
		AppendingStringBuffer asb = new AppendingStringBuffer("123456789012345678901234567890");
		assertEquals("123456789012345678901234567890", asb.toString());
	}

	/**
	 * @throws Exception
	 */
	public void testCharPrepend() throws Exception
	{
		AppendingStringBuffer asb = new AppendingStringBuffer("123456789");
		asb.append('0');
		assertEquals("1234567890", asb.toString());
	}
	
	/**
	 *  @throws Exception
	 */
	public void testEqualsToAppeningBuffer()  throws Exception
	{
		AppendingStringBuffer asb1 = new AppendingStringBuffer("123456789");
		AppendingStringBuffer asb2 = new AppendingStringBuffer("123456789");
		assertEquals(asb1, asb2);
	}
	
	/**
	 *  @throws Exception
	 */
	public void testEqualsToCharSequence()  throws Exception
	{
		AppendingStringBuffer asb = new AppendingStringBuffer("123456789");
		StringBuffer sb = new StringBuffer("123456789");
		assertEquals(asb, sb);
		assertEquals(asb, "123456789");
		
		sb = new StringBuffer("01234567890");
		assertFalse(asb.equals(sb));
		assertFalse(asb.equals("01234567890"));
	}

	/**
	 *  @throws Exception
	 */
	public void testStartsWidth()  throws Exception
	{
		AppendingStringBuffer asb = new AppendingStringBuffer("123456789");
		StringBuffer sb = new StringBuffer("1234");
		assertTrue(asb.startsWith(sb));
		assertTrue(asb.startsWith("1234"));
		assertTrue(asb.startsWith(asb));
		
		sb = new StringBuffer("01234");
		assertFalse(asb.startsWith(sb));
		assertFalse(asb.startsWith("01234"));
	}	
	
	/**
	 *  @throws Exception
	 */
	public void testEndsWidth()  throws Exception
	{
		AppendingStringBuffer asb = new AppendingStringBuffer("123456789");
		StringBuffer sb = new StringBuffer("6789");
		assertTrue(asb.endsWith(sb));
		assertTrue(asb.endsWith("6789"));
		assertTrue(asb.endsWith(asb));
		
		sb = new StringBuffer("67890");
		assertFalse(asb.endsWith(sb));
		assertFalse(asb.endsWith("67890"));
	}	
	
}
