package pl.krystiankaniowski.billonsport.model

data class Player(
		val id: Hash,
		val firstName: String,
		val lastName: String,
		val nickname: String,
		val rank: Float,
		val rankDeviation: Float)
