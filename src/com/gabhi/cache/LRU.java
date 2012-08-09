/*
 * The MIT License
 *
 * Copyright 2012 Abhijit Gaikwad <gaikwad.abhijit@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.gabhi.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com> visit http://gabhi.com
 */
class LRU<A, B> extends LinkedHashMap<A, B> {

    private final int maxEntries;

    public LRU(final int maxEntries) {
        super(maxEntries + 1, 1.0f, true);
        this.maxEntries = maxEntries;
    }

    /**
     * Returns <tt>true</tt> if this
     * <code>LruCache</code> has more entries than the maximum specified when it
     * was created.
     *
     * <p> This method <em>does not</em> modify the underlying
     * <code>Map</code>; it relies on the implementation of
     * <code>LinkedHashMap</code> to do that, but that behavior is documented in
     * the JavaDoc for
     * <code>LinkedHashMap</code>. </p>
     *
     * @param eldest the <code>Entry</code> in question; this implementation
     * doesn't care what it is, since the implementation is only dependent on
     * the size of the cache
     * @return <tt>true</tt> if the oldest
     * @see java.util.LinkedHashMap#removeEldestEntry(Map.Entry)
     */
    @Override
    protected boolean removeEldestEntry(final Map.Entry<A, B> eldest) {
        return super.size() > maxEntries;
    }
}
