class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0) return 0;

        List<Pair<Integer,Double>>cars = new ArrayList<>();
        int n = position.length;
        for(int i=0;i<n;i++){
            double time = (double)(target-position[i])/speed[i];
            cars.add(new Pair<>(position[i],time));
        }
        Collections.sort(cars, (a,b) -> Integer.compare(b.getKey(), a.getKey()));

        double leader = cars.get(0).getValue();
        int fleet = 1;
        for(int i=1;i<cars.size();i++){
            if(cars.get(i).getValue() > leader){
                leader = cars.get(i).getValue();
                fleet++;
            }
        }

        return fleet;
    }
}
