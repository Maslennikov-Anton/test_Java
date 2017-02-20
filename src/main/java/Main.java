import exception.InvalidInputValues;
import exception.NullInputValues;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NullInputValues, IOException, InvalidInputValues {

        File inFile=new File("/home/anton/Java/IdeaProjects/test_Java/src/main/java/puts/INPUT.txt");
        File outFile=new File("/home/anton/Java/IdeaProjects/test_Java/src/main/java/puts/OUTPUT.txt");

        FileWriter writer=new FileWriter(outFile,false);
        Scanner scanner=new Scanner(inFile);

        Helper bolts =new Helper(scanner.nextLine().split(" "));
        Helper gayks =new Helper(scanner.nextLine().split(" "));

        if (!(bolts.checker() && gayks.checker())) throw new InvalidInputValues("Values do not match the condition");

        int bonusCosts;
        if (bolts.notFoundDetails()>gayks.notFoundDetails()){
            bonusCosts=(bolts.notFoundDetails()-gayks.notFoundDetails())*gayks.getPrice();
        }else{
            bonusCosts=(gayks.notFoundDetails()-bolts.notFoundDetails())*bolts.getPrice();
        }

        int allCosts =gayks.costs()+bolts.costs()+bonusCosts/2;

        writer.write(Integer.toString(allCosts));
        writer.flush();
    }
}
