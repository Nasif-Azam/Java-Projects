package com.Apache.PDFbox;

import java.io.File;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import junit.framework.Assert;

public class PDF_Reader {

	@Test
	public void ReadPDFFile() throws Exception {
		File file = new File(
				"D:\\Collection\\Programming Languages\\Java\\PDF_to_Text_Maven\\src\\test\\resources\\EAP1.pdf");
		FileInputStream fis = new FileInputStream(file);
		PDDocument pdfDocument = PDDocument.load(fis);

		System.out.println("Page Number: " + pdfDocument.getPages().getCount());

		PDFTextStripper pdfText = new PDFTextStripper();

//		pdfText.setStartPage(2);
//		pdfText.setEndPage(3);

		String docText = pdfText.getText(pdfDocument);
		System.out.println(docText);

		Assert.assertTrue(docText.startsWith("Why and How to Learn"));
		Assert.assertTrue(docText.contains("a) Pick Best Movies"));

		pdfDocument.close();
		fis.close();

	}

	public static void main(String[] args) {

	}

}
