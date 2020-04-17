/*
Here i'm going to reverse the control flow such that we don't expose these
internal fields of the Account and also make a code more manageable in general.
 */

class AccountInfo3 {
    String username;
    int age;
    String country;
    String iphoneVersion;
    String ipadVersion;

    public AccountInfo3(String username, int age, String country,
                       String iphoneVersion, String ipadVersion) {
        this.username = username;
        this.age = age;
        this.country = country;
        this.iphoneVersion = iphoneVersion;
        this.ipadVersion = ipadVersion;
    }

    public String getWorkflowToStart() {
        StringBuilder response = new StringBuilder(this.username);
        if (this.country.equals("US")) {
            if (this.age >= 18) {
                response.append(" as a american adult! Murica");
            } else {
                response.append(" as a american minor!");
            }
        } else {
            if (this.age >= 18) {
                response.append(" as a international adult!");
            } else {
                response.append(" as a international minor!");
            }
        }

        if (this.ipadVersion != null) {
            response.append(" ipad user");
        }

        if (this.iphoneVersion != null) {
            response.append(" iphone user");
        }

        return response.toString();
    }
}

class BullshitService3 {

    public void process(AccountInfo3 accountInfo) {
        // This is the workflow that has to be started.
        String response = "Start workflow for " + accountInfo.getWorkflowToStart();
        System.out.println(response);
    }

    public static void main(String[] args) {
        // You are going to punch me in the face and say that all i did was
        // move code from one place to another and that all the
        // original problems [long params, long if-else ladder, those null-check remain.] remain.
        // I would say this refactor is a win, because
        // 1. the logic is now better encapsulated. "No leak" of internal fields.
        // 2. We removed the orignal violation of law of demeter.
        //
        // Now lets do better. May be solve the params and null problem.
        new BullshitService3().process(new AccountInfo3("Saba", 18, "US", null
                , null));
        new BullshitService3().process(new AccountInfo3("Saba", 18, "US",
                "iphone X", null));
        new BullshitService3().process(new AccountInfo3("Saba", 18, "US", null
                , "Ipad 12 user"));
    }
}