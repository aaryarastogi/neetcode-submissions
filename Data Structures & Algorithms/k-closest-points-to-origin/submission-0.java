class Solution {
    public int distance(int[] a){
        int x1 = 0;
        int y1 = 0;
        int x2 = a[0];
        int y2 = a[1];

        return (x2*x2 + y2*y2);
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(distance(a),distance(b))
        );
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
        }

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = pq.poll();
        }
        return result;
    }
}
