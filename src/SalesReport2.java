import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalesReport2 {
    public static void main(String[] args){

        String filename = "SalesData.txt"; //filename
        int months = 0; //month counter
        double oneMonth; //per month sales
        double totSales = 0.0; //total sales
        double aveSales; //average sales

        Scanner r = openFile(filename);

        while(r == null){
            Scanner s = new Scanner(System.in);
            System.out.print("ERROR: " + filename + " does not exist.\n" + "Enter another file name: ");
            filename = s.nextLine();
            r = openFile(filename);
        }

        try{

            oneMonth = r.nextDouble(); //gets a month's sales amount
            totSales+= oneMonth; //adds it to total
            months++; //ups the counter
                                        //Mennua Netri Herta Davis
        }catch (InputMismatchException e){

            System.out.println("Nonnumeric data found in the file:" + e.getMessage());
            System.out.println("The invalid record will be skipped.");
            r.nextLine();
        }
        r.close();
        aveSales = totSales / months;

        System.out.printf("Number of months: %s\n", months);
        System.out.printf("Total sales: $%,.2f\n", totSales);
        System.out.printf("Average sales: $%,.2f\n", aveSales);
    }

    public static Scanner openFile(String filename){
        Scanner scan;

        try{
            File file =  new File(filename);
            scan = new Scanner(file);
        }catch (FileNotFoundException e){
            scan = null;
        }

        return scan;
    }
}
