import java.util.*;

public class SurveyDataAnalyzer{
    public static int[] genderDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static int[] ageGroupDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                int age = table.search(i).getAge();
                ans[age-1]++;
            }
        }

        return ans;
    }

    public static int[] residenceDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                int residence = table.search(i).getResidence();
                ans[residence-1]++;
            }
        }

        return ans;
    }

    public static int[] educationDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i)!= null) {
                int education = table.search(i).getEducation();
                ans[education-1]++;
            }
        }

        return ans;
    }

    public static int[] incomeDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                int incomeSource = table.search(i).getIncomeSource();
                ans[incomeSource-1]++;
            }
        }

        return ans;
    }

    public static int[] maritalDistribution (CustomHashTable table) {
        int[] ans = new int[4];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                int maritalStatus = table.search(i).getMaritalStatus();
                ans[maritalStatus-1]++;
            }
        }

        return ans;
    }

    public static int[] smokerDistribution (CustomHashTable table) {
        int[] ans = new int[2];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                int smoker = table.search(i).getSmoker();
                ans[1 - smoker]++;
            }
        }

        return ans;
    }

    public static double lifeQualityGeneral (CustomHashTable table) {
        double sum = 0;
        int n = 0;

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                double quality = table.search(i).getQuality();
                sum += quality;
                n++;
            }
        }

        return sum/n;
    }

    public static double[] lifeQualityGenderBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualityAgeBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualityResidenceBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualityEducationBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualityIncomeBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualityMaritalBased (CustomHashTable table) {
        double[] ans = new double[4];

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualitySmokerBased (CustomHashTable table) {
        double[] ans = new double[2];

        for (int i = 0; i <= table.size(); i++) {
            if (table.search(i) != null) {
                int smoker = table.search(i).getSmoker();
                ans[1 - smoker] += table.search(i).getQuality();
            }
        }

        int[] count = smokerDistribution(table);

        for(int i = 0; i < 2; i++) {
            ans[i] /= count[i];
        }

        return ans;
    }

    public static String[] mostCommonTreatment (CustomHashTable table) {
        String[] ans = new String[5];

        int s = 0, c = 0, r = 0, i = 0, m = 0;

        for (int j = 0; j <= table.size(); j++) {
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

        Map<String, Integer> map = new HashMap<>();
        map.put("Surgical", s);
        map.put("Chemotherapy", c);
        map.put("Radiotherapy", r);
        map.put("Immunotherapy", i);
        map.put("MolecularlyTargetedTherapy", m);

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (int j = 0; j < sortedEntries.size(); j++) {
            ans[j] = sortedEntries.get(j).getKey();
        }

        return ans;
    }

    public static String[] mostCommonSymptoms (CustomHashTable table) {
        String[] ans = new String[6];

        int[] count = new int[6];

        for (int j = 0; j <= table.size(); j++) {
            if (table.search(j) != null) {
                String temp = table.search(j).getQ16();
                String[] symptoms = temp.split("[;]");
                for (String symptom : symptoms) {
                    switch (symptom) {
                        case "Cough":
                            count[0]++;
                            break;
                        case "Hoarseness":
                            count[1]++;
                            break;
                        case "CoughingUpBlood":
                            count[2]++;
                            break;
                        case "ChestPain":
                            count[3]++;
                            break;
                        case "ShortnessOfBreath":
                            count[4]++;
                            break;
                        case "Weakness":
                            count[5]++;
                            break;
                    }
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();

        map.put("Cough", count[0]);
        map.put("Hoarseness", count[1]);
        map.put("CoughingUpBlood", count[2]);
        map.put("ChestPain", count[3]);
        map.put("ShortnessOfBreath", count[4]);
        map.put("Weakness", count[5]);

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue())); // sort by value descending

        for (int j = 0; j < sortedEntries.size(); j++) {
            ans[j] = sortedEntries.get(j).getKey();
        }

        return ans;
    }

    public static String[] mostCommonLifeAspects (CustomHashTable table) {
        String[] ans = new String[5];

        int[] count = new int[5];

        for (int j = 0; j <= table.size(); j++) {
            if (table.search(j) != null) {
                String temp = table.search(j).getQ23();
                String[] aspects = temp.split("[;]");
                for (String aspect : aspects) {
                    switch (aspect) {
                        case "PhysicalAspect":
                            count[0]++;
                            break;
                        case "PsychologicalAspect":
                            count[1]++;
                            break;
                        case "ProfessionalLife":
                            count[2]++;
                            break;
                        case "FamilyLife":
                            count[3]++;
                            break;
                        case "SocialLife":
                            count[4]++;
                            break;
                    }
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();

        map.put("PhysicalAspect", count[0]);
        map.put("PsychologicalAspect", count[1]);
        map.put("ProfessionalLife", count[2]);
        map.put("FamilyLife", count[3]);
        map.put("SocialLife", count[4]);

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((b, a) -> a.getValue().compareTo(b.getValue()));

        for (int j = 0; j < sortedEntries.size(); j++) {
            ans[j] = sortedEntries.get(j).getKey();
        }

        return ans;
    }

    public static double[] lifeQualityMixConditionsBased (CustomHashTable table) {
        double[] ans = new double[2];
        int a = 0, b = 0;

        for (int i = 0; i <= table.size(); i++) {
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

    public static double[] lifeQualityResponseBased (CustomHashTable table) {
        double[] ans = new double[4];
        int[] count = new int[4];

        for (int i = 0; i <= table.size(); i++) {
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
