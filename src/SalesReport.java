import java.io.*;
import java.util.*;

public class SalesReport {
    public static void main(String[] args){

        String filename = "SalesData.txt"; //filename
        int months = 0; //month counter
        double oneMonth; //per month sales
        double totSales = 0.0; //total sales
        double aveSales; //average sales

        try{
            File file = new File(filename);
            Scanner r = new Scanner(file);

            while(r.hasNext()){ //reading through file and updating variables using contents

                oneMonth = r.nextDouble(); //gets a month's sales amount
                totSales+= oneMonth; //adds it to total
                months++; //ups the counter
            }                  //Mennua Netri Herta Davis
            r.close();
            aveSales = totSales / months; //average

            System.out.printf("Number of months: %s\n", months);
            System.out.printf("Total sales: $%,.2f\n", totSales);
            System.out.printf("Average sales: $%,.2f\n", aveSales);


        }catch (FileNotFoundException e){ //file not found be the Scanner call
            System.out.println("The file " + filename + " does not exist.");
        }catch (InputMismatchException e){ //Scanner successfully created and matched to a file, but call type is wrong (nextDouble to a string)
            System.out.println("Nonnumeric data found in the file:" + e.getMessage());
        }
    }
}
