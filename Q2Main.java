//import java.io.FileNotFoundException;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import java.util.stream.*;
//import java.util.function.*;
//
//
//public class Q2Main {
//
//    public static <T, U> List<U>
//    convertStringListToIntList(List<T> listOfString, Function<T, U> function)
//    {
//        return listOfString.stream()
//                .map(function)
//                .collect(Collectors.toList());
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//
//
//
//        File f = new File("extensionPuzzle.txt");
//        Scanner in = new Scanner(f);
//        FileInputStream inputStream = new FileInputStream(f);
//        InputStreamReader textInput = new InputStreamReader(inputStream);
//        BufferedReader reader = new BufferedReader(textInput);
//        String lineReading;
//
//        List<String> rowString = new ArrayList<>();
//
//        List<Integer> rowInt = new ArrayList<>();
//
//
//
//        while(in.hasNextLine()){
//
//            lineReading = reader.readLine();
//
//            String[] rowList = lineReading.split(",");
//
//            for(int i=0; i<rowList.length;i++){
//                rowString.add(rowList[i]);
//            }
//
//            rowInt.addAll(convertStringListToIntList(rowString,Integer::parseInt));
//
//        }
//
//
//
//        //console.log('Task one: ');
////      var row = [1 , 2 , 3 , 4];
////      console.log(makeRows(row));
////      console.log('The correct answer should be: [[1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4], [1, 2, 3, 4]]');
//
//
//        //console.log('Task two: ');
////      var row = [1 , 2 , 3 , 4];
////      console.log(permuteRow(row,2));
////      console.log('The correct answer should be: [3, 4, 1, 2]');
//
//
//        //console.log('Task three')
////      var puzzle = [[1,2,3,4],[2,3,4,1],[3,4,1,2],[4,1,2,3]];
////      console.log(checkColumn(puzzle,1));
////      puzzle = [[1,2,3,4],[2,3,4,1],[2,3,4,1],[4,1,2,3]];
////      console.log(checkColumn(puzzle,2));
////      console.log('The correct answer should be:  true, false')
//
//
//        //console.log('Task four: ')
////      var puzzle = [[1, 2, 3, 4], [2, 3, 4, 1], [3, 4, 1, 2], [4, 1, 2, 3]];
////      console.log(colCheck(puzzle));
////      puzzle = [[1, 2, 3, 4], [2, 3, 4, 1], [2, 3, 4, 1], [4, 1, 2, 3]];
////      console.log(colCheck(puzzle));
////      console.log('The correct answer should be:  true, false')
//
//
//        //console.log('Task five: ')
////      var puzzle = [[1, 2, 3, 4], [2, 3, 4, 1], [3, 4, 1, 2], [4, 1, 2, 3]];
////      console.log(checkGrid(puzzle , 0, 1, 2, 3));
////      puzzle = [[1, 2, 3, 4], [3, 4, 1, 2], [4, 1, 2, 3], [4, 1, 2, 3]];
////      console.log(checkGrid(puzzle , 0, 1, 0, 1));
////      console.log('The correct answer should be:  false, true')
//
//
//        //console.log('Task six: ')
////      var puzzle = [[1, 2, 3, 4], [2, 3, 4, 1], [3, 4, 1, 2], [4, 1, 2, 3]];
////      console.log(checkGrids(puzzle));
////      puzzle = [[1, 2, 3, 4], [3, 4, 1, 2], [4, 1, 2, 3], [2, 3, 4, 1],];
////      console.log(checkGrids(puzzle));
////      console.log('The correct answer should be: false, true')
//
//
//        //var row = [1, 2, 3, 4];
////      console.log("Task SEVEN: ")
////      console.log(makeSolution(row));
//
//
//        //console.log("Task EIGHT: ")
////        console.log(entriesToDel(6));
//
//    }
//
//}
