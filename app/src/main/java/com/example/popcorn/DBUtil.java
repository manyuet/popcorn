package com.example.popcorn;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.popcorn.entity.Record;
import com.example.popcorn.entity.StatisticRecord;
import com.example.popcorn.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DBUtil {
    private DBUtil() {
    }

    private static List<User> users = new ArrayList<>();

    private static List<Record> records = new ArrayList<>();

    static {
        User defaultUser = new User();
        defaultUser.setUsername("admin");
        defaultUser.setPassword("123456");
        users.add(defaultUser);
    }

    // 保存登录后的用户名
    public static String loginUsername;

    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public static boolean loginUser(String username, String password) {
        // 这里登录成功后是不是要保存一下，登录后的用户名是什么？
        User user = getUserByUsername(username);
        if(user == null) return false;
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            loginUsername = username;
            return true;
        }
        return false;

    }

    /**
     * 新增用户
     *
     * @param username
     * @param password
     * @return
     */
    public static boolean addUser(String username, String password) {
        // 1. 判断有没有存在相同的username
        if (getUserByUsername(username) != null) return false;
        // 2. 插入新用户
        User user = new User(username, password);
        users.add(user);
        return true;
    }

    /**
     * 获取用户的记账记录
     * @param username
     * @return
     */
    public static List<Record> getRecordsByUsername(String username){
        // 用来存符合条件的结果
        List<Record> result = new LinkedList<>();
        // 遍历所有的记账记录
        for(Record record : records){
            // 如果这一条记账记录的用户名等于我们查询的用户名，就记录到result list中
            if(username.equals(record.getUsername())){
                result.add(record);
            }
        }
        // 返回查询结果
        return result;
    }

    /**
     * 添加记账记录
     * @param record
     */
    // 要是static类型的方法才能直接用DBUtil.来调用
    public static void addRecord(Record record){
        //传进来的record对象里面的属性已经有值了
        // 把传进来的record放进records里，也就是向保存所有记账记录的list里面添加一天新添加的记账记录
        records.add(record);
    }

    public static List<Record> getRecordsByUsernameAndTag(String username,String tag){
        List<Record> result=new LinkedList<>();
        for (Record record:records){
            if(username.equals(record.getUsername())&&tag.toLowerCase().equals(record.getTag().toLowerCase())){
                result.add(record);
            }
        }
        return result;
    }

    public static List<StatisticRecord> countAllTagAmount(String username){
        Map<String,Double> counter = new HashMap<>();
        for(Record record:records){
            if(!record.getUsername().equals(username))continue;
            if(!counter.containsKey(record.getTag())){
                counter.put(record.getTag(), Double.valueOf(0));
            }
            counter.put(record.getTag(), counter.get(record.getTag())+record.getAmount());
        }
        List<StatisticRecord> result = new ArrayList<>();
        for(Map.Entry<String,Double> entry:counter.entrySet()){
            StatisticRecord record = new StatisticRecord();
            record.setTag(entry.getKey());
            record.setAmount(entry.getValue());
            result.add(record);
        }
        return result;
    }


}
