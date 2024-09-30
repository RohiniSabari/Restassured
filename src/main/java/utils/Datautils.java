package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.jayway.jsonpath.JsonPath;

public class Datautils {
	public static String readJsonFileToString(String sFilePath) throws IOException {
		byte[] data = Files.readAllBytes(Paths.get(sFilePath));
		return new String(data, StandardCharsets.UTF_8);
	}
	public static String gettestdata(String FilePath,String jsonPath) throws IOException {
		String testdata = Datautils.readJsonFileToString(FilePath);
		return JsonPath.read(testdata,jsonPath).toString();
			
	}

}

