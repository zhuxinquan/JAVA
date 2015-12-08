package Chapter6;

/**
 * Created by zhuxinquan on 15-12-1.
 */

enum PaperWeight{
    SCI(2.2), EI(1.5), DomesticCoreJournal(1.2);
    private double journalFactor;
    PaperWeight(double factor){
        journalFactor = factor;
    }
    public double getJournalFactor(){
        return journalFactor;
    }
}

public class Ex6_11 {
    public static void main(String[] args) {
        PaperWeight paper = PaperWeight.EI;
        System.out.print(paper);
        System.out.print("国内核心期刊的洗漱：" + paper.getJournalFactor());
    }
}
