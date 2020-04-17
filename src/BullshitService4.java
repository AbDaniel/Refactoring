/* Lets refactor to achieve better abstraction.*/


import java.util.ArrayList;
import java.util.List;

interface Account {
    String getWorkflowToStart();
}

class BasicAccount implements Account {
    // Basic account only the has the necessary fields. No optionals.

    String username;
    int age;
    String country;

    public BasicAccount(String username, int age, String country) {
        this.username = username;
        this.age = age;
        this.country = country;
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
        return response.toString();
    }
}

class IPhoneUserAccount extends BasicAccount {

    String iphoneVersion;

    public IPhoneUserAccount(
            String username, int age, String country, String iphoneVersion) {
        super(username, age, country);
        this.iphoneVersion = iphoneVersion;
    }

    public String getWorkflowToStart() {
        return super.getWorkflowToStart() + (
                " iphone user, with version " + this.iphoneVersion);
    }
}

class IPadUserAccount extends BasicAccount {

    String ipadVersion;

    public IPadUserAccount(
            String username, int age, String country, String ipadVersion) {
        super(username, age, country);
        this.ipadVersion = ipadVersion;
    }

    public String getWorkflowToStart() {
        return super.getWorkflowToStart() + (
                " iphone user, with version " + this.ipadVersion);
    }
}

class MultipleDeviceAccount extends BasicAccount {
    List<String> devices;

    public MultipleDeviceAccount(String username, int age, String country,
                                 List<String> devices) {
        super(username, age, country);
        this.devices = devices;
    }

    public String getWorkflowToStart() {
        return super.getWorkflowToStart() + " i got shit tone of device.";
    }
}


class BullshitService4 {

    public void process(BasicAccount accountInfo) {
        // This is the workflow that has to be started.
        String response =
                "Start workflow for " + accountInfo.getWorkflowToStart();
        System.out.println(response);
    }

    public static void main(String[] args) {
        // WTF! No usage of nulls. [That is unavoidable in builder] + plus we
        // also improved the control flow.
        // 1. Better encapsulation.
        // 2. control flow.
        // 3. no violation of law of demeter.
        // 4. easily extendedable.
        // --------
        // One major thing though. I don't really like creating sub-classes from
        // concrete classes. So ideally i would remove the inhertiance relation
        // between BasicAccount and its subclasses.
        // See "Composition over inheritance". But rest of the structure would
        // remain the same.
        BasicAccount basic = new BasicAccount("Saba", 18, "US");
        IPhoneUserAccount iphone = new IPhoneUserAccount("Saba", 18, "US",
                "Iphone X");
        IPadUserAccount ipad = new IPadUserAccount("Saba", 18, "IN", "Ipad 12");
        MultipleDeviceAccount multidevice = new MultipleDeviceAccount(
                "Saba", 18, "US", new ArrayList<>());

        new BullshitService4().process(basic);
        new BullshitService4().process(iphone);
        new BullshitService4().process(ipad);
        new BullshitService4().process(multidevice);
    }
}
