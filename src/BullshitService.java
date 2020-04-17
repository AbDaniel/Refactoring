/*Disclaimer: Its been really long since I touched Java, my code is very rusty.

Consider this following service, it accepts details about a user account and based on the details it starts
a corresponding workflow.

   account details are:
      username: String, not optional.
      age:      int, not optional.
      country:  String, not optional. [in real this might be a enum, but lets make this simple.]

   There are 4 types of workflows based on the account details.
      1. If user is in US.
         1. 1 User is an adult [age >= 18], start adult american workflow.
         1. 2 User is a minor [age < 18], start minor american workflow.
      2. If user is in outside US
         1. 1 User is an adult [age >= 18], start adult international workflow.
         1. 2 User is a minor [age < 18], start minor international workflow.


 */

public class BullshitService {

    public void process(String username, int age, String country) {
        StringBuilder response = new StringBuilder("Start workflow for ");
        response.append(username);
        if (country.equals("US")) {
            if (age >= 18) {
                response.append(" as a american adult! Murica");
            }
            else {
                response.append(" as a american minor!");
            }
        }
        else {
            if (age >= 18) {
                response.append(" as a international adult!");
            }
            else {
                response.append(" as a international minor!");
            }
        }
        System.out.println(response.toString());
    }

    public static void main(String[] args) {
        new BullshitService().process("Saba", 18, "US");
        new BullshitService().process("Saba", 17, "US");
        new BullshitService().process("Saba", 17, "IN");
    }
}