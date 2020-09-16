package com.kingdee.eas.zjlw.social.client;

import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.editor.ICellEditor;
import com.kingdee.bos.ctrl.kdf.util.style.StyleAttributes;
import com.kingdee.bos.ctrl.kdf.util.style.Styles;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.IKDEditor;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.event.EventListenerList;

public class TableHelper {
	private static final BigDecimal MAXVALUE = new BigDecimal(999999999);
	public static final String COL_NUMBER = "number";
	public static final String COL_ISLEAF = "isLeaf";
	public static final String COL_ID = "id";
	public static final String COL_LEVEL = "level";
	public static final String COL_PARENT = "parent.id";
	public static final String COL_LONGNUMBER = "longNumber";
	public static final String COL_AMOUNT = "amount";
	public static final String COL_PRICE = "price";
	public static final String COL_QTY = "qty";
	public static final String COL_BIZNUMBER = "bizNumber";
	public static final String COL_NAME = "name";
	public static final String COL_DESCRIPTION = "description";

	public static void setTableDateFormat(KDTable tbl, String[] cols) {
		int length = cols.length;
		for (int i = 0; i < length; ++i)
			if (tbl.getColumn(cols[i]) != null) {
				IColumn col = tbl.getColumn(cols[i]);
				KDDatePicker bizDate = new KDDatePicker();
				bizDate.setSupportedEmpty(false);
				col.setEditor(new KDTDefaultCellEditor(bizDate));
				String formatString = "%{yyyy-MM-dd}t";
				col.getStyleAttributes().setNumberFormat(formatString);
			}
	}

	public static IColumn getColumn(KDTable table, String fieldName) {
		IColumn column = null;
		if ((table != null) && (fieldName != null) && (fieldName.trim().length() != 0)) {
			column = table.getColumn(fieldName);
		}
		return column;
	}

	public static void setWidthForColumn(KDTable tbl, Map map) {
		Set keySet = map.keySet();
		Iterator iter = keySet.iterator();
		String strCol = null;
		Integer length = null;
		Object obj = null;
		while (iter.hasNext()) {
			strCol = (String) iter.next();
			IColumn col = getColumn(tbl, strCol);
			if (col != null) {
				obj = map.get(strCol);
				length = (Integer) obj;
				col.setWidth(length.intValue());
			}
		}
	}


	public static void setFieldsHorizontalAlignment(Styles.HorizontalAlignment hAlign, KDTable table, String[] fieldNames) {
		if (fieldNames != null) {
			IColumn col = null;
			int i = 0;
			for (int size = fieldNames.length; i < size; ++i) {
				col = getColumn(table, fieldNames[i]);
				if (col != null)
					col.getStyleAttributes().setHorizontalAlign(hAlign);
			}
		}
	}

	public static void setRate(KDTable table, String[] fieldNames, int precision) {
		if (fieldNames != null) {
			IColumn col = null;
			for (int i = 0; i < fieldNames.length; ++i) {
				col = getColumn(table, fieldNames[i]);
				if (col == null)
					continue;
				col.setEditor(new KDTDefaultCellEditor(getBigDecimalTextField(precision, new BigDecimal("1.0"), new BigDecimal("0.0"))));

				col.getStyleAttributes().setNumberFormat(getFormatString(precision));
			}
		}
	}

	public static void removeKDEditAdapter(KDTable table) {
		EventListenerList listenerList = table.getListenerList();
		EventListener[] event = listenerList.getListeners(KDTEditAdapter.class);
		int length = event.length;
		EventListener listener = null;
		for (int i = 0; i < length; ++i) {
			listener = event[i];
			table.removeKDTEditListener((KDTEditListener) listener);
		}
	}


	public static void rowToUseObject(IRow row, String[] cols, String[] propertys) {
		if ((cols == null) || (row == null) || (propertys == null)) {
			return;
		}
		Object obj = row.getUserObject();
		if (obj == null) {
			return;
		}

		if (obj instanceof AbstractObjectValue) {
			AbstractObjectValue objectValue = (AbstractObjectValue) obj;
			Enumeration key = null;
			int length = (cols.length <= propertys.length) ? cols.length : propertys.length;
			String strCol = null;
			String proCol = null;
			Object colValue = null;
			for (int i = 0; i < length; ++i) {
				strCol = cols[i];
				proCol = propertys[i];
				key = objectValue.keys();
				boolean flag = checkContain(proCol, key);
				flag = true;
				ICell cell = row.getCell(strCol);
				if (!(flag))
					continue;
				if (cell == null) {
					continue;
				}
				colValue = row.getCell(strCol).getValue();
				objectValue.put(proCol, colValue);
			}
		}
	}

	public static void rowToUseObject(IRow row, String[] cols) {
		if ((cols == null) || (row == null)) {
			return;
		}
		Object obj = row.getUserObject();
		if (obj == null) {
			return;
		}

		if (obj instanceof AbstractObjectValue) {
			AbstractObjectValue objectValue = (AbstractObjectValue) obj;
			Enumeration key = null;
			int length = cols.length;
			String strCol = null;
			Object colValue = null;
			for (int i = 0; i < length; ++i) {
				strCol = cols[i];
				key = objectValue.keys();
				boolean flag = checkContain(strCol, key);

				ICell cell = row.getCell(strCol);
				if (!(flag))
					continue;
				if (cell == null) {
					continue;
				}
				colValue = row.getCell(strCol).getValue();
				objectValue.put(strCol, colValue);
			}
		}
	}

	public static void useObjectToRow(AbstractObjectValue useObject, IRow row, String[] cols) {
		if ((cols == null) || (row == null) || (useObject == null)) {
			return;
		}
		row.setUserObject(useObject);
		Enumeration key = null;
		int length = cols.length;
		String strCol = null;
		Object colValue = null;
		for (int i = 0; i < length; ++i) {
			strCol = cols[i];
			key = useObject.keys();
			boolean flag = checkContain(strCol, key);

			ICell cell = row.getCell(strCol);
			if (!(flag))
				continue;
			if (cell == null) {
				continue;
			}
			colValue = useObject.get(strCol);
			row.getCell(strCol).setValue(colValue);
		}
	}

	public static void useObjectToRow(AbstractObjectValue useObject, IRow row, String[] cols, String[] propertys) {
		if ((cols == null) || (row == null) || (useObject == null)) {
			return;
		}
		row.setUserObject(useObject);
		Enumeration key = null;
		int length = (cols.length <= propertys.length) ? cols.length : propertys.length;
		String strCol = null;
		String property = null;
		Object colValue = null;
		for (int i = 0; i < length; ++i) {
			strCol = cols[i];
			property = propertys[i];
			key = useObject.keys();
			boolean flag = checkContain(property, key);

			ICell cell = row.getCell(strCol);
			if (!(flag))
				continue;
			if (cell == null) {
				continue;
			}
			colValue = useObject.get(property);
			row.getCell(strCol).setValue(colValue);
		}
	}

	public static boolean checkContain(String property, Enumeration keys) {
		Object obj = null;
		boolean flag = false;
		do {
			if (!(keys.hasMoreElements()))
				return true;
			obj = keys.nextElement();
		} while (!(obj.toString().equalsIgnoreCase(property)));
		flag = true;
		return flag;
	}

	public static void setLockFields(KDTable table, String[] fieldNames, boolean isLock) {
		if (fieldNames != null) {
			IColumn column = null;
			int i = 0;
			for (int size = fieldNames.length; i < size; ++i) {
				column = getColumn(table, fieldNames[i]);
				if (column != null)
					column.getStyleAttributes().setLocked(isLock);
			}
		}
	}

	public static void setBigDecimalFieldsPrecision(int precision, KDTable table, String[] fieldNames) {
		if (fieldNames != null) {
			int i = 0;
			for (int size = fieldNames.length; i < size; ++i)
				setBigDecimalFieldsPrecisionByColumn(getColumn(table, fieldNames[i]), precision);
		}
	}

	public static void setBigDecimalFieldsPrecisionByColumn(IColumn column, int precision) {
		if (column == null)
			return;
		column.setEditor(new KDTDefaultCellEditor(getBigDecimalTextField(precision, null)));

		column.getStyleAttributes().setNumberFormat(getFormatString(precision));
	}

	public static KDFormattedTextField getBigDecimalTextField(int precision, BigDecimal maxValue) {
		KDFormattedTextField colTxtField = new KDFormattedTextField();
		colTxtField.setDataType(1);
		colTxtField.setPrecision(precision);
		colTxtField.setHorizontalAlignment(4);

		colTxtField.setSupportedEmpty(true);
		colTxtField.setMaximumValue(MAXVALUE);
		return colTxtField;
	}

	public static KDFormattedTextField getBigDecimalTextField(int precision, BigDecimal maxValue, BigDecimal minValue) {
		KDFormattedTextField colTxtField = new KDFormattedTextField();
		colTxtField.setDataType(1);
		colTxtField.setPrecision(precision);
		colTxtField.setHorizontalAlignment(4);

		colTxtField.setSupportedEmpty(true);
		colTxtField.setMaximumValue(MAXVALUE);
		colTxtField.setMinimumValue(minValue);
		return colTxtField;
	}

	public static void setRequiredFields(KDTable table, String[] fieldNames, boolean isRequired) {
		if (fieldNames != null) {
			IColumn column = null;
			int i = 0;
			for (int size = fieldNames.length; i < size; ++i) {
				column = getColumn(table, fieldNames[i]);
				if (column != null)
					column.setRequired(isRequired);
			}
		}
	}

	public static void setHideFields(KDTable table, String[] fieldNames, boolean isHide) {
		if (fieldNames != null) {
			IColumn column = null;
			int i = 0;
			for (int size = fieldNames.length; i < size; ++i) {
				column = getColumn(table, fieldNames[i]);
				if (column != null)
					column.getStyleAttributes().setHided(isHide);
			}
		}
	}

	public static void setColEditor(KDTable table, Map columnEditors) {
		if ((table != null) && (columnEditors != null)) {
			Iterator itor = columnEditors.keySet().iterator();

			Object key = null;
			Object editor = null;
			IColumn column = null;
			while (itor.hasNext()) {
				key = itor.next();

				if (key instanceof String)
					column = getColumn(table, key.toString());
				else if (key instanceof Integer) {
					column = getColumn(table, Integer.parseInt(key.toString()));
				}

				editor = columnEditors.get(key);
				if ((column != null) && (editor instanceof IKDEditor))
					column.setEditor(new KDTDefaultCellEditor((IKDEditor) editor));
				if ((column != null) && (editor instanceof KDTDefaultCellEditor))
					;
				column.setEditor((ICellEditor) editor);
			}
		}
	}

	public static IColumn getColumn(KDTable table, int columnIndex) {
		IColumn column = null;
		if ((table != null) && (columnIndex > -1)) {
			column = table.getColumn(columnIndex);
		}
		return column;
	}

	public static Object getFieldValue(IRow row, String fieldName) {
		Object result = null;
		ICell cell = getCell(row, fieldName);
		if (cell != null) {
			result = cell.getValue();
		}
		return result;
	}

	public static Object getFieldValue(KDTable table, int rowIndex, String fieldName) {
		Object result = null;
		ICell cell = getCell(table, rowIndex, fieldName);
		if (cell != null) {
			result = cell.getValue();
		}
		return result;
	}

	public static String getFieldName(KDTable table, int columnIndex) {
		String fieldName = null;
		if ((table != null) && (columnIndex > -1)) {
			fieldName = table.getColumnKey(columnIndex);
		}
		return fieldName;
	}

	public static Object getFieldValue(KDTable table, int rowIndex, int columnIndex) {
		Object result = null;
		ICell cell = getCell(table, rowIndex, columnIndex);
		if (cell != null) {
			result = cell.getValue();
		}
		return result;
	}

	public static List getFieldValues(KDTable table, int rowIndex, String[] fieldNames) {
		List values = new ArrayList();
		if ((table != null) && (rowIndex > -1) && (fieldNames != null)) {
			int size = fieldNames.length;
			for (int i = 0; i < size; ++i) {
				values.add(i, getFieldValue(table, rowIndex, fieldNames[i]));
			}
		}
		return values;
	}

	public static List getMapFieldValues(KDTable table, String[] fieldNames) {
		List allList = new ArrayList();
		if ((table != null) && (fieldNames != null)) {
			for (int i = 0; i < table.getRowCount(); ++i) {
				Map map = getMapFieldValues(table, i, fieldNames);
				allList.add(map);
			}
		}
		return allList;
	}

	public static Map getMapFieldValues(KDTable table, int rowIndex, String[] fieldNames) {
		Map map = new HashMap();
		List list = getFieldValues(table, rowIndex, fieldNames);
		for (int j = 0; j < fieldNames.length; ++j) {
			map.put(fieldNames[j], list.get(j));
		}
		return map;
	}

	public static List getFieldValues(KDTable table, int rowIndex, int[] columnIndexes) {
		List values = new ArrayList();
		if ((table != null) && (rowIndex > -1) && (columnIndexes != null)) {
			int size = columnIndexes.length;
			for (int i = 0; i < size; ++i) {
				values.add(i, getFieldValue(table, rowIndex, columnIndexes[i]));
			}
		}
		return values;
	}

	public static void setFieldValues(KDTable table, int rowIndex, String[] fieldNames, Object[] values) {
		if (fieldNames != null) {
			int vSize = values.length;
			int i = 0;
			for (int size = fieldNames.length; i < size; ++i)
				if ((i > -1) && (i < vSize))
					setFieldValue(table, rowIndex, fieldNames[i], values[i]);
				else
					setFieldValue(table, rowIndex, fieldNames[i], null);
		}
	}

	public static void setFieldValues(KDTable table, int rowIndex, int[] columnIndexes, Object[] values) {
		if (columnIndexes != null) {
			int vSize = values.length;
			int i = 0;
			for (int size = columnIndexes.length; i < size; ++i)
				if ((i > -1) && (i < vSize))
					setFieldValue(table, rowIndex, columnIndexes[i], values[i]);
				else
					setFieldValue(table, rowIndex, columnIndexes[i], null);
		}
	}

	public static void setFieldValue(KDTable table, int rowIndex, String fieldName, Object value) {
		ICell cell = getCell(table, rowIndex, fieldName);
		if (cell != null)
			cell.setValue(value);
	}

	public static void setFieldValue(IRow row, String fieldName, Object value) {
		ICell cell = row.getCell(fieldName);
		if (cell != null)
			cell.setValue(value);
	}

	public static void setFieldValue(IRow row, String fieldName, Object value, String colFormat) {
		ICell cell = row.getCell(fieldName);
		cell.getStyleAttributes().setNumberFormat(colFormat);
		if (cell != null)
			cell.setValue(value);
	}

	public static void setFieldValue(KDTable table, int rowIndex, int columnIndex, Object value) {
		ICell cell = getCell(table, rowIndex, columnIndex);
		if (cell != null)
			cell.setValue(value);
	}

	public static ICell getCell(KDTable table, int rowIndex, String fieldName) {
		ICell cell = null;
		if ((table != null) && (rowIndex > -1) && (fieldName != null) && (fieldName.trim().length() != 0)) {
			cell = table.getRow(rowIndex).getCell(fieldName);
		}
		return cell;
	}

	public static ICell getCell(IRow row, String fieldName) {
		ICell cell = null;
		if ((fieldName != null) && (fieldName.trim().length() != 0)) {
			cell = row.getCell(fieldName);
		}
		return cell;
	}

	public static ICell getCell(KDTable table, int rowIndex, int columnIndex) {
		ICell cell = null;
		if ((table != null) && (rowIndex > -1) && (columnIndex > -1)) {
			cell = table.getRow(rowIndex).getCell(columnIndex);
		}
		return cell;
	}

	public static String getFormatString(int precision) {
		if (precision == 0)
			return "%R-{#,##0}f";
		StringBuffer buffer = new StringBuffer();

		if (precision == 0)
			buffer.append("#");
		else {
			buffer.append("0.");
		}
		for (int i = 0; i < precision; ++i) {
			buffer = buffer.append("0");
		}
		StringBuffer formatString = new StringBuffer();
		formatString.append("%r-[=]{#,##").append(buffer).append("}f");
		return formatString.toString();
	}

	public static IRow appendFootRow(KDTable tblMain, String[] strFieldSum) {
		try {
			if (strFieldSum.length > 0) {
				Map mapSum = sumTable(tblMain, strFieldSum);

				IRow footRow = null;
				KDTFootManager footRowManager = tblMain.getFootManager();
				if (footRowManager == null) {
					String total = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Total");
					footRowManager = new KDTFootManager(tblMain);
					footRowManager.addFootView();
					tblMain.setFootManager(footRowManager);
					footRow = footRowManager.addFootRow(0);
					footRow.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.getAlignment("right"));
					tblMain.getIndexColumn().setWidthAdjustMode((short) 1);
					tblMain.getIndexColumn().setWidth(30);
					footRowManager.addIndexText(0, total);
				} else {
					footRow = footRowManager.getFootRow(0);
				}
				String colFormat = "%{0.##########}f";
				int columnCount = tblMain.getColumnCount();

				tblMain.putUserProperty("INIT_USERPROPERTIES", Boolean.TRUE);
				Set footNameSet = (Set) tblMain.getUserProperty("TABLE_FOOTNAME_SET");
				if (null == footNameSet) {
					footNameSet = new HashSet();
					tblMain.putUserProperty("TABLE_FOOTNAME_SET", footNameSet);
				}

				for (int c = 0; c < columnCount; ++c) {
					String fieldName = tblMain.getColumn(c).getFieldName();
					for (int i = 0; i < strFieldSum.length; ++i) {
						String name = strFieldSum[i];
						if (name.equalsIgnoreCase(fieldName)) {
							ICell cell = footRow.getCell(c);
							cell.getStyleAttributes().setNumberFormat(colFormat);
							cell.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.getAlignment("right"));
							cell.getStyleAttributes().setFontColor(Color.BLACK);

							cell.setValue(mapSum.get(name));
						}

						footNameSet.add(name);
					}
				}

				footRow.getStyleAttributes().setBackground(new Color(246, 246, 191));
				return footRow;
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return null;
	}

	public static IRow appendFootRow(KDTable tblMain, String[] strFieldSum, String colFormat) {
		try {
			if (strFieldSum.length > 0) {
				Map mapSum = sumTable(tblMain, strFieldSum);

				IRow footRow = null;
				KDTFootManager footRowManager = tblMain.getFootManager();
				if (footRowManager == null) {
					String total = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Total");
					footRowManager = new KDTFootManager(tblMain);
					footRowManager.addFootView();
					tblMain.setFootManager(footRowManager);
					footRow = footRowManager.addFootRow(0);
					footRow.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.getAlignment("right"));
					tblMain.getIndexColumn().setWidthAdjustMode((short) 1);
					tblMain.getIndexColumn().setWidth(30);
					footRowManager.addIndexText(0, total);
				} else {
					footRow = footRowManager.getFootRow(0);
				}

				int columnCount = tblMain.getColumnCount();

				tblMain.putUserProperty("INIT_USERPROPERTIES", Boolean.TRUE);
				Set footNameSet = (Set) tblMain.getUserProperty("TABLE_FOOTNAME_SET");
				if (null == footNameSet) {
					footNameSet = new HashSet();
					tblMain.putUserProperty("TABLE_FOOTNAME_SET", footNameSet);
				}

				for (int c = 0; c < columnCount; ++c) {
					String fieldName = tblMain.getColumn(c).getFieldName();
					for (int i = 0; i < strFieldSum.length; ++i) {
						String name = strFieldSum[i];
						if (name.equalsIgnoreCase(fieldName)) {
							ICell cell = footRow.getCell(c);
							cell.getStyleAttributes().setNumberFormat(colFormat);
							cell.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.getAlignment("right"));
							cell.getStyleAttributes().setFontColor(Color.BLACK);

							cell.setValue(mapSum.get(name));
						}

						footNameSet.add(name);
					}
				}
				footRow.getStyleAttributes().setBackground(new Color(246, 246, 191));
				return footRow;
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return null;
	}

	public static IRow appendFootRow(KDTable tblMain, String[] strFieldSum, int rowNum, String[] columName) {
		try {
			if (strFieldSum.length > 0) {
				Map mapSum = sumTable(tblMain, strFieldSum);

				IRow footRow = null;
				KDTFootManager footRowManager = tblMain.getFootManager();
				if (footRowManager == null) {
					String total = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_Total");
					footRowManager = new KDTFootManager(tblMain);
					footRowManager.addFootView();
					tblMain.setFootManager(footRowManager);
					for (int j = 0; (rowNum >= 0) && (j <= rowNum); ++j) {
						footRow = footRowManager.addFootRow(j);
						footRow.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.getAlignment("right"));
						footRow.getCell(0).setValue(columName[j].toString());

						String colFormat = "%{0.##########}f";
						int columnCount = tblMain.getColumnCount();
						for (int c = 0; c < columnCount; ++c) {
							String fieldName = tblMain.getColumn(c).getFieldName();
							for (int i = 0; i < strFieldSum.length; ++i) {
								String name = strFieldSum[i];
								if (name.equalsIgnoreCase(fieldName)) {
									ICell cell = footRow.getCell(c);
									cell.getStyleAttributes().setNumberFormat(colFormat);
									cell.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.getAlignment("right"));
									cell.getStyleAttributes().setFontColor(Color.BLACK);

									cell.setValue(mapSum.get(name));
								}
							}
						}

						footRow.getStyleAttributes().setBackground(new Color(246, 246, 191));
					}

					tblMain.getIndexColumn().setWidthAdjustMode((short) 1);
					tblMain.getIndexColumn().setWidth(30);
					footRowManager.addIndexText(0, total);
				} else {
					footRow = footRowManager.getFootRow(0);
				}
				return footRow;
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return null;
	}

	public static void setSumToRow(KDTable tbl, String[] cols) {
		if ((tbl == null) || (tbl.getFootManager() == null)) {
			return;
		}

		IRow row = tbl.getFootManager().getFootRow(0);
		if ((row.getCell("level") != null) && (row.getCell("level").getValue() != null) && (row.getCell("level").getValue() instanceof Integer)) {
			int rowLevel = ((Integer) row.getCell("level").getValue()).intValue();
			setSumToRow(tbl, cols, rowLevel);
		} else {
			setSumToRow(tbl, cols, -1);
		}
	}

	public static void setSumToRow(KDTable tbl, String[] cols, int level) {
		if ((tbl == null) || (tbl.getFootManager() == null)) {
			return;
		}
		IRow row = tbl.getFootManager().getFootRow(0);
		if ((level > 0) && (row.getCell("level") != null)) {
			row.getCell("level").setValue(new Integer(level));
		}
		Map mapSum = null;
		if (level < 0)
			mapSum = sumTable(tbl, cols);
		else {
			mapSum = sumTable(tbl, cols, level);
		}
		Set setKey = mapSum.keySet();
		Iterator iter = setKey.iterator();
		String str = "";
		while (iter.hasNext()) {
			str = (String) iter.next();
			setFieldValue(row, str, mapSum.get(str));
		}
	}

	public static void setSumToRow(KDTable tbl, String[] cols, int level, String colFormat) {
		IRow row = tbl.getFootManager().getFootRow(0);
		if ((level > 0) && (row.getCell("level") != null)) {
			row.getCell("level").setValue(new Integer(level));
		}
		Map mapSum = null;
		if (level < 0)
			mapSum = sumTable(tbl, cols);
		else {
			mapSum = sumTable(tbl, cols, level);
		}
		Set setKey = mapSum.keySet();
		Iterator iter = setKey.iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();
			setFieldValue(row, str, mapSum.get(str), colFormat);
		}
	}

	public static void setSumToRows(KDTable tbl, String[] cols, int level) {
		IRow row = null;

		IRow rows = null;
		if (level == 1) {
			row = tbl.getFootManager().getFootRow(0);
		}
		if (level == 2) {
			row = tbl.getFootManager().getFootRow(1);
		}
		if ((level > 0) && (row.getCell("level") != null)) {
			row.getCell("level").setValue(new Integer(level));
		}
		rows = tbl.getFootManager().getFootRow(2);
		Map mapSum = null;
		if (level < 0)
			mapSum = sumTable(tbl, cols);
		else {
			mapSum = sumTable(tbl, cols, level);
		}
		Set setKey = mapSum.keySet();
		Iterator iter = setKey.iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();

			setFieldValue(row, str, mapSum.get(str));
		}
	}

	public static Map sumTable(KDTable tbl, String[] cols) {
		return sumTable(tbl, cols, -1);
	}

	public static Map sumTable(KDTable tbl, String[] cols, int level) {
		Map mapSum = new HashMap();
		if ((tbl == null) || (tbl.getRowCount() == 0) || (cols == null) || (cols.length == 0)) {
			for (int j = 0; j < cols.length; ++j) {
				mapSum.put(cols[j], new BigDecimal("0.0"));
			}
			return mapSum;
		}
		int tblLength = tbl.getRowCount();
		int colLength = cols.length;
		int count = 0;

		IRow row = null;
		for (int i = 0; i < tblLength; ++i) {
			row = tbl.getRow(i);

			if ((level > 0) && (row.getCell("level") != null) && (row.getCell("level").getValue() instanceof Integer)) {
				int rowLevel = ((Integer) row.getCell("level").getValue()).intValue();
				if (rowLevel != level) {
					++count;
				}
			} else {
				for (int j = 0; j < colLength; ++j) {
					addBigDecimalOfRow(mapSum, cols[j], row);
				}
			}
		}

		if (count == tblLength) {
			for (int j = 0; j < colLength; ++j) {
				mapSum.put(cols[j], new BigDecimal("0.0"));
			}
		}

		return mapSum;
	}

	public static void addBigDecimalOfRow(Map map, String str, IRow row) {
		if (row.getCell(str) == null) {
			return;
		}
		Object obj = map.get(str);
		Object dec = row.getCell(str).getValue();
		if ((obj instanceof BigDecimal) && (dec instanceof BigDecimal)) {
			map.put(str, ((BigDecimal) obj).add((BigDecimal) dec));
		} else if ((obj instanceof BigDecimal) && (dec instanceof String))
			try {
				BigDecimal decDeci = new BigDecimal((String) dec);
				map.put(str, ((BigDecimal) obj).add(decDeci));
			} catch (Exception e) {
			}
		else if ((obj == null) && (dec instanceof String))
			try {
				BigDecimal decDeci = new BigDecimal((String) dec);
				map.put(str, decDeci);
			} catch (Exception e) {
			}
		else if ((obj == null) && (dec instanceof BigDecimal))
			map.put(str, (BigDecimal) dec);
		else if ((obj == null) && (dec == null))
			map.put(str, new BigDecimal("0.0"));
	}




















}