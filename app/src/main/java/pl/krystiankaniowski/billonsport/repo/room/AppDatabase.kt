package pl.krystiankaniowski.billonsport.repo.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import pl.krystiankaniowski.billonsport.repo.room.converters.HashConverter
import pl.krystiankaniowski.billonsport.repo.room.dao.MatchDao
import pl.krystiankaniowski.billonsport.repo.room.dao.PlayerDao
import pl.krystiankaniowski.billonsport.repo.room.entity.MatchDB
import pl.krystiankaniowski.billonsport.repo.room.entity.MatchMemberDB
import pl.krystiankaniowski.billonsport.repo.room.entity.PlayerDB

@Database(entities = arrayOf(PlayerDB::class, MatchDB::class, MatchMemberDB::class), version = 1)
@TypeConverters(HashConverter::class)
abstract class AppDatabase : RoomDatabase() {

	abstract fun players(): PlayerDao

	abstract fun matches(): MatchDao

}