/*

Lets fix the growing parameter by introducing a data object "AccountInfo"

 */

class AccountInfo {
    // Hate java for this bullshit. These fields should be private by default.
    String username;
    int age;
    String country;
    String iphoneVersion;
    String ipadVersion;

    // Seriously bullshit boilerplate this constructor is.
    public AccountInfo(String username, int age, String country,
                       String iphoneVersion, String ipadVersion) {
        this.username = username;
        this.age = age;
        this.country = country;
        this.iphoneVersion = iphoneVersion;
        this.ipadVersion = ipadVersion;
    }
}

class BullshitService2 {

    public void process(AccountInfo accountInfo) {
        StringBuilder response = new StringBuilder("Start workflow for ");
        if (accountInfo.country.equals("US")) {
            if (accountInfo.age >= 18) {
                response.append(accountInfo.username).append(
                        " as a american adult! Murica");
            } else {
                response.append(accountInfo).append(" as a american minor!");
            }
        } else {
            if (accountInfo.age >= 18) {
                response.append(accountInfo).append(" as a international " +
                        "adult!");
            } else {
                response.append(accountInfo).append(" as a international " +
                        "minor!");
            }
        }

        // I'll let you decide the reasoning behind why this kind of usage of
        // null check is BAD.
        // This is not a normal null check which we have to avoid null pointer
        // errors.
        // Read the apologies section: https://en.wikipedia.org/wiki/Tony_Hoare#Apologies_and_retractions
        if (accountInfo.ipadVersion != null) {
            response.append(" ipad user");
        }

        if (accountInfo.iphoneVersion != null) {
            response.append(" iphone user");
        }

        // This is the workflow that has to be started.
        System.out.println(response.toString());
    }

    public static void main(String[] args) {
        // These additional and potentially growing optional params were the
        // problem that you had cited, and proposed to builder pattern to fix
        // it. But for me the bigger issue with this code is above process
        // function.
        // 1. It breaks encapsulation of AccountInfo by access the private fields.* [though its debatable].
        // 2. Adding more rules and new conditions are only going to make the method too big to manage.
        //
        // Let me try to fix those problems by a little invertion of control in the next refactor.

        new BullshitService2().process(new AccountInfo("Saba", 18, "US", null
                , null));
        new BullshitService2().process(new AccountInfo("Saba", 18, "US",
                "iphone X", null));
        new BullshitService2().process(new AccountInfo("Saba", 18, "US", null
                , "Ipad 12 user"));
    }
}