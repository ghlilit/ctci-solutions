import java.util.*;

class Strings {
  
  // 1.1:  Implement an algorithm to determine if a string has all unique characters. 
  public static boolean isUnique(String str) {
    boolean [] chars = new boolean[128];

    for(int i = 0; i < str.length(); i++) {
      int idx = (int) str.charAt(i);
        if(chars[idx] == false){
          chars[idx] = true;
        }
        else{
          return false;
        }
    }
    return true;
  }

  // 1.2: Given two strings, write a method to decide if one is a permutation of the other. 
  public static boolean isPermuation(String str1, String str2){

    if(str1.length() != str2.length()) {
      return false;
    }

    Hashtable chars = new Hashtable();

    for(int i = 0; i < str1.length(); i++) {
      int myChar = str1.charAt(i);
      if(chars.get(myChar)!=null){
        chars.put(myChar, (int) chars.get(myChar) + 1);
      }
      else {
        chars.put(myChar, 1);
      }
    }

    for(int i = 0; i < str2.length(); i++){
      int myChar = str2.charAt(i);
      if(chars.get(myChar) != null){
        chars.put(myChar, (int) chars.get(myChar) - 1);
      }
      else {
        return false;
      }
    }

    return true;
  }

  // 1.3: Write a method to replace all spaces in a string with '%20'. 
  public static String urlify(String str) {
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < str.length(); i++){
      int myChar = str.charAt(i);
      if(myChar == 32){
        sb.append('%');
        sb.append('2');
        sb.append('0');
      }
      else {
        sb.append(str.charAt(i));
      }
    }

    return sb.toString();
  }

  // 1.4: Given a string, write a function to check if it is a permutation of a palin­drome.
  public static boolean isPalindromePermutation(String str) {
    Hashtable chars = new Hashtable();

    for(int i = 0; i < str.length(); i++) {
      int myChar = str.charAt(i);
      if(chars.get(myChar)!=null) {
        chars.put(myChar, (int) chars.get(myChar) + 1);
      }
      else {
        chars.put(myChar, 1);
      }
    }

    Enumeration e = chars.elements();
    int odds = 0;
   
    while(e.hasMoreElements()){
      if((int) e.nextElement() % 2 == 1){
        odds++;
      }
    }

    if(odds > 1){
      return false;
    }
    
    return true;
  }

  // 1.5: : There are three types of edits that can be performed on strings:
  //  insert a character, remove a character, or replace a character.
  //  Given two strings, write a function to check if they are one edit (or zero edits) away. 
  public static boolean oneAway(String str1, String str2){
    int changes = 0; 

    if (str1.length() > str2.length() + 2 || str1.length() > str2.length() + 2){
      return false;
    }

    if(str1.length() == str2.length()){
      for(int i=0; i < str1.length(); i++){
        if(str1.charAt(i) != str2.charAt(i)){
          changes++;
        }
      }
      return changes <= 1;
    }

    String longer = ""; 
    String shorter = "";

    if(str1.length() > str2.length()){
      longer = str1;
      shorter = str2;
    }
    else{
      longer = str2;
      shorter = str1;
    }

    int j = 0;

    for(int i=0; i < shorter.length(); i++){
      if(shorter.charAt(i) == longer.charAt(j)){
        j++;
      }
      else if(shorter.charAt(i) == longer.charAt(j+1)){
        j+=2;
        changes++;
      }
      else{
        return false;
      }
    }

    return changes <= 1;
  }

  // 1.6: n: Implement a method to perform basic string compression
  //  using the counts of repeated characters.
  public static String stringCompression(String str){
    StringBuilder sb = new StringBuilder();
    Integer count = 1;
    char currentChar = str.charAt(0);

    for (int i=1; i < str.length(); i++){
      currentChar = str.charAt(i-1);
      if(str.charAt(i) == currentChar){
        count++;
      }
      else{
        sb.append(String.valueOf(currentChar));
        sb.append(String.valueOf(count));
        count = 1;
      }
    }
      sb.append(String.valueOf(currentChar));
      sb.append(String.valueOf(count));

    if(sb.length() > str.length()){
      return str;
    }

    return sb.toString();
  }

  // 1.7: Given an image represented by an NxN matrix,
  //  where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
  public static boolean matrixRotation(int matrix[][]){
    int length = matrix.length;

    for (int layer = 0; layer < matrix.length/2; layer++){
      for(int i=layer; i < matrix.length-1-layer; i++){
        int temp = matrix[layer][i];
        matrix[layer][i] = matrix[length-1-i][layer];
        matrix[length-1-i][layer] = matrix[length-1-layer][length-1-i];
        matrix[length-1-layer][length-1-i] = matrix[i][length-1-layer];
        matrix[i][length-1-layer] = temp;
      }
    }

    return true;
  }

  // 1.8: Write an algorithm such that if an element in an MxN matrix is 0,
  //  its entire row and column are set to 0. 
  public static void zeroMatrix(int matrix[][]){

    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix.length; j++){
        if(matrix[i][j] == 0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for(int i=1; i<matrix.length; i++){
      if(matrix[i][0] == 0){
        setRowZero(i, matrix);
      }
      if(matrix[0][i] == 0){
        setColZero(i, matrix);
      }
    }

    if(matrix[0][0]==0){
      setRowZero(0, matrix);
      setColZero(0, matrix);
    }

  }

  public static void setRowZero(int row, int matrix[][]){
    for(int i=0; i<matrix.length; i++){
      matrix[row][i] = 0;
    }
  }

  public static void setColZero(int col, int matrix[][]){
    for(int i=0; i<matrix.length; i++){
      matrix[i][col] = 0;
    }
  }
  
  // 1.9:  Given two strings, s1 and s2, write code to check if s2 is a rotation of s1.
  public static boolean stringRotation(String str1, String str2){
    if(str1.length() != str2.length()){
      return false;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(str1);
    sb.append(str1);
    String concat = sb.toString();

    if(concat.contains(str2)){
      return true;
    }

    return false;
  }

}