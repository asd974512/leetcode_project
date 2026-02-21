package com.ning.hot100;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class java146LRU {

    public static void main(String[] args) {
        LRUCache cache = new java146LRU().new LRUCache(2);
        int i =0;
        cache.put(1,1);
        cache.put(2,2);
        i = cache.get(1);
        System.out.print(i+" ");
        cache.put(3,3);
        i = cache.get(2);
        System.out.print(i+" ");
        cache.put(4,4);
        i = cache.get(1);
        System.out.print(i+" ");
        i = cache.get(3);
        System.out.print(i+" ");
        i = cache.get(4);
        System.out.print(i+" ");

    }


    class LRUCache {

        class DLinkNode{
            //参考答案还需要key属性，我觉得应该不需要
            //上面的错了，必须要key，因为删除双向链表节点的时候
            // 也需要删除hashmap里面的值，因此需要节点里面有key
            int key;
            int val;
            DLinkNode pre,next;
            DLinkNode(int key,int val){
                this.val = val;
                this.key = key;
            }
            DLinkNode(){

            }

        }

        int size = 0;
        int capacity = 0;
        HashMap<Integer,DLinkNode> hashMap;
        //假的头指针和尾指针，目的是方便操作
        DLinkNode head;
        DLinkNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            hashMap = new HashMap<Integer,DLinkNode>();
            head = new DLinkNode();
            tail = new DLinkNode();
            //因为是双指针，记得前后指向
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(hashMap.containsKey(key)){
                //该节点被使用过，更新节点到链表的头部【删除该节点，然后添加到头节点】
                DLinkNode node = hashMap.get(key);
                removeNode(node);
                addToHead(node);
                return hashMap.get(key).val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(hashMap.containsKey(key)){
                DLinkNode node = hashMap.get(key);
                node.val = value;
                removeNode(node);
                addToHead(node);
                //该节点被使用过，更新节点到链表的头部
            }else{
                if(size<capacity){
                    size++;
                    DLinkNode node = new DLinkNode(key,value);
                    hashMap.put(key,node);
                    addToHead(node);
                    //添加到头节点
                }else{
                    DLinkNode dLinkNode = removeTail();
                    hashMap.remove(dLinkNode.key);
                    DLinkNode node = new DLinkNode(key,value);
                    hashMap.put(key,node);
                    addToHead(node);
                    //删除尾节点
                    //添加到头节点
                }
            }
        }

        public void addToHead(DLinkNode node){
            node.next = head.next;
            node.pre = head;
            node.next.pre = node;
            head.next = node;
        }

        public void removeNode(DLinkNode node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }

        public DLinkNode removeTail(){
            DLinkNode node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            node.pre = null;
            node.next = null;
            return node;
        }

    }
}