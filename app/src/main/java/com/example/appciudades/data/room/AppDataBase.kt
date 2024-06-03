package com.example.appciudades.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appciudades.data.models.Ciudades
import com.example.appciudades.data.models.CiudadesDao


@Database(entities = [Ciudades::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun ciudadesDao(): CiudadesDao

    companion object{
        const val DBNAME = "ciudades_db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val temporalInstance = INSTANCE
            if (temporalInstance != null)
                return temporalInstance

            synchronized(AppDataBase::class.java) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DBNAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}