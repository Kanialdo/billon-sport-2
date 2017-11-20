package pl.krystiankaniowski.billonsport.repo.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import pl.krystiankaniowski.billonsport.model.Hash
import pl.krystiankaniowski.billonsport.repo.room.entity.MatchDB
import pl.krystiankaniowski.billonsport.repo.room.entity.MatchMemberDB

@Dao
abstract class MatchDao : CommonDao<MatchDB> {

	@Insert
	abstract fun insertMatchMember(item: MatchMemberDB): Long

	@Query("SELECT * FROM matches WHERE hash = :hash")
	abstract fun get(hash: Hash): MatchDB

	@Query("SELECT * FROM matches")
	abstract fun getAll(): List<MatchDB>

	@Transaction
	open fun insert(match: MatchDB, members: List<MatchMemberDB>) {
		insert(match)
		for (member in members) {
			insertMatchMember(member)
		}
	}

}