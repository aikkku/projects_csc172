import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static CustomHashTable readResponsesFromFile(String filePath) {
        CustomHashTable table = new CustomHashTable();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");

                int Id = Integer.parseInt(fields[0]);
                int Gender = Integer.parseInt(fields[1]);
                int Age = Integer.parseInt(fields[2]);
                int Residence = Integer.parseInt(fields[3]);
                int Education = Integer.parseInt(fields[4]);
                int IncomeSource = Integer.parseInt(fields[5]);
                int MaritalStatus = Integer.parseInt(fields[6]);
                int Smoker = Integer.parseInt(fields[7]);
                int Year = Integer.parseInt(fields[8]);
                String Q9 = fields[9];
                int Q10 = Integer.parseInt(fields[10]);
                int Q11 = Integer.parseInt(fields[11]);
                int Q12 = Integer.parseInt(fields[12]);
                int Q13 = Integer.parseInt(fields[13]);
                int Q14 = Integer.parseInt(fields[14]);
                int Q15 = Integer.parseInt(fields[15]);
                String Q16 = fields[16];
                int Q17 = Integer.parseInt(fields[17]);
                int Q18 = Integer.parseInt(fields[18]);
                int Q19 = Integer.parseInt(fields[19]);
                int Q20 = Integer.parseInt(fields[20]);
                int Q21 = Integer.parseInt(fields[21]);
                int Q22 = Integer.parseInt(fields[22]);
                String Q23 = fields[23];
                int Q24 = Integer.parseInt(fields[24]);
                int Q25 = Integer.parseInt(fields[25]);
                int Q26 = Integer.parseInt(fields[26]);
                int Q27 = Integer.parseInt(fields[27]);
                int Q28 = Integer.parseInt(fields[28]);
                int Q29 = Integer.parseInt(fields[29]);
                int Q30 = Integer.parseInt(fields[30]);

                Response r = new Response(Id, Gender, Age, Residence, Education, IncomeSource, MaritalStatus, Smoker, Year,
                        Q9, Q10, Q11, Q12, Q13, Q14, Q15, Q16, Q17, Q18, Q19, Q20,
                        Q21, Q22, Q23, Q24, Q25, Q26, Q27, Q28, Q29, Q30);

                table.insert(Id, r);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return table;
    }
}