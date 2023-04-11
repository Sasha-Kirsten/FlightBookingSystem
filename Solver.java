//import java.io.Serializable;
//import java.util.ArrayList;
//
//public class Solver {
//
//    public ArrayList<Integer> makeRows(ArrayList<Integer> row) {
//
//        ArrayList<Integer> puzzle = new ArrayList();
//
//        //int[] puzzle = new int[row];
//        for(int i = 0; i < row.size(); i++){
//            puzzle.add(row.get(i));  //push(row.slice());// Find a method that "pushes" and "slice".
//        }
//        return puzzle;
//    }
//
////// this is the constructor of the queue data structure
//    class Queue {
//        ArrayList<Integer> arr = new ArrayList();
//        ArrayList<Integer> o = new ArrayList();
//
//        //int[] arr;
//        //int[] o;
//
//        public int head() {
//            return this.arr.get(0);
//        };
//        public String dequeue() {
//            if (this.arr.size() == 0) {
//                return "Queue underflow!";
//            } else {
//                return String.valueOf(this.arr.remove(0));
//            }
//        };
//        public void enqueue(int o){
//            this.arr.add(o);
//        };
//        public boolean isEmpty(){
//            return this.arr.size() == 0;
//        };
//    };
//////////////////////////////
//    public int[] permuteRow(int[] row,int p) {
//        Queue queue = new Queue();
//
//        for(int i=0 ; i < row.length ;i++){
//            queue.enqueue(row[i]);
//        }
//
//        while(p > 0){
//            queue.enqueue(queue.head());
//            queue.dequeue();
//            p--;
//        }
//        int [] array = new int[row.length];
//
//        while(!queue.isEmpty()){
//            //array.push(queue.head());
//            queue.dequeue();
//        }
//        return array;
//
//    }
////
//    public int[] permutePuzzle(int[]puzzle,int p,int q,int r) {
//        //ArrayList<Integer> perms = new ArrayList()<>;
//
//        //int[] perms = [p,q,r];
//        for (int i=0; i<puzzle.length; i++){
//            puzzle[i + 1] = permuteRow(puzzle[i + 1], perms[i]);
//        }
//        return puzzle;
//    }
//
//    public boolean linearSearch(int[] array,int item) {
//        int n = array.length;
//        for (int i = 0; i < n; i++) {
//            if (array[i] == item) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkColumn(int[][] puzzle,int j) {
//        //first make an array out of the values stored in column j
//        boolean arrayBool = false;
//
//        //ArrayList<Integer> array = new ArrayList()<>;
//        int[] array = new int[puzzle.length];
//
//        for(int i = 0; i < puzzle.length; i++){
//            array.push(puzzle[i][j]);
//        }
//
//        //call linearSearch on the array of column values for all values of k from 1 to 4
//        if(linearSearch(array, 1) &&
//                linearSearch(array, 2) &&
//                linearSearch(array, 3) &&
//                linearSearch(array, 4)){
//            arrayBool = true;
//        }
//        return arrayBool;
//
//    }
//
//    public boolean colCheck(int[][] puzzle) {
//        boolean puzzleBool = true;
//
//        for(int i=0; i<puzzle.length; i++){
//            if(!checkColumn(puzzle, i)){
//                puzzleBool = false;
//            }
//        }
//        return puzzleBool;
//    }
//
//    public int[] makeGrid(int[][] puzzle,int[] row1,int[] row2,int[] col1,int[] col2) {
//        //this copies all elements in a grid from co-ordinates (row1, col1) to (row2,col2) to an array
//        int[] array = new int[row1.length];
//        for (int i = row1.length; i < row2.length; i++) {
//            for (int j = col1.length; j < col2.length; j++){
//                array.push(puzzle[i][j]);
//            }
//        }
//        return array;
//    }
////
//    public boolean checkGrid(int[][] puzzle,int[] row1,int[] row2,int[] col1,int[] col2) {
//
//        int[] checkGridPuzzle = makeGrid(puzzle, row1, row2, col1, col2);
//        if(linearSearch(checkGridPuzzle, 1) &&
//                linearSearch(checkGridPuzzle, 2) &&
//                linearSearch(checkGridPuzzle, 3) &&
//                linearSearch(checkGridPuzzle, 4)){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean checkGrids(int[][] puzzle) {
//
//        if(checkGrid( puzzle, 0, 1, 0, 1) == false){
//            return false;
//        }
//        if(checkGrid( puzzle, 0, 1, 2, 3) == false){
//            return false;
//        }
//        if(checkGrid( puzzle, 2, 3, 0, 1) == false){
//            return false;
//        }
//        if(checkGrid(puzzle, 2, 3, 2, 3) == false){
//            return false;
//        }
//        return true;
//    }
//
//    public int[] makeSolution(int[] row) {
//
//        int[] array = new int[row.length];
//
//        int[] puzzle = makeRows(row.length);
//        for(var p = 0; p < row.length; p++){
//            for(var q = 0; q < row.length; q++){
//                for(var r = 0; r < row.length; r++){
//                    array.push(permutePuzzle(puzzle.slice(), p, q, r));
//                }
//            }
//        }
//
//        for(var i = 0; i < array.length; i++){
//            if(colCheck(array[i])){
//                if(checkGrids(array[i])){
//                    return array[i];
//                }
//            }
//        }
//        return null;
//    }
//
////    // a function to randomly select n (row,column) entries of a 2d array
//    //public int[] entriesToDel(int n) {
//        //var array = new int[];
////        for (var i = 0; i < n; i++) {
////            var row = Math.round(3*Math.random());
////            var col = Math.round(3*Math.random());
////            array.push([row,col]);
////            for(var j = 0; j < array.length; j++){
////                if(array[j] === array[-1]){
////                    array.pop();
////                    i--;
////                }
////            }
////        }
////        return array;
//    //}
//
//    public Serializable genPuzzle(int[] row, int n) {
//        if (n >= 16) {
//            return "Error! Too many blank spaces!";
//        }
//        int[] solution = makeSolution(row);
//        int[] blanks = entriesToDel(n);
//        for (var i = 0; i < blanks.length; i++) {
//            solution[blanks[i][0]][blanks[i][1]] = " ";
//        }
//        return solution;
//    }
//}