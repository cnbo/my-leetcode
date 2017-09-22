## Valid Phone Numbers

Given a text file ``file.txt`` that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.

For example, assume that ``file.txt`` has the following content:

- 987-123-4567
- 123 456 7890
- (123) 456-7890

Your script should output the following valid phone numbers:

- 987-123-4567
- (123) 456-7890

## 代碼實現

```
public class Solution {	
    private static String REGEX_1 = "(\\d{3}-){2}\\d{4}";
    private static String REGEX_2 = "\\(\\d{3}\\) \\d{3}-\\d{4}";

    public static void printValidPhoneNumber() {
        List<String> phoneNumbers = getPhoneNumber();
        for (String number : phoneNumbers) {
            if (isValidPhone(number)) {
                System.out.println(number);
            }
        }
    }

    public static boolean isValidPhone(String number) {
        return number.matches(REGEX_1) || number.matches(REGEX_2);
    }

    public static List<String> getPhoneNumber() {
        BufferedReader br = null;
        List<String> numbers = new ArrayList<String>();
        try {
            br = new BufferedReader(
new FileReader(new File("D:\\javaproject\\hubo\\src\\file.txt")));
            String number = "";
            while ((number = br.readLine()) != null) {
                numbers.add(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return numbers;
    }
}
```
