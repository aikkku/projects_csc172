public class Main {
    public static void main(String[] args) {
        CustomHashTable myTable = new CustomHashTable();
        ReadFile.readResponsesFromFile("/Users/asilbek/Desktop/projects_csc172/Project 2/src/responses.txt");
        myTable.printHT();

    }
}