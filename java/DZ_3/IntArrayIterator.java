package DZ_3;

import java.util.Iterator;

public  class IntArrayIterator implements Iterator<Integer> {
        private final int[] source;
        private int index = 0;
        public IntArrayIterator(int[] source) {
            this.source = source;
        }

        @Override
        public boolean hasNext() {
            // FIXME: 20.01.2023 Код писать тут
            return index <= source.length-1;
        }

        @Override
        public Integer next() {
            // FIXME: 20.01.2023 Код писать тут
            int nextIndex = source[index];
            index++;
            return nextIndex;
        }
    }

