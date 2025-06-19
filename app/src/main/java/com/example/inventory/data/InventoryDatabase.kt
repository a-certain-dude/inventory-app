package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao /* so that the database would know about the DAO */
    
    companion object {
        @Volatile  /* volatile values are not cached */
        private var Instance: InventoryDatabase? = null
        fun getDatabase(context: Context): InventoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = InventoryDatabase::class.java,
                    name = "item_database"
                ).build().also { instance -> Instance = instance }
            }
        }
    }
}