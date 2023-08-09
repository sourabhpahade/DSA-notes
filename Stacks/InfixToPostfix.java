package Stacks;

import java.util.Stack;

public class InfixToPostfix {

  /*
   * Naive solution :
   *
   * 1. Fully Parenthesis the infix expression.
   * 2. Start converting from the innermost bracket.
   */

  /*
   * Efficient solution : Using stack.
   *
   * 1. Create a empty stack to store operators
   *
   * 2. traverse exp from left to right
   *
   * 3. if curr char x :
   *
   * a> operand -> print(x)
   * b> open paren -> push(x)
   * c> close paren -> pop until open paren is found and print(pop())
   * d> operator :
   *
   * i> if stack is empty -> push(x)
   * ii> if x has higher priority than st.peek -> push it
   * iii> if has lower priority -> pop until peek has lower priority than x,
   * print(pop), than push(x)
   * iv> if has equal priority -> we folloe associativity
   *
   * e. after traversing the whole exp -> empty the st and print(pop)
   */

  // method to find precendence of operator -> ( < +- < */ < ^

  static int precendence(char c) {

    if (c == '(')
      return 0;
    if (c == '+' || c == '-')
      return 1;
    if (c == '*' || c == '/')
      return 2;
    if (c == '^')
      return 3;

    return -1;
  }

  static String convertToPostfix(String exp) {

    StringBuilder res = new StringBuilder();

    // stack to store operators
    Stack<Character> st = new Stack<>();

    // traversing exp
    for (char c : exp.toCharArray()) {

      if (c >= 'a' && c <= 'z') {
        res.append(c);
      } else if (c == '(') {
        st.push(c);
      } else if (c == ')') {

        while (st.peek() != '(') {
          res.append(st.peek());
          st.pop();
        }
        st.pop(); // popping open paren
      } else {

        while (!st.isEmpty() && precendence(st.peek()) >= precendence(c)) {
          res.append(st.peek());
          st.pop();
        }
        st.push(c);

      }

    }

    // emptying the stack
    while (!st.isEmpty()) {
      res.append(st.peek());
      st.pop();
    }

    return res.toString();

  }

  public static void main(String[] args) {

    String exp = "((2+((6*4)/8))-3)";
    System.out.println(convertToPostfix(exp));
  }
}
