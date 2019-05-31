public class ThirdHomeWork {
    public static void main(String[] args) {
        int[] a = {0, 2, 2, 3, 4, 4, 6};
        int[] b = {1, 23, 278};

        for (int i : mergeArrays(a, b)) {
            System.out.print(i + " ");
        }

        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич",
                "Ревизор",
                "Лука"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: " +
                "к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Аммос Федорович: Вот это да-а-а!",
                "Городничий: Городничий: Ревизор! Ревизор! Ревизор!",
                "Лука: ... с секретным предписаньем!"};

        System.out.print(printTextPerRole(roles, textLines));
    }

    public static int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int arrayLength = firstArray.length + secondArray.length;
        int[] resultArray = new int[arrayLength];
        int i = 0, j = 0, k = 0;

        while (i < firstArray.length || j < secondArray.length) {
            if (i < firstArray.length && j < secondArray.length) {
                if (firstArray[i] < secondArray[j]) {
                    resultArray[k] = firstArray[i];
                    ++i;
                    ++k;
                } else {
                    resultArray[k] = secondArray[j];
                    ++j;
                    ++k;
                }
            } else if (j == secondArray.length) {
                resultArray[k] = firstArray[i];
                ++i;
                ++k;
            } else if (i == firstArray.length) {
                resultArray[k] = secondArray[j];
                ++j;
                ++k;
            }
        }
        return resultArray;
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < roles.length; i++) {
            String role = roles[i] + ":";
            result.append(role);

            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(role)) {
                    result.append("\n").append(j + 1).append(") ").append(textLines[j].substring(role.length() + 1));
                }
                if (j == textLines.length - 1 && i != roles.length - 1) {
                    result.append("\n");
                }
            }
            if (i < roles.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
