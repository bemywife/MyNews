package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class Daogenerator {

    public static void main(String[] args) throws Exception {
        int version = 1;
        String defaultJavaPackage = "com.fightzhao.news.greendao";
        Schema schema = new Schema(version, defaultJavaPackage);
        addTable(schema);
        // /表示根目录， ./表示当前路径， ../表示上一级父目录
        new DaoGenerator().generateAll(schema, "./app/src/main/java-gen");
    }

    private static void addTable(Schema schema) {
        Entity note = schema.addEntity("NewsChannelTable");
        //        note.addIdProperty();
        /**
         * 频道名称
         */
        note.addStringProperty("newsChannelName").notNull().primaryKey().index();
        /**
         * 频道id
         */
        note.addStringProperty("newsChannelId").notNull();
        /**
         * 频道类型
         */
        note.addStringProperty("newsChannelType").notNull();
        /**
         * 选中的频道
         */
        note.addBooleanProperty("newsChannelSelect").notNull();
        /**
         * 频道的排序位置
         */
        note.addIntProperty("newsChannelIndex").notNull();
        /**
         * 频道是否是固定的
         */
        note.addBooleanProperty("newsChannelFixed");
    }

}
