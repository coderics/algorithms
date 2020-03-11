package problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackProblem {

    private static List<String> strings = Arrays.asList(
            "}{({}[])",
            "(({()})))",
            "({(){}()})()({(){}()})(){()}",
            "{}()))(()()({}}{}",
            "}}}}",
            "))))",
            "{{{",
            "(((",
            "[]{}(){()}((())){{{}}}{()()}{{}{}}",
            "[[]][][]",
            "}{"
    );

    private static void checkCorrectness(List<String> stringData) {
        Stack<Character> stack = new Stack<>();

        for (String line : stringData) {
            char[] arr = line.toCharArray();
            for(char c : arr) {
                if (!stack.empty() && stack.peek().equals(invertSymbol(c))) {
                    stack.pop();
                } else
                    stack.push(c);
            }
            if(stack.size() != 0) System.out.println("false");
            else System.out.println("true");
            stack.clear();
        }
    }

    private static Character invertSymbol(char c) {
        if (c == '}') return '{';
        if (c == ']') return '[';
        if (c == ')') return '(';
        else return '-';
    }

    public static void main(String[] args) {
        checkCorrectness(strings);
    }
}
