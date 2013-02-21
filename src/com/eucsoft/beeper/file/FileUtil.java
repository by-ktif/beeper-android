package com.eucsoft.beeper.file;

import java.io.File;
import java.util.Random;

import android.os.Environment;

public class FileUtil {

	public static String getUniqFilePath() {
		File beeperDir = getBeeperFolder();
		String uniqFilePath = beeperDir.getAbsolutePath() + "/" + generateUniqName();
		File uniqFile = new File(uniqFilePath);
		if (uniqFile.exists()) {
			return getUniqFilePath();
		}
		return uniqFile.getAbsolutePath();
	}

	public static File getBeeperFolder() {
		//TODO: move hardcoded beeper folder to ApplicationContext
		File beeperDir = new File(Environment.getExternalStorageDirectory() + "/beeper");
        if (!beeperDir.exists()) {
        	beeperDir.mkdir();
        }
        return beeperDir;
	}

	private static String generateUniqName() {
		Random random = new Random();
		String randomSalt = Integer.toString(random.nextInt());
		String time = Long.toString(System.currentTimeMillis());
		
		//TODO: file format? ugly...
		return time + randomSalt + ".ogg";
	}

	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		deleteFile(file);
	}

	public static void deleteFile(File file) {
		if (file.exists()) {
			file.delete();
		}
	}

}
