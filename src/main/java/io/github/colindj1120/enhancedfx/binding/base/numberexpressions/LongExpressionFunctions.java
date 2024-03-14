/*
 * Copyright (C) 2024 Colin Jokisch
 * This file is part of EnhancedFX (https://github.com/colindj1120/EnhancedFX).
 *
 * EnhancedFX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EnhancedFX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with EnhancedFX.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.colindj1120.enhancedfx.binding.base.numberexpressions;

import javafx.beans.binding.LongBinding;
import javafx.beans.binding.ObjectExpression;

/**
 * Interface for enhancing the functionality of {@link LongBinding} through extension methods. LongExpressionFunctions extend
 * {@link NumberExpressionFunctions}, providing additional capabilities specifically tailored for handling long values within the
 * JavaFX property and binding system. This interface allows for the seamless integration and manipulation of long values within the
 * broader context of observable and bindable properties, enhancing the fluency and expressiveness of JavaFX application development.
 *
 * <p>
 * The primary focus of LongExpressionFunctions is to augment the standard operations available to {@link LongBinding}, such as
 * retrieval and conversion of its value. By implementing this interface, classes gain access to a suite of utility functions that
 * facilitate common tasks such as converting the long value to other observable types, directly accessing the long value, and
 * more.
 * </p>
 *
 * <p>
 * This interface is particularly useful in scenarios where precise control over numerical values and their representation is required,
 * such as in UI development, where dynamic feedback based on numerical inputs or calculations is a common requirement. The added
 * methods provide a convenient and type-safe way to work with long values in a reactive programming model, enabling developers to
 * write cleaner, more readable, and maintainable code.
 * </p>
 *
 * @author Colin Jokisch
 * @version 1.0.0
 * @see LongBinding
 * @see NumberExpressionFunctions
 */
public interface LongExpressionFunctions extends NumberExpressionFunctions {
    /**
     * Retrieves the {@link LongBinding} instance.
     *
     * @return the {@link LongBinding} instance, enabling access to its functionality.
     */
    LongBinding getBinding();

    /**
     * Gets the current value of this {@link LongBinding}.
     *
     * @return the current long value held by this binding.
     */
    default long get() {
        return getBinding().get();
    }

    /**
     * Converts this {@link LongBinding} into an {@link ObjectExpression<Long>}. This allows the long value to be treated as an
     * object, facilitating operations and transformations that require object types.
     *
     * @return an {@link ObjectExpression<Long>} representing the current value of this {@link LongBinding}.
     */
    default ObjectExpression<Long> asObject() {
        return getBinding().asObject();
    }
}
