package pl.krystiankaniowski.billonsport.model

class Hash private constructor(val value: String) {

	companion object {
		fun create() = Hash(System.currentTimeMillis().toString())
	}

}