package src.src.com.Java;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。
设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
示例:
假设迭代器被初始化为列表 [1,2,3]。
调用 next() 返回 1，得到列表中的第一个元素。
现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
*/
public class _284_Peeking_Iterator_顶端迭代器 {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    class PeekingIterator implements Iterator<Integer> {
        private Iterator iterator;
        private Integer peek;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (peek == null) {
                peek = (Integer) iterator.next();
                return peek;
            } else {
                return peek;
            }
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peek == null) {
                return (Integer) iterator.next();
            } else {
                Integer val = peek;
                peek = null;
                return val;
            }
        }

        @Override
        public boolean hasNext() {
            return peek != null || iterator.hasNext();
        }
    }
}
