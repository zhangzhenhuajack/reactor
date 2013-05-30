/*
 * Copyright (c) 2011-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reactor.fn.selector;


/**
 * Implementation of {@link Selector} that uses {@link Class#isAssignableFrom(Class)} to determine a match.
 *
 * @author Jon Brisbin
 * @author Andy Wilkinson
 * @author Stephane Maldini
 */
public class ClassSelector extends ObjectSelector<Class<?>> {

	public ClassSelector(Class<?> type) {
		super(type);
	}

	/**
	 * Creates a {@link Selector} based on the given class type and only matches if the other Selector against which this
	 * is compared is assignable according to {@link Class#isAssignableFrom(Class)}.
	 *
	 * @param supertype The supertype to compare.
	 * @return The new {@link Selector}.
	 * @see {@link reactor.fn.selector.ClassSelector}
	 */
	public static Selector typeSelector(Class<?> supertype) {
		return new ClassSelector(supertype);
	}

	@Override
	public boolean matches(Object key) {
		return Class.class.isInstance(key) && getObject().isAssignableFrom((Class<?>) key);
	}

}
