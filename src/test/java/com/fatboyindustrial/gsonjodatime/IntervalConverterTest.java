/*
 * GSON Joda Time Serialisers
 *
 * Copyright 2013-2014 Greg Kopff
 * All rights reserved.
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

package com.fatboyindustrial.gsonjodatime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Tests for {@link IntervalConverter}.
 */
public class IntervalConverterTest
{
  /**
   * Tests that the {@link LocalTime} can be round-tripped.
   */
  @Test
  public void testRoundtrip()
  {
    final Gson gson = Converters.registerInterval(new GsonBuilder()).create();
    final Interval i = new Interval(DateTime.now().minusDays(7), DateTime.now());

    assertThat(gson.fromJson(gson.toJson(i), Interval.class), is(i));
  }

  /**
   * Tests that deserialising an empty string returns null
   */
  @Test
  public void testDeserialiseEmptyString()
  {
    final Gson gson = Converters.registerInterval(new GsonBuilder()).create();

    assertThat(gson.fromJson("", Interval.class), is(nullValue()));
  }

  /**
   * Tests that deserialising a null string returns null
   */
  @Test
  public void testDeserialiseNullString()
  {
    final Gson gson = Converters.registerInterval(new GsonBuilder()).create();

    assertThat(gson.fromJson((String) null, Interval.class), is(nullValue()));
  }
}
