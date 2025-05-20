package com.ruby.java.ch08.ex;

public class Ex_05 {
    private Node head;

    public Ex_05 () {
        head = null;
    }

    private class Node {
        private String data;
        private Node link;

        public Node(String data) {
            this.data = data;
        }
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void printList() {
        Node temp = head; 
        //노드가 있으면 반복 (리스트 끝까지 돌면서 출력할거야) 
        while (temp != null) {
        	//현재노드가 가지고 있는 데이터 출력 
            System.out.print(temp.data);
            //다음노드가 있는지 확인(마지막 노드가 아니라면)
            if (temp.link != null) {
            	//화살표 출력
                System.out.print(" -> ");
            }
            //만약 마지막 노드라면 출력하지않음
            temp = temp.link;
        }
        System.out.println();
    }

    public void delete(String data) {
        if (head == null) return;

        if (data.equals(head.data)) {
            head = head.link;
            return;
        }

        Node prev = head;
        Node curr = head.link;

        while (curr != null) {
            if (data.equals(curr.data)) {
                prev.link = curr.link;
                return;
            }
            prev = curr;
            curr = curr.link;
        }
    }

    public static void main(String[] args) {
    	Ex_05 myList = new Ex_05();
        myList.printList();

        myList.add("JAVA");
        myList.add("HTML");
        myList.add("CSS");
        myList.add("Javascript");

        myList.printList(); // JAVA -> HTML -> CSS -> Javascript

        myList.delete("CSS");

        myList.printList(); // JAVA -> HTML -> Javascript
    }
}

