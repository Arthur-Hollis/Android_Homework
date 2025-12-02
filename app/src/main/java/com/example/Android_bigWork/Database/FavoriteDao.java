package com.example.Android_bigWork.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.Android_bigWork.Entity.Favorite;
import com.example.Android_bigWork.Entity.Dish; // 用于返回 Dish 列表

import java.util.List;

@Dao
public interface FavoriteDao {

    // 收藏 (增加)
    @Insert
    void insertFavorite(Favorite favorite);

    // 取消收藏 (删除)
    @Query("DELETE FROM favorite_table WHERE username = :username AND dishId = :dishId")
    void deleteFavorite(String username, int dishId);

    // 查询是否收藏 (检查状态)
    @Query("SELECT * FROM favorite_table WHERE username = :username AND dishId = :dishId")
    Favorite getFavoriteStatus(String username, int dishId);

    // 查询某个用户的所有收藏菜品 GID (用于显示列表)
    @Query("SELECT dishId FROM favorite_table WHERE username = :username")
    List<Integer> getAllFavoriteDishIds(String username);

    // 【重要】: 联表查询，返回用户收藏的所有 Dish 实体
    // 假设 Dish 表名为 dish_table
    @Query("SELECT T1.* FROM dish_table AS T1 INNER JOIN favorite_table AS T2 ON T1.GID = T2.dishId WHERE T2.username = :username ORDER BY T2.timestamp DESC")
    List<Dish> getFavoriteDishes(String username);
}