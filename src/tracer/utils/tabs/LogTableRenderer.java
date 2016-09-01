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
public class LogTableRenderer implements TableCellRenderer{

    DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component myComponent = defaultRenderer.getTableCellRendererComponent(
                table, value, false, false, row, column-1);
        
        myComponent.setBackground(Color.WHITE);
        
        if(((String)table.getValueAt(row, 2)).equals("info")){
            myComponent.setBackground(new Color(255, 255, 255));
        }
        if(((String)table.getValueAt(row, 2)).equals("warning")){
            myComponent.setBackground(new Color(255, 255, 0));
        }
        if(((String)table.getValueAt(row, 2)).equals("error")){
            myComponent.setBackground(new Color(255, 0, 0));
        }

        return myComponent;
    }
}