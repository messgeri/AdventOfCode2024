public class Day18(val resourcePath : String = "Day18.txt", val gridSize : Int = 71, val errorCount : Int = 1024) {
    private var  grid = Array<Array<Int>>(gridSize){
        Array<Int>(gridSize) {Int.MAX_VALUE}
    }
    //private var errors = ArrayList<Pair<Int, Int>>()

    init {
        val input = readResource(resourcePath)

        for (i in 0 until errorCount){

            val coords = input.lines()[i].split(",")
            val x = coords[0].toInt()
            val y = coords[1].toInt()

            grid[x][y] = -1
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

    fun solveOneStar() : Int{
        stepSomewhere(0, 0,0)
        return grid[gridSize-1][gridSize-1]
    }

}