package pl.krystiankaniowski.billonsport.repo.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import pl.krystiankaniowski.billonsport.model.Hash
import pl.krystiankaniowski.billonsport.repo.room.entity.PlayerDB

@Dao
interface PlayerDao : CommonDao<PlayerDB> {

	@Query("SELECT * FROM players WHERE hash = :hash")
	fun get(hash: Hash): PlayerDB

	@Query("SELECT * FROM players")
	fun getAll(): List<PlayerDB>

}