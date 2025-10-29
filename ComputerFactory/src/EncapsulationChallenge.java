public class EncapsulationChallenge {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public EncapsulationChallenge(int pagesPrinted){
        this(100,pagesPrinted,true);
    }

    public EncapsulationChallenge(int tonerLevel, int pagesPrinted, boolean duplex){

        if (tonerLevel <= 0){
            this.tonerLevel = 0;
        }
        else if (tonerLevel >= 100){
            this.tonerLevel = 100;
        }
        else {
            this.tonerLevel = tonerLevel;
        }
        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }

    public int getTonerLevel(){
        return this.tonerLevel;
    }
    public int getPagesPrinted(){
        return this.pagesPrinted;
    }

    public int addToner(int toBeAdded){
        if ((this.tonerLevel + toBeAdded) > 100){
            return -1;
        }else{
            this.tonerLevel += toBeAdded;
        }
        return this.tonerLevel;
    }

    public int printPages(int pages){
        if (this.duplex){
            this.pagesPrinted = this.pagesPrinted + (pages/2);
        }else{
            this.pagesPrinted+= pages;
        }
        return this.pagesPrinted;
    }


}
