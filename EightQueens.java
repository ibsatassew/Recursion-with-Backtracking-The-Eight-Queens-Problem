/**

This class solves the Eight Queens problem by placing eight queens on an 8x8 chessboard

in such a way that no two queens threaten each other.

@author [Your Name]

@version 1.0
*/
public class EightQueens{
    // The chessboard is represented as a 2D char array
    private static char [][] chessboard = new char[8][8];
    
    /**
    
    Initializes the chessboard with '.' to indicate empty cells.
    */
    public static void fillArray(){
    for(int i = 0; i<8; i++){
    for(int j = 0; j<8; j++){
    chessboard[i][j]='.';
    }
    }
    }
    /**
    
    Places queens on the chessboard recursively, starting from column c.
    @param c the column to start placing the queen from
    @return true if all queens have been placed successfully, false otherwise
    */
    public static boolean placeQueens(int c){
    if(c >= 8){
    return true; // All queens have been placed successfully
    }
    else{
    int cnt = 1;
    while(cnt<=8){
    if(!isUnderAttack(c, cnt-1)){
    chessboard[c][cnt-1] = 'Q'; // Place the queen at (c, cnt-1)
    if(!placeQueens(c+1)){ // Recursively place queens in the next column
    chessboard[c][cnt-1] = '.'; // Backtrack: remove the queen from (c, cnt-1)
    }
    else{
    return true; // All queens have been placed successfully
    }
    }
    cnt++;
    }
    }
    return false; // Could not place all queens
    }
    /**
    
    Checks whether the position (rw, cl) is under attack by any queen already placed on the board.
    @param rw the row of the position to check
    @param cl the column of the position to check
    @return true if the position is under attack, false otherwise
    */
    public static boolean isUnderAttack(int rw, int cl) {
    // Check all eight directions (4 diagonal, 2 vertical and 2 horizontal) around the current position
    for (int dr = -1; dr <= 1; dr++) {
    for (int dc = -1; dc <= 1; dc++) {
    if (dr == 0 && dc == 0) continue; // Skip the current position
    int r = rw + dr;
    int c = cl + dc;
    while (r >= 0 && r < 8 && c >= 0 && c < 8) {
    if (chessboard[r][c] == 'Q') {
    return true; // Queen found in this direction
    }
    r += dr;
    c += dc;
    }
    }
    }
    return false; // No queen found in any direction
    }
    /**
    
    The main method that initializes the chessboard, places queens on it and prints the final configuration.
    @param args the command-line arguments
    */
    public static void main(String[] args){
    fillArray();
    placeQueens(0);
    for(int i = 0; i<8; i++){
    for(int j = 0; j<8; j++){
    System.out.print(chessboard[i][j] + " ");
    }
    System.out.println("");
    }
    }
    }