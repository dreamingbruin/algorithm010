# 学习笔记

## 分析 Queue 和 Priority Queue 的源码

### Queue

java.util.Queue是所有队列实现的基础接口，主要有3类方法：
1. insert：向队尾增加一个元素
    * add：在空间不足时抛出异常
    * offer：在空间不足时返回false
2. remove：从队头拿走一个元素
    * remove：在队列为空时抛出异常
    * poll：在队列为空时返回null
3. examine：检查队头的元素，不做出队操作
    * element：在队列为空时抛出异常
    * peek：在队列为空时返回null

### PriorityQueue
#### 简介
* java.util.PriorityQueue是一个非线程安全的优先级队列，内部使用堆来实现。
* 堆内的元素默认按照从小到大排列，也可以在构造函数中传入自定义的java.lang.Comparator实例来自定义排序规则。
* 当不指定Comparator实例时，元素本身需要实现java.lang.Comparable接口。
#### PriorityQueue的主要方法
* offer执行流程：
    1. modCount++
    2. 按需扩大数据空间（Double size if small; else grow by 50%），最大为Integer.MAX_VALUE
    3. 增大队列size
    4. 按照排序规则对堆进行整理（siftUp）并放入新元素
* poll执行流程：
    1. 减小队列size 
    2. modCount++
    3. 记录堆头元素
    4. 记录堆尾元素，将堆尾元素设为null
    5. 按照排序规则对堆进行整理（siftDown）并将原堆尾元素放入堆中
    6. 返回原堆头元素
