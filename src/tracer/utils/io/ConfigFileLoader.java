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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class ConfigFileLoader {

    /**
     *
     * @param file String config file to load
     * @return HashMap config
     */
    public HashMap<String, String> loadConfig(File file) {
        System.out.println("loading config file from: "+file);
        
        HashMap<String,String> configMap = new HashMap<String, String>();
        Properties prop = new Properties();
        InputStream input = null;
        
        
        
        try {
            
            input = new FileInputStream(file);
            
            if (file.exists()) {
                // load a properties file
                prop.load(input);

                // get the config
                configMap.put("rabbitIP", prop.getProperty("rabbitIP"));
                configMap.put("isCustomPort", prop.getProperty("isCustomPort"));
                configMap.put("rabbitPort", prop.getProperty("rabbitPort"));
                configMap.put("rabbitID", prop.getProperty("rabbitID"));
                configMap.put("rabbitVHost", prop.getProperty("rabbitVHost"));
                configMap.put("isCustomTimout", prop.getProperty("isCustomTimout"));
                configMap.put("rabbitTimout", prop.getProperty("rabbitTimout"));
                configMap.put("exchangeName", prop.getProperty("exchangeName"));
                configMap.put("exchangeType", prop.getProperty("exchangeType"));
                configMap.put("exchangeParams", prop.getProperty("exchangeParams"));
                configMap.put("rabbitBingingKeys", prop.getProperty("rabbitBingingKeys"));

                System.out.println("config file loaded succesfully..");
            }else {
                System.out.println("config file does not exit..");
            }
        
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
        }
        return configMap;
    }
    
}
