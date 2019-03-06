package src.com.Java;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），
代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。请确保每次调用 ExamRoom.leave(p) 时都有学生坐在座位 p 上。
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
        private PriorityQueue<Room> pq;
        private int N;

        private class Room {
            int start;
            int end;
            int dist;

            public Room(int start, int end) {
                this.start = start;
                this.end = end;
                if (start == -1) {
                    this.dist = end;
                } else if (end == N) {
                    this.dist = end - start - 1;
                } else {
                    this.dist = (end - start) / 2;
                }
            }
        }

        public ExamRoom(int N) {
            this.N = N;
            pq = new PriorityQueue<>(new Comparator<Room>() {
                public int compare(Room r1, Room r2) {
                    if (r1.dist == r2.dist)
                        return r1.start - r2.start;
                    return r2.dist - r1.dist;
                }
            });
            pq.offer(new Room(-1, N));
        }

        public int seat() {
            int seat = 0;
            Room room = pq.poll();
            if (room.start == -1)
                seat = 0;
            else if (room.end == N)
                seat = N - 1;
            else
                seat = (room.end + room.start) / 2;

            pq.offer(new Room(room.start, seat));
            pq.offer(new Room(seat, room.end));
            return seat;
        }

        public void leave(int p) {
            Room a = null, b = null;
            List<Room> list = new LinkedList<Room>(pq);
            for (Room room : list) {
                if (room.start == p)
                    b = room;
                if (room.end == p)
                    a = room;
                if (a != null && b != null)
                    break;
            }
            pq.remove(a);
            pq.remove(b);

            pq.offer(new Room(a.start, b.end));
        }
    }
    /**
     * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
     * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
     */
}
