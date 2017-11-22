package suite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

public class PdfComparison {

	WebDriver driver;

	@Test
	public void sampleTest() throws InterruptedException, IOException {
		PDFUtil pdfUtil = new PDFUtil();
		String file1="/Users/Naveen/Downloads/PTEscoreReport-1.pdf";
		String file2="/Users/Naveen/Downloads/PTEscoreReport-2.pdf";

		// compares the pdf documents and returns a boolean
		// true if both files have same content. false otherwise.
		// Default is CompareMode.TEXT_MODE
		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		pdfUtil.compare(file1, file2);

		// compare the 3rd page alone
		pdfUtil.compare(file1, file2, 3, 3);

		// compare the pages from 1 to 5
		pdfUtil.compare(file1, file2, 1, 5);

		//if you need to store the result
		pdfUtil.highlightPdfDifference(true);
		pdfUtil.setImageDestinationPath("/Users/Naveen/Downloads/scan");
		pdfUtil.compare(file1, file2);
	}

}