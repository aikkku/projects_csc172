public class Response {
    private int Id;
    private String Gender;
    private int Age;
    private int Residence;
    private int Education;
    private int IncomeSource;
    private int MaritalStatus;
    private int Smoker;
    private int Year;
    private String Q9;
    private int Q10;
    private int Q11;
    private int Q12;
    private int Q13;
    private int Q14;
    private int Q15;
    private String Q16;
    private int Q17;
    private int Q18;
    private int Q19;
    private int Q20;
    private int Q21;
    private int Q22;
    private String Q23;
    private int Q24;
    private int Q25;
    private int Q26;
    private int Q27;
    private int Q28;
    private int Q29;
    private int Q30;
    private int Quality;

    public Response (int Id, int Gender, int Age, int Residence, int Education,
                     int IncomeSource, int MaritalStatus, int Smoker, int Year,
                     String Q9, int Q10, int Q11, int Q12, int Q13, int Q14,
                     int Q15, String Q16, int Q17, int Q18, int Q19, int Q20,
                     int Q21, int Q22, String Q23, int Q24, int Q25, int Q26,
                     int Q27, int Q28, int Q29, int Q30) {
        this.Id = Id;
        switch(Gender) {
            case 1: this.Gender = "F"; break;
            case 2: this.Gender = "M"; break;
            case 3: this.Gender = "O"; break;
            default: this.Gender = "-"; break;
        }
        this.Age = Age;
        this.Residence = Residence;
        this.Education = Education;
        this.IncomeSource = IncomeSource;
        this.MaritalStatus = MaritalStatus;
        this.Smoker = Smoker;
        this.Year = Year;
        this.Q9 = Q9;
        this.Q10 = Q10;
        this.Q11 = Q11;
        this.Q12 = Q12;
        this.Q13 = Q13;
        this.Q14 = Q14;
        this.Q15 = Q15;
        this.Q16 = Q16;
        this.Q17 = Q17;
        this.Q18 = Q18;
        this.Q19 = Q19;
        this.Q20 = Q20;
        this.Q21 = Q21;
        this.Q22 = Q22;
        this.Q23 = Q23;
        this.Q24 = Q24;
        this.Q25 = Q25;
        this.Q26 = Q26;
        this.Q27 = Q27;
        this.Q28 = Q28;
        this.Q29 = Q29;
        this.Q30 = Q30;
        this.Quality = Q13 + Q14 + Q15 + Q17 + Q18 + Q19 + Q21 + Q22 +
                Q24 + Q25 + Q26 + Q27 + Q28 + Q29 + Q30;

    }

    public int getId() {
        return Id;
    }
    public String getGender() {
        return Gender;
    }
    public int getAge() {
        return Age;
    }
    public int getResidence() {
        return Residence;
    }
    public int getEducation(){
        return Education;
    }
    public int getIncomeSource(){
        return IncomeSource;
    }
    public int getMaritalStatus(){
        return MaritalStatus;
    }
    public int getSmoker() {
        return Smoker;
    }
    public int getYear() {
        return Year;
    }
    public String getQ9(){
        return Q9;
    }
    public int getQ10(){
        return Q10;
    }
    public int getQ11(){
        return Q11;
    }
    public int getQ12(){
        return Q12;
    }
    public int getQ13(){
        return Q13;
    }
    public int getQ14(){
        return Q14;
    }
    public int getQ15(){
        return Q15;
    }
    public String getQ16(){
        return Q16;
    }
    public int getQ17(){
        return Q17;
    }
    public int getQ18(){
        return Q18;
    }
    public int getQ19(){
        return Q19;
    }
    public int getQ20(){
        return Q20;
    }
    public int getQ21(){
        return Q21;
    }
    public int getQ22(){
        return Q22;
    }
    public String getQ23(){
        return Q23;
    }
    public int getQ24(){
        return Q24;
    }
    public int getQ25(){
        return Q25;
    }
    public int getQ26(){
        return Q26;
    }
    public int getQ27(){
        return Q27;
    }
    public int getQ28(){
        return Q28;
    }
    public int getQ29(){
        return Q29;
    }
    public int getQ30(){
        return Q30;
    }
    public int getQuality(){
        return Quality;
    }

    public void printResponse() {
        System.out.printf(
                "Response ID: %d Gender: %s Age group: %d Place of residence: %d " +
                        "Education level: %d Source of income: %d Marital status: %d Smoker: %s",
                Id, Gender, Age, Residence, Education, IncomeSource, MaritalStatus,
                Smoker == 1 ? "Yes" : "No"
        );
    }
}
