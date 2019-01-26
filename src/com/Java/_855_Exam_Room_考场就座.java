package src.com.Java;

import java.util.*;

/*
在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），
代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
请确保每次调用 ExamRoom.leave(p) 时都有学生坐在座位 p 上。
示例：
输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
输出：[null,0,9,4,2,null,5]
解释：
ExamRoom(10) -> null
seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
seat() -> 9，学生最后坐在 9 号座位上。
seat() -> 4，学生最后坐在 4 号座位上。
seat() -> 2，学生最后坐在 2 号座位上。
leave(4) -> null
seat() -> 5，学生最后坐在 5 号座位上。
 */
public class _855_Exam_Room_考场就座 {
    class ExamRoom {

        int N;
        PriorityQueue<Interval> pq;

        class Interval {
            int s, e, dist;

            public Interval(int s, int e) {
                this.s = s;
                this.e = e;
                if (s == -1) {
                    dist = e;
                } else if (e == N) {
                    dist = N - s - 1;
                } else {
                    dist = Math.abs(s - e) / 2;
                }
            }
        }

        public ExamRoom(int N) {
            this.N = N;
            this.pq = new PriorityQueue<>((a, b) -> a.dist == b.dist ? a.s - b.s : b.dist - a.dist);
            pq.add(new Interval(-1, N));
        }

        public int seat() {
            int seat = 0;
            Interval in = pq.poll();
            if (in.s == -1)
                seat = 0;
            else if (in.e == N)
                seat = N - 1;
            else
                seat = (in.s + in.e) / 2;
            pq.offer(new Interval(in.s, seat));
            pq.offer(new Interval(seat, in.e));
            return seat;
        }

        public void leave(int p) {
            Interval head = null, tail = null;
            List<Interval> intervals = new ArrayList<>(pq);
            for (Interval in : intervals) {
                if (in.s == p)
                    tail = in;
                if (in.e == p)
                    head = in;
                if (head != null && tail != null)
                    break;
            }
            pq.remove(head);
            pq.remove(tail);
            pq.offer(new Interval(head.s, tail.e));
        }
    }

    /**
     * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
     * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
     */
}
