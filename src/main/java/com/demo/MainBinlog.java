package com.demo;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;

import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2022/8/18 22:32
 */
public class MainBinlog {
    public static void main(String[] args) {
        BinaryLogClient client = new BinaryLogClient("ecs01", 3306, "test", "test");
        client.setServerId(123454);
        client.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof TableMapEventData) {
                System.out.println("Table:");
                TableMapEventData tableMapEventData = (TableMapEventData) data;
                System.out.println(tableMapEventData.getTableId()+": ["+tableMapEventData.getDatabase() + "-" + tableMapEventData.getTable()+"]");
            }
            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update:");
                System.out.println(data);
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("Insert:");
                System.out.println(data);
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete:");
                System.out.println(data);
            }
        });

        try {
            client.connect();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
