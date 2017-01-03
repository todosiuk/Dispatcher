package dispatcher.exportToExcel;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import dispatcher.entity.Supply;

public class ExcelBuilder extends AbstractXlsxView {

	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

	@Override
	protected void buildExcelDocument(Map model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"report.xls\"");

		@SuppressWarnings("unchecked")
		List<Supply> supplyes = (List<Supply>) model.get("supplyList");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Отчет");

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Дата поставки");
		header.createCell(1).setCellValue("Номер автомобиля");
		header.createCell(2).setCellValue("Фамилия водителя");
		header.createCell(3).setCellValue("Телефон");
		header.createCell(4).setCellValue("Отдел");
		header.createCell(5).setCellValue("Товар");
		header.createCell(6).setCellValue("Документ поставщика");
		header.createCell(7).setCellValue("Документ получателя");
		header.createCell(8).setCellValue("Кладовщик");
		header.createCell(9).setCellValue("Диспетчер");

		// Create data cells
		int rowCount = 1;
		for (Supply supply : supplyes) {
			Row supplyRow = sheet.createRow(rowCount++);
			String date = supply.getArrivalDate().toString();
			supplyRow.createCell(0).setCellValue(date);
			supplyRow.createCell(1).setCellValue(supply.getCarNumber());
			supplyRow.createCell(2).setCellValue(supply.getDriverName());
			supplyRow.createCell(3).setCellValue(supply.getPhone());
			supplyRow.createCell(4).setCellValue(supply.getDepartment());
			supplyRow.createCell(5).setCellValue(supply.getProduct());
			supplyRow.createCell(6).setCellValue(supply.getVendorDocument());
			supplyRow.createCell(7).setCellValue(supply.getDocumentReceiving());
			supplyRow.createCell(8).setCellValue(supply.getStorekeeper());
			supplyRow.createCell(9).setCellValue(supply.getDispatcher());

		}

	}

}
