package pl.krystiankaniowski.billonsport.repo.room.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update

interface CommonDao<T> {

	@Insert
	fun insert(item: T): Long

	@Update
	fun update(item: T): Int

	@Delete
	fun delete(item: T): Int

}