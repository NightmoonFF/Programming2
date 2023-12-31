package PRO.Lektion10_JCF_og_Lambda.Exercise4_Iterator_And_PredicateFilter;

public class Runner {

    private final String name; // not null
    private final int lapTime;

    public Runner(String name) {

        this(name, 0);
    }

    public Runner(String name, int lapTime) {

        this.name = name;
        this.lapTime = lapTime;
    }

    @Override
    public String toString() {

        return String.format("Runner[%s, %d sec]", name, lapTime);
    }

    public String getName() {

        return name;
    }

    public int getLapTime() {

        return lapTime;
    }

}
