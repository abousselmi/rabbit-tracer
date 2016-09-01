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

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class TracingTableRenderer implements TableCellRenderer{

    DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component myComponent = defaultRenderer.getTableCellRendererComponent(
                table, value, false, false, row, column-1);
        myComponent.setBackground(Color.WHITE);
        if(((String)table.getValueAt(row, 3)).startsWith("network") || (
                (String)table.getValueAt(row, 3)).startsWith("neutron")){
            myComponent.setBackground(new Color(190, 215, 250));
        }
        if(((String)table.getValueAt(row, 4)).contains("WARNING") || (
                (String)table.getValueAt(row, 4)).contains("Warning")
                || ((String)table.getValueAt(row, 4)).contains("warning")){
            myComponent.setBackground(new Color(180, 250, 10));
        }
        if(((String)table.getValueAt(row, 4)).contains("ERROR") || (
                (String)table.getValueAt(row, 4)).contains("Error")
                || ((String)table.getValueAt(row, 4)).contains("error")){
            myComponent.setBackground(new Color(250, 190, 160));
        }
        //In the bottom: more important to see in the context of Openstack
        if(((String)table.getValueAt(row, 4)).contains("Traceback")){
            myComponent.setBackground(new Color(250, 80, 80));
        }
        return myComponent;
    }
    
}
