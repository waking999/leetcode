package leetcode.attempt;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReplaceFileContent {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Example:");
			System.out.println("ReplaceFileContent c:\\a.txt");
			return;
		}

		String pahtName = args[0];

		File file = new File(pahtName);

		if (file.isDirectory()) {
			replaceFormatDirectory(file);
		} else {
			replaceFormatFile(file);
		}
	}

	private static void replaceFormatDirectory(File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				replaceFormatDirectory(fileEntry);
			} else {
				replaceFormatFile(fileEntry);
			}
		}
	}

	private static void replaceFormatFile(File file) {

		replaceFileContent(file);

	}

	@SuppressWarnings("finally")
	private static String replaceFileContent(File file) {

		BufferedInputStream fis = null;
		BufferedReader reader = null;

		BufferedWriter writer = null;
		FileWriter fw = null;

		String outFileName = null;

		try {

			fis = new BufferedInputStream(new FileInputStream(file));
			// reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 510241024);
			reader = new BufferedReader(new InputStreamReader(fis));
			outFileName = file.getAbsolutePath() + ".out";

			fw = new FileWriter(outFileName);
			writer = new BufferedWriter(fw);

			String line = "";
			line = reader.readLine();

			if (line.contains("p edge ")) {
				line = line.replaceAll("p edge ", "");
			}
			writer.write(line);
			writer.newLine();

			while ((line = reader.readLine()) != null) {
				if (line.contains("e ")) {
					line = line.replaceAll("e ", "");
				}
				writer.write(line);
				writer.newLine();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (fis != null) {
					fis.close();
				}
				if (writer != null) {
					writer.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
			return outFileName;
		}
	}
}
