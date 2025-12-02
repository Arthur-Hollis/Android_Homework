package com.example.Android_bigWork.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author YourName
 * @Type Favorite
 * @Desc 用户收藏的菜品记录
 */
// 复合主键：确保一个用户不能收藏同一个菜品两次
@Entity(tableName = "favorite_table", primaryKeys = {"username", "dishId"})
public class Favorite {

    @NonNull
    private String username;     // 用户名 (Part of Primary Key)
    private int dishId;          // 菜品 GID (Part of Primary Key)
    private long timestamp;      // 收藏时间

    // 构造函数
    public Favorite(@NonNull String username, int dishId, long timestamp) {
        this.username = username;
        this.dishId = dishId;
        this.timestamp = timestamp;
    }

    // 必须有 Getter 和 Setter (Room 库需要)
    @NonNull
    public String getUsername() { return username; }
    public void setUsername(@NonNull String username) { this.username = username; }
    public int getDishId() { return dishId; }
    public void setDishId(int dishId) { this.dishId = dishId; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}