fun main(){
    val day18 = Day18()
    val day19 = Day19()

    print("Day18 1-star solution: ${day18.solveStarOne()} \n")
    val day18star2result = day18.solveStarTwo()
    print("Day18 2-star solution: ${day18star2result.first},${day18star2result.second}\n")

    print("Day19 1-star solution: ${day19.solveStarOne()}")
}