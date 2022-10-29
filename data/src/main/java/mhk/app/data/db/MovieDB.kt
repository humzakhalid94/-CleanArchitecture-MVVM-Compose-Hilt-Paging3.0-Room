package mhk.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farhan.tanvir.domain.model.MovieRemoteKeys
import mhk.app.data.db.MovieDao
import mhk.app.data.db.MovieRemoteKeysDao
import mhk.app.domain.model.Movie

@Database(
    entities = [Movie::class, MovieRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDB : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieRemoteKeysDao(): MovieRemoteKeysDao
}