import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static CustomHashTable readResponsesFromFile(String filePath) {
        CustomHashTable hashTable = new CustomHashTable();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                Response response = parseResponse(line);
                if (response != null) {
                    hashTable.insert(response.getId(), response);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return hashTable;
    }

    private static Response parseResponse(String line) {
        try {
            String[] parts = line.split(",");

            int Id = Integer.parseInt(parts[0].trim());
            int Gender = Integer.parseInt(parts[1].trim());
            int Age = Integer.parseInt(parts[2].trim());
            int Residence = Integer.parseInt(parts[3].trim());
            int Education = Integer.parseInt(parts[4].trim());
            int IncomeSource = Integer.parseInt(parts[5].trim());
            int MaritalStatus = Integer.parseInt(parts[6].trim());
            int Smoker = Integer.parseInt(parts[7].trim());
            int Year = Integer.parseInt(parts[8].trim());
            String Q9 = parts[9].trim();
            int Q10 = Integer.parseInt(parts[10].trim());
            int Q11 = Integer.parseInt(parts[11].trim());
            int Q12 = Integer.parseInt(parts[12].trim());
            int Q13 = Integer.parseInt(parts[13].trim());
            int Q14 = Integer.parseInt(parts[14].trim());
            int Q15 = Integer.parseInt(parts[15].trim());
            String Q16 = parts[16].trim();
            int Q17 = Integer.parseInt(parts[17].trim());
            int Q18 = Integer.parseInt(parts[18].trim());
            int Q19 = Integer.parseInt(parts[19].trim());
            int Q20 = Integer.parseInt(parts[20].trim());
            int Q21 = Integer.parseInt(parts[21].trim());
            int Q22 = Integer.parseInt(parts[22].trim());
            String Q23 = parts[23].trim();
            int Q24 = Integer.parseInt(parts[24].trim());
            int Q25 = Integer.parseInt(parts[25].trim());
            int Q26 = Integer.parseInt(parts[26].trim());
            int Q27 = Integer.parseInt(parts[27].trim());
            int Q28 = Integer.parseInt(parts[28].trim());
            int Q29 = Integer.parseInt(parts[29].trim());
            int Q30 = Integer.parseInt(parts[30].trim());

            return new Response(Id, Gender, Age, Residence, Education, IncomeSource,
                    MaritalStatus, Smoker, Year, Q9, Q10, Q11, Q12, Q13,
                    Q14, Q15, Q16, Q17, Q18, Q19, Q20, Q21, Q22, Q23,
                    Q24, Q25, Q26, Q27, Q28, Q29, Q30);
        } catch (Exception e) {
            System.out.println("Error parsing line: " + line);
            return null;
        }
    }
}