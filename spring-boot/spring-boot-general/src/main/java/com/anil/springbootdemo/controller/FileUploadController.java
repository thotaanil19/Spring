package com.anil.springbootdemo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.UUID;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

	//@PostMapping("/upload")
	@RequestMapping(value="/upload")
	public @ResponseBody String uploadExcelFile(@RequestParam("file") MultipartFile file) throws Exception {

		LOGGER.info("File uploading started....");

		byte[] bytes = file.getBytes();
		final String label = UUID.randomUUID().toString() + ".xlsx";
		final String filepath = "/tmp/" + label;
		File fh = new File("/tmp/");
		if (!fh.exists()) {
			fh.mkdir();
		}
		FileOutputStream writer = new FileOutputStream(filepath);
		writer.write(bytes);
		writer.close();
		LOGGER.info("image bytes received: {}", bytes.length);
		return "File uploded successfully";
	}

	//@PostMapping("/uploadAndRead")
	@RequestMapping(value="/uploadAndRead")
	public @ResponseBody String uploadExcelFileAndReadIt(@RequestParam("file") MultipartFile file) throws Exception {
		LOGGER.info("File uploading started....");
		byte[] bytes = file.getBytes();
		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		DataFormatter dataFormatter = new DataFormatter();
		while (rowIterator.hasNext()) {
			int idx = 0;
			Row row = rowIterator.next();
			
			String userId = dataFormatter.formatCellValue(row.getCell(idx++));
			String boardId = dataFormatter.formatCellValue(row.getCell(idx++));
			System.out.print(userId + "\t");
			System.out.print(boardId + "\t");
			
			/*Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			}*/
			System.out.println();
		}
		LOGGER.info("image bytes received: {}", bytes.length);
		return "File uploded successfully";
	}

}
