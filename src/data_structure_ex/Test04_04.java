package data_structure_ex;

import java.util.*;

public class Test04_04 {

	public static boolean isValid(String s) {

		// Map<Character, Character> pairs = *** // 사용 추천 "[ ]"을 map 쌍으로 정의
		Map<Character, Character> pairs = new HashMap<>();
		// 키값 벨류값 기호 넣기
		pairs.put('>', '<');
		pairs.put(')', '(');
		pairs.put('}', '{');
		pairs.put(']', '[');

		// 스텍으로 풀어야하니까 스텍생성
		Stack<Character> stack = new Stack<>();
		// for확장문사용해서, 괄호 꺼내기/ 근데 String이니까 character로 한자씩 분리해주기
		for (Character a : s.toCharArray()) {
			// if 맵에 여는괄호면 포함되면, 스텍에 넣기
			if (pairs.containsValue(a)) {
				stack.push(a);
			}
			// else if 맵에 닫는괄호면, if 스택이 비어있거나 스택이 꺼내진게 괄호가 맞지 않으면 폴스
			else if (pairs.containsKey(a)) {
				if (stack.isEmpty() || stack.pop() != pairs.get(a)) {
					return false;
				}
			}
		}
		// 모든괄호가 짝을 이뤘으면 스택이 비워야함
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		String[] cases1 = { "(12{as[33<1q2w3e>90]kkk}4r)fg", "<111{ddd[4r(1q2w3e)44]77}jj>kk",
				"zz{w(a+b)*[c/d]-<q-e>1+2}w*t", "dd[a+b+c(y*u[abstract]go{234}2w3e)444]ttt",
				"a+b<c-d<e%r{123{waste[go[stop(a+b+c(?)$)@]!]*}12}33>c-d>drop" };

		String[] cases2 = { "a-b-c{1234[3.14(hello)kkk]1>d-w", "a*b*c(121<good[days)gostop>q-w]t-1",
				"123{hello[a-w-e(w/e/r]\n)\t}qq", "q*t&w{12-34[a+b]*(c/d]-e}123",
				"12<a/b/c/d{q-t-t[a=c(78::]23;)'8}sss>x+y+w", };

		System.out.println("예제1:");
		for (String test : cases1) {
			/* 출력 형식: 괄호가 유효하면 "Valid"를, 유효하지 않으면 "Invalid"를 출력.(삼항연산자 사용하기) */
			System.out.println(test + " → " + (isValid(test) ? "Valid" : "Invalid"));
		}

		System.out.println("\n예제2:");
		for (String test : cases2) {
			System.out.println(test + " → " + (isValid(test) ? "Valid" : "Invalid"));
		}
	}
}
