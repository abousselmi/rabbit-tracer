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

import java.util.StringTokenizer;

/**
 *
 * @author ayoub bousselmi
 * @since September 2015
 */
public class CustomJsonViewer {

    private static final String STRINGSPACE = "     ";
    private static final String HTMLSPACE = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
       
    /*
    * After trying diffrent JSON parsers: json-simple, minimal-json, Gson and 
    * jackson, no one could get me what I need. This class is used only to 
    * display nicely the content of a json file whithout a prior knowlage of
    * its structure. Feel free to modify it if you have any other solution :)
    */
    private String cleanJSON(String txt2clean){
        String text = txt2clean;
        text = text.replaceAll(" ", "");
        int counter = 0;
        String myspace = "";
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '{'){
                counter++;
                String space = "";
                for (int j = 0; j < counter; j++) {
                    space += STRINGSPACE;
                }
                myspace = space;
                text = text.replaceFirst("\\{", "\n"+space);
            }else if(text.charAt(i) == '}'){
                counter --;
                String space = "";
                for (int j = 0; j < counter; j++) {
                    space += STRINGSPACE;
                }
                myspace = space;
                text = text.replaceFirst("\\}", space);
            }else if(text.charAt(i) == ','){
                text = text.replaceFirst(",", "\n"+myspace);
            }
        }
        text = text.replaceAll(":", ": ");
        text = text.replaceAll("\\[", "");
        text = text.replaceAll("\\]", "");
        text = text.replaceAll("\"", "");
        text = text.replaceAll("\\\\", "");
        
        if(text.startsWith("\n"+STRINGSPACE)){
            text = text.replaceAll("\n"+STRINGSPACE, "\n");
            text = text.replaceFirst("\n", "");
        }
        return text;
    }
    
    private String formatJSON(String txt2format){
        StringTokenizer bigST = new StringTokenizer(txt2format, "\n");
        String text = "";
        while(bigST.hasMoreTokens()){
            StringTokenizer litleST = new StringTokenizer(bigST.nextToken(), ":");
            while (litleST.hasMoreTokens()) {
                text += "<b>"+litleST.nextToken()+" </b> ";
                while (litleST.hasMoreTokens()) {
                    text += ":"+litleST.nextToken().trim();
                }
                text += "\n";
            }
        }
        text = text.replaceAll(STRINGSPACE, HTMLSPACE);
        text = text.replaceAll("\n", "<br>");
        return text;
    }
    
    public String getJSON(String rowjson){
        return formatJSON(cleanJSON(rowjson));
    }
}