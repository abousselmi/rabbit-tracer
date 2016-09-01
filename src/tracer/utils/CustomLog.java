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

package tracer.utils;

import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
 
/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class CustomLog extends OutputStream {
    private final JTextArea myTextArea;
    private final Document myDocument;
    private final SimpleDateFormat myDateFormatter;
    private boolean flag;

    public CustomLog(JTextArea textarea) {
        this.myTextArea = textarea;
        myDocument = myTextArea.getDocument();
        myTextArea.setFont(new Font("consolas", Font.PLAIN, 12));
        myTextArea.setText("  ");
        myTextArea.setAutoscrolls(false);
        myDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        flag = false;
    }
     
    @Override
    public void write(int myByte) throws IOException {
        String string = String.valueOf((char) myByte);
        try {
            if(string.equals("\n")){
                myDocument.insertString(myDocument.getLength(), string+"  ", null);
                flag = true;
            }else{
                if(flag){
                    myDocument.insertString(myDocument.getLength(), myDateFormatter.format(new Date())+"  "+string, null);
                    flag = false;
                }else{
                    myDocument.insertString(myDocument.getLength(), string, null);
                }
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(CustomLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        //not effective..
        //myTextArea.setCaretPosition(myDocument.getLength());
        
    }
}