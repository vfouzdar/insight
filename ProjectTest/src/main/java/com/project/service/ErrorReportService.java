package com.project.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ErrorReportService {

	public Map<String, Long> filePath(String folderPath) throws IOException, IOException {

		//String folderPath = "F://Directory_Files//";

		File file = new File(folderPath);

		Map<String, Long> mapErrorCode = new HashMap<String, Long>();

		if (file.isDirectory()) {
			FilenameFilter fileNameFilter = new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					// System.out.println("File name=" + name);

					if (name != null && name.toLowerCase().endsWith(".csv")) {
						return true;
					}
					return false;
				}
			};

			File[] csvFileArr = file.listFiles(fileNameFilter);
			
			for (File csvFile : csvFileArr) {
				System.out.println(csvFile);
			}

			for (File csvFile : csvFileArr) {
				fileToMapConverter(csvFile.getAbsolutePath(), mapErrorCode);
			} // end for loop
			
		}
		
		return mapErrorCode;
	}// end of method

	public void fileToMapConverter(String filePath, Map<String, Long> mapErrorCode) {

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				String[] values = line.split(",");
				String errorCount = values[(values.length) - 1];
				// System.out.println(errorCount);
				String[] ec = errorCount.split(";");

				for (int i = 0; i < ec.length - 1; i++) {
					String[] ec1 = ec[i].split("=");

					String key = ec1[0];
					// System.out.println(key);

					Long value = Long.parseLong(ec1[1]);

					// System.out.println(value);

					if (mapErrorCode.containsKey(key)) {
						value = value + mapErrorCode.get(key);
					}

					mapErrorCode.put(key, value);

				} // end of for loop

			} // end of while

		} // end of try block
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*for (String key : mapErrorCode.keySet()) {
			System.out.println(key + "  --  key and value is  --  " + mapErrorCode.get(key));
		}
*/
	}

}
