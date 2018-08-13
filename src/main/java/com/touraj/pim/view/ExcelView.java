package com.touraj.pim.view;

import com.touraj.pim.domain.Product;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by toraj on 08/11/2018.
 */
public class ExcelView extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"products.xls\"");

        List<Product> products = (List<Product>) model.get("products");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Product Detail");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ZamroID");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Name");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Description");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("MinOrderQuantity");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("UnitOfMeasure");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("CategoryID");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("PurchasePrice");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Available");
        header.getCell(7).setCellStyle(style);

//        Create Real Rows
        int rowCount = 1;
        for(Product product : products){
            Row userRow =  sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(product.getZamroid());
            userRow.createCell(1).setCellValue(product.getName());
            userRow.createCell(2).setCellValue(product.getDescription());
            userRow.createCell(3).setCellValue(product.getMinorderquantity());
            userRow.createCell(4).setCellValue(product.getUnitofmeasure());
            userRow.createCell(5).setCellValue(product.getCategory().getCategoryid());
            userRow.createCell(6).setCellValue(product.getPurchaseprice());
            userRow.createCell(7).setCellValue(product.isAvailable());
        }
    }
}