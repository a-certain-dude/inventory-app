package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert
    suspend fun insert(item: Item)
    
    @Update
    suspend fun update(item: Item)
    
    @Delete
    suspend fun delete(item: Item)
    
    @Query("SELECT * FROM items WHERE id = :id")
    fun getItems(id: Int):Flow<Item>
    
    @Query("SELECT  * FROM items ORDER BY name ASC")
    fun getAllItems():  Flow<List<Item>>
}