class Clock {

    public int hours = 12;
    public int minutes = 0;

    public void next() {
        // implement me
        this.minutes++;
        if (this.minutes == 60) {
            this.minutes = 0;
            this.hours++;
            if (this.hours == 13) {
                this.hours = 1;
            }
        }
    }
}