/*
   Copyright [2011] [Prasad Balan]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.yarsquidy.x12;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * <p>Parser interface.</p>
 *
 * @author colwellr
 * @version $Id: $Id
 */
public interface Parser {
	/**
	 * <p>parse.</p>
	 *
	 * @param source a {@link java.io.File} object.
	 * @return a {@link EDI} object.
	 * @throws FormatException if any.
	 * @throws java.io.IOException if any.
	 */
	EDI parse(File source) throws FormatException, IOException;
	/**
	 * <p>parse.</p>
	 *
	 * @param source a {@link java.lang.String} object.
	 * @return a {@link EDI} object.
	 * @throws FormatException if any.
	 */
	EDI parse(String source) throws FormatException;
	/**
	 * <p>parse.</p>
	 *
	 * @param source a {@link java.io.InputStream} object.
	 * @return a {@link EDI} object.
	 * @throws FormatException if any.
	 * @throws java.io.IOException if any.
	 */
	EDI parse(InputStream source) throws FormatException, IOException;
}
