package pl.krystiankaniowski.billonsport.repo.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

import pl.krystiankaniowski.billonsport.model.Hash

@Entity(tableName = "players", indices = arrayOf(Index(value = "hash", unique = true)))
data class PlayerDB(

		@PrimaryKey(autoGenerate = true)
		@ColumnInfo(name = "id")
		val id: Long,

		@ColumnInfo(name = "hash")
		val hash: Hash,

		@ColumnInfo(name = "first_name")
		val firstName: String = "",

		@ColumnInfo(name = "last_name")
		val lastName: String = "",

		@ColumnInfo(name = "nickname")
		val nickname: String = ""

)