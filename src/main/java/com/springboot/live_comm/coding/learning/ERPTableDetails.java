package com.springboot.live_comm.coding.learning;

/**
 * @ClassName: ERP
 * @Author : ever
 * @Date :2023/12/27  21:18
 * @Description: TODO
 * @Version :1.0
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//        String url = "jdbc:mysql://47.111.7.171:3306/dhbase_erp2_2";
//                String user = "dh";
//                String password = "dhIoPBnM999";

public class ERPTableDetails {

    public static void main(String[] args) {
        String url = "jdbc:mysql://47.111.7.171:3306/dhbase_erp2_2";
        String user = "dh";
        String password = "dhIoPBnM999";
        String outputPath = "D:\\ZTY\\工作2023-东华\\erp.xlsx";

        Map<String, String> tableNameToCommentMap = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                // 执行SQL查询，获取表名和注释
                String sql = "SELECT table_name '表名', t.table_comment '说明' FROM information_schema.TABLES t WHERE table_schema = 'dhbase_erp2_2' AND table_name LIKE 'erp%'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tableNameToCommentMap.put(rs.getString("tablename"), rs.getString("table_comment"));
                }
            } else {
                System.out.println("Failed to make connection!");
            }

            for (Map.Entry<String, String> entry : tableNameToCommentMap.entrySet()) {
                System.out.println("Table Name: " + entry.getKey() + ", Table Comment: " + entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}