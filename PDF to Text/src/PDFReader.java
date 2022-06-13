import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

	public static void main(String[] args) {
		try {
			PDDocument pdfDocument = PDDocument.load(new File(
					"D:\\Collection\\Programming Languages\\Java\\PDF_to_Text_Maven\\src\\test\\resources\\EAP1.pdf"));

			PDFTextStripper pdfText = new PDFTextStripper();
			String getPDFtext = pdfText.getText(pdfDocument);

			System.out.println(getPDFtext);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
