package reflection.multiclass;

public class QueryableComparable implements Queryable, Comparable<QueryableComparable>{
    @Override
    public int compareTo(QueryableComparable o) {
        return 0;
    }
}
