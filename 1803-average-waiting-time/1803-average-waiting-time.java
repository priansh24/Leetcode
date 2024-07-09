class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitingTime = 0;
        double currentTime = customers[0][0];
        int i = 0;
        int n = customers.length;
        for(int[] customer:customers)
        {
            if(currentTime<customer[0]) currentTime = customer[0];
            currentTime += customer[1];
            waitingTime += (currentTime-customer[0]);
        }
        double avg = waitingTime/customers.length;
        return avg;
    }
}