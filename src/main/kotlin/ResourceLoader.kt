public fun readResource(path: String) : String {
    return object{}.javaClass.getResourceAsStream(path)?.bufferedReader()?.readText() ?: ""
}