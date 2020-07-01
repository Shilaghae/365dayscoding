package matrix

class BattleShipBoard {

    private var n = 0
    private var m = 0
    private var count: Int = 0

    fun countBattleships(board: Array<CharArray>): Int {
        if (board.isNotEmpty()) {
            n = board.lastIndex
            m = board[0].lastIndex

            for (i in 0..n) {
                for (j in 0..m) {
                    if (board[i][j] != 'S' && board[i][j] == 'X') {
                        count++
                        check(i, j, board)
                    }
                }
            }
        }
        return count
    }

    private fun check(i: Int, j: Int, board: Array<CharArray>) {
        if (board[i][j] != 'S') {
            board[i][j] = 'S'
            if (i - 1 >= 0)
                if (board[i - 1][j] == 'X') check(i - 1, j, board) else board[i - 1][j] = 'S'
            if (i + 1 <= n)
                if (board[i + 1][j] == 'X') check(i + 1, j, board) else board[i + 1][j] == 'S'
            if (j - 1 >= 0)
                if (board[i][j - 1] == 'X') check(i, j - 1, board) else board[i][j - 1] = 'S'
            if (j + 1 <= m) if (board[i][j + 1] == 'X') check(i, j + 1, board) else board[i][j + 1] = 'S'

        } else
            return
    }
}