package pl.krystiankaniowski.billonsport.repo.room.converters

import android.arch.persistence.room.TypeConverter
import pl.krystiankaniowski.billonsport.model.Hash

class HashConverter {

	@TypeConverter
	fun toString(value: Hash): String = value.value

	@TypeConverter
	fun toHash(value: String): Hash = Hash.from(value)

}

