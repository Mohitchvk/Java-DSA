package jobSequencing;

public class SequencingDataClass {
    int profit;
    int deadlines;
    int jobId;

    SequencingDataClass(int profit, int deadlines, int jobId) {
        this.profit = profit;
        this.deadlines = deadlines;
        this.jobId = jobId;
    }
}
