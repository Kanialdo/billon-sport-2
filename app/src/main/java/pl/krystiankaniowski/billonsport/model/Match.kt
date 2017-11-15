package pl.krystiankaniowski.billonsport.model

data class Match(
		val id: Hash,
		val date: String,
		val teams: List<Team>)
