package vttp.batch5.sdf.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) {
//check for valid args input output
		if (args.length < 2){
			System.out.println("Usage: java Main <input_file> <output_file>");
            return;
		}
		String inputFilePath = args[0];
        String outputFilePath = args[1];


//read csv
		try {
            List<String[]> data = readCSV(inputFilePath);
            Map<String, BikeEntry> BikeEntries = processAppData(data);
            writeOutput(outputFilePath, BikeEntries);
        } catch (IOException e) {
            System.out.println("Invalid input");
        }
    }

	private static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        }
        return data;
    }

    // process app data
    private static Map<String, BikeEntry> processAppData(List<String[]> data) {
        Map<String, BikeEntry> BikeEntries = new HashMap<>();

        for (String[] row : data) {
			//season,mnth,holiday,weekday,weathersit,temp,hum,windspeed,casual,registered
			//3,8,0,6,1,0.678333,0.603333,0.177867,2827,5038

            int season = 0; 
			season = Integer.parseInt(row[0]);
			int month = 0;
			month = Integer.parseInt(row[1]);
			int holiday = 0;
			holiday = Integer.parseInt(row[2]);
			int weekday = 0;
			weekday = Integer.parseInt(row[3]);
			int weathersit = 0;
			weathersit = Integer.parseInt(row[4]);
			double temp = 0;
			temp = Double.parseDouble(row[5]);
			double hum = 0;
			hum = Double.parseDouble(row[6]);
			double windspeed = 0;
			windspeed = Double.parseDouble(row[7]);
			int casual = 0;
			casual = Integer.parseInt(row[8]);
			int registered = 0;
			registered = Integer.parseInt(row[9]);
			

          total = casual + registered


        return BikeEntries;
    }

   
	//calculate total bikers by adding casual and registered
	//check how which one is the highest

	//I WOULD MAKE A HASHMAP THAT MAPS 1,2,3,4 TO THE RELEVANT WEATHER SPECIFIED IN THE DATASET CHARACTERISTICS
	//SAME FOR 0,1 FOR HOLIDAY/NOT HOLIDAY

    private static void updateBikeEntries
    }

    // Method to write the results to an output file
    private static void writeOutput(String filePath, Map<String, BikeEntry> BikeEntries) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, BikeEntry> entry : BikeEntries.entrySet()) {
                String <> = entry.getKey();
                BikeEntry <> = entry.getValue();
          

                writer.write("The " + POSITIONvariable + " recorded number of cyclists was in " + SEASONvariable + ", on a " + DAYvariable
				+ " in the month of " MONTH "."
				"There were a total of " + TOTALvariable + "cyclists. The weather was + " WEATHERvariable + ". " + DAYvariable " was " + HOLIDAYvariable + ".")
            }
        }
    }
	}
}  

    // Method to read the CSV file
// Method to process app data and calculate ratings
    // Method to parse rating from String to int
    // Method to update highest, lowest, and total ratings
   // Method to write the results to an output file

//system.out.println("The " + position)








//get the days with most number of runners, use some arraylist or map  to make it into a new instance of bikeentry just like BikeEntries





// season,mnth,holiday,weekday,weathersit,temp,hum,windspeed,casual,registered
// 3,8,0,6,1,0.678333,0.603333,0.177867,2827,5038



// App,Category,Rating,Reviews,Size,Installs,Type,Price,Content Rating,Genres,Last Updated,Current Ver,Android Ver
// Photo Editor & Candy Camera & Grid & ScrapBook,ART_AND_DESIGN,4.1,159,19M,"10,000+",Free,0,Everyone,Art & Design,"January 7, 2018",1.0.0,4.0.3 and up






// =========================================
// Dataset characteristics
// =========================================	
// Both hour.csv and day.csv have the following fields, except hr which is not available in day.csv
	
// 	- season : season (1:spring, 2:summer, 3:fall, 4:winter)
// 	- mnth : month ( 1 to 12)
// 	- hr : hour (0 to 23)
// 	- holiday : weather day is holiday or not (extracted from http://dchr.dc.gov/page/holiday-schedule)
// 	- weekday : day of the week, (0 - Sunday, 1 - Monday, etc)
// 	+ weathersit : 
// 		- 1: Clear, Few clouds, Partly cloudy, Partly cloudy
// 		- 2: Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist
// 		- 3: Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds
// 		- 4: Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog
// 	- temp : Normalized temperature in Celsius. The values are divided to 41 (max)
// 	- hum: Normalized humidity. The values are divided to 100 (max)
// 	- windspeed: Normalized wind speed. The values are divided to 67 (max)
// 	- casual: count of casual users
// 	- registered: count of registered users