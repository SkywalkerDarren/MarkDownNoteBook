package io.github.skywalkerdarren.markdownnotebook.repository.local

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import io.github.skywalkerdarren.markdownnotebook.NoteBookApplication
import io.github.skywalkerdarren.markdownnotebook.model.Note
import io.github.skywalkerdarren.markdownnotebook.model.NoteBook

@Database(entities = [Note::class, NoteBook::class], version = 1)
@TypeConverters(Convectors::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun noteBookDao(): NoteBookDao

    companion object {
        private const val TAG = "AppDatabase"
        val db by lazy {
            Room.databaseBuilder(
                NoteBookApplication.appContext,
                AppDatabase::class.java, "AppDatabase"
            ).fallbackToDestructiveMigrationOnDowngrade()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d(TAG, "onCreate")
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        Log.d(TAG, "onOpen")
                    }

                    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                        super.onDestructiveMigration(db)
                        Log.d(TAG, "onDestructiveMigration")
                    }
                })
                .build()
        }
    }
}