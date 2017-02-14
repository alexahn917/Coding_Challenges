/*
x = 0
x = x + 1
loop x {
  ...
}
*/

// a = b - 1

a = 0
c = 0

loop b {
  a = 0 
  loop c {
    a = a+1
  }
  c = c + 1
}


//a = b * c

a = 0

loop b {
  loop c {
    a = a + 1
  }  
}


//ABCDE -> BADCE
//A -> A

public String swap2char(String str) {
  if (str.length() < 2) {
    return str;
  }
  
  char[] result = new char[str.length];
  char temp;
  
  for (int i=0; i < str.length()-1; ) {
    temp = str.charAt(i);
    result[i] = str.charAt(i+1);
    result[i+1] = temp;
    i = i+2;
  }
  
  if (str.length() % 2 == 1) {
    result[str.length()-1] = str.charAt(str.length()-1);
  }
  
  return result.toString();
  
}