/* 
 * Copyright 2016 Orange.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tracer.utils.tabs;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class DynamicRPCStatsTableModel extends AbstractTableModel{

    ArrayList<Object[]> dataTable = new ArrayList<Object[]>();
    String[] header = new String [] {"id", "exchange.name", "routing.key", 
        "rpc.method", "rpc.counter", "%msg/rpc", "rpc.rate/s"
    };
    
    Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, 
            java.lang.String.class, java.lang.Integer.class, 
            java.lang.Float.class, java.lang.Float.class
    };
    
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
    };
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }

    @Override
    public int getRowCount() {
        return dataTable.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        return ((Object[]) dataTable.get(arg0))[arg1];
    }
    
    @Override
    public void setValueAt(Object value, int row, int column){
        ((Object[]) dataTable.get(row))[column] = value;
        fireTableCellUpdated(row, column);
    }
    
    public void addRow(Object[] data){
        dataTable.add(data);
        fireTableRowsInserted(dataTable.size()-1, dataTable.size()-1);
    }
    
    public void removeRow(Object[] data){
        dataTable.remove(data);
        fireTableRowsInserted(dataTable.size()-1, dataTable.size()-1);
    }
}
