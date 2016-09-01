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

package tracer.utils.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class DataFileWriter {
    
    private final int BUFFER_SIZE = 8192;

    public DataFileWriter(File f, String fc) {
        System.out.println("saving file to: "+f);
        writeBuffered(f, fc, BUFFER_SIZE);
    }
  
    //writeBuffered and write functions are created by David Moles and
    //slightly modified
    //http://stackoverflow.com/questions/1062113/fastest-way-to-write-
    //huge-data-in-text-file-java
    private void writeBuffered(File file, String content, int bufSize) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer, bufSize);
            System.out.print("saving data... ");
            write(content, bufferedWriter);
            System.out.println("file saved succesfully...");
        } catch (IOException ex) {
            System.out.println("ERROR has occured while saving data...");
            Logger.getLogger(DataFileWriter.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    private void write(String content, Writer writer) {
        try {
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("ERROR has occured while writing data...");
            Logger.getLogger(DataFileWriter.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}