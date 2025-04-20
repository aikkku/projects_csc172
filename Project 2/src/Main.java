import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomHashTable myTable = new CustomHashTable();
        myTable = ReadFile.readResponsesFromFile("src/responses.txt");
        myTable.printHT();
//        System.out.println(Arrays.toString(SurveyDataAnalyzer.genderDistribution(myTable)));
    }
}