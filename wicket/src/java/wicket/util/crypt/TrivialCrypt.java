/*
 * $Id$
 * $Revision$ $Date$
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.util.crypt;

import java.security.GeneralSecurityException;

/**
 * THIS CLASS IS FOR TESTING PURPOSES ONLY.  DO NOT USE IT IN PRODUCTION CODE!
 * 
 * @author Jonathan Locke
 */
public class TrivialCrypt extends AbstractCrypt
{
	/**
	 * Constructor
	 */
	public TrivialCrypt()
	{
		super();
	}

	/**
	 * @see wicket.util.crypt.AbstractCrypt#crypt(byte[], int)
	 */
	@Override
	protected byte[] crypt(byte[] input, int mode) throws GeneralSecurityException
	{
		final byte[] result = new byte[input.length];
		for (int i = 0; i < input.length; i++)
		{
			result[i] = (byte)(input[i] ^ 0xff);
		}
		return result;
	}
}

