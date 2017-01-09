package dispatcher.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
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

		PdfPTable table = new PdfPTable(10);
		//table.setWidthPercentage(100.0f);
		//table.setWidths(new float[] { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f });
		//table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA, "UTF-8", BaseFont.EMBEDDED);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		// write table header
		cell.setPhrase(new Phrase("Date", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Car Number", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Фамилия водителя", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Телефон", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Отдел", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Товар", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Документ поставщика", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Документ получателя", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Кладовщик", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Диспетчер", font));
		table.addCell(cell);

		for (Supply sup : supplyList) {
			String date = sup.getArrivalDate().toString();
			table.addCell(date);
			table.addCell(sup.getCarNumber());
			table.addCell(sup.getDriverName());
			table.addCell(sup.getPhone());
			table.addCell(sup.getDepartment());
			table.addCell(sup.getProduct());
			table.addCell(sup.getVendorDocument());
			table.addCell(sup.getDocumentReceiving());
			table.addCell(sup.getStorekeeper());
			table.addCell(sup.getDispatcher());
		}
		document.add(table);

	}

}
