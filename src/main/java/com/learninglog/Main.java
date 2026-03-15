package com.learninglog;
import java.sql.SQLException;

import com.learninglog.view.View;

public class Main {
    public static void main(String[] args) throws SQLException {
        View obj = new View();
        obj.startProgram();
    }
}