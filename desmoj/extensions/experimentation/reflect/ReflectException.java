package desmoj.extensions.experimentation.reflect;

/**
 * A runtime exception indicating an that occured because of using reflection.
 * Thrown by the ReflectionManager
 * 
 * @version DESMO-J, Ver. 2.4.1 copyright (c) 2014
 * @author Nicolas Knaak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
public class ReflectException extends RuntimeException {

	/**
	 * Constructor for ReflectException.
	 * 
	 * @param arg
	 *            a message
	 */
	public ReflectException(String arg) {
		super(arg);
	}
}