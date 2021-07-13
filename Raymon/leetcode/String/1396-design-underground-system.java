class UndergroundSystem {

    HashMap<String, Pair<Double, Double>> timeMap;
    HashMap<Integer, Pair<String, Integer>> checkInMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<String,Integer>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> checkInData = checkInMap.get(id);
        StringBuilder sb = new StringBuilder();
        sb.append(checkInData.getKey()).append("->").append(stationName);
        Pair<Double, Double> timeMapData = timeMap.getOrDefault(sb.toString(), new Pair<>(0.0, 0.0));
        timeMap.put(sb.toString(), new Pair<>(t - checkInData.getValue() + timeMapData.getKey(), timeMapData.getValue() + 1));
        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        StringBuilder sb = new StringBuilder();
        sb.append(startStation).append("->").append(endStation);
        Pair<Double, Double> timeMapData = timeMap.get(sb.toString());
        if (timeMapData == null) {
            return 0.0;
        }
        Double totalTime = timeMapData.getKey();
        Double totalTrips = timeMapData.getValue();
        // The average is simply the total divided by the number of trips.
        return totalTime / totalTrips;
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
