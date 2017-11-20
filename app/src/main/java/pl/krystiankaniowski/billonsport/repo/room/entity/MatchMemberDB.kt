package pl.krystiankaniowski.billonsport.repo.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import pl.krystiankaniowski.billonsport.model.Hash

@Entity(foreignKeys = arrayOf(
		ForeignKey(entity = MatchDB::class, parentColumns = arrayOf("hash"), childColumns = arrayOf("match_hash"), onDelete = ForeignKey.CASCADE),
		ForeignKey(entity = PlayerDB::class, parentColumns = arrayOf("hash"), childColumns = arrayOf("player_hash"), onDelete = ForeignKey.CASCADE)))

data class MatchMemberDB(

		@PrimaryKey(autoGenerate = true)
		val id: Long,

		@ColumnInfo(name = "match_hash")
		val matchHash: Hash,

		@ColumnInfo(name = "player_hash")
		val playerHash: Hash,

		@ColumnInfo(name = "team")
		val team: Int

)