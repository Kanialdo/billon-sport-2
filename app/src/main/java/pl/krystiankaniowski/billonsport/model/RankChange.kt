package pl.krystiankaniowski.billonsport.model

data class RankChange(
		val id: Hash,
		val playerId: Hash,
		val matchId: Hash,
		val rankType: RankType,
		val rank: Float,
		val rankDeviation: Float)
