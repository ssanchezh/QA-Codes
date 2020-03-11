/*
Code for save data in to a CSV file
For languages: Java
*/

import java.io.FileWriter;
import java.util.Arrays;
import java.io.Writer;
import java.util.List;

//Declare parameters that you want save
param1 = "1 parameter";
param2 = "2 parameter";
param3 = "3 parameter";

//Path of csv file
String csvFile = "C:/User/Directory/yourcsvfile.csv";

//Default separator
char SEPARATOR = ',';

//function write line in csv
public void writeLine(FileWriter writer, String[] params, char separator)
{
   boolean firstParam = true;

   StringBuilder stringBuilder = new StringBuilder();
   String param = "";
   
   for (int i = 0; i < params.length; i++)
   {
      //get parameters
      param = params[i];
      log.info(param);
       
        //if the first param in the line, no set seperator
       if (!firstParam) 
       {
           stringBuilder.append(separator);
       }

       //Add param to line
       stringBuilder.append(param);
      
       firstParam = false;
   }

   //add line break
   stringBuilder.append("\n");

   //add line to file
   log.info(stringBuilder.toString());
   writer.append(stringBuilder.toString());

}


//You can add all parameters that you want
String[] params = {param1, param2, param3};

//Write file
FileWriter fileWriter = new FileWriter(csvFile, true);
writeLine(fileWriter, params, SEPARATOR);

//Close file
fileWriter.flush();
fileWriter.close();


