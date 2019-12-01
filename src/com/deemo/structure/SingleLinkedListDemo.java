package com.deemo.structure;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        SingleLinkedList node = new SingleLinkedList();
        node.add(node1);
        node.add(node2);
        node.add(node3);
        node.add(node4);
        node.add(node5);

        node.list();
        System.out.println("reverse...");
        reverse(node.getHead().getNext());
    }

    public static void reverse(Node node) {
        if (node == null) {
            return ;
        }

        if (node.getNext() != null) {
            reverse(node.getNext());
            System.out.println(node);
        } else {
            System.out.println(node);
        }
    }
}

class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private Node head = new Node(-1);

    //返回头节点
    public Node getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(Node heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        Node temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.getNext() == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.getNext();
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.setNext(heroNode);
    }

    public void list() {
        //判断链表是否为空
        if(head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        Node temp = head.getNext();
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp= temp.getNext();
        }
    }

}

class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}