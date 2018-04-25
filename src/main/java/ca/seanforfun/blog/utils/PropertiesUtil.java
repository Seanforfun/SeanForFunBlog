package ca.seanforfun.blog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

import ca.seanforfun.blog.exception.SeanForFunException;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 1:12:13 PM
 * @version 1.0
 */
public class PropertiesUtil {
	public static Properties getClasspathProperties(String path){
		Properties statistic = new Properties();
		ClassPathResource resource = new ClassPathResource(path);
		File accessFile;
		FileInputStream is;
		try {
			accessFile = resource.getFile();
			is = new FileInputStream(accessFile);
			statistic.load(is);
			is.close();
		} catch (IOException e) {
			throw new SeanForFunException("Load properties file error...");
		}
		return statistic;
	}
	
	public static void setClasspathProperties(Properties properties, String path, String key, String value){
		ClassPathResource resource = new ClassPathResource(path);
		File file;
		try {
			file = resource.getFile();
			FileOutputStream os = new FileOutputStream(file);
			properties.setProperty(key, value);
			properties.store(os, null);
			os.flush();
			os.close();
		} catch (IOException e) {
			throw new SeanForFunException("Write properties file error...");
		}
	}
}
