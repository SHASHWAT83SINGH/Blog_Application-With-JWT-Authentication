package com.codewithshashwat.blogs.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithshashwat.blogs.services.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		//FILE NAME
		String name=file.getOriginalFilename();
		
		
		//PATH BANEGE FILE TAK KA.
		String Filepath=path+File.separator+name;
		
		
		//CREATE FOLDER IF NOT CREATED.
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		
		//FILE COPY
		Files.copy(file.getInputStream(),Paths.get(Filepath));
		
		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {

		return null;
	}
	

}
