package vn.edu.iuh.fit.wwwduongtuankietgk.enums;

public enum Roles {
    ADMINSTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXECUTIVE(3);

    private int value;

    Roles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
