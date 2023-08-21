class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((count1, count2) -> Integer.compare(count2.count, count1.count));
        if (a>0) {
            pq.add(new Pair('a' , a));
        }
        if (b>0) {
            pq.add(new Pair('b' , b));
        }
        if (c>0) {
            pq.add(new Pair('c' , c));
        }

        while(pq.size() > 1) {
            Pair pair_one = pq.poll();
            if(pair_one.count >=2) {
                sb.append(pair_one.ch);
                sb.append(pair_one.ch);
                pair_one.count -= 2;
            } else {
                sb.append(pair_one.ch);
                pair_one.count -=1;
            }

            Pair pair_two = pq.poll();
            if (pair_two.count >= 2 && pair_one.count < pair_two.count) {
                sb.append(pair_two.ch);
				sb.append(pair_two.ch);
				pair_two.count -= 2;
			} else {
				sb.append(pair_two.ch);
				pair_two.count -= 1;
			}

            if (pair_one.count > 0) {
                pq.add(pair_one);
            }
            if (pair_two.count> 0 ) {
                pq.add(pair_two);
            }
        }

        if (!pq.isEmpty()) {
            {
                if (pq.peek().count >= 2) {
                    sb.append(pq.peek().ch);
                    sb.append(pq.peek().ch);
                } else {
                    sb.append(pq.peek().ch);
                }
            }
        }
        return sb.toString();
        
    }



    static class Pair {
        public Character ch;
        int count;

        public Pair(Character ch, int count) {
			this.ch = ch;
			this.count = count;
		}


    }
}
