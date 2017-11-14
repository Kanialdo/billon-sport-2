package pl.krystiankaniowski.billonsport.repo

interface BaseProvider<T> {

	fun get(id: String): T?

	fun getAll(): List<T>

}