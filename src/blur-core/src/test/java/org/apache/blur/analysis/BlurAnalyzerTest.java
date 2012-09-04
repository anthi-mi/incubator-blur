package org.apache.blur.analysis;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.blur.thrift.generated.AlternateColumnDefinition;
import org.apache.blur.thrift.generated.AnalyzerDefinition;
import org.apache.blur.thrift.generated.ColumnDefinition;
import org.apache.blur.thrift.generated.ColumnFamilyDefinition;
import org.apache.lucene.document.Field.Store;
import org.junit.Test;

public class BlurAnalyzerTest {

  private static final String STANDARD = "org.apache.lucene.analysis.standard.StandardAnalyzer";

  @Test
  public void testToAndFromJSONDef1() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef1());
    String json = analyzer.toJSON();
    BlurAnalyzer analyzer2 = BlurAnalyzer.create(json);
    assertEquals(analyzer.getAnalyzerDefinition(), analyzer2.getAnalyzerDefinition());
  }

  @Test
  public void testStoringOfFieldDef1() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef1());
    assertEquals(Store.NO, analyzer.getStore("b.c.sub1"));
    assertEquals(Store.YES, analyzer.getStore("b.c"));
  }

  @Test
  public void testGetSubFieldsDef1() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef1());
    assertNull(analyzer.getSubIndexNames("b.d"));
    Set<String> subIndexNames = analyzer.getSubIndexNames("b.c");
    TreeSet<String> set = new TreeSet<String>();
    set.add("b.c.sub1");
    set.add("b.c.sub2");
    assertEquals(set, subIndexNames);
  }

  @Test
  public void testFullTextFieldsDef1() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef1());
    assertTrue(analyzer.isFullTextField("a.b"));
    assertFalse(analyzer.isFullTextField("a.d"));
  }

  @Test
  public void testToAndFromJSONDef2() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef2());
    String json = analyzer.toJSON();
    BlurAnalyzer analyzer2 = BlurAnalyzer.create(json);
    assertEquals(analyzer.getAnalyzerDefinition(), analyzer2.getAnalyzerDefinition());
  }

  @Test
  public void testStoringOfFieldDef2() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef2());
    assertEquals(Store.YES, analyzer.getStore("a.b"));
    assertEquals(Store.YES, analyzer.getStore("b.c"));
  }

  @Test
  public void testGetSubFieldsDef2() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef2());
    assertNull(analyzer.getSubIndexNames("b.d"));
  }

  @Test
  public void testFullTextFieldsDef2() throws IOException {
    BlurAnalyzer analyzer = new BlurAnalyzer(getDef2());
    assertTrue(analyzer.isFullTextField("a.b"));
    assertFalse(analyzer.isFullTextField("d.a"));
  }

  private AnalyzerDefinition getDef1() {

    AnalyzerDefinition analyzerDefinition = new AnalyzerDefinition().setDefaultDefinition(new ColumnDefinition(STANDARD, false, null)).setFullTextAnalyzerClassName(STANDARD);
    Map<String, ColumnFamilyDefinition> columnFamilyDefinitions = new HashMap<String, ColumnFamilyDefinition>();

    ColumnFamilyDefinition aColumnFamilyDefinition = new ColumnFamilyDefinition();

    Map<String, ColumnDefinition> aColumnDefinitions = new HashMap<String, ColumnDefinition>();
    aColumnDefinitions.put("b", new ColumnDefinition(STANDARD, true, null));
    aColumnFamilyDefinition.setColumnDefinitions(aColumnDefinitions);
    columnFamilyDefinitions.put("a", aColumnFamilyDefinition);

    Map<String, ColumnDefinition> bColumnDefinitions = new HashMap<String, ColumnDefinition>();
    Map<String, AlternateColumnDefinition> alternates = new HashMap<String, AlternateColumnDefinition>();
    alternates.put("sub1", new AlternateColumnDefinition(STANDARD));
    alternates.put("sub2", new AlternateColumnDefinition(STANDARD));
    bColumnDefinitions.put("c", new ColumnDefinition(STANDARD, true, alternates));
    ColumnFamilyDefinition bColumnFamilyDefinition = new ColumnFamilyDefinition();
    bColumnFamilyDefinition.setColumnDefinitions(bColumnDefinitions);
    columnFamilyDefinitions.put("b", bColumnFamilyDefinition);

    analyzerDefinition.setColumnFamilyDefinitions(columnFamilyDefinitions);
    return analyzerDefinition;
  }

  private AnalyzerDefinition getDef2() {
    AnalyzerDefinition analyzerDefinition = new AnalyzerDefinition().setDefaultDefinition(new ColumnDefinition(STANDARD, false, null)).setFullTextAnalyzerClassName(STANDARD);
    analyzerDefinition.putToColumnFamilyDefinitions("a", new ColumnFamilyDefinition().setDefaultDefinition(new ColumnDefinition(STANDARD, true, null)));
    return analyzerDefinition;
  }
}
