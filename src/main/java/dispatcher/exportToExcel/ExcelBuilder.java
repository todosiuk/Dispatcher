package dispatcher.exportToExcel;

import java.text.DateFormat;
import java.util.LinkedList;
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
		LinkedList<Supply> supplyes = (LinkedList<Supply>) model.get("supplyList");

		// create excel xls sheet
		Sheet sheet = workbook.createSheet("�����");

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("���� ��������");
		header.createCell(1).setCellValue("����� ����������");
		header.createCell(2).setCellValue("������� ��������");
		header.createCell(3).setCellValue("�������");
		header.createCell(4).setCellValue("�����");
		header.createCell(5).setCellValue("�����");
		header.createCell(6).setCellValue("�������� ����������");
		header.createCell(7).setCellValue("�������� ����������");
		header.createCell(8).setCellValue("���������");
		header.createCell(9).setCellValue("���������");

		// Create data cells
		int rowCount = 1;
		for (Supply supply : supplyes) {
			Row supplyRow = sheet.createRow(rowCount++);
			supplyRow.createCell(0).setCellValue(DATE_FORMAT.format(supply.getArrivalDate()));
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
