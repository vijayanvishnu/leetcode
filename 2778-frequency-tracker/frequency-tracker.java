class FrequencyTracker {
    int freqFreq[];
    int freq[];
    public FrequencyTracker() {
        freqFreq = new int[1_00_001];
        freq = new int[1_00_001];
    }
    
    public void add(int number) {
        int numFreq = freq[number];
        if(numFreq > 0){
            freqFreq[numFreq]--;
            freqFreq[numFreq + 1]++;
        }else{
            freqFreq[1]++;
        }
        freq[number]++;
    }
    
    public void deleteOne(int number) {
        int numFreq = freq[number];
        if(numFreq > 0){
            freqFreq[numFreq - 1]++;
            freqFreq[numFreq]--;
            freq[number]--;
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return freqFreq[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */