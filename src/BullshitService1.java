/*

Now lets say we add two more params,

    iphone_version: String, Optional
    ipad_version: String, Optional

    if they are present, start different workflows.
 */

class BullshitService1 {

    public void process(String username, int age, String country, String iphone_version, String ipad_version) {
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

        if (ipad_version != null) {
            response.append(" ipad user");
        }

        if (iphone_version != null) {
            response.append(" iphone user");
        }

        System.out.println(response.toString());
    }

    public static void main(String[] args) {
        new BullshitService1().process("Saba", 18, "US", null, null);
        new BullshitService1().process("Saba", 17, "US", null, null);
        new BullshitService1().process("Saba", 17, "IN", "Iphone X", null);
        new BullshitService1().process("Saba", 27, "IN", null, "iPad 12");
    }
}