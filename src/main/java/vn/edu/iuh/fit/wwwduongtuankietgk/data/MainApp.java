package vn.edu.iuh.fit.wwwduongtuankietgk.data;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.wwwduongtuankietgk.repositories.ConnectDB;

public class MainApp {
    public static void main(String[] args) {
        EntityManager entityManager = ConnectDB.getInstance().getEntityManager();
        entityManager.close();
    }
}
