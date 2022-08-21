package com.support.Utils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.support.Entitis.Ticket;


public class ExcelGenerator {

    private List < Ticket > studentList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List < Ticket > studentList) {
        this.studentList = studentList;
        workbook = new XSSFWorkbook();

    }
    private void writeHeader() {
        sheet = workbook.createSheet("Student");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Machine Id", style);
        createCell(row, 2, "Machine Familly ", style);
        createCell(row, 3, "Issuer User name.", style);
        createCell(row, 3, "Resever User name.", style);
        createCell(row, 3, "Stats.", style);
        createCell(row, 3, "BreakDown Type.", style);
        createCell(row, 3, "Issue Date.", style);
        createCell(row, 3, "Take Date.", style);
        createCell(row, 3, "Close Date.", style);
        createCell(row, 3, "Titel Date.", style);
        createCell(row, 3, "Description Date.", style);
        createCell(row, 3, "Observetion Date.", style);
    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(Objects.isNull(valueOfCell)){
            cell.setCellValue("Empty");
        }
        else if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell instanceof Date) {
            Date  obj=(Date) valueOfCell;
            
            cell.setCellValue((String) obj.toString());
        }
        else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Ticket record: studentList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId().substring(0,4), style);
            createCell(row, columnCount++, record.getMachine().getId(), style);
            createCell(row, columnCount++, record.getMachine().getFamily().getId(), style);
            createCell(row, columnCount++, record.getMachine().getFamily().getName(), style);
            createCell(row, columnCount++, record.getUser().getUsername(), style);

            if(! Objects.isNull(record.getTecnesstion())){
                createCell(row, columnCount++, record.getTecnesstion().getUsername(), style);
            }else{
                createCell(row, columnCount++,"Empty", style);

            }

            createCell(row, columnCount++, record.getStatus().name(), style);
            createCell(row, columnCount++, record.getBreakdown().getType(), style);
            createCell(row, columnCount++, record.getIssueDate(), style);
            createCell(row, columnCount++, record.getTakeDate(), style);
            createCell(row, columnCount++, record.getCloseDate(), style);
            createCell(row, columnCount++, record.getTitel(), style);
            createCell(row, columnCount++, record.getDescrption(), style);
            createCell(row, columnCount++, record.getObservetion(), style);
        }

    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

}