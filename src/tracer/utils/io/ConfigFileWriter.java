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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class ConfigFileWriter {
    
    private final String[][] configContent;
    private final File file;

    /**
     *
     * @param f File name
     * @param content String[][] content to write
     */
    public ConfigFileWriter(File f, String[][] content) {
        configContent = content;
        file = f;
        System.out.println("saving config to: "+f);
        writeConfig();
    }
    
    private void writeConfig() {
        Properties prop = new Properties();
        OutputStream output = null;
        
        try {
            
            output = new FileOutputStream(file);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            // set the config
            for (String[] configRow : configContent) {
                prop.setProperty(configRow[0], configRow[1]);
            }
            // save config
            prop.store(output, null);
            System.out.println("config file saved succesfully..");

        } catch (IOException io) {
            io.printStackTrace(System.out);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
            
        }
    }

}
