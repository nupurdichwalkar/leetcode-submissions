// class HitCounter {
//     private Queue<Integer> hits;

//     public HitCounter() {
//         this.hits = new LinkedList<Integer>();
//     }
    
//     public void hit(int timestamp) {
//         this.hits.add(timestamp);
        
//     }
    
//     public int getHits(int timestamp) {
//         while(!this.hits.isEmpty()){
//             int diff = timestamp - this.hits.peek();
//             if (diff >= 300) this.hits.remove();
//             else break;
//         }
//         return this.hits.size();
        
//     }
// }

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */



 class HitCounter {
     Queue<Integer> hitQueue;

     HitCounter() {
         hitQueue = new LinkedList<>();
     }

     public void hit(int timestamp) {
         hitQueue.add(timestamp);
     }

     public int getHits(int timestamp) {
         //remove all queue elements more than 300s old 
        

        while(!hitQueue.isEmpty()) {
            int firstElement = hitQueue.peek();
            if ((timestamp - firstElement) >= 300 ) {
                hitQueue.remove();
            } else {
                break;
            }
        }

         return hitQueue.size();
     }
 }
