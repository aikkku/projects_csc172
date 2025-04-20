import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SurveyDataAnalyzer{
    public static int[] genderDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                String gender = table.search(i).getGender();
                switch(gender) {
                    case "F": ans[0]++; break;
                    case "M": ans[1]++; break;
                    case "O": ans[2]++; break;
                    case "-": ans[3]++; break;
                }
            }
        }

        return ans;
    }

    public int[] ageGroupDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int age = table.search(i).getAge();
                ans[age-1]++;
            }
        }

        return ans;
    }

    public int[] residenceDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int residence = table.search(i).getResidence();
                ans[residence-1]++;
            }
        }

        return ans;
    }

    public int[] educationDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i)!= null) {
                int education = table.search(i).getEducation();
                ans[education-1]++;
            }
        }

        return ans;
    }

    public int[] incomeDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int incomeSource = table.search(i).getIncomeSource();
                ans[incomeSource-1]++;
            }
        }

        return ans;
    }

    public int[] maritalDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int maritalStatus = table.search(i).getMaritalStatus();
                ans[maritalStatus-1]++;
            }
        }

        return ans;
    }

    public int[] smokerDistribution (CustomHashTable table) {
        int[] ans = new int[2];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int smoker = table.search(i).getSmoker();
                ans[smoker-1]++;
            }
        }

        return ans;
    }

    public double lifeQualityGeneral (CustomHashTable table) {
        double sum = 0;
        int n = 0;

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                double quality = table.search(i).getQuality();
                sum += quality;
                n++;
            }
        }

        return sum/n;
    }

    public double[] lifeQualityGenderBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                String gender = table.search(i).getGender();
                switch(gender) {
                    case "F": ans[0] += table.search(i).getQuality(); break;
                    case "M": ans[1] += table.search(i).getQuality(); break;
                    case "O": ans[2] += table.search(i).getQuality(); break;
                    case "-": ans[3] += table.search(i).getQuality(); break;
                }
            }
        }

        int[] count = genderDistribution(table);

        for(int i = 0; i < 4; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public double[] lifeQualityAgeBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int age = table.search(i).getAge();
                ans[age-1] += table.search(i).getQuality();
            }
        }

        int[] count = ageGroupDistribution(table);

        for(int i = 0; i < 4; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public double[] lifeQualityResidenceBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int residence = table.search(i).getResidence();
                ans[residence-1] += table.search(i).getQuality();
            }
        }

        int[] count = residenceDistribution(table);

        for(int i = 0; i < 4; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public double[] lifeQualityEducationBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int education = table.search(i).getEducation();
                ans[education-1] += table.search(i).getQuality();
            }
        }

        int[] count = educationDistribution(table);

        for(int i = 0; i < 4; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public double[] lifeQualityIncomeBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int incomeSource = table.search(i).getIncomeSource();
                ans[incomeSource-1] += table.search(i).getQuality();
            }
        }

        int[] count = incomeDistribution(table);

        for(int i = 0; i < 4; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public double[] lifeQualityMaritalBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int maritalStatus = table.search(i).getMaritalStatus();
                ans[maritalStatus-1] += table.search(i).getQuality();
            }
        }

        int[] count = maritalDistribution(table);

        for(int i = 0; i < 4; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public double[] lifeQualitySmokerBased (CustomHashTable table) {
        double[] ans = new double[2];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int smoker = table.search(i).getSmoker();
                ans[smoker-1] += table.search(i).getQuality();
            }
        }

        int[] count = smokerDistribution(table);

        for(int i = 0; i < 2; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public String[] mostCommonTreatment (CustomHashTable table) {
        String[] ans = new String[5];

        int s = 0, c = 0, r = 0, i = 0, m = 0;

        for (int j = 0; j < table.size(); j++) {
            if (table.search(j) != null) {
                String temp = table.search(j).getQ9();
                for(int z = 0; z < temp.length(); z++) {
                    if (temp.charAt(z) >= 'A' && temp.charAt(z) <= 'Z'){
                        switch (temp.charAt(z)) {
                            case 'S': s++; break;
                            case 'C': c++; break;
                            case 'R': r++; break;
                            case 'I': i++; break;
                            case 'M': m++; break;
                        }
                    }
                }
            }
        }

        Map<String, Integer> map = new TreeMap<String, Integer>();

        map.put("Surgical", s);
        map.put("Chemotherapy", c);
        map.put("Radiotherapy", r);
        map.put("Immunotherapy", i);
        map.put("Molecularly targeted therapy", m);


        Iterator<String> iter = map.keySet().iterator();
        int g = 4;

        while(iter.hasNext()){
            ans[g] = iter.next();
            g--;
        }

        return ans;
    }

    public String[] mostCommonSymptoms (CustomHashTable table) {
        String[] ans = new String[6];

        int[] count = new int[6];

        for (int j = 0; j < table.size(); j++) {
            if (table.search(j) != null) {
                String temp = table.search(j).getQ9();
                String[] symptoms = temp.split("[;]");
                for(int i = 0; i < symptoms.length; i++){
                    switch (symptoms[i]){
                        case "Cough": count[0]++; break;
                        case "Hoarseness": count[1]++; break;
                        case "Coughing up blood": count[2]++; break;
                        case "Chest pain": count[3]++; break;
                        case "Shortness of breath": count[4]++; break;
                        case "Weakness": count[5]++; break;
                    }
                }
            }
        }

        Map<String, Integer> map = new TreeMap<String, Integer>();

        map.put("Cough", count[0]);
        map.put("Hoarseness", count[1]);
        map.put("Coughing up blood", count[2]);
        map.put("Chest pain", count[3]);
        map.put("Shortness of breath", count[4]);
        map.put("Weakness", count[5]);


        Iterator<String> iter = map.keySet().iterator();
        int g = 5;

        while(iter.hasNext()){
            ans[g] = iter.next();
            g--;
        }

        return ans;
    }

    public String[] mostCommonLifeAspects (CustomHashTable table) {
        String[] ans = new String[5];

        int[] count = new int[5];

        for (int j = 0; j < table.size(); j++) {
            if (table.search(j) != null) {
                String temp = table.search(j).getQ9();
                String[] aspects = temp.split("[;]");
                for (String symptom : aspects) {
                    switch (symptom) {
                        case "Physical aspect":
                            count[0]++;
                            break;
                        case "Psychological aspect":
                            count[1]++;
                            break;
                        case "Professional life":
                            count[2]++;
                            break;
                        case "Family life":
                            count[3]++;
                            break;
                        case "Social life":
                            count[4]++;
                            break;
                    }
                }
            }
        }

        Map<String, Integer> map = new TreeMap<String, Integer>();

        map.put("Physical aspect", count[0]);
        map.put("Psychological aspect", count[1]);
        map.put("Professional life", count[2]);
        map.put("Family life", count[3]);
        map.put("Social life", count[4]);


        Iterator<String> iter = map.keySet().iterator();
        int g = 4;

        while(iter.hasNext()){
            ans[g] = iter.next();
            g--;
        }

        return ans;
    }

    public double[] lifeQualityMixConditionsBased (CustomHashTable table) {
        double[] ans = new double[2];
        int a = 0, b = 0;

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int maritalStatus = table.search(i).getMaritalStatus();
                int residence = table.search(i).getResidence();

                if(maritalStatus == 1 && residence == 4) {
                    ans[0] += table.search(i).getQuality();
                    a++;
                } else if(maritalStatus == 2 && (residence == 2 || residence == 1)){
                    ans[1] += table.search(i).getQuality();
                    b++;
                }
            }
        }

        ans[0] /= a;
        ans[1] /= b;

        return ans;
    }

    public double[] lifeQualityResponseBased (CustomHashTable table) {
        double[] ans = new double[4];
        int[] count = new int[4];

        for (int i = 0; i < table.size(); i++) {
            if (table.search(i) != null) {
                int q15 = table.search(i).getQ15();
                ans[q15-1] += table.search(i).getQuality();
                count[q15-1] ++;
            }
        }

        for(int i = 0; i < 4; i ++) {
            ans[i] /= count[i];
        }


        return ans;
    }

}
