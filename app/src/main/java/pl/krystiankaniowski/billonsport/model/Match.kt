package pl.krystiankaniowski.billonsport.model

data class Match(
		val id: Hash,
		val date: String,
		val team_1: List<Hash>,
		val team_2: List<Hash>,
		val result: MatchResult)
