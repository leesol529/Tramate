package com.tramate.upload;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

//file을 업로드 해주는 Class
public class SpringFileWriter {
	private FileOutputStream fos;

	public void writeFile(MultipartFile file, String path) {
		String fileName = file.getOriginalFilename();
		try {
			byte fileData[] = file.getBytes();
			fos = new FileOutputStream(path + "\\" + fileName);
			fos.write(fileData);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}