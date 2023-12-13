public abstract class Support {

    private final String name;
    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    //루프 구성
    public void support(Trouble trouble) {
        for (Support obj = this; true; obj = obj.next) {
            if (obj.resolve(trouble)) {
                done(trouble);
                break;
            }

            if (obj.next == null) {
                fail(trouble);
                break;
            }
        }
    }
    //재귀 구성
//    public void support(Trouble trouble) {
//        if (resolve(trouble)) {
//            done(trouble);
//            return;
//        }
//
//        if (next != null) {
//            next.support(trouble);
//            return;
//        }
//
//        fail(trouble);
//    }

    @Override
    public String toString() {
        return "[ " + name + " ]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}
