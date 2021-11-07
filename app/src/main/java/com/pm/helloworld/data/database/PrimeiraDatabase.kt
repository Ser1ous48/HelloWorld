package com.pm.filigrana.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pm.helloworld.data.dao.PrimeiraInterface
import com.pm.helloworld.data.entities.PrimeiraClasse

@Database(entities = [PrimeiraClasse :: class], version = 1, exportSchema = false)
abstract class PrimeiraDatabase : RoomDatabase() {

    abstract fun productDao() : PrimeiraInterface
    companion object {
        @Volatile
        private var INSTANCE: PrimeiraDatabase? = null

        fun getDatabase(context: Context): PrimeiraDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PrimeiraDatabase::class.java,
                    "helloworld_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}