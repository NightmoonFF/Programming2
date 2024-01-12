package PRO.Lektion17_StackADT.Exercise2;

import PRO.Lektion17_StackADT.Exercise1.ArrayStack23Y;
import PRO.Lektion17_StackADT.Exercise1.LinkedStack23Y;
import PRO.Lektion17_StackADT.Exercise1.Stack23Y;

import java.sql.SQLOutput;

public class Exercise2{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Create a method that uses a stack to determine, whether a string contains matching brackets             │
    │    and parenthesis. Use the stack from exercise 1. Legal brackets and parenthesis are (), {},[].           │
    │    This string is correct: (3+{5[99 {*}]}[23[{67}67]])                                                     │
    │    This string is not correct (}){                                                                         │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    // --ChatGPT Solution--

    public static void print(){
        System.out.println("String: (3+{5[99 {*}]}[23[{67}67]]) has matching brackets? - "
                + checkMatchingBrackets("(3+{5[99 {*}]}[23[{67}67]])") );

        System.out.println("String: (}){ has matching brackets? - "
                + checkMatchingBrackets("(}){)") );
    }

    private static boolean checkMatchingBrackets(String s){
        Stack23Y<Character> stack = new ArrayStack23Y<>();

        // Mapping of opening and closing brackets/parentheses
        char[][] bracketPairs = {
                {'(', ')'},
                {'{', '}'},
                {'[', ']'}
        };

        for (char c : s.toCharArray()) {
            if (isOpenBracketOrParenthesis(c)) {
                stack.push(c);
            } else if (isCloseBracketOrParenthesis(c)) {

                if (stack.isEmpty() || !matches(stack.pop(), c, bracketPairs)) {
                    return false;  // Mismatched brackets or parentheses
                }

            }
        }

        return stack.isEmpty();  // If stack is empty, all brackets and parentheses matched
    }



    private static boolean isOpenBracketOrParenthesis(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isCloseBracketOrParenthesis(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private static boolean matches(char open, char close, char[][] pairs) {
        for (char[] pair : pairs) {
            if (pair[0] == open && pair[1] == close) {
                return true;
            }
        }
        return false;
    }

}

/*
Why use stacks for this shit
ChatGPT

The use of stacks for bracket matching is motivated by the nature of bracket expressions and the need to ensure that
 the brackets are correctly paired and nested. Here are some reasons why stacks are commonly used for this purpose:

    LIFO (Last In, First Out) Property:
        The LIFO property of stacks is well-suited for tracking the most recently opened bracket. This ensures that the
         corresponding closing bracket is the next one encountered.

    Nesting Structure:
        Bracket expressions often have a nested structure, where brackets must be closed in the reverse order they
         were opened. Stacks naturally handle this nesting by maintaining the order of opening and closing brackets.

    Efficient Checking:
        Stacks provide an efficient way to check bracket correctness during parsing. As you iterate through the string,
         you can quickly check if each closing bracket matches the most recently opened bracket.

    Simplicity and Readability:
        The stack-based approach simplifies the logic and makes the code more readable. It abstracts away the details of
         tracking nested brackets and focuses on the essential logic of ensuring matching pairs.

    Versatility:
        Stacks can be easily adapted for other parsing scenarios, not just bracket matching.
         They are a versatile data structure that suits various parsing and expression evaluation needs.

While the specific implementation details may vary, the fundamental idea of using a stack to track brackets' order and
 nesting remains a common and effective strategy. If you have a different preference or specific requirements in mind,
  alternative approaches might be considered, but using a stack is a widely accepted and
   efficient solution for bracket matching.

 */
