import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{
    private int currentIndex;
    private int[] data;

    /*Construct the sequence by copying values from the other array into the data array*/
    public ArraySequence(int[] other){
        currentIndex = 0;
        data = new int[other.length];
        for(int i = 0; i < data.length; i++){
            data[i]=other[i];
        }
    }
    //Construct the sequence from another sequence
    public ArraySequence(IntegerSequence otherseq){
        data = new int[otherseq.length()];
        otherseq.reset();
        for(int i = 0; otherseq.hasNext(); i++){
            data[i]=otherseq.next();
        }
        currentIndex = 0;
    }

    //does the sequence have more elements? 
    public boolean hasNext(){
        return currentIndex<data.length;
    }

    //return the current value in the sequence and advances to the next element
    public int next(){
        if (hasNext()){
            return data[currentIndex++];
            }
        else{
            throw new NoSuchElementException("End of Sequence");
        }
    }

    //returns the total length of the sequence
    public int length(){
        return data.length;
    }
    //start over from the start of the sequence  
    public void reset(){
        currentIndex = 0;
    }
}
