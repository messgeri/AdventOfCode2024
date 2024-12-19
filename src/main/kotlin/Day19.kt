class Day19(private val resourcePath : String = "Day19.txt") {
    private var towels = ArrayList<String>()
    private var patterns = ArrayList<String>()

    init{
        val input = readResource(resourcePath)
        var finished = false

        input.lines().forEach{ it ->

            if(finished) {
                patterns.add(it)
            }else if(it.isEmpty()){
                finished = true
            }else{
                val towelList = it.split(", ")
                towelList.forEach { towel->
                    towels.add(towel)
                }
            }
        }

        towels.sortBy{
            it.length
        }
    }

    private fun creatRegex(): Regex{
        var regex = "("
        towels.forEach{
            if(it.length == 1) {
                regex += "$it|"
            }
            else{
                regex = regex.removeSuffix("|").removeSuffix(")*") + ")*"
                if(!it.matches(Regex(regex))) {
                    regex = regex.removeSuffix(")*") + "|$it)*"
                }
            }
        }
        return Regex(regex)
    }

    fun solveStarOne() : Int{
        val regex = creatRegex()
        var possible = 0
        patterns.forEach{
            if(it.matches(regex)) possible++
        }
        return possible
    }
}