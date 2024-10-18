package vn.edu.iuh.fit.wwwduongtuankietgk.enums;

import jakarta.persistence.Embeddable;

public enum Roles {

    ADMINSTRATION(0),
    STAFF(1),
    MANAGER(2),
    EXCUTIVE(3);
    private int value;
    Roles(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
