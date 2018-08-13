package com.touraj.pim.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.touraj.pim.domain.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by toraj on 08/11/2018.
 */
public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"products.pdf\"");

        List<Product> products = (List<Product>) model.get("products");
        document.add(new Paragraph("Products " + LocalDate.now()));

        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // Create table headers
        cell.setPhrase(new Phrase("ZamroID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Description", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("MinOrderQuantity", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("UnitOfMeasure", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("CategoryID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("PurchasePrice", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Available", font));
        table.addCell(cell);

        // Write real rows
        for(Product product : products){
            table.addCell(String.valueOf(product.getZamroid()));
            table.addCell(product.getName());
            table.addCell(product.getDescription());
            table.addCell(String.valueOf(product.getMinorderquantity()));
            table.addCell(product.getUnitofmeasure());
            table.addCell(String.valueOf(product.getCategory().getCategoryid()));
            table.addCell(String.valueOf(product.getPurchaseprice()));
            table.addCell(String.valueOf(product.isAvailable()));
        }
        document.add(table);
    }
}
