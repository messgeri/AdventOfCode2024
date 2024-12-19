public class Day18(private val resourcePath : String = "Day18.txt",private val gridSize : Int = 71, private val errorCount : Int = 1024) {
    private var  grid = Array<Array<Int>>(gridSize){
        Array<Int>(gridSize) {Int.MAX_VALUE}
    }
    private var errors = ArrayList<Pair<Int, Int>>()

    init {
        val input = readResource(resourcePath)
        input.lines().forEach{
            val coords = it.split(",")
            errors.add(Pair(coords[0].toInt(), coords[1].toInt()))
        }
        for (i in 0 until errorCount){
            grid[errors[i].first][errors[i].second] = -1
        }
    }

    private fun stepSomewhere(stepCount : Int,x : Int, y : Int){
        if(!validTile(stepCount,x,y)) return

        grid[x][y] = stepCount

        stepSomewhere(stepCount + 1, x+1, y)
        stepSomewhere(stepCount + 1, x, y+1)
        stepSomewhere(stepCount + 1, x-1, y)
        stepSomewhere(stepCount + 1, x, y-1)
    }

    private fun validTile(stepCount : Int, x : Int, y : Int) : Boolean{
        return x >= 0 && y >= 0 && x < gridSize  && y < gridSize && grid[x][y] != -1 && grid[x][y] > stepCount
    }

    fun solveStarOne() : Int{
        stepSomewhere(0, 0,0)
        return grid[gridSize-1][gridSize-1]
    }

    private fun resetGrid(){
        grid.forEach {
            for (i in it.indices) {
                if(it[i] == -1) it[i] = -1
                else it[i] = Int.MAX_VALUE
            }
        }
    }

    fun solveStarTwo() : Pair<Int, Int>{
        var index = errorCount
        var solution = 0
        while(solution != Int.MAX_VALUE && solution != -1){
            resetGrid()
            grid[errors[index].first][errors[index].second] = -1
            index++
            solution = solveStarOne()
        }
        return errors[index - 1]
    }
}