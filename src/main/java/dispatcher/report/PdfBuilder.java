package dispatcher.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dispatcher.entity.Supply;

public class PdfBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Supply> supplyList = (List<Supply>) model.get("supplyList");

		document.add(new Paragraph("VISKOZNA"));

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		// table.setWidths(new float[] { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
		// 1.0f, 1.0f, 1.0f, 1.0f });
		// table.setSpacingBefore(10);

		// define font for table header row
		BaseFont baseFont = BaseFont.createFont("c:/windows/Fonts/MSMINCHO.TTF", BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);

		Font font = new Font(baseFont, 12, Font.BOLD);

		// define table header cell
		PdfPCell cell = new PdfPCell();

		cell.setVerticalAlignment(5);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("ƒ‡Ú‡", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("¿‚ÚÓ", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("‘»Œ", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("“ÂÎ", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("–Õ ", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("œÁÍ, «ÍÁ", font));
		table.addCell(cell);

		BaseFont bf;
		for (Supply sup : supplyList) {
			bf = BaseFont.createFont("c:/windows/Fonts/MSMINCHO.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font f = new Font(bf, 12);
			String date = sup.getArrivalDate().toString();
			table.addCell(date);
			cell.setPhrase(new Phrase(sup.getCarNumber(), f));
			table.addCell(cell);
			cell.setPhrase(new Phrase(sup.getDriverName(), f));
			table.addCell(cell);
			cell.setPhrase(new Phrase(sup.getPhone(), f));
			table.addCell(cell);
			cell.setPhrase(new Phrase(sup.getVendorDocument(), f));
			table.addCell(cell);
			cell.setPhrase(new Phrase(sup.getDocumentReceiving(), f));
			table.addCell(cell);
		}
		document.add(table);
	}

}
