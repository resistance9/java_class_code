package inclass_code.w9;

interface PhoneInterface {
    int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    void flash();
    default void printLogo() {
        System.out.println("** Phone **");
    }
}

class SamsungPhone implements PhoneInterface {
    @Override
    public void sendCall() {
        System.out.println("띠리리리링");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화가 왔습니다.");
    }

    @Override
    public void flash() {
        System.out.println("전화기에 불이 켜졌습니다.");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}