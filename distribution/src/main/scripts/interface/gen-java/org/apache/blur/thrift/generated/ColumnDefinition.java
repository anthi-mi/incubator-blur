/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.blur.thrift.generated;

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



import org.apache.blur.thirdparty.thrift_0_9_0.scheme.IScheme;
import org.apache.blur.thirdparty.thrift_0_9_0.scheme.SchemeFactory;
import org.apache.blur.thirdparty.thrift_0_9_0.scheme.StandardScheme;

import org.apache.blur.thirdparty.thrift_0_9_0.scheme.TupleScheme;
import org.apache.blur.thirdparty.thrift_0_9_0.protocol.TTupleProtocol;
import org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolException;
import org.apache.blur.thirdparty.thrift_0_9_0.EncodingUtils;
import org.apache.blur.thirdparty.thrift_0_9_0.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * The ColumnDefinition defines how a given Column should be interpreted (indexed/stored)
 */
public class ColumnDefinition implements org.apache.blur.thirdparty.thrift_0_9_0.TBase<ColumnDefinition, ColumnDefinition._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct STRUCT_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TStruct("ColumnDefinition");

  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField FAMILY_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("family", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)1);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField COLUMN_NAME_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("columnName", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)2);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField SUB_COLUMN_NAME_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("subColumnName", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)3);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField FIELD_LESS_INDEXED_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("fieldLessIndexed", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.BOOL, (short)4);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField FIELD_TYPE_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("fieldType", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, (short)5);
  private static final org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField PROPERTIES_FIELD_DESC = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField("properties", org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ColumnDefinitionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ColumnDefinitionTupleSchemeFactory());
  }

  /**
   * Required. The family that this column exists within.
   */
  public String family; // required
  /**
   * Required. The column name.
   */
  public String columnName; // required
  /**
   * If this column definition is for a sub column then provide the sub column name.  Otherwise leave this field null.
   */
  public String subColumnName; // required
  /**
   * If this column should be searchable without having to specify the name of the column in the query.
   * NOTE: This will index the column as a full text field in a default field, so that means it's going to be indexed twice.
   */
  public boolean fieldLessIndexed; // required
  /**
   * The field type for the column.  The built in types are:
   * <ul>
   * <li>text - Full text indexing.</li>
   * <li>string - Indexed string literal</li>
   * <li>int - Converted to an integer and indexed numerically.</li>
   * <li>long - Converted to an long and indexed numerically.</li>
   * <li>float - Converted to an float and indexed numerically.</li>
   * <li>double - Converted to an double and indexed numerically.</li>
   * <li>stored - Not indexed, only stored.</li>
   * </ul>
   */
  public String fieldType; // required
  /**
   * For any custom field types, you can pass in configuration properties.
   */
  public Map<String,String> properties; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.blur.thirdparty.thrift_0_9_0.TFieldIdEnum {
    /**
     * Required. The family that this column exists within.
     */
    FAMILY((short)1, "family"),
    /**
     * Required. The column name.
     */
    COLUMN_NAME((short)2, "columnName"),
    /**
     * If this column definition is for a sub column then provide the sub column name.  Otherwise leave this field null.
     */
    SUB_COLUMN_NAME((short)3, "subColumnName"),
    /**
     * If this column should be searchable without having to specify the name of the column in the query.
     * NOTE: This will index the column as a full text field in a default field, so that means it's going to be indexed twice.
     */
    FIELD_LESS_INDEXED((short)4, "fieldLessIndexed"),
    /**
     * The field type for the column.  The built in types are:
     * <ul>
     * <li>text - Full text indexing.</li>
     * <li>string - Indexed string literal</li>
     * <li>int - Converted to an integer and indexed numerically.</li>
     * <li>long - Converted to an long and indexed numerically.</li>
     * <li>float - Converted to an float and indexed numerically.</li>
     * <li>double - Converted to an double and indexed numerically.</li>
     * <li>stored - Not indexed, only stored.</li>
     * </ul>
     */
    FIELD_TYPE((short)5, "fieldType"),
    /**
     * For any custom field types, you can pass in configuration properties.
     */
    PROPERTIES((short)6, "properties");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FAMILY
          return FAMILY;
        case 2: // COLUMN_NAME
          return COLUMN_NAME;
        case 3: // SUB_COLUMN_NAME
          return SUB_COLUMN_NAME;
        case 4: // FIELD_LESS_INDEXED
          return FIELD_LESS_INDEXED;
        case 5: // FIELD_TYPE
          return FIELD_TYPE;
        case 6: // PROPERTIES
          return PROPERTIES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __FIELDLESSINDEXED_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FAMILY, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("family", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.COLUMN_NAME, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("columnName", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.SUB_COLUMN_NAME, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("subColumnName", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.FIELD_LESS_INDEXED, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("fieldLessIndexed", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.BOOL)));
    tmpMap.put(_Fields.FIELD_TYPE, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("fieldType", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING)));
    tmpMap.put(_Fields.PROPERTIES, new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData("properties", org.apache.blur.thirdparty.thrift_0_9_0.TFieldRequirementType.DEFAULT, 
        new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.MapMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP, 
            new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING), 
            new org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldValueMetaData(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.blur.thirdparty.thrift_0_9_0.meta_data.FieldMetaData.addStructMetaDataMap(ColumnDefinition.class, metaDataMap);
  }

  public ColumnDefinition() {
  }

  public ColumnDefinition(
    String family,
    String columnName,
    String subColumnName,
    boolean fieldLessIndexed,
    String fieldType,
    Map<String,String> properties)
  {
    this();
    this.family = family;
    this.columnName = columnName;
    this.subColumnName = subColumnName;
    this.fieldLessIndexed = fieldLessIndexed;
    setFieldLessIndexedIsSet(true);
    this.fieldType = fieldType;
    this.properties = properties;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ColumnDefinition(ColumnDefinition other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFamily()) {
      this.family = other.family;
    }
    if (other.isSetColumnName()) {
      this.columnName = other.columnName;
    }
    if (other.isSetSubColumnName()) {
      this.subColumnName = other.subColumnName;
    }
    this.fieldLessIndexed = other.fieldLessIndexed;
    if (other.isSetFieldType()) {
      this.fieldType = other.fieldType;
    }
    if (other.isSetProperties()) {
      Map<String,String> __this__properties = new HashMap<String,String>();
      for (Map.Entry<String, String> other_element : other.properties.entrySet()) {

        String other_element_key = other_element.getKey();
        String other_element_value = other_element.getValue();

        String __this__properties_copy_key = other_element_key;

        String __this__properties_copy_value = other_element_value;

        __this__properties.put(__this__properties_copy_key, __this__properties_copy_value);
      }
      this.properties = __this__properties;
    }
  }

  public ColumnDefinition deepCopy() {
    return new ColumnDefinition(this);
  }

  @Override
  public void clear() {
    this.family = null;
    this.columnName = null;
    this.subColumnName = null;
    setFieldLessIndexedIsSet(false);
    this.fieldLessIndexed = false;
    this.fieldType = null;
    this.properties = null;
  }

  /**
   * Required. The family that this column exists within.
   */
  public String getFamily() {
    return this.family;
  }

  /**
   * Required. The family that this column exists within.
   */
  public ColumnDefinition setFamily(String family) {
    this.family = family;
    return this;
  }

  public void unsetFamily() {
    this.family = null;
  }

  /** Returns true if field family is set (has been assigned a value) and false otherwise */
  public boolean isSetFamily() {
    return this.family != null;
  }

  public void setFamilyIsSet(boolean value) {
    if (!value) {
      this.family = null;
    }
  }

  /**
   * Required. The column name.
   */
  public String getColumnName() {
    return this.columnName;
  }

  /**
   * Required. The column name.
   */
  public ColumnDefinition setColumnName(String columnName) {
    this.columnName = columnName;
    return this;
  }

  public void unsetColumnName() {
    this.columnName = null;
  }

  /** Returns true if field columnName is set (has been assigned a value) and false otherwise */
  public boolean isSetColumnName() {
    return this.columnName != null;
  }

  public void setColumnNameIsSet(boolean value) {
    if (!value) {
      this.columnName = null;
    }
  }

  /**
   * If this column definition is for a sub column then provide the sub column name.  Otherwise leave this field null.
   */
  public String getSubColumnName() {
    return this.subColumnName;
  }

  /**
   * If this column definition is for a sub column then provide the sub column name.  Otherwise leave this field null.
   */
  public ColumnDefinition setSubColumnName(String subColumnName) {
    this.subColumnName = subColumnName;
    return this;
  }

  public void unsetSubColumnName() {
    this.subColumnName = null;
  }

  /** Returns true if field subColumnName is set (has been assigned a value) and false otherwise */
  public boolean isSetSubColumnName() {
    return this.subColumnName != null;
  }

  public void setSubColumnNameIsSet(boolean value) {
    if (!value) {
      this.subColumnName = null;
    }
  }

  /**
   * If this column should be searchable without having to specify the name of the column in the query.
   * NOTE: This will index the column as a full text field in a default field, so that means it's going to be indexed twice.
   */
  public boolean isFieldLessIndexed() {
    return this.fieldLessIndexed;
  }

  /**
   * If this column should be searchable without having to specify the name of the column in the query.
   * NOTE: This will index the column as a full text field in a default field, so that means it's going to be indexed twice.
   */
  public ColumnDefinition setFieldLessIndexed(boolean fieldLessIndexed) {
    this.fieldLessIndexed = fieldLessIndexed;
    setFieldLessIndexedIsSet(true);
    return this;
  }

  public void unsetFieldLessIndexed() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __FIELDLESSINDEXED_ISSET_ID);
  }

  /** Returns true if field fieldLessIndexed is set (has been assigned a value) and false otherwise */
  public boolean isSetFieldLessIndexed() {
    return EncodingUtils.testBit(__isset_bitfield, __FIELDLESSINDEXED_ISSET_ID);
  }

  public void setFieldLessIndexedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __FIELDLESSINDEXED_ISSET_ID, value);
  }

  /**
   * The field type for the column.  The built in types are:
   * <ul>
   * <li>text - Full text indexing.</li>
   * <li>string - Indexed string literal</li>
   * <li>int - Converted to an integer and indexed numerically.</li>
   * <li>long - Converted to an long and indexed numerically.</li>
   * <li>float - Converted to an float and indexed numerically.</li>
   * <li>double - Converted to an double and indexed numerically.</li>
   * <li>stored - Not indexed, only stored.</li>
   * </ul>
   */
  public String getFieldType() {
    return this.fieldType;
  }

  /**
   * The field type for the column.  The built in types are:
   * <ul>
   * <li>text - Full text indexing.</li>
   * <li>string - Indexed string literal</li>
   * <li>int - Converted to an integer and indexed numerically.</li>
   * <li>long - Converted to an long and indexed numerically.</li>
   * <li>float - Converted to an float and indexed numerically.</li>
   * <li>double - Converted to an double and indexed numerically.</li>
   * <li>stored - Not indexed, only stored.</li>
   * </ul>
   */
  public ColumnDefinition setFieldType(String fieldType) {
    this.fieldType = fieldType;
    return this;
  }

  public void unsetFieldType() {
    this.fieldType = null;
  }

  /** Returns true if field fieldType is set (has been assigned a value) and false otherwise */
  public boolean isSetFieldType() {
    return this.fieldType != null;
  }

  public void setFieldTypeIsSet(boolean value) {
    if (!value) {
      this.fieldType = null;
    }
  }

  public int getPropertiesSize() {
    return (this.properties == null) ? 0 : this.properties.size();
  }

  public void putToProperties(String key, String val) {
    if (this.properties == null) {
      this.properties = new HashMap<String,String>();
    }
    this.properties.put(key, val);
  }

  /**
   * For any custom field types, you can pass in configuration properties.
   */
  public Map<String,String> getProperties() {
    return this.properties;
  }

  /**
   * For any custom field types, you can pass in configuration properties.
   */
  public ColumnDefinition setProperties(Map<String,String> properties) {
    this.properties = properties;
    return this;
  }

  public void unsetProperties() {
    this.properties = null;
  }

  /** Returns true if field properties is set (has been assigned a value) and false otherwise */
  public boolean isSetProperties() {
    return this.properties != null;
  }

  public void setPropertiesIsSet(boolean value) {
    if (!value) {
      this.properties = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FAMILY:
      if (value == null) {
        unsetFamily();
      } else {
        setFamily((String)value);
      }
      break;

    case COLUMN_NAME:
      if (value == null) {
        unsetColumnName();
      } else {
        setColumnName((String)value);
      }
      break;

    case SUB_COLUMN_NAME:
      if (value == null) {
        unsetSubColumnName();
      } else {
        setSubColumnName((String)value);
      }
      break;

    case FIELD_LESS_INDEXED:
      if (value == null) {
        unsetFieldLessIndexed();
      } else {
        setFieldLessIndexed((Boolean)value);
      }
      break;

    case FIELD_TYPE:
      if (value == null) {
        unsetFieldType();
      } else {
        setFieldType((String)value);
      }
      break;

    case PROPERTIES:
      if (value == null) {
        unsetProperties();
      } else {
        setProperties((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FAMILY:
      return getFamily();

    case COLUMN_NAME:
      return getColumnName();

    case SUB_COLUMN_NAME:
      return getSubColumnName();

    case FIELD_LESS_INDEXED:
      return Boolean.valueOf(isFieldLessIndexed());

    case FIELD_TYPE:
      return getFieldType();

    case PROPERTIES:
      return getProperties();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FAMILY:
      return isSetFamily();
    case COLUMN_NAME:
      return isSetColumnName();
    case SUB_COLUMN_NAME:
      return isSetSubColumnName();
    case FIELD_LESS_INDEXED:
      return isSetFieldLessIndexed();
    case FIELD_TYPE:
      return isSetFieldType();
    case PROPERTIES:
      return isSetProperties();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ColumnDefinition)
      return this.equals((ColumnDefinition)that);
    return false;
  }

  public boolean equals(ColumnDefinition that) {
    if (that == null)
      return false;

    boolean this_present_family = true && this.isSetFamily();
    boolean that_present_family = true && that.isSetFamily();
    if (this_present_family || that_present_family) {
      if (!(this_present_family && that_present_family))
        return false;
      if (!this.family.equals(that.family))
        return false;
    }

    boolean this_present_columnName = true && this.isSetColumnName();
    boolean that_present_columnName = true && that.isSetColumnName();
    if (this_present_columnName || that_present_columnName) {
      if (!(this_present_columnName && that_present_columnName))
        return false;
      if (!this.columnName.equals(that.columnName))
        return false;
    }

    boolean this_present_subColumnName = true && this.isSetSubColumnName();
    boolean that_present_subColumnName = true && that.isSetSubColumnName();
    if (this_present_subColumnName || that_present_subColumnName) {
      if (!(this_present_subColumnName && that_present_subColumnName))
        return false;
      if (!this.subColumnName.equals(that.subColumnName))
        return false;
    }

    boolean this_present_fieldLessIndexed = true;
    boolean that_present_fieldLessIndexed = true;
    if (this_present_fieldLessIndexed || that_present_fieldLessIndexed) {
      if (!(this_present_fieldLessIndexed && that_present_fieldLessIndexed))
        return false;
      if (this.fieldLessIndexed != that.fieldLessIndexed)
        return false;
    }

    boolean this_present_fieldType = true && this.isSetFieldType();
    boolean that_present_fieldType = true && that.isSetFieldType();
    if (this_present_fieldType || that_present_fieldType) {
      if (!(this_present_fieldType && that_present_fieldType))
        return false;
      if (!this.fieldType.equals(that.fieldType))
        return false;
    }

    boolean this_present_properties = true && this.isSetProperties();
    boolean that_present_properties = true && that.isSetProperties();
    if (this_present_properties || that_present_properties) {
      if (!(this_present_properties && that_present_properties))
        return false;
      if (!this.properties.equals(that.properties))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ColumnDefinition other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ColumnDefinition typedOther = (ColumnDefinition)other;

    lastComparison = Boolean.valueOf(isSetFamily()).compareTo(typedOther.isSetFamily());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFamily()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.family, typedOther.family);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumnName()).compareTo(typedOther.isSetColumnName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumnName()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.columnName, typedOther.columnName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubColumnName()).compareTo(typedOther.isSetSubColumnName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubColumnName()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.subColumnName, typedOther.subColumnName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFieldLessIndexed()).compareTo(typedOther.isSetFieldLessIndexed());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFieldLessIndexed()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.fieldLessIndexed, typedOther.fieldLessIndexed);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFieldType()).compareTo(typedOther.isSetFieldType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFieldType()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.fieldType, typedOther.fieldType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProperties()).compareTo(typedOther.isSetProperties());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProperties()) {
      lastComparison = org.apache.blur.thirdparty.thrift_0_9_0.TBaseHelper.compareTo(this.properties, typedOther.properties);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ColumnDefinition(");
    boolean first = true;

    sb.append("family:");
    if (this.family == null) {
      sb.append("null");
    } else {
      sb.append(this.family);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("columnName:");
    if (this.columnName == null) {
      sb.append("null");
    } else {
      sb.append(this.columnName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("subColumnName:");
    if (this.subColumnName == null) {
      sb.append("null");
    } else {
      sb.append(this.subColumnName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fieldLessIndexed:");
    sb.append(this.fieldLessIndexed);
    first = false;
    if (!first) sb.append(", ");
    sb.append("fieldType:");
    if (this.fieldType == null) {
      sb.append("null");
    } else {
      sb.append(this.fieldType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("properties:");
    if (this.properties == null) {
      sb.append("null");
    } else {
      sb.append(this.properties);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(out)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TCompactProtocol(new org.apache.blur.thirdparty.thrift_0_9_0.transport.TIOStreamTransport(in)));
    } catch (org.apache.blur.thirdparty.thrift_0_9_0.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ColumnDefinitionStandardSchemeFactory implements SchemeFactory {
    public ColumnDefinitionStandardScheme getScheme() {
      return new ColumnDefinitionStandardScheme();
    }
  }

  private static class ColumnDefinitionStandardScheme extends StandardScheme<ColumnDefinition> {

    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol iprot, ColumnDefinition struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      org.apache.blur.thirdparty.thrift_0_9_0.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FAMILY
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.family = iprot.readString();
              struct.setFamilyIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLUMN_NAME
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.columnName = iprot.readString();
              struct.setColumnNameIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SUB_COLUMN_NAME
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.subColumnName = iprot.readString();
              struct.setSubColumnNameIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FIELD_LESS_INDEXED
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.BOOL) {
              struct.fieldLessIndexed = iprot.readBool();
              struct.setFieldLessIndexedIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // FIELD_TYPE
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING) {
              struct.fieldType = iprot.readString();
              struct.setFieldTypeIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // PROPERTIES
            if (schemeField.type == org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.MAP) {
              {
                org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap _map110 = iprot.readMapBegin();
                struct.properties = new HashMap<String,String>(2*_map110.size);
                for (int _i111 = 0; _i111 < _map110.size; ++_i111)
                {
                  String _key112; // optional
                  String _val113; // required
                  _key112 = iprot.readString();
                  _val113 = iprot.readString();
                  struct.properties.put(_key112, _val113);
                }
                iprot.readMapEnd();
              }
              struct.setPropertiesIsSet(true);
            } else { 
              org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol oprot, ColumnDefinition struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.family != null) {
        oprot.writeFieldBegin(FAMILY_FIELD_DESC);
        oprot.writeString(struct.family);
        oprot.writeFieldEnd();
      }
      if (struct.columnName != null) {
        oprot.writeFieldBegin(COLUMN_NAME_FIELD_DESC);
        oprot.writeString(struct.columnName);
        oprot.writeFieldEnd();
      }
      if (struct.subColumnName != null) {
        oprot.writeFieldBegin(SUB_COLUMN_NAME_FIELD_DESC);
        oprot.writeString(struct.subColumnName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(FIELD_LESS_INDEXED_FIELD_DESC);
      oprot.writeBool(struct.fieldLessIndexed);
      oprot.writeFieldEnd();
      if (struct.fieldType != null) {
        oprot.writeFieldBegin(FIELD_TYPE_FIELD_DESC);
        oprot.writeString(struct.fieldType);
        oprot.writeFieldEnd();
      }
      if (struct.properties != null) {
        oprot.writeFieldBegin(PROPERTIES_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, struct.properties.size()));
          for (Map.Entry<String, String> _iter114 : struct.properties.entrySet())
          {
            oprot.writeString(_iter114.getKey());
            oprot.writeString(_iter114.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ColumnDefinitionTupleSchemeFactory implements SchemeFactory {
    public ColumnDefinitionTupleScheme getScheme() {
      return new ColumnDefinitionTupleScheme();
    }
  }

  private static class ColumnDefinitionTupleScheme extends TupleScheme<ColumnDefinition> {

    @Override
    public void write(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, ColumnDefinition struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetFamily()) {
        optionals.set(0);
      }
      if (struct.isSetColumnName()) {
        optionals.set(1);
      }
      if (struct.isSetSubColumnName()) {
        optionals.set(2);
      }
      if (struct.isSetFieldLessIndexed()) {
        optionals.set(3);
      }
      if (struct.isSetFieldType()) {
        optionals.set(4);
      }
      if (struct.isSetProperties()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetFamily()) {
        oprot.writeString(struct.family);
      }
      if (struct.isSetColumnName()) {
        oprot.writeString(struct.columnName);
      }
      if (struct.isSetSubColumnName()) {
        oprot.writeString(struct.subColumnName);
      }
      if (struct.isSetFieldLessIndexed()) {
        oprot.writeBool(struct.fieldLessIndexed);
      }
      if (struct.isSetFieldType()) {
        oprot.writeString(struct.fieldType);
      }
      if (struct.isSetProperties()) {
        {
          oprot.writeI32(struct.properties.size());
          for (Map.Entry<String, String> _iter115 : struct.properties.entrySet())
          {
            oprot.writeString(_iter115.getKey());
            oprot.writeString(_iter115.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TProtocol prot, ColumnDefinition struct) throws org.apache.blur.thirdparty.thrift_0_9_0.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.family = iprot.readString();
        struct.setFamilyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.columnName = iprot.readString();
        struct.setColumnNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.subColumnName = iprot.readString();
        struct.setSubColumnNameIsSet(true);
      }
      if (incoming.get(3)) {
        struct.fieldLessIndexed = iprot.readBool();
        struct.setFieldLessIndexedIsSet(true);
      }
      if (incoming.get(4)) {
        struct.fieldType = iprot.readString();
        struct.setFieldTypeIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap _map116 = new org.apache.blur.thirdparty.thrift_0_9_0.protocol.TMap(org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, org.apache.blur.thirdparty.thrift_0_9_0.protocol.TType.STRING, iprot.readI32());
          struct.properties = new HashMap<String,String>(2*_map116.size);
          for (int _i117 = 0; _i117 < _map116.size; ++_i117)
          {
            String _key118; // optional
            String _val119; // required
            _key118 = iprot.readString();
            _val119 = iprot.readString();
            struct.properties.put(_key118, _val119);
          }
        }
        struct.setPropertiesIsSet(true);
      }
    }
  }

}

