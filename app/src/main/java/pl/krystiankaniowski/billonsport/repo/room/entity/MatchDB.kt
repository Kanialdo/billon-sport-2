package pl.krystiankaniowski.billonsport.repo.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import pl.krystiankaniowski.billonsport.model.Hash

@Entity(tableName = "matches", indices = arrayOf(Index(value = "hash", unique = true)))
data class MatchDB(

		@PrimaryKey(autoGenerate = true)
		@ColumnInfo(name = "id")
		val id: Long,

		@ColumnInfo(name = "hash")
		val hash: Hash,

		@ColumnInfo(name = "date")
		val date: String = ""

)
