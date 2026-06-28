package WEEK1.DesignPattern.FactoryMethodPatternExample;

import javax.print.Doc;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wFactory = new WordDocumentFactory();

        Document wordDoc = wFactory.createDocument();

        wordDoc.open();


        DocumentFactory pFactory = new PdfDocumentFactory();

        Document pdfDoc = pFactory.createDocument();
        pdfDoc.open();


        DocumentFactory eFactory = new ExcelDocumentFactory();

        Document excelDoc = eFactory.createDocument();

        excelDoc.open();

        
    }
}
