package WEEK1.DesignPattern.FactoryMethodPatternExample;


interface Document {
    void open();
} 

class WordDocument implements Document{
    public void open(){
        System.out.println("WordDocument open successfully");
    }
}


class PdfDocument implements Document{
    
    public void open(){
        System.out.println("Pdf Document open successfully");
    }
}


class ExcelDocument implements Document{
    public void open(){
        System.out.println("Excel document open successfully");
    }
}



abstract class DocumentFactory{

    abstract Document createDocument();

}


class WordDocumentFactory extends DocumentFactory{

    public Document createDocument(){
        return new WordDocument();
    }

}


class PdfDocumentFactory extends DocumentFactory{

    public Document createDocument(){
        return new PdfDocument();
    }
}


class ExcelDocumentFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();

    }
}



public class DocumentManagementFactory {
    
    public static void main(String args[]){
        
    }
}